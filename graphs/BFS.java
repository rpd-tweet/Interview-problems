import java.util.*;
class BFS
{
	int v;
	LinkedList<Integer> adj_list[];
	BFS(int v)
	{
		this.v=v;
		this.adj_list=new LinkedList[v];
		for (int i=0;i<v;i++)
		{
			adj_list[i]=new LinkedList();
		}
	}
	 void adjList(int node1,int node2)
	{
		adj_list[node1].add(node2);
	}
	 
	void bfsPrint(int s)
	{
		boolean visited[]=new boolean[v];
		LinkedList<Integer> l=new LinkedList<Integer>();
		l.add(s);
		visited[s]=true;
		while(l.size()!=0)
		{
			s=l.poll();
			System.out.print(s+" ");
			Iterator<Integer> i=adj_list[s].listIterator();
			while(i.hasNext())
			{
				int vertex=i.next();
				if (!visited[vertex])
				{
					visited[vertex]=true;
					l.add(vertex);
				}
			}
		}
	}
		
				
				
	public static void main(String rpd[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("No.of Nodes:");
		BFS obj=new BFS(sc.nextInt());
		for(int i=0;i<6;i++)
		obj.adjList(sc.nextInt(),sc.nextInt());
		System.out.println("Start Vertex :");
		obj.bfsPrint(sc.nextInt());
		
	}
}
		