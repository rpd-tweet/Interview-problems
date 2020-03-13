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
class PathOfSum
{
	Node root;
	Vector<Integer> v=new Vector<Integer>();
	static int count=0;
	
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
			if (s.charAt(i)=='L')
			{
				if (temp.right==null)
				{
					temp.right=new Node(d);
				}
				temp=temp.right;
			}
		}
	}
	
	void print(Node root)
	{
		if (root==null)
			return;
		print(root.left);
		System.out.println(root.data+" ");
		print(root.right);
	}
	void count(Vector<Integer> v,int j)
	{
		for(int i=j;i<v.size();i++)
		{
			System.out.print(v.get(i)+" ");
		}
		System.out.println();
		count++;
		
	}
	
	void pathSum(Node root,int sum)
	{
		if (root==null)
			return ;
		v.add(root.data);
		pathSum(root.left,sum);
		pathSum(root.right,sum);
		int s=0;
		for(int i=v.size()-1;i>=0;i--)
		{
			s+=v.get(i);
			if (s==sum)
				count(v,i);
			    
			
		}
		v.remove(v.size()-1);
		
	}
	
	public static void main(String rpd[])
	{
		PathOfSum pathofsum=new PathOfSum();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			pathofsum.insert(sc.next(),sc.nextInt());
		}
		System.out.println("Array sum :");
		pathofsum.pathSum(pathofsum.root,sc.nextInt());
		System.out.println("Count :"+pathofsum.count);
		//pathofsum.print(pathofsum.root);
		
	}
}