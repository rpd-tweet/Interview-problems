import java.util.*;
class BasicGraph
{
	int v;
	ArrayList<ArrayList<Integer>> adj_list;
	BasicGraph(int v)
	{
		this.v=v;
		this.adj_list=new ArrayList<ArrayList<Integer>>();
		for (int i=0;i<v;i++)
		{
			adj_list.add(new ArrayList<Integer>());
		}
	}
	 void adjList(int node1,int node2)
	{
		adj_list.get(node1).add(node2);
	}
	 void print()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print("Vertex- "+i);
			for(int j=0;j<adj_list.get(i).size();j++)
			{
				System.out.print("->"+adj_list.get(i).get(j));
			}System.out.println();
		}
	}
				
				
	public static void main(String rpd[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("No.of Nodes:");
		BasicGraph obj=new BasicGraph(sc.nextInt());
		for(int i=0;i<6;i++)
		obj.adjList(sc.nextInt(),sc.nextInt());
		obj.print();
		
	}
}
		