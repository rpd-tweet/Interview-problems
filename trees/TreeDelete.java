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
class TreeDelete
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
	
	void delete(int data)
	{
		Node key_node=null,temp=null,parent=null;
		if (root==null)
			System.out.println("deleted");
		else if(root.left==null && root.right==null)
		{
			if (root.data==data)
			{
				System.out.println("deleted");
			}
			else
			{
				System.out.println("Not found");
			}
		}
		else
		{
			
			Queue<Node> q=new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty())
			{
				
				 temp=q.remove();
				 if(temp.left!=null || temp.right!=null)
				 {
					 parent=temp;
				 }
					 
				if (temp.data==data)
				{
					key_node=temp;
				}
				if (temp.left!=null)
				{
					q.add(temp.left);
				}
				if(temp.right!=null)
				{
					q.add(temp.right);
				}
				
			}
		}
			if (key_node!=null)
			{
				key_node.data=temp.data;
				if(parent.right==temp)
				{
					parent.right=null;
					return;
				}
				if (parent.left==temp)
				{
					parent.left=null;
					return;
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
		TreeDelete treedelete=new TreeDelete();
		Scanner sc=new Scanner(System.in);
		System.out.println("no of nodes:");
		int n=sc.nextInt();
		System.out.println("Enter nodes :");
		for(int i=0;i<n;i++)
		{
			treedelete.insert(sc.nextInt());
		}
		System.out.println("Node to delete :");
		treedelete.delete(sc.nextInt());
		
		treedelete.print(treedelete.root);
		
	}
}
		
		
			
	