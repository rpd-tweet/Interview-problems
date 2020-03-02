import java.util.*;
class CountTriplets
{
	int countTriplets(int arr[],int n,int sum)
	{
		int j,k;
		int count=0;
		for (int i=0;i<n-2;i++)
		{
			j=i+1;
			k=n-1;
			while(j<k)
			{
				if (arr[i]+arr[j]+arr[k]<sum)
				{
					count+=(k-j);
					j++;
				}
				else
				{
					k--;
				}
			}
		}
		return count;
	}
					
	
	
	
	public static void main(String rpd[])
	{
		Scanner sc = new Scanner(System.in);
		CountTriplets counttriplets=new CountTriplets();
		System.out.println("Array Input length :");
		int n = sc.nextInt();
		System.out.println("Array input :");
		int arr[] = new int[n];
		for (int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Total sum :");
		int sum = sc.nextInt();
		System.out.println("Count :");
		System.out.println(counttriplets.countTriplets(arr,n,sum));
	}
}
			
		