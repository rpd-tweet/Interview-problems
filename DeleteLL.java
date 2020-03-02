import java.util.*;
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		this.next=null;
		this.data=d;
	}
}
class DeleteLL
{
	Node head;
	DeleteLL()
	{
		this.head=null;
	}
	
	void insert(int d)
	{
		Node temp = new Node(d);
		if (head==null)
		{
			head=temp;
		}
		else
		{
			Node t=head;
			while(t.next!=null)
			{
				t=t.next;
			}
			t.next=temp;
		}
	}
	void delete(int d)
	{
		Node prev=head;
		Node temp=head;
		while(temp.data!=d)
		{
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
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
		DeleteLL deletell=new DeleteLL();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			deletell.insert(sc.nextInt());
		}
		System.out.println("Element to delete :");
		deletell.delete(sc.nextInt());
		System.out.println("Output :");
		deletell.print();
	}
}

		
			