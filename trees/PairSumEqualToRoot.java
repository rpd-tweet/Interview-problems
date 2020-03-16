import java.util.*;
import java.util.Map.Entry; 
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
class PairSumEqualToRoot
{
	Node root;
   void insert(String s,int d)
	{
		if(this.root==null)
		{
			this.root=new Node(d);
			return;
		}
		Node temp=this.root;
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i)=='L')
			{
				if (temp.left==null)
				{
					temp.left=new Node(d);
				}
				temp=temp.left;
			}
			if (s.charAt(i)=='R')
			{
				if (temp.right==null)
				{
					temp.right=new Node(d);
				}
				temp=temp.right;
			}
		}
	}
	
	boolean printDiagutil(Node root,int d,HashSet<Integer> hash)
	{
		if(root==null)
			return false;
		hash.add(root.data);
		if (hash.contains(d-root.data))
			return true;
		boolean res= printDiagutil(root.left,d,hash) || printDiagutil(root.left,d,hash);
		return res;
		
		
	}
	
	boolean printDiag(Node root,int d)
	{
		HashSet<Integer> hash=new HashSet<Integer>();
		return printDiagutil(root.left,d,hash) || printDiagutil(root.right,root.data,hash);
		
	}
	void print(Node root)
	{
		if (root==null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	public static void main(String rpd[])
	{
		PairSumEqualToRoot obj=new PairSumEqualToRoot();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			obj.insert(sc.next(),sc.nextInt());
		}
		if (obj.printDiag(obj.root,obj.root.data))
			System.out.println("Yes");
		else
			System.out.println("No");		
	}
}