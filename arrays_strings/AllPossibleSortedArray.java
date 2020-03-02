import java.util.*;
class AllPossibleSortedArray
{
	int arr1[],arr2[],res[];
	
	void sortedArray()
	{
		res = new int[arr1.length+arr2.length];
		sortedArrayUtil(arr1,arr2,res,0,0,arr1.length,arr2.length,0,true);
	}
	
	void print(int res[],int len)
	{
		System.out.println("Output: ");
		for(int i=0;i<len;i++)
		{
			System.out.print(res[i]+" ");
		}
		System.out.println();
		
	}
	
	void sortedArrayUtil(int arr1[],int arr2[],int res[],int i,int j,int m,int n,int len,boolean flag)
	{
		if(flag)
		{
			if (len!=0)
			{
				print(res,len+1);
			}
				
				
			for(int k=i;k<m;k++)
			{
				if(len==0)
				{
					res[len]=arr1[k];
					sortedArrayUtil(arr1,arr2,res,k+1,j,m,n,len,!flag);
					
				}
				else if (arr1[k]>res[len])
					{
						res[len+1]=arr1[k];
						sortedArrayUtil(arr1,arr2,res,k+1,j,m,n,len+1,!flag);
					}
					
			}
		}
		else
		{
			for(int l=j;l<n;l++)
			{
				if (arr2[l]>res[len])
					{
						res[len+1]=arr2[l];
						sortedArrayUtil(arr1,arr2,res,i,l+1,m,n,len+1,!flag);
					}
					
			}
		}
				
	}
		
	
	public static void main(String rpd[])
	{
		Scanner sc = new Scanner(System.in);
		AllPossibleSortedArray allpossiblesortedarray = new AllPossibleSortedArray();
		System.out.println("Size of array 1 :");
		int n=sc.nextInt();
		System.out.println("Array 1 elements :");
		allpossiblesortedarray.arr1=new int[n];
		for(int i=0;i<n;i++)
		{
			allpossiblesortedarray.arr1[i]=sc.nextInt();
		}
		System.out.println("Size of array 2 :");
	    n=sc.nextInt();		
		System.out.println("Array 2 elements :");
		allpossiblesortedarray.arr2=new int[n];
		for(int i=0;i<n;i++)
		{
			allpossiblesortedarray.arr2[i]=sc.nextInt();
		}
		allpossiblesortedarray.sortedArray();
	}
}
		