import java.util.*;
class Node
{
	int data;
	Node left,right;
	Node(int d)
	{
		this.data=d;
		this.left=this.right=null;
	}
}
class PreOrderUsingRightPointer
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
	
	void pre()
	{
		if(root==null)
		{
			return;
		}
		Stack<Node> stack=new Stack<Node>();
		stack.push(root);
		Node pre=null;
		while(!stack.isEmpty())
		{
			Node temp=stack.peek();
			stack.pop();
			if (temp.right!=null)
				stack.push(temp.right);
			if (temp.left!=null)
				stack.push(temp.left);
			if(pre!=null)
			{
				pre.right=temp;
			}
			pre=temp;
		}
		
	}
		
	void print(Node root)
	{
		while(root!=null){
		System.out.print(root.data+" ");
		root=root.right;
		}
	}
	
	public static void main(String rpd[])
	{
		PreOrderUsingRightPointer obj = new PreOrderUsingRightPointer();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			obj.insert(sc.next(),sc.nextInt());
		}
	
		obj.pre();
		obj.print(obj.root);	
	}
}