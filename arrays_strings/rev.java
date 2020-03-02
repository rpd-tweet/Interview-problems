import java.util.*;
class rev
{
	public static void main(String rpd[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("String input :");
		String s = sc.next();
		int l = 0,r = s.length()-1;
		char c[] = s.toCharArray();
		while(l<r)
		{
			if (!Character.isAlphabetic(c[l]))
			{
				l++;
			}
			else if (!Character.isAlphabetic(c[r]))
			{
				r--;
			}
			else
			{
				char temp=c[l];
				c[l]=c[r];
				c[r]=temp;
				l++;
				r--;
			}
		}
		System.out.println("String output :");
		System.out.println(c);
	}
}