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
class DiagTravIt1
{
	Node root;
   void insert(String s,int d)
	{
		if(this.root==null)
		{
			this.root=new Node(d);
			return;
		}
		Node temp=this.root;
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i)=='L')
			{
				if (temp.left==null)
				{
					temp.left=new Node(d);
				}
				temp=temp.left;
			}
			if (s.charAt(i)=='R')
			{
				if (temp.right==null)
				{
					temp.right=new Node(d);
				}
				temp=temp.right;
			}
		}
	}
	
	void printDiag()
	{
		Queue<Node> q=new LinkedList<Node>();
		Node temp=root;
		q.add(temp);
		q.add(null);
		while(q.size()>0)
		{
		  temp=q.remove();
			if(temp==null)
			{
				if (q.size()==0)
					return;
				System.out.println();
				q.add(null);
			}
			else
			{
				
				while(temp!=null)
				{
					System.out.print(temp.data+" ");
					if(temp.left!=null)
						q.add(temp.left);
					temp=temp.right;
				}
			}
				
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
		DiagTravIt1 obj=new DiagTravIt1();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			obj.insert(sc.next(),sc.nextInt());
		}
		obj.printDiag();
		//obj.print(obj.root);
		
		
	}
}