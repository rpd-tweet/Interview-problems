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

class MinTree
{
	Node root;
	
	Node insert(int arr[],int strt,int end)
	{
		if (strt>end)
		{
			return null;
		}
		int mid=(strt+end)/2;
		Node node=new Node(arr[mid]);
		node.left=insert(arr,strt,mid-1);
		node.right=insert(arr,mid+1,end);
		return node;
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
		MinTree mintree=new MinTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		Node temp=mintree.insert(arr,0,size-1);
		mintree.print(temp);
	}
}