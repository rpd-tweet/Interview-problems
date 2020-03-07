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
class SymmetricTree
{
	Node root;
	
	boolean check(Node n1,Node n2)
	{
		
		if (n1== null && n2==null)
			return true;
		if (n1!=null && n2!=null && n1.data==n2.data)
			return (check(n1.left,n2.right)&& check(n1.right,n2.left));
		return false;
		
	}
	
	Node insert(int arr[],int i,Node root)
	{
		if (i<arr.length){
			root=new Node(arr[i]);
		root.left=insert(arr,2*i+1,root.left);
		root.right=insert(arr,2*i+2,root.right);
		}
		return root;
	}
	
	public static void main(String rpd[])
	{
		SymmetricTree symmetrictree=new SymmetricTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
	
		int arr[]=new int[sc.nextInt()];
		System.out.println("Array elements :");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		symmetrictree.root=symmetrictree.insert(arr,0,symmetrictree.root);
		System.out.println(symmetrictree.check(symmetrictree.root,symmetrictree.root));
	}
}
			