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
class ListOfDepth
{
	Node root;
	int ind;
	LinkedList<Integer> list=new LinkedList<Integer>();
	void insert(String s,int d)
	{
		Node temp=this.root;
		if (temp==null)
		{
			this.root=new Node(d);
			return;
		}
		int i=0;
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
				if(temp.right==null)
				{
					temp.right=new Node(d);
					return;
				}
				temp=temp.right;
			}
			i++;
		}
	}

int printList(int arr[],int ind)
{
	
	for(int i=0;i<ind;i++)
	{
		list.add(arr[i]);
		
	}
	System.out.print(list);
	return 0;
	
}
	
	
	void leveltraversal(int arr[])
	{
		Node temp=root;
		
		if (temp==null)
		{
			System.out.println("Empty.. ");
			return ;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(temp);
		while(q.size()>0)
		{
	        int size=q.size();
			while(size>0)
			{
				Node temp1=q.peek();
				list.add(q.peek().data);
				q.remove();
				if (temp1.left!=null)
				{
					q.add(temp1.left);
					
					
				}
				if(temp1.right!=null)
				{
					q.add(temp1.right);
					
				}
				//System.out.println(arr[ind]+" "+ind);
				size--;
			}
			System.out.println(list);
			list.clear();

	    }
	}	
			
	void print(Node root)
	{
		if(root==null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	
	public static void main(String rpd[])
	{
		ListOfDepth listofdepth=new ListOfDepth();
		Scanner sc=new Scanner(System.in);
		System.out.println("Arrays size :");
		int size=sc.nextInt();
		System.out.println("String and data :");
		for(int i=0;i<size;i++)
		{
			listofdepth.insert(sc.next(),sc.nextInt());
		}
		listofdepth.print(listofdepth.root);
		int arr[]=new int [size];
		listofdepth.leveltraversal(arr);
		
		
	}
}

		