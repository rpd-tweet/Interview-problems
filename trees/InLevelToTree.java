import java.util.*;
class Node
{
	Node right,left;
	int data;
	Node(int d)
	{
		this.data=d;
		this.left=null;
		this.right=null;
	}
}

class InLevelToTree
{
	
	Node construct(Node node,int in[],int lvl[],int strt,int end)
	{
		
		if (strt>end)
		{
			return null;
		}
		
		if (strt==end)
		{
			return new Node(in[strt]);
		}
		boolean found=true;
		int preind=0;
       
		for(int i=0;i<lvl.length;i++)
		{
			int c=lvl[i];
			for(int j=strt;j<end;j++)
			{
				if (c==in[j])
				{
					node=new Node(in[j]);
					preind=j;
					found=false;
					break;
				}
			}
			if(found==false)
			{
				break;
			}
		}
		
		node.left=construct(node,in,lvl,strt,preind-1);
		node.right=construct(node,in,lvl,preind+1,end);
		return node;
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
		InLevelToTree inleveltotree=new InLevelToTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size:");
		int size=sc.nextInt();
	    int in[]=new int[size];
		int pre[]=new int[size];
		for(int i=0;i<size;i++)
		{
			in[i]=sc.nextInt();
		}
		for(int i=0;i<size;i++)
		{
			pre[i]=sc.nextInt();
		}
		Node node=null;
		Node temp=inleveltotree.construct(node,in,pre,0,size-1);
		inleveltotree.print(temp);
	}
}
		
		
		