class Node {
  public int key, val, cnt;
  public Node prev, next;

  Node() {
    key = val = -1;
    prev = next = null;
    cnt = 1;
  }

  Node(int key, int val) {
    this.key = key;
    this.val = val;
    prev = next = null;
    cnt = 1;
  }
}

class DList {
  public Node head, tail;
  public int size;
  DList() {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  public void deleteNode(Node node) {
    Node prevNode = node.prev;
    Node nextNode = node.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
    size--;
  }

  public void insertAfterHead(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next = node;
    node.next.prev = node;
    size++;
  }
}

class LFUCache {
  private HashMap<Integer, Node> keyNode;
  private HashMap<Integer, DList> freqDList;
  private int capacity;
  private int currSize;
  private int minFreq;

  public LFUCache(int capacity) {
    keyNode = new HashMap<>();
    freqDList = new HashMap<>();
    this.capacity = capacity;
    currSize = 0;
    minFreq = 0;
  }

  public void updateFreqDList(Node node) {
    freqDList.get(node.cnt).deleteNode(node);
    if (minFreq == node.cnt && freqDList.get(node.cnt).size == 0) {
      minFreq++;
    }
    node.cnt += 1;
    DList nextHigherFreqDList = freqDList.getOrDefault(node.cnt, new DList());
    nextHigherFreqDList.insertAfterHead(node);
    freqDList.put(node.cnt, nextHigherFreqDList);
  }

  public int get(int key) {
    if (keyNode.containsKey(key)) {
      Node node = keyNode.get(key);
      updateFreqDList(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if (keyNode.containsKey(key)) {
      Node node = keyNode.get(key);
      node.val = value;
      updateFreqDList(node);
    }
    else {
        if (currSize == capacity) {
            DList LFU = freqDList.get(minFreq);
            Node LRU = LFU.tail.prev;
            keyNode.remove(LRU.key);
            LFU.deleteNode(LRU);
            currSize--;
        }
        currSize++;
        minFreq = 1;
        DList newDList = new DList();
        if (freqDList.containsKey(minFreq)) {
            newDList = freqDList.get(minFreq);
        }
        Node newNode = new Node(key, value);
        newDList.insertAfterHead(newNode);
        freqDList.put(minFreq, newDList);
        keyNode.put(key, newNode);
    }
  }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */