import java.util.*;
import java.io.*;
class UnixStyle
{
	void unixStyle(String string)
	{
		Stack<String> stack = new Stack<String>();
		char c[]=string.toCharArray();
		int i=0;
		String dir="";
		while(i<string.length())
		{
			dir="";	
			while(i<string.length() && c[i]=='/' )
			{
				i++;
			}
			while (i<string.length() && c[i]!='/')
			{
				dir+=c[i];
				i++;
			}
			if (dir.equals("."))
			{
				continue;
			}
			else if(dir.equals(".."))
			{
				if (!stack.empty())
					stack.pop();
			}
			else if(dir.length()!=0)
			{
				stack.push(dir);
			}
			
		}
		Stack<String> s1=new Stack<String>();
		while(!stack.empty())
		{
			s1.push(stack.pop());
		}
		String res="/";
		while(!s1.empty())
		{
			if (s1.size()!=1)
				res+=(s1.pop()+"/");
			else
				res+=s1.pop();
			
		}
		System.out.println(res);
	}
	
	
	public static void main(String rpd[])
	{
		UnixStyle unixstyle = new UnixStyle();
		Scanner sc=new Scanner(System.in);
		String string = sc.next();
		unixstyle.unixStyle(string);
	}
}
		
		