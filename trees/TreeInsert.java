import java.util.*;
import java.util.Queue;
class Node
{
	Node right;
	Node left;
	int data;
	Node(int d)
	{
		this.data=d;
		this.left=null;
		this.right=null;
	}
}
class TreeInsert
{
	
	Node root;
	void insert(int data)
	{
		if (root==null)
		{
			root=new Node(data);
			return;
		}
		else
		{
			Queue<Node> q=new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty())
			{
				Node temp=q.peek();
				q.remove();
				if (temp.left==null)
				{
					temp.left=new Node(data);
					break;
				}
				else
				{
					q.add(temp.left);
				}
				if(temp.right==null)
				{
					temp.right=new Node(data);
					break;
				}
				else
				{
					q.add(temp.right);
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
		TreeInsert treeinsert=new TreeInsert();
		Scanner sc=new Scanner(System.in);
		System.out.println("no of nodes:");
		int n=sc.nextInt();
		System.out.println("Enter nodes :");
		for(int i=0;i<n;i++)
		{
			treeinsert.insert(sc.nextInt());
		}
		
		treeinsert.print(treeinsert.root);
		
	}
}
		
		
			
	