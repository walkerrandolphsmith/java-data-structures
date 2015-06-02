package translator;

/**

Huffman tree is decoder
HashMap is an encoder

*/
@SuppressWarnings("hiding")
public class HuffmanTree<Character> extends BinaryTree<Character> 
{
	public HuffmanTree()
	{
		this(null);
	}
	
	protected HuffmanTree(Node<Character> root)
	{
		super(root);
	}
	
	
	public void setLeftSubtree(HuffmanTree<Character> newLeft)
	{
		if(root != null)
		{
			root.left = newLeft.root;
		}
	}
	
	public void setRightSubtree(HuffmanTree<Character> newRight)
	{
		if(root != null)
		{
			root.right = newRight.root;
		}
	}
	public HuffmanTree<Character> getLeftSubtree()
	{
		if(root != null && root.left != null)
		{
			return new HuffmanTree<Character>(root.left);
		}
		else
		{
			return new HuffmanTree<Character>(null);
		}
	}
	    
	public HuffmanTree<Character> getRightSubtree()
	{
		if(root != null && root.right != null)
		{
			return new HuffmanTree<Character>(root.right);
		}
		else
		{
			return new HuffmanTree<Character>(null);
		}
	}
	    
	public void add(Character data, String code)
	{
		if(code.length() == 0)
		{
			if(isEmpty())
			{
				root = new Node<Character>(data);
			}
		}
		else
		{
			if(isEmpty())
			{
				root = new Node('*');
			}
				HuffmanTree<Character> tempTree;
				switch(code.charAt(0))
				{
					case '0': 
						tempTree = getLeftSubtree();
						tempTree.add(data, code.substring(1));
						setLeftSubtree(tempTree);
					break;
					case '1' :
						tempTree = getRightSubtree();
						tempTree.add(data, code.substring(1));
						setRightSubtree(tempTree);
					break;
				}
		}
	 }	
	
	public String decode(String code)
	{
		String remaining = code;
		String decoded = "";
		while(remaining.length() > 0)
		{
			String result = decodeOne(remaining);
			decoded = decoded + result.substring(0, 1);
			remaining = result.substring(1);
		}
		return decoded;
	}
	
	private String decodeOne(String code)
	{
		if(isLeaf())
		{
			return root.data.toString() + code;
		}
		else
		{
			if(code.length() == 0)
			{
				return root == null? "Does not exist" : root.data.toString();
			}
				HuffmanTree<Character> tempTree;
				switch(code.charAt(0))
				{
					case '0': 
						tempTree = getLeftSubtree();
						return tempTree.decodeOne(code.substring(1));
					case '1' :
						tempTree = getRightSubtree();
						return tempTree.decodeOne(code.substring(1));
				}
				return "";
		}
	}
}
