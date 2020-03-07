import java.util.*;
class Node
{
	Node left,right;
	int data;
	Node(int d)
	{
		this.data=d;
		this.left=null;
		this.right=null;
	}
}
class FoldableTree
{
	Node root;
	
	boolean check(Node n1,Node n2)
	{
		
		if (n1== null && n2==null)
			return true;
		if (n1!=null && n2!=null)
			return (check(n1.left,n2.right)&& check(n1.right,n2.left));
		return false;
		
	}
	
	void insert(String s,int d)
	{
		Node temp=this.root;
		int i=0;
		if (this.root==null)
			{
				this.root=new Node(d);
				return;
			}
		while(i<s.length())
		{
			if (s.charAt(i)=='L')
			{
				if (temp.left==null)
				{ 
			      temp.left=new Node(d);
				  return;
				}
				temp=temp.left;
			}
			if (s.charAt(i)=='R')
			{
				if (temp.right==null)
				{ 
			      temp.right=new Node(d);
				  return;
				}
				temp=temp.right;
			}
			i++;
		}
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
		FoldableTree foldabletree=new FoldableTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
	
		int arr[]=new int[sc.nextInt()];
		System.out.println("Array elements :");
		for(int i=0;i<arr.length;i++)
		{
			foldabletree.insert(sc.next(),sc.nextInt());
		}
		System.out.println(foldabletree.check(foldabletree.root,foldabletree.root));
		//foldabletree.print(foldabletree.root);
	}
}
			