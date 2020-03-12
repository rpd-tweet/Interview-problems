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
class height
	{
		int height=0;
	}
class CheckBST
{
	Node root;
	
	
	void insert(String s,int d)
	{
		
		Node temp=this.root;
		if (temp==null)
		{
			this.root=new Node(d);
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='L')
			{
				if (temp.left==null)
				{
					temp.left=new Node(d);
					return;
				}
				temp=temp.left;
			}
			if(s.charAt(i)=='R')
			{
				if (temp.right==null)
				{
					temp.right=new Node(d);
					return;
				}
				temp=temp.right;
			}
		}
	}
	
	
	boolean checkBalance(Node root,int min,int max)
	{
		if (root==null)
		{
			return true;
		}
		
		if (root.data<min || root.data>max)
			return false;
		
		boolean left=checkBalance(root.left,min,root.data-1);
		boolean right=checkBalance(root.right,root.data+1,max);
		
		return left && right;
	}
	
	
	
	
		
	void print(Node root)
	{
		if (root==null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	
	public static void main(String rpd[])
	{
		CheckBST checkbalance=new CheckBST();
		height height=new height();
		Scanner sc=new Scanner(System.in);
		System.out.println("Size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			checkbalance.insert(sc.next(),sc.nextInt());
		}
		if(checkbalance.checkBalance(checkbalance.root,Integer.MIN_VALUE,Integer.MAX_VALUE))
		{
			System.out.println("Balanced..");
		}
		else
		{
			System.out.println("Not Balanced..");
		}
		checkbalance.print(checkbalance.root);
	}
}