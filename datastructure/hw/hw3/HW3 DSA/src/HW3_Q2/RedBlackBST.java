package HW3_Q2;

import java.util.ArrayList;
import java.util.List;




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
    private List<Integer> len=new ArrayList<>();
    public double getresult() {
    	return getresult(root);
    }
    private double getresult(Node x)
    {
    	double avg= (double)getInterlength(x)/len.size();
    	return avg;
    }
    private int getInterlength(Node x) {
    	int length=0;
    	if(x==null)
    	{
    		return 0;
    	}
    	length=x.size+getInterlength(x.left)+getInterlength(x.right);
    	len.add(length);
    	return length;
    }
  /*  public double avgTreePaths() {//return the average path length
    	return avgTreePaths(root);
    	}
    public double avgTreePaths(Node x) {
       List<Integer> list=new ArrayList<Integer>();
       int length=1;
       traversePath(x,length,list);
       double sum=0;
       double avg=0;
       for (Integer val : list) {
           sum += val;
       }
       avg=(sum/list.size());
       return avg;
    }
    private void traversePath(Node x,int length, List<Integer> list) {// traverse the tree
        if (x.left == null && x.right == null) {
            list.add(length);
        }
        if (x.left != null) {
        	traversePath(x.left, length+1,list);
        }
        if (x.right != null) {
        	traversePath(x.right, length+1,list);
        }
    }*/
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
            if (isRed(h))
                h.left.color = BLACK;
            if (!isRed(h))
                h.left.color = RED;
            }
            else  if(isRed(h.right))
            	{h.left.color=BLACK;}
          //  else {h.right.color=RED;}
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
           if(h.left==null)
            { 
        	   if (!isRed(h))
                h.right.color = RED;
               if (isRed(h))
                h.right.color = BLACK;
            }
            else if(isRed(h))
         	   {h.right.color=BLACK;}
            else {h.right.color=RED;}
        } else {
            h.val = val;
        }
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
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
}
