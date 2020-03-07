import java.util.*;
import java.lang.Math;
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
class ContinuousTree
{
	Node root;
	
	boolean check(Node n1)
	{
		if (n1==null)
			return true;
		if(n1.left==null && n1.right==null)
			return true;
		if(n1.left==null)
			return Math.abs(n1.data-n1.right.data)==1 && check(n1.right);
		if(n1.right==null)
			return Math.abs(n1.data-n1.left.data)==1 && check(n1.left);
		return Math.abs(n1.data-n1.left.data)==1 && check(n1.left) && Math.abs(n1.data-n1.right.data)==1 && check(n1.right);
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
		ContinuousTree continuoustree=new ContinuousTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
	
		int arr[]=new int[sc.nextInt()];
		System.out.println("Array elements :");
		
		for(int i=0;i<arr.length;i++)
		{
			continuoustree.insert(sc.next(),sc.nextInt());
		}
		//continuoustree.insert(arr,0,continuoustree.root);
		System.out.println(continuoustree.check(continuoustree.root));
		//ContinuousTree.print(ContinuousTree.root);
	}
}
	
		