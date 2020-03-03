import java.util.*;
class RedundantBraces
{
	void check(char s1[])
	{
		int count=0;
		Stack<Character> stack=new Stack<Character>();
		for (char c:s1)
		{
			boolean flag=true;
			if(c==')')
			{
				char top=stack.pop();
				while(top!='(')
				{
					if (c=='+' || c=='-' || c=='*' || c=='/')
						flag=false;
					top=stack.pop();
				}
				if (flag)
				{
					count++;
				}
			}
			else
			{
				stack.push(c);
			}
		}
		System.out.println(count);
					
		
		
	}
	
	
	public static void main(String rpd[])
	{
		RedundantBraces redundantbraces = new RedundantBraces();
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		char s1[]=s.toCharArray();
		redundantbraces.check(s1);
	}
}