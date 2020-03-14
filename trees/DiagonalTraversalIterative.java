import java.util.*;
class Node
{
	int data;
	Node right,left;
	Node(int d)
	{
		this.data=d;
		this.left=this.right=null;
	}
}
class DiagonalTraversalIterative
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
	
	void printList(LinkedList<Node> l)
	{
		for(Node t:l)
		{
			System.out.print(t.data+" ");
		}
		System.out.println();
	}
	
	void printDiagonal()
	{
		if (root==null)
			return;
		LinkedList<Node> q=new LinkedList<Node>();
		//printList(q);
		
		while(true)
		{
			System.out.print(root.data+" ");
			if (root.left!=null)
			{
				q.add(root.left);
			}
			if (root.right!=null)
			{
				//printList(q);
			    root=root.right;
			}
			else
			{
			root=q.removeFirst();
			}
			if(q.size()==0)
				break;
		}
	}
	
	void print(Node root)
	{
		if( root==null)
			return;
		print(root.left);
		System.out.println(root.data+" ");
		print(root.right);
	}
	
	public static void main(String rpd[])
	{
		DiagonalTraversalIterative obj=new DiagonalTraversalIterative();
		Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			obj.insert(sc.next(),sc.nextInt());
		}
         obj.printDiagonal();
         obj.print(obj.root);		 
	}
}
	