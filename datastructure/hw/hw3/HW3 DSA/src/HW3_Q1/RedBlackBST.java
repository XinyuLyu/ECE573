package HW3_Q1;



public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    private Node root;     // root of the BST
    private class Node {
        private Key key;           // key
        private Value val;         // associated data
        private Node left, right;  // links to left and right subtrees
        private boolean color;     // color of parent link
        private int size;          // subtree count
        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }
    public RedBlackBST() {
    }
    private boolean isRed(Node x) {//judge whether the node is red 
        if (x == null) return false;
        return x.color == RED;
    }
    private int size(Node x) {// return the size
        if (x == null) return 0;
        return x.size;
    } 
    public int size() {
        return size(root);
    }
    public boolean isEmpty() {
        return root == null;
    } 
    public void put(Key key, Value val) {// insert
        if (key == null) 
        	return;
        if (val == null) {
            return;
        }
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val ,BLACK, 1);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
            if(h.left==null)
            { 
            if (h.color == RED)
                h.left.color = BLACK;
            if (h.color == BLACK)
                h.left.color = RED;
            }
            else  if(h.right.color=RED)
            	{h.left.color=BLACK;}
            else {h.right.color=RED;}
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
            if(h.left==null)
            { 
        	   if (h.color == BLACK)
                h.right.color = RED;
               if (h.color == RED)
                h.right.color = BLACK;
            }
            else if(h.left.color=RED)
         	   {h.right.color=BLACK;}
            else {h.right.color=RED;}
        } else {
            h.val = val;
        }
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }
    private void flipColors(Node h) {
        //h.color = !h.color;
        //h.left.color = !h.left.color;
        //h.right.color = !h.right.color;
    	h.color=RED;
    	h.left.color=BLACK;
    	h.right.color=BLACK;
    }
    public boolean contains(Key key) {// judge if contain a certain key
        return get(key) != null;
    }
    public Value get(Key key) {// get the value of a certain key
        if (key == null) return null;
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
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
    /********some basic api support the delete*****/
    private Node moveRedLeft(Node h) {
        flipColors(h);
        return h;
    }
    private Node moveRedRight(Node h) {
        flipColors(h);
        return h;
    }
    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    } 
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    public void deleteMin() {// delete min nodes
        if (isEmpty()) return;
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }
    private Node deleteMin(Node h) { 
        if (h.left == null)
            return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return h;
    }
    /***********function for test***********/
    public boolean is23() { return is23(root); }
    private boolean is23(Node x) {
        if (x == null) return true;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    }
   
    public boolean isBalanced() { 
        int black = 0;     
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    } 
    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    } 
}
