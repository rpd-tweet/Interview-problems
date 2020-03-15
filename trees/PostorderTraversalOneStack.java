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
class PostorderTraversalOneStack
{
	Node root;
	
	Node insert(Node root,int arr[],int i)
	{
		if(i<arr.length)
		{
			root=new Node(arr[i]);
			root.left=insert(root.left,arr,2*i+1);
			root.right=insert(root.right,arr,2*i+2);
		}
		return root;
	}
	
	void printPost()
	{
		Stack<Node> stack=new Stack<Node>();
        Node temp=root;
		while(true)
		{
			while(temp!=null)
			{
				stack.push(temp);
				stack.push(temp);
				temp=temp.left;
			}
			if (stack.size()==0)
				break;
			temp=stack.pop();
			if (!stack.empty() && temp==stack.peek())
				temp=temp.right;
			else
			{
				System.out.print(temp.data+" ");
				temp=null;
			}
		}
		
	}
	
	public static void main(String rpd[])
	{
		PostorderTraversalOneStack obj=new PostorderTraversalOneStack();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		obj.root=obj.insert(obj.root,arr,0);
		obj.printPost();
	}
}