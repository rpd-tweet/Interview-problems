import java.util.*;
class Node
{
	Node right,left;
	char data;
	Node(char d)
	{
		this.data=d;
		this.left=null;
		this.right=null;
	}
}

class InPreToTree
{
	int preind=0;
	Node construct(char in[],char pre[],int strt,int end)
	{
		
		if (strt>end)
		{
			return null;
		}
		Node tnode=new Node(pre[preind++]);
		
		if (strt==end)
		{
			return tnode;
		}
         
		int search=searchNode(in,strt,end,tnode.data);
		
		tnode.left=construct(in,pre,strt,search-1);
		tnode.right=construct(in,pre,search+1,end);
		return tnode;
	}
	
	int searchNode(char in[],int strt,int end,char data)
	{
		int i;
		for( i=strt;i<=end;i++)
		{
			if (in[i]==data)
			{
				
				return i;
			}
		}
		return i;
	}
	void print(Node temp)
	{
		if(temp==null)
			return;
		print(temp.left);
		System.out.print(temp.data+" ");
		print(temp.right);
	}
	
	
	
	public static void main(String rpd[])
	{
		InPreToTree inpretotree=new InPreToTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size:");
		int size=sc.nextInt();
		char in[]=new char[size];
		char pre[]=new char[size];
		for(int i=0;i<size;i++)
		{
			in[i]=sc.next().charAt(0);
		}
		for(int i=0;i<size;i++)
		{
			pre[i]=sc.next().charAt(0);
		}
		Node temp=inpretotree.construct(in,pre,0,size-1);
		inpretotree.print(temp);
	}
}
		
		
		