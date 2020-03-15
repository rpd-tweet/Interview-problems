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
class SumOfRightLeafs
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
	
	void rightLeafSum(Node root)
	{
		if(root==null)
			return ;
		if(root.right!=null){
		if(root.right.left==null && root.right.right==null)
		{
			sum+=root.right.data;
		}}
		rightLeafSum(root.left);
		rightLeafSum(root.right);
		
	}
	
	public static void main(String rpd[])
	{
		SumOfRightLeafs obj=new SumOfRightLeafs();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		obj.root=obj.insert(obj.root,arr,0);
		obj.rightLeafSum(obj.root);
		System.out.println(obj.sum);
	}
}