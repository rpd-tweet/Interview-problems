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
class BoundaryTraversal
{
	Node root;
	
	void insert(String s,int d)
	{
		if (this.root==null)
		{
			this.root=new Node(d);
			return;
		}
		Node temp=this.root;
	    for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i)=='L')
			{
				if (temp.left==null){
					temp.left=new Node(d);
					return;
					}
				temp=temp.left;
			}
			if (s.charAt(i)=='R')
			{
				if (temp.right==null){
					temp.right=new Node(d);
					return;
					}
				temp=temp.right;
			}
		}
	}				
	
	void printLeft(Node root)
	{
		if (root==null)
		{
			return;
		}
		if(root.left!=null)
		{
			System.out.print(root.data+" ");
			printLeft(root.left);
		}
		else if(root.right!=null)
		{
			System.out.println(root.data+" ");
			printLeft(root.left);
		}
	}
	void printRight(Node root)
	{
		if (root==null)
		{
			return;
		}
		if(root.right!=null)
		{
			System.out.print(root.data+" ");
			printLeft(root.right);
		}
		else if(root.left!=null)
		{
			System.out.println(root.data+" ");
			printLeft(root.right);
		}
	}
	
	void printLeaf(Node root)
	{
		if (root==null)
			return ;
		printLeaf(root.left);
		if (root.left==null && root.right==null)
		{
			System.out.print(root.data+" ");
		}
		printLeaf(root.right);
	}
	
	void printBoundary()
	{
		if (root==null)
			return ;
		System.out.print(root.data+" ");
		printLeft(root.left);		
		printLeaf(root.left);
		printLeaf(root.right);
		
		printRight(root.right);
	}
	
	public static void main(String rpd[])
	{
		BoundaryTraversal obj=new BoundaryTraversal();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			obj.insert(sc.next(),sc.nextInt());
		}
		obj.printBoundary();
	}
}