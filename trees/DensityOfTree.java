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
class Size
{
	int size=0;
}
class DensityOfTree
{
	Node root;
	
	Node insert(Node root,int arr[],int index)
	{
		if (index<arr.length)
		{
			root=new Node(arr[index]);
			root.left=insert(root.left,arr,2*index+1);
			root.right=insert(root.right,arr,2*index+2);
		}
		return root;
	}
	
	int findHeightSize(Node root,Size s)
	{
		if (root==null)
			return 0;
		int left=findHeightSize(root.left,s);
		int right=findHeightSize(root.right,s);
		s.size++;
		return Math.max(left,right)+1;
	}
	
	float findDensity()
	{
		Size s=new Size();
		int height=findHeightSize(root,s);
		return (float) s.size/height;
	}
	
	public static void main(String rpd[])
	{
		DensityOfTree obj=new DensityOfTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int arr[]=new int[sc.nextInt()];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		obj.root=obj.insert(obj.root,arr,0);
		System.out.println("Density : "+obj.findDensity());
	}
}