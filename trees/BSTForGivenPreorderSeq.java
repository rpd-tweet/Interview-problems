import java.util.*;
class BSTForGivenPreorderSeq
{
	int countBST(int seq)
		{
			int bst[]=new int[seq+1];
			bst[0]=bst[1]=1;
			for(int i=2;i<=seq;i++)
			{
				for(int j=0;j<i;j++)
				{
					bst[i]+=(bst[j]*bst[i-j-1]);
				}
			}
			return bst[seq];
		}
	public static void main(String rpd[])
	{		
		BSTForGivenPreorderSeq obj=new BSTForGivenPreorderSeq();
		Scanner sc=new Scanner(System.in);
		System.out.println("Preorder seq :");
	    System.out.println(obj.countBST(sc.nextInt()));
	}
}