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
class SumOfAllNodes
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
	
	int sumOfNodes(Node root,int sum)
	{
		if (root==null)
			return sum;
		sum=sumOfNodes(root.left,sum);
		sum+=root.data;
		sum=sumOfNodes(root.right,sum);
		return sum;
	}
	
	public static void main(String rpd[])
	{
		SumOfAllNodes obj=new SumOfAllNodes();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		obj.root=obj.insert(obj.root,arr,0);
		System.out.println(obj.sumOfNodes(obj.root,0));
	}
}