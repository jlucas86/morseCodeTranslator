import java.util.ArrayList;

/**
 * this class is a tree that holds the letters of the alphabet  and uses morsecode to traverse to be traversed
 * @author Joshua Lucas
 *
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root1 = new TreeNode<String>("");
	
	/**
	 * a constructor that builds the morsecode tree
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	public void buildTree()
	{
		                                            insert(".", "e");                                                                                                                insert("-", "t");
		
		                 insert("..", "i");                                      insert(".-", "a");                                                             insert("-.", "n");                                                      insert("--", "m");
		
		         insert("...", "s");insert("..-", "u");                  insert(".-.", "r"); insert(".--", "w");                                         insert("-..", "d");insert("-.-", "k");                                 insert("--.", "g"); insert("---", "o");
		          
		insert("....", "h"); insert("...-", "v");insert("..-.", "f");  insert(".-..", "l");  insert(".--.", "p");insert(".---", "j");   insert("-...", "b"); insert("-..-", "x");insert("-.-.", "c");insert("-.--", "y");   insert("--..", "z");  insert("--.-", "q");
	}
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	
	public  MorseCodeTree insert(String code, String letter)
	{
		
		addNode( root1, code, letter);
		
		return null;
	}
	
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		String code1 = "";
		
		if (root.leftC == null && code.charAt(0) == '.' && code.length() == 1)
		{

			root.leftC = new TreeNode<String> (letter);
		}
		
		else if (root.rightC == null && code.charAt(0) == '-' && code.length() == 1)
		{
			root.rightC = new TreeNode<String> (letter);
		}
		
		else
		{
			
			if (code.charAt(0) == '.')
			{
				for (int i = 1; i < code.length(); i++)
					code1 += code.charAt(i);
				
				addNode( root.leftC, code1, letter);
			}
			
			else if (code.charAt(0) == '-')
			{
				for (int i = 1; i < code.length(); i++)
					code1 += code.charAt(i);
				
				addNode( root.rightC, code1, letter);
			}
			
		}
	}
	
	/**
	 * finds and returns the root of the tree
	 * @return the root of the tree
	 */
	
	public TreeNode<String> getRoot()
	{
		return root1;
	}
	
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode)
	{
		root1 = newNode;
	}
	
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code)
	{ 
		return fetchNode(root1, code);	
	}
	
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code)
	{
		
		if( code.length() == 1 && code.charAt(0) == '.')
			return root.leftC.getData();
		
		else if( code.length() == 1 && code.charAt(0) == '-')
			return root.rightC.getData();
		else 
		{
			
			String code1 = "";
			
			if (code.charAt(0) == '.')
			{
				for (int i = 1; i < code.length(); i++)
					code1 += code.charAt(i);
				
				return fetchNode( root.leftC, code1);
			}
			
			else if (code.charAt(0) == '-')
			{
				for (int i = 1; i < code.length(); i++)
					code1 += code.charAt(i);
				
				return fetchNode( root.rightC, code1);
			}
			
			else
				return null;
			
			
		}
		
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		 throw new UnsupportedOperationException();
	}
	
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
	{
		 throw new UnsupportedOperationException();
	}

	


	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> send = new ArrayList<String>();
		
		LNRoutputTraversal(root1, send);
		
		return send;
	}
	
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		
		if(root != null)
	    {
			
			LNRoutputTraversal(root.leftC, list);
	        list.add(root.getData() + " ");
	       
	        LNRoutputTraversal(root.rightC, list);
	        
	       
	    }

		
		 /*if(root.leftC != null)
		 {
	        list.add(root.leftC.getData());  // traverse the entire left subtree
	        LNRoutputTraversal(root.leftC, list);
		 }
	   if(root.rightC != null)
	   {
		   list.add(root.rightC.getData());
	        LNRoutputTraversal(root.rightC, list);  // traverse the entire right subtree
	   }*/
	   

	}
	
	/*private TreeNode<String> root;

	public MorseCodeTree ()
	{
		buildTree();
	}
	
	public void buildTree() 
	{
		
	}
	
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		
	}*/
	
}
