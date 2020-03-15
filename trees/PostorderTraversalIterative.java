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
class PostorderTraversalIterative
{
	Node root;
	
	Node insert(Node root,int arr[],int i)
	{
		if (i<arr.length)
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
	Stack<Node> stack1=new Stack<Node>();
	Node temp=root;
	stack.push(temp);
	while(stack.size()>0)
	{
		temp=stack.pop();
		if(temp.left!=null)
			stack.push(temp.left);
		if (temp.right!=null)
			stack.push(temp.right);
		stack1.push(temp);
	}
	while(stack1.size()>0)
	{
		System.out.print(stack1.pop().data+" ");
	}
	
	}
	
	
	public static void main(String rpd[])
	{
		PostorderTraversalIterative obj=new PostorderTraversalIterative();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size: ");
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