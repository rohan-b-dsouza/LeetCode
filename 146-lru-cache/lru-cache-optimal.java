class Node {
  public int key, val;
  public Node prev, next;

  Node() {
    key = -1;
    val = -1;
    prev = next = null;
  }

  Node(int key, int val) {
    this.key = key;
    this.val = val;
    prev = next = null;
  }
}

class LRUCache {
  private Node head;
  private Node tail;
  private HashMap<Integer, Node> map;
  private int capacity;

  private void deleteNode(Node node) {
    Node nextNode = node.next;
    Node prevNode = node.prev;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }

  private void insertAfterHead(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next = node;
    node.next.prev = node;
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      deleteNode(node);
      insertAfterHead(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      deleteNode(node);
      insertAfterHead(node);
      node.val = value;
      return;
    }
    if (map.size() == capacity) {
      Node LRU = tail.prev;
      map.remove(LRU.key);
      deleteNode(LRU);
    }
    Node newNode = new Node(key, value);
    insertAfterHead(newNode);
    map.put(key, newNode);
  }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
