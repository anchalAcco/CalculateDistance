package asses;
import java.util.*;
public class GraphSol {
	
	
	private static class Edge{
	        String src;
	        String dest;
	        int wt;
	        Edge(String src,String dest,int wt)
	        {
	            this.src=src;
	            this.dest=dest;
	            this.wt=wt;
	        }
	    }
	  private static class Graph{
	        int vertices;
	        LinkedList<Edge>[] adj;

	        int noOfpaths;
	        int SumOfDistances=0;
	        Graph(int vertices)
	        {
	            this.vertices=vertices;
	            adj=new LinkedList[vertices];
	            for(int i=0;i<vertices;i++)
	            {
	                adj[i]=new LinkedList<>();
	            }
	        }
	        public void addEdge(String src,String dest,int wt)
	        {
	            Edge first=new Edge(src,dest,wt);
	            Edge sec=new Edge(dest,src,wt);
	            int index1=(int)(src.charAt(0))-65;
	            int index2=(int)(dest.charAt(0))-65;
	            adj[index1].addFirst(first);
	            adj[index2].addFirst(sec);
	        }
	        public double calculateAverageDistanceBetweenTwoPoints(String x,String y)
	        {
	            boolean ifvisited[]=new boolean[vertices];
	            for(int i=0;i<vertices;i++)
	                ifvisited[i]=false;
	            noOfpaths=0;
	            SumOfDistances=0;
	            ifvisited[(int)(x.charAt(0))-65]=true;
	            calculate(x,y,ifvisited,0);
	            return ((double)SumOfDistances/(double) noOfpaths);
	        }
	        public void calculate(String a,String b,boolean ifvisited[],int d)
	        {
	            if(a.equals(b))
	            {
	                noOfpaths++;
	                SumOfDistances+=d;
	                return;
	            }
	            int index=(int)(a.charAt(0))-65;
	            for(int i=0;i<adj[index].size();i++)
	            {
	                String to=adj[index].get(i).dest;
	                int indexOfDestination=(int)(to.charAt(0))-65;
	                if(ifvisited[indexOfDestination]==false)
	                {
	                    ifvisited[indexOfDestination]=true;
	                    calculate(to,b, ifvisited, d+adj[index].get(i).wt);
	                    ifvisited[indexOfDestination]=false;
	                }
	            }
	            return;
	        }
	    }
	    public static void main(String[] args) {
	    	 Graph g=new Graph(5);
	         g.addEdge("A","B",12);
	         g.addEdge("A","C",13);
	         g.addEdge("A","D",11);
	         g.addEdge("A","E",8);
	         g.addEdge("B","C",3);
	         g.addEdge("C","E",4);
	         g.addEdge("D","E",7);
	        Scanner sc = new Scanner(System.in);
	        String x = sc.next();
	        String y = sc.next();
	        System.out.println("Average distance between "+x+" and "+y+" is "+g.calculateAverageDistanceBetweenTwoPoints(x,y));
	    }
	}

	