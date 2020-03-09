import java.util.*;

class Node
{
	Node left=null;
	Node right=null;
	int data;
	Node(int d)
	{
		this.data=d;
		this.right=null;
		this.left=null;
	}
}
class TreeInsertRec
{
	Node root;
	Node insert(Node root,int arr[],int d)
	{
		if (d<arr.length){
			root= new Node(arr[d]);
		root.left=insert(root.left,arr,2*d+1);
		root.right=insert(root.right,arr,2*d+2);
		}
		return root;
	}
	
	
	public static void main(String rpd[])
	{
		TreeInsertRec treeinsertrec=new TreeInsertRec;
		Scanner sc=new Scanner(System.in);
		System.out.println("no of nodes:");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter array :");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		treeinsertrec.insert(treeinsertrec.root,arr,0);
	}
}
