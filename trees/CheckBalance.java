
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
class CheckBalance
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
	
	
	boolean checkBalance(Node root,height height)
	{
		if (root==null)
		{
			height.height=0;
			return true;
		}
		height lh=new height();
		height rh=new height();
		boolean left=checkBalance(root.left,lh);
		boolean right=checkBalance(root.right,rh);
		
		height.height=(lh.height>rh.height?lh.height:rh.height)+1;
		
		if ((lh.height-rh.height>=2) || (rh.height-lh.height>=2))
		{
			return false;
		}
		else{
		return (left && right);
		}
		
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
		CheckBalance checkbalance=new CheckBalance();
		height h=new height();
		Scanner sc=new Scanner(System.in);
		System.out.println("Size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			checkbalance.insert(sc.next(),sc.nextInt());
		}
		if(checkbalance.checkBalance(checkbalance.root,h))
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