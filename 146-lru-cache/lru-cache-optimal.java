// Optimal

class Node {
  public int key, val;
  public Node prev, next;
  // Constructor to create head and tail dummy node
  Node() {
    key = -1;
    val = -1;
    prev = next = null;
  }
  // Constructor to create a node with given key and value
  Node(int key, int val) {
    this.key = key;
    this.val = val;
    prev = next = null;
  }
}

class LRUCache {
  // Declare head, tail, capacity and a HashMap to store the {key, reference of node} pair to get any node's reference in O(1) time using its key
  private Node head;
  private Node tail;
  private HashMap<Integer, Node> map;
  private int capacity;
  // Function to delete a node
  private void deleteNode(Node node) {
    // Get node's nextNode and prevNode
    Node nextNode = node.next;
    Node prevNode = node.prev;
    // Connect these two nodes
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }
  // Function to insert a node after dummy head node
  private void insertAfterHead(Node node) {
    // Link node's next to head's next
    node.next = head.next;
    // Link node's prev to head
    node.prev = head;
    // Link head's next to node
    head.next = node;
    // Link node's nextnode's prev to node
    node.next.prev = node;
  }
  // Function to handle LRU operations
  public LRUCache(int capacity) {
    // Initialize capacity with given capacity
    this.capacity = capacity;
    // Define the map
    map = new HashMap<>();
    // Define head and tail nodes with {key : -1, val : -1, next = prev = null}
    head = new Node();
    tail = new Node();
    // Link head's next to tail and tail's prev to head
    head.next = tail;
    tail.prev = head;
  }
  // Function to get node's value when a key is given
  public int get(int key) {
    // If map contains this key
    if (map.containsKey(key)) {
      // Get the node's reference using the key from the map
      Node node = map.get(key);
      // Delete this node and insert it after head to ensure LRU is maintained
      deleteNode(node);
      insertAfterHead(node);
      // Return the node's value
      return node.val;
    }
    // Return -1 if map does'nt contain this key
    return -1;
  }
  // Function to put a node in the map
  public void put(int key, int value) {
    // If map contains the given key
    if (map.containsKey(key)) {
      // Get the node reference from the map using the key
      Node node = map.get(key);
      // Delete this node and insert it after the head to ensure LRU is maintained
      deleteNode(node);
      insertAfterHead(node);
      // Change node's val to new value given
      node.val = value;
      // End the function
      return;
    }
    // If map's size is equal to capacity it means the no. of nodes is equal to capacity
    if (map.size() == capacity) {
      // Hence, get the LRU node using tail.prev
      Node LRU = tail.prev;
      // Remove it from the map as well as delete this node
      map.remove(LRU.key);
      deleteNode(LRU);
    }
    // Create a newNode using the given key and value
    Node newNode = new Node(key, value);
    // Insert it after the head to ensure LRU is maintained 
    insertAfterHead(newNode);
    // Put this new {key, reference} to the map
    map.put(key, newNode);
  }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// T.C => O(1) per operation
// S.C => O(n) + O(n) for the map and the DLL = O(2 * n) = O(n)
