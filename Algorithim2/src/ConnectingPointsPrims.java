import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


//This is Kruskal not prism
class CustomComparatorPrims implements Comparator<queueObject>
{

     @Override     
     public int compare(queueObject o1, queueObject o2) {
            if(o1.cost<o2.cost)
                   return -1;
            if(o1.cost>o2.cost)
                   return 1;
                  
            return 0;
     }
    
}
//


//class Node{
//	
//	public Node(int x,int y)
//	{
//		this.x=x;
//		this.y=y;
//		
//	}
//	int x;
//	int y;
//	
//}

class queueObject
{
	
	public queueObject(int source,int destination,double cost)
	{
		this.source=source;
		this.destination=destination;
		this.cost=cost;
		
		
	}
	int source;
	int destination;
	double cost;
	
}

public class ConnectingPointsPrims {
	
	
	
	
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;

        PriorityQueue<queueObject> queue=new PriorityQueue<queueObject>(new CustomComparatorPrims());
        int[] root=new int[x.length];
        
        ArrayList<Node> nodes=new ArrayList<Node>();
        
        for(int i=0;i<x.length;i++)
        {
        	nodes.add(new Node(x[i],y[i]));
        	root[i]=i;
        }
        
        
        for(int i=0;i<nodes.size();i++)
        {
        	double distance=0.;
        	for(int j=i+1;j<nodes.size();j++)
        	{
        		
        		distance=Math.pow(Math.pow((nodes.get(i).x-nodes.get(j).x),2)+ Math.pow((nodes.get(i).y-nodes.get(j).y),2),0.5);
        		 queue.add(new queueObject(i,j,distance));
        	}
        }
        
        ArrayList<queueObject> mst=new ArrayList<queueObject>();
        
        while(!queue.isEmpty())
        {
        	
        	queueObject edge=queue.remove();
        	if(root[edge.source]!=root[edge.destination])
        	{
        		mst.add(edge);
        		union(edge.source,edge.destination,root);
        	}
        	
        }
        
        for(queueObject node:mst)
        {
        	result=result+node.cost;
        }
        
        return result;
    }

    private static void union(int source, int destination,int[] root)
	{
    	int rSource=root[source];
    	int rDest=root[destination];
    	int newRoot=rSource;
    	
		for(int i=0;i<root.length;i++)
		{
			if(root[i]==rSource || root[i]==rDest)
				root[i]=newRoot;
			
		}
	}

	

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        DecimalFormat df = new DecimalFormat("####0.000000000");
        System.out.println(df.format(minimumDistance(x, y)));
    }
}

