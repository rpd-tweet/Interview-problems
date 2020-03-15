import java.util.*;
class Node
{
	int data;
	Node left,right;
	Node(int d)
	{
		this.left=this.right=null;
		this.data=d;
	}
}
class SumOfLeftLeafs
{
	Node root;
	int sum=0;
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
	
	void leftLeafSum(Node root)
	{
		if(root==null)
			return ;
		if(root.left!=null){
		if(root.left.left==null && root.left.right==null)
		{
			sum+=root.left.data;
		}}
		leftLeafSum(root.left);
		leftLeafSum(root.right);
		
	}
	
	public static void main(String rpd[])
	{
		SumOfLeftLeafs obj=new SumOfLeftLeafs();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		obj.root=obj.insert(obj.root,arr,0);
		obj.leftLeafSum(obj.root);
		System.out.println(obj.sum);
	}
}