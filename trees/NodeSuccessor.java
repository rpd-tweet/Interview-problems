import java.util.*;
class Node
{
	Node left,right,parent;
	int data;
	Node(int d)
	{
		this.data=d;
		this.left=this.parent=null;
		this.right=null;
	}
}
class NodeSuccessor
{
	Node root;
	
	Node insert(Node root,int d)
	{
		if (root==null)
		{
			return new Node(d);
		}
		else
		{
			Node temp=null;
			if(root.data>d)
			{
				temp=insert(root.left,d);
				root.left=temp;
				temp.parent=root;
			}
			if(root.data<d)
			{
				temp=insert(root.right,d);
				root.right=temp;
				temp.parent=root;
			}
		}
        return root;	
	}
	
	Node search(Node root,int d)
	{
		
		if (root==null)
		{
			return null;
		}
		if (root.data==d)
		{
			return root;
		}
		if (root.data>d)
		{
			Node temp=search(root.left,d);
			if (temp!=null)
			{
				return temp;
			}
		}
	
			Node temp=search(root.right,d);
			return temp;
		
		
	}
	
	 
	 Node successor(Node root,int d)
	 {
		 Node suc=search(root,d);
		 if(suc.right!=null)
		 {
			 suc=suc.right;
			 while(suc.left!=null)
			 {
				 suc=suc.left;
			 }
			 return suc;
		 }
		 
		 Node pare=suc.parent;
		 while(pare!=null && pare.right==suc)
		 {
			 suc=pare;
			 pare=pare.parent;
		 }
		 return pare;
		 
		 
		 
	 }
	 
	 
	void print(Node root)
	{
		if (root==null)
		{
			return;
		}
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	
	
	
	public static void main(String rpd[])
	{
		NodeSuccessor nodesuccessor = new NodeSuccessor();
		Scanner sc=new Scanner(System.in);
		System.out.println("Array size :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			nodesuccessor.root=nodesuccessor.insert(nodesuccessor.root,sc.nextInt());
		}
		System.out.println("node :");
		System.out.println(nodesuccessor.successor(nodesuccessor.root,sc.nextInt()).data);
	    nodesuccessor.print(nodesuccessor.root);
	}
}
		