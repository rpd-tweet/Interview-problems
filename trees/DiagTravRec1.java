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
class DiagTravSumRec1
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
	
	void printDiagutil(Node root,int d,HashMap<Integer,Integer> hash)
	{
		if(root==null) return;
		Integer v=hash.get(d);
		
		v+=root.data;
		
		hash.put(d,v);
		printDiagutil(root.left,d+1,hash);
		printDiagutil(root.right,d,hash);
		
	}
	
	void printDiag(Node root,int d)
	{
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		printDiagutil(root,d,hash);
		for(Entry<Integer,Integer> entry:hash.entrySet())
		{
			System.out.println(entry.getValue());
		}
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
		DiagTravSumRec1 obj=new DiagTravSumRec1();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			obj.insert(sc.next(),sc.nextInt());
		}
		obj.printDiag(obj.root,0);
		//obj.print(obj.root);
		
		
	}
}