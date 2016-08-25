import java.util.*;


 
public class DijkstraTest {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
       
       boolean[] completed = new boolean[adj.length];
       int[] distance=new int[adj.length];
       for(int i=0;i<distance.length;i++)
       {
              distance[i]=1000001;
       }
      
      
       PriorityQueue<priorityObject> queue=new PriorityQueue<priorityObject>(10,new CustomComparator());
      
       queue.add(new priorityObject(s,0));
       distance[s]=0;
       completed[s]=true;
      
       while(!queue.isEmpty())
       {
             
              int node=queue.poll().nodeNumber;
              completed[node]=true;
             
              int weightNum=0;
              for(int adjNode:adj[node])
              {
                     if(completed[adjNode]==false)
              {  
                    
                     int weight=cost[node].get(weightNum);
                     if(distance[node]+weight<distance[adjNode])
                     {
                           distance[adjNode]=distance[node]+weight;
                     }
                    
                     queue.add(new priorityObject(adjNode,distance[adjNode]));
              }
                  
                     weightNum++;
              }
             
       }
      
       if(distance[t]!=1000001)
              return distance[t];
       return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =1000;
        int m = 999;
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        
        
        
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = i+1;
            y = i+2;
            w = 1000;
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
 
        int x =0;
        int y = 999;
        System.out.println(distance(adj, cost, x, y));
    }
}

