import java.util.*;
class Node
{
	Node next;
	char data;
	Node(char d)
	{
		this.next=null;
		this.data=d;
	}
}
class CompareString
{
	Node head;
	CompareString()
	{
		this.head=null;
	}
	
	void insert(char d)
	{
		if (head==null)
		{
			head=new Node(d);
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=new Node(d);
		}
	}
	void compareString(Node head,Node root)
	{
		
		Node temp1=head;
		Node temp2=root;
		if (temp1==null && temp2==null)
		{
				System.out.println(1);
				return;
		}
		while(temp1!=null && temp2!=null && temp1.data==temp2.data)
		{
			temp1=temp1.next;
			temp2=temp2.next;
		}
		if (temp1!=null && temp2!=null)
		{
			if (temp1.data>temp2.data)
			{
				System.out.println(1);
			}
			else
				System.out.println("-1");
			return;
		}
		if (temp1!=null && temp2==null)
		{
			System.out.println(1);
			return;
		}
		if (temp1==null && temp2!=null)
		{
			System.out.println("-1");
		}
	}
		
		
	
	void print()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String rpd[])
	{
		CompareString comparestring1=new CompareString();
		CompareString comparestring2=new CompareString();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array 1 size :");
		int n=sc.nextInt();
		System.out.println("Array 1 elements :");
		for(int i=0;i<n;i++)
		{
			comparestring1.insert(sc.next().charAt(0));
		}
		System.out.println("Array 2 size :");
		n=sc.nextInt();
		System.out.println("Array 2 elements :");
		for(int i=0;i<n;i++)
		{
			comparestring2.insert(sc.next().charAt(0));
		}
		new CompareString().compareString(comparestring1.head,comparestring2.head);
		//comparestring1.print();
		//comparestring2.print();
	}
}
		
		
	