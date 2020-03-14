import java.util.*;
class DepthFromPreOrder
{
	int findDepth(String s,int ind)
	{
		if (ind>s.length() ||s.charAt(ind)=='l')
			return 0;
		ind++;
		int left=findDepth(s,ind);
		ind++;
		int right=findDepth(s,ind);
		
		return Math.max(left,right)+1;
	}
	public static void main(String rpd[])
	{
		DepthFromPreOrder obj=new DepthFromPreOrder();
		Scanner sc=new Scanner(System.in);
		System.out.println("Preorder :");
		String s=sc.next();
		System.out.println("Depth : "+obj.findDepth(s,0));
		
	}
}
		