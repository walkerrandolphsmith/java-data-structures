package translator;

/**
 * Write a description of class BinaryTree here.
 * 
 * @author (Walker Smith) 
 * @version (7/10/2012)
 */
public class BinaryTree<E>
{
    protected Node<E> root;
    
    protected class Node<E>
    {
        E data;
        Node<E> left;
        Node<E> right;
        
        public Node(E data)
        {
            this.data = data;
            left = null;
            right = null;
        }
        
        public String toString ()
        {
            return data.toString();
        }
    }

    public BinaryTree()
    {
        this(null);
    }
    
    protected BinaryTree(Node<E> root)
    {
        this.root = root;
    }
    
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
    {
        root = new Node<E>(data);
        if(leftTree != null)
        {
            root.left = leftTree.root;
        }
        else
        {
            root.left = null;
        }
        if(rightTree != null)
        {
            root.right = rightTree.root;
        }
        else
        {
            root.right = null;
        }
    }
    
    public BinaryTree<E> getLeftSubtree()
    {
        if(root != null && root.left != null)
        {
            return new BinaryTree<E>(root.left);
        }
        else
        {
            return new BinaryTree<E>(null);
        }
    }
    
    public BinaryTree<E> getRightSubtree()
    {
        if(root != null && root.right != null)
        {
            return new BinaryTree<E>(root.right);
        }
        else
        {
            return new BinaryTree<E>(null);
        }
    }
    
    public E getData()
    {
        return root.data;
    }
    
    public boolean isEmpty()
    {
    	return root == null; 
    }
    
    public boolean isLeaf()
    {
        return root == null? false : (root.left == null && root.right == null);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
    {
        for(int i = 1; i < depth; i++)
        {
            sb.append("  ");
        }
        if (node == null)
        {
                sb.append("null\n");
        }
        else
        {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
    
    public boolean isBinary()
    {
        if(root == null)
        {
        	return true;
        }
        else
        {
        	return getLeftSubtree().isBinary() && getRightSubtree().isBinary();
        }
    }
}


















