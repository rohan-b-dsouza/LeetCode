// Optimal

// Node Class
class Node {
  // 'cnt' basically keeps a count of the frequency of usage
  public int key, val, cnt;
  public Node prev, next;
  // Constructor to initialize node with the key, val, prev, next and cnt for the dummy 'head' and dummy 'tail'
  Node() {
    key = val = -1;
    prev = next = null;
    cnt = 1;
  }
  // Constructor to initialize the node with key, val, prev, next, cnt with a given key and val
  Node(int key, int val) {
    this.key = key;
    this.val = val;
    prev = next = null;
    cnt = 1;
  }
}
// Doubly Linked List Class
class DList {
  // Declare the head and tail
  public Node head, tail;
  // Declare size which tracks the size of a particular DLL
  public int size;
  // Constructor to initialize head, tail and link head's next to tail and tail's prev to head
  // Size is set to 0 initially as head and tail are dummy nodes so we don't count it in this
  DList() {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    size = 0;
  }
  // Function to delete a node
  public void deleteNode(Node node) {
    // Get node's previous node and next node
    Node prevNode = node.prev;
    Node nextNode = node.next;
    // Link previous node's next to nextNode and nextNode's prev to previous node
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
    // Decrement size by 1
    size--;
  }
  // Function to insert a node after head
  public void insertAfterHead(Node node) {
    // Link node's next to head's next
    node.next = head.next;
    // Link node's prev to head
    node.prev = head;
    // Link head's next to node
    head.next = node;
    // Link node's next's prev to node
    node.next.prev = node;
    // Increment size by 1
    size++;
  }
}

// LFU Cache Class
class LFUCache {
  // HashMap to store {key, reference of the node}
  private HashMap<Integer, Node> keyNode;
  // HashMap to store {frequency, Dlist} 
  private HashMap<Integer, DList> freqDList;
  // Stores the no. of nodes allowed
  private int capacity;
  // Stores current no. of nodes
  private int currSize;
  // Tracks the minFreq at each point
  private int minFreq;

  // Constructor to define keyNode and freqDList maps
  // Also it sets the capacity
  // Also it initializes currSize and minFreq to 0
  public LFUCache(int capacity) {
    keyNode = new HashMap<>();
    freqDList = new HashMap<>();
    this.capacity = capacity;
    currSize = 0;
    minFreq = 0;
  }
  // This function is called only when the get / put operation on a node is not for the first time
  public void updateFreqDList(Node node) {
    // Get the current list of this node from the freqDList map and delete it from this list
    freqDList.get(node.cnt).deleteNode(node);
    // If the minFreq currently is equal to this node's frequency usage and if deleting this node from the freqDList map has made that particular {freq, list} pair's list's size 0; then minFreq is incremented by 1
    if (minFreq == node.cnt && freqDList.get(node.cnt).size == 0) {
      minFreq++;
    }
    // Increment node's frequency usage
    node.cnt += 1;
    // Get the next Higher frequency list for node
    // If it already exists use the same list else create a new list
    DList nextHigherFreqDList = freqDList.getOrDefault(node.cnt, new DList());
    // Insert node after the head of this new list
    nextHigherFreqDList.insertAfterHead(node);
    // Add / Update this new {frequency, List} pair to the map
    freqDList.put(node.cnt, nextHigherFreqDList);
  }
  // Function to get the value for a given key
  public int get(int key) {
    // If key exists in the map
    if (keyNode.containsKey(key)) {
      // Get the node with this key
      Node node = keyNode.get(key);
      // Call updateFreqDList to maintain the LFU
      updateFreqDList(node);
      // Return the node value
      return node.val;
    }
    // If key doesn't exist return -1
    return -1;
  }
  // Function to put a {key, value} in the cache
  public void put(int key, int value) {
    // If capacity is 0, we can put no nodes in the cache hence return 
    if (capacity == 0) return;
    // If key exists already in the map
    if (keyNode.containsKey(key)) {
      // Get the node
      Node node = keyNode.get(key);
      // Update the node's value with new given value
      node.val = value;
      // Call updateFreqDList to maintain the LFU
      updateFreqDList(node);
    }
    // If the key is new
    else {
        // If current size of cache is equal to max allowed capacity, remove the LRU node
        if (currSize == capacity) {
            // Get the list with the minimum freq
            DList LFUList = freqDList.get(minFreq);
            // Get the LRU of LFUList i.e the node before tail node
            Node LRU = LFUList.tail.prev;
            // Remove this node's key from the keyNode map
            keyNode.remove(LRU.key);
            // Also, delete this LRU node from the LFUList
            LFUList.deleteNode(LRU);
            // Decrement current size of cache by 1
            currSize--;
        }
        // Increment current size of cache by 1 as we are going to put a new node 
        currSize++;
        // Set minFreq to 1 ; this is because as we are putting a new node in the cache its 'cnt' i.e frequency of usage will be 1
      // Hence, minFreq will also become 1 now
        minFreq = 1;
        // Get the new list to store this newNode, if a list with minFreq 1 already exists then use that list itself, else create new list
        DList newDList = freqDList.getOrDefault(minFreq, new List());
        // Create a newNode with the given key and value
        Node newNode = new Node(key, value);
        // Insert this new node after the head of newDList
        newDList.insertAfterHead(newNode);
        // Add / Update the new pair {minFreq, newDList} into the freqDList map
        freqDList.put(minFreq, newDList);
        // Put this new {key, reference} of node pair to the keyNode map 
        keyNode.put(key, newNode);
    }
  }
}

// T.C => O(1) per operation, O(n) to process all queries
// S.C => O(n) for the keyNode map, O(n) for the freqDList map and O(n) for the Doubly linked list

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
