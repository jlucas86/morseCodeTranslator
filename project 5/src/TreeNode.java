/**
 * this class holds a treenode 
 * @author Joshua Lucas
 */

public class TreeNode<T> {
	
	public TreeNode<T> leftC;
	public TreeNode<T> rightC;
	private T data;
	
	/**
	 *  enters a data point into the tree node and sets both children to null 
	 * @param dataNode the data being entered in to the node
	 */
	public TreeNode (T dataNode)
	{
		data = dataNode;
		leftC = null;
		rightC = null;
	}
	
	/**
	 * makes a deep copy of a tree node
	 * @param node the tree node that will be deep copied
	 */
	
	public TreeNode (TreeNode<T> node)
	{
		TreeNode<T> copy = node;
	}
	
	/**
	 * gets the value in the tree node
	 * @return that data held in the tree node
	 */
	public T getData ()
	{
		return data;
	}

}
