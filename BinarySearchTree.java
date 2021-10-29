package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
/**
 * 
 * @author DeAngelo Phlippeau
 * 
 * This class creates a Binary SearchTree of Types that starts with the first given number as the root of the tree
 * Then the following items that are inserted will be the left or right children depending on if the value
 * of the item to be instated into the Binary SerchTree is less ore more than the current node
 * when a node already has a node where the node will be inserted the node will do the same comparison with 
 * the child node being the current node.
 *
 * @param <Type>
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
	Node root;
	int size = 0;
	/**
	 * This is the  constructor class for BinarySearchTree that creates a node called root
	 * This will be starting point for the BinarySearchTree
	 * 
	 */
	public BinarySearchTree()
	{
		root = null;
	}
	
	/**
	 * This creates a Node with the given data while creating left and right children for the node
	 * @author DeAngelo Phlippeau
	 *
	 */
	private class Node {

		Type data;
		Node left, right;
		/**
		 * This inserts the given data to the node while making the children of the node null
		 * @param nodeData the data of the given node
		 */
		public Node(Type nodeData) {
			this.data = nodeData;
			this.left = null;
			this.right = null;
		}
	}
	
	/**
	 * This is the driver code used when adding a node to the binary search tree then increased size of tree
	 * 
	 * @param - item the item that will be inserted into the BinarySerchTree
	 * @return - True if the item was added into the BinarySerchTree
	 */
	@Override
	public boolean add(Type item) {
		//base case
		if(root == null)
			root = new Node(item);
		else
			addRecursive(item, root);
		size++;
		return true;
	}
	
	/**
	 * This method recursively check if the item being inserted in less or equal/greater than the current item
	 * till the algorithm locates an empty spot in the BinarySerchTree
	 * 
	 * @param item - item that is recursively checked inheritor to locate a spot for it in the BinarySerchTree
	 * @param current - The current node that the item node is compared with in order to see if the node should
	 * 					be inserted to the left or right based on if the compared value is less or more
	 */
	private void addRecursive(Type item, Node current)
	{
		// item is less than the current - need to go left
		if(item.compareTo(current.data) < 0)
		{
			if(current.left == null) // checks to see if there is a node currently in its place
				current.left = new Node(item);
			else
				addRecursive(item, current.left); // if there is a node recursively move left
		}
		// item is more or equal - need to go right
		else
		{
			if(current.right == null) // checks to see if there is a node currently in its place
				current.right = new Node(item);
			else
				addRecursive(item, current.right); // if there is a node recursively move right
		}
	}
	
	/**
	 * This method adds all Types in the given array list and adds them to the BinarySerchTree
	 * 
	 * @param item - the given array list to be added to the BinarySerchTree
	 * @return boolean false if the given items set was empty and true if them items in the given item set where added
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {
		if(items.size() == 0) // checks if the arrayList is empty
			return false;
		for(Type data : items)
			add(data);
		return true;
	}
	
	/**
	 * This method clears the BinarySerchTree by setting the root to null and setting the size to 0
	 * 
	 */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * This is the driver method for containsRecursive
	 * 
	 * @param item - item to be check if it is inside of the BinarySerchTree
	 */
	@Override
	public boolean contains(Type item) {
		return containsRecursive(item, root);
	}
	
	/**
	 * This method recursively checks if the given item is located in the tree by comparing its self to the current node
	 * if the item is less than the current node it will recursively compare its self to current nodes left child
	 * if the item is more than the current node it will recursively compare its self to current nodes right child
	 * if the item is equal than the current node then it has found the node and will return True
	 * if the current item equals null then the end of the tree has been reached and the item in not inside of the tree and will return False
	 * 
	 * @param item to be checked if it is located inside of the BinarySerchTree
	 * @param current The item that is use to compare if item given item is less more, or equal to
	 * @return boolean - True if the item is found False if the item is not found
	 */
	private boolean containsRecursive(Type item, Node current)
	{
		if(current == null)
			return false;
		if(item.equals(current.data))
			return true;
		if(item.compareTo(current.data) < 0)
			return containsRecursive(item, current.left);
		else
			return containsRecursive(item, current.right);
	}

	/**
	 * This method iterates though the entire array list and check if the items is in the BinarySerchTree
	 * on the first item that is not contained in the tree the function will return false
	 * 
	 * @param items - the array list that will be 
@return boolean - True if all items in the arrayList are present returns False if at least one item in the arrayList is not found
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		for(Type data : items)
			if(!contains(data))
				return false;
			return true;
	}

	/**
	 * Finds the smallest item in the BinarySerchTree
	 * This is the driver method for the recursive method of first
	 * 
	 * @return Type - the item that has the least value in the BinarySerchTree
	 */
	@Override
	public Type first() throws NoSuchElementException {
		// if the list is empty throw NoSuchElementException
		if(root == null)
			throw new NoSuchElementException();
		else
			return firstRecursive(root);
	}
	
	/**
	 * This method iterates though the BinarySerchTree though the left child till its child is null
	 * when its child is null it is at the left most bottom item in the tree.
	 * 
	 * @param current the current item while iterating the BinarySerchTree
	 * @return Type - the item that has the least value in the BinarySerchTree
	 */
	public Type firstRecursive(Node current) {
		if(current.left == null)
			return current.data;
		else
			return firstRecursive(current.left);
	}

	/**
	 * Checks if the BinarySerchTree is empty by checking if the root node is null
	 * 
	 * @return True - if the BinarySerchTree is empty False - if the BinarySerchTree is not empty
	 */
	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Finds the largest item in the BinarySerchTree
	 * This is the driver method for the recursive method of last
	 * 
	 * @return Type - the item that has the highest value in the BinarySerchTree
	 */
	@Override
	public Type last() throws NoSuchElementException {
		if(root == null)
			throw new NoSuchElementException();
		else
			return lastRecursive(root);
	}
	
	/**
	 * This method iterates though the BinarySerchTree though the right child till its child is null
	 * when its child is null it is at the right most bottom item in the tree.
	 * 
	 * @param current the current item while iterating the BinarySerchTree
	 * @return Type - the item that has the highest value in the BinarySerchTree
	 */
	public Type lastRecursive(Node current) {
		if(current.right == null)
			return current.data;
		else
			return lastRecursive(current.right);
	}

	/**
	 * This is the driver method for the recursive remove method 
	 * if the items is not in the BinarySerchTree this will return false
	 * 
	 * @param item - the items that is going to be roomed
	 * @return boolean - false if the item was not removed
	 * 
	 */
	@Override
	public boolean remove(Type item) {
		int oldsize = size();
		root = removeRecursive(root, item);
		return (oldsize != size);
	}
	
	/**
	 * This method recursively iterates the BinarySerchTree looking for the given item when the item is found
	 * The method replaces the node with its child
	 * 
	 * 
	 * @param current - the current node that the item is at when it is iterating
	 * @param item - the item that is being searched for to be removed
	 * @return Node - the child node of the node that is being replaced
	 */
	public Node removeRecursive(Node current, Type item) {
		//base case
		if (current == null)
            return current;
		// checks if if the given item is less than the current node the moves left
		else if (item.compareTo(current.data) < 0)
			current.left = removeRecursive(current.left, item);
		// checks if if the given item is more than the current node the moves right
        else if (item.compareTo(current.data) > 0)
        	current.right = removeRecursive(current.right, item);
		// if the node is not null, less, or more then it is the node that we are looking for
        else {
        	size--;
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;
            current.data = first();
            current.right = removeRecursive(current.right, current.data);
        }
 
        return current;
		
	}


	/**
	 * This method iterates though the given arrayList calling the remove method for each item
	 * Then returns True or False based on if the size of the BinarySerchTree changed
	 * 
	 * @param items - the given array this with the items that will be deleted
	 * @return boolean True - if items where removed False if items where not removed
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		int prevousSize = size;
		for(Type data : items)
			remove(data);
		return (prevousSize != size);
	}

	/**
	 * This method gives the amount of elements in the BinarySerchTree
	 * 
	 * @return int - the size of BinarySerchTree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This method converts the BianrySerchTree into an ArrayList but help of in inorderTraversal method
	 * 
	 * @return ArrayList - of the BinarySerchTree in order of smallest to largest
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> output = new ArrayList<Type>();
		inOrderTraversal(root, output);
		return output;
	}
	
	/**
	 * This is a recursive method that searches the left most nodes before switching to the right inorder to 
	 * add the nodes to the arrayList in the smallest to largest order.
	 * 
	 * @param current the node that the method is currently looking at
	 * @param output - the array list that is being added to
	 */
	public void inOrderTraversal(Node current, ArrayList<Type> output) {
		//base case
	    if (current == null) {
	        return; 
	      }
	    inOrderTraversal(current.left, output); // Recursively goes left till the left most node is null
	    output.add(current.data);
	    inOrderTraversal(current.right, output); // Recursively goes right till the right most node is null
	    return;
	  }

}
