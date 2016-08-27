import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

//class CustomComparatorNew implements Comparator<priorityObjectNew>
//{
//
//     @Override     
//     public int compare(priorityObjectNew o1, priorityObjectNew o2) {
//            if(o1.priority<o2.priority)
//                   return -1;
//            if(o1.priority>o2.priority)
//                   return 1;
//                  
//            return 0;
//     }
//    
//}
////
//class priorityObjectNew
//{
//    public priorityObjectNew(int nodeNumber,double priority) {
//           this.priority=priority;
//           this.nodeNumber=nodeNumber;
//    }
//    int nodeNumber;
//    double priority;
//}
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

public class ConnectingPointsTest {
	
	
	
	
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;

        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[x.length];
        ArrayList<Double>[] dist = (ArrayList<Double>[])new ArrayList[x.length];
        for (int i = 0; i < x.length; i++) {
            adj[i] = new ArrayList<Integer>();
            dist[i] = new ArrayList<Double>();
        }
        ArrayList<Node> nodes=new ArrayList<Node>();
        
        for(int i=0;i<x.length;i++)
        {
        	nodes.add(new Node(x[i],y[i]));
        }
        
        
        for(int i=0;i<nodes.size();i++)
        {
        	double distance=0.;
        	for(int j=0;j<nodes.size();j++)
        	{
        		if(i==j)
        			continue;
        		distance=Math.pow(Math.pow((nodes.get(i).x-nodes.get(j).x),2)+ Math.pow((nodes.get(i).y-nodes.get(j).y),2),0.5);
        		  adj[i].add(j);
                  dist[i].add(distance);
        	}
        }
        
        
        SortedSet<priorityObjectNew> queue=new TreeSet<priorityObjectNew>(new CustomComparatorNew());
        
        boolean[] inQueue = new boolean[x.length];
        double[] cost=new double[x.length];
        for(int i=0;i<cost.length;i++)
        {
               cost[i]=1000001;
               inQueue[i]=true;
        }
        
        cost[0]=0;
        
        for(int i=0;i<cost.length;i++)
        {
             queue.add(new priorityObjectNew(i, cost[i]));
        }
        
        while(queue.isEmpty()!=true)
        {
        	
        	priorityObjectNew node=queue.first();
        	queue.remove(node);
        	inQueue[node.nodeNumber]=false;
        	
        	int distNum=0;
        	for(int adjNode:adj[node.nodeNumber])
        	{
        		if(inQueue[adjNode]==true && cost[adjNode]>dist[node.nodeNumber].get(distNum))
        			{
        			
        			 queue.remove(new priorityObjectNew(adjNode,cost[adjNode]));
        			  cost[adjNode]=dist[node.nodeNumber].get(distNum);
        			 
        			  queue.add(new priorityObjectNew(adjNode,cost[adjNode]));
        			  
        			}
        		distNum++;
        			
        	}
        }
        
        for(double d:cost)
        {
        	result=result+d;
        }
        return result;
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

