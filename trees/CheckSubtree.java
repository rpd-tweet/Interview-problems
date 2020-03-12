import java.util.*;
class Node
{
	Node left,right;
	int data;
	Node(int d)
	{
		this.data=d;
		this.left=this.right=null;
	}
}
class CheckSubtree
{
	Node root,root1;
	
	Node insert(Node root,int d)
	{
		if (root==null)
			return new Node(d);
		if (root.data>d)
		{
			root.left=insert(root.left,d);
		}
		else if(root.data<d)
		{
			root.right=insert(root.right,d);
		}
		return root;
	}
	
	boolean check(Node root,Node root1)
	{
		if (root1==null)
			return true;
		if (root==null)
			return false;
		
		if (isIdentical(root,root1))
			return true;
		return (check(root.left,root1) || check(root.right,root1));
		
	}
	
	boolean isIdentical(Node root,Node root1)
	{
		if (root==null && root1==null)
		{
			return true;
		}
		if (root==null || root1==null)
		{
			return false;
		}
		return (root.data==root1.data && isIdentical(root.left,root1.left) && isIdentical(root.right,root1.right));
		
		
	}
	
	void print(Node root)
	{
		if (root==null)
		{
			return;
		}
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	
	public static void main(String rpd[])
	{
		CheckSubtree checksubtree=new CheckSubtree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array1 size: ");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			checksubtree.root=checksubtree.insert(checksubtree.root,sc.nextInt());
		}
		System.out.println("Array2 size: ");
		size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			checksubtree.root1=checksubtree.insert(checksubtree.root1,sc.nextInt());
		}
		System.out.println(checksubtree.check(checksubtree.root,checksubtree.root1));
		checksubtree.print(checksubtree.root);
		checksubtree.print(checksubtree.root1);
		
	}
}