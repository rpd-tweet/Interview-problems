import java.util.*;
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		this.data=d;
		this.next=null;
	}
}
class InsertLL
{
	Node head;
	InsertLL()
	{
		this.head=null;
	}
	
	void insert(int d)
	{
		Node temp=new Node(d);
		if(head==null)
		{
			this.head=temp;
		}
		else
		{
			Node t=head;
			Node prev=head;
			while(true)
			{
				if (t==null)
				{
					prev.next=temp;
					break;
				}
				if(t.data>d)
				{
					if (t==head)
					{
						temp.next=head;
						head=temp;
						break;
					}
					temp.next=prev.next;
					prev.next=temp;
					break;
				}
				
				prev=t;
				t=t.next;
			}
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
	}
	
	
	public static void main(String rpd[])
	{
		Scanner sc=new Scanner(System.in);
		InsertLL insertll = new InsertLL();
		System.out.println("Array size :");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			insertll.insert(sc.nextInt());
		}
		System.out.println("Node to insert :");
		insertll.insert(sc.nextInt());
		System.out.println("output :");
		insertll.print();
	}
}
		
		
		