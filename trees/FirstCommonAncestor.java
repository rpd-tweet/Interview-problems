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
class FirstCommonAncestor
{
	Node root;
	boolean v1=false,v2=false;
	
	Node insert(int arr[],int i,Node root)
	{
		if (i<arr.length)
		{
			root=new Node(arr[i]);
			root.left=insert(arr,2*i+1,root.left);
			root.right=insert(arr,2*i+2,root.right);
		}
		return root;
	}
	
	Node findlcaAncestor(Node root,int n1,int n2)
	{
		if (root==null)
			return null;
		Node temp=null;
		if (root.data==n1)
		{
			v1=true;
			temp=root;
		}
		if (root.data==n2)
		{
			v2=true;
			temp=root;
		}
		Node leftlca = findlcaAncestor(root.left,n1,n2);
		Node rightlca =  findlcaAncestor(root.right,n1,n2);
		
		if(temp!=null)
		{
			return temp;
		}
		if (leftlca!=null && rightlca!=null)
		{
			return root;
		}
		return (leftlca!=null)?leftlca:rightlca;			
	}
	
	Node findAncestor(Node root,int n1,int n2)
	{
		Node temp=findlcaAncestor(root,n1,n2);
		if (v1&&v2)
		{
			return temp;
		}
		return null;
	}
	
  void  print(Node root)
	{
		if (root==null)
		{
		return ;
		}
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}

	public static void main(String rpd[])
	{
		FirstCommonAncestor firstcommonancestor=new FirstCommonAncestor();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		firstcommonancestor.root=firstcommonancestor.insert(arr,0,firstcommonancestor.root);
		firstcommonancestor.print(firstcommonancestor.root);
		System.out.println(firstcommonancestor.findAncestor(firstcommonancestor.root,sc.nextInt(),sc.nextInt()).data);
		
	}
}