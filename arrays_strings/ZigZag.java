import java.util.*;
class ZigZag
{
	int arr[];
	
	void zigZag()
	{
		boolean flag=true;
		
		for(int i=0;i<arr.length-2;i++)
		{
			if((flag && arr[i]>arr[i+1])|| (!flag && arr[i]<arr[i+1]))
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			 flag=!flag;
		}
	}
				
	
	public static void main(String rpd[])
	{
		ZigZag zigzag = new ZigZag();
		Scanner sc = new Scanner(System.in);
		System.out.println("Array size :");
		int n=sc.nextInt();
		System.out.println("Array elements :");
		zigzag.arr=new int[n];
		for(int i=0;i<n;i++)
		{
			zigzag.arr[i]=sc.nextInt();
		}
		zigzag.zigZag();
		System.out.println(Arrays.toString(zigzag.arr));
	}
}
		