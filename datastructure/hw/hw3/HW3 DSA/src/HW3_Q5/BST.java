package HW3_Q5;
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    private class Node {
         Key key;           // sorted by key
         Value val;         // associated data
         Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    public BST() {
    }
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            return null;
        }
        return select(root, k).key;
    }
    private Node select(Node x, int k) {
        if (x == null) return null; 
        if      (size(x.left) > k) return select(x.left,  k); 
        else if (size(x.left) < k) return select(x.right, k-size(x.left)-1); 
        else            return x; 
    } 
    public int rank(Key key) {
        if (key == null) return 0;
        return rank(key, root);
    } 
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    }   
    public boolean isEmpty() {//tell if the tree is empty
        return size() == 0;
    }
    public int size() {// return the tree size
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    public void put(Key key, Value val) {//insert node if not null
        if (key == null) return;
        if (val == null) {
            delete(key);
        	return;
        }
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    public void deleteMin() {
        if (isEmpty()) return;
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 

    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 


}
