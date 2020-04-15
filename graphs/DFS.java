import java.util.*;
class DFS
{
	int v;
	LinkedList<Integer> adj_list[];
	DFS(int v)
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
	 
	void DFSPrintUtil(int s,boolean visited[])
	{
		
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
					DFSPrintUtil(vertex,visited);
				}
			}
		}
	}
	void DFSPrint(int s)
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if (visited[i]==false)
			DFSPrintUtil(i,visited);
		}
	}
				
				
	public static void main(String rpd[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("No.of Nodes:");
		DFS obj=new DFS(sc.nextInt());
		for(int i=0;i<6;i++)
		obj.adjList(sc.nextInt(),sc.nextInt());
		System.out.println("Start Vertex :");
		obj.DFSPrint(sc.nextInt());
		
	}
}
		