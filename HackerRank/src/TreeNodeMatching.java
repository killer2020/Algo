import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class BtreeNode
{
	int nodeData;
	
	int parent=0;
	
	public BtreeNode(int nodeData,int parent)
	{
		this.nodeData=nodeData;
		this.parent=parent;
	}
}
 
public class TreeNodeMatching {
 
    public static void main(String[] args) throws Exception 
    {
       FastScanner scanner = new FastScanner();
	   int count=scanner.nextInt();
	   int numOfQueries=scanner.nextInt();
       
	   ArrayList<BtreeNode> nodes=new ArrayList<BtreeNode>();
	   nodes.add(new BtreeNode(0,0));
	   
	   for(int i=1;i<=count;i++)
	   {
		   int data=scanner.nextInt();
		   
		   nodes.add(new BtreeNode(data,0));
		   
	   }
	   
	   for(int i=0;i<count-1;i++)
	   {
		   int parent=scanner.nextInt();
		   int child=scanner.nextInt();
		   
		   nodes.get(child).parent=parent;
		   
	   }
	   
        
       
	   
	   for(int i=0;i<numOfQueries;i++)
	   {
		   int first=scanner.nextInt();
		   int second=scanner.nextInt();
		   int third=scanner.nextInt();
		   int fourth=scanner.nextInt();
		   
		   String resultFirst=getPath(first,second,nodes);
		  
		   //System.out.println(resultFirst);
		  
		   String resultSecond=getPath(third,fourth,nodes);
		   
		  // System.out.println(resultSecond);
		   
		 
		   int[] commonFirst=new int[count+1];
		   int[] commonSecond=new int[count+1];
		   
		   
		   ArrayList<Integer> firstNodes=new ArrayList<Integer>();
		   ArrayList<Integer> secondNodes=new ArrayList<Integer>();
		   
		   if(resultFirst.equals("1to2"))
		     getNodesData(first,second,firstNodes,nodes,commonFirst);
		   else 
		   if(resultFirst.equals("2to1"))
			   getNodesData(second,first, firstNodes, nodes,commonFirst);
		   else
			   getNodesData(first,second,Integer.parseInt(resultFirst), firstNodes, nodes,commonFirst);
		   
		   
		   if(resultSecond.equals("1to2"))
			     getNodesData(third,fourth,secondNodes,nodes,commonSecond);
			   else 
			   if(resultSecond.equals("2to1"))
				   getNodesData(fourth,third, secondNodes, nodes,commonSecond);
			   else
				   getNodesData(third,fourth,Integer.parseInt(resultSecond),secondNodes, nodes,commonSecond);
		   
		   
		   //System.out.println(firstNodes);
		  // System.out.println(secondNodes);
		   ArrayList<Integer> commonData=new ArrayList<Integer>();
		   for(int ii=0;ii<count+1;ii++)
		   {
			   if(commonFirst[ii]==1 && commonSecond[ii]==1)
				  commonData.add(nodes.get(ii).nodeData);
		   }
		   
		   Collections.sort(firstNodes);
		   Collections.reverse(firstNodes);
		   
		   Collections.sort(secondNodes);
		   Collections.reverse(secondNodes);
		   
		   Collections.sort(commonData);
		   Collections.reverse(commonData);
		 
		   
		   Stack<Integer> firstData=new Stack<Integer>();
		   firstData.addAll(firstNodes);
		   
		   Stack<Integer> secondData=new Stack<Integer>();
		   secondData.addAll(secondNodes);
		   
		   Stack<Integer> common=new Stack<Integer>();
		   common.addAll(commonData);
		   
		 //  System.out.println(firstData);
		 //  System.out.println(secondData);
		   
		   int result=0;
		   while(!(firstData.isEmpty() || secondData.isEmpty()))
		   {
			   
			   int current=firstData.peek();
		//	   System.out.println(current);
			   int firstCount=getNumberCount(firstData,current); 
			   
			    
			   
			    int secondCount=getNumberCount(secondData,current); 
			    if(secondCount==0)
			    {
			    	continue;
			    	
			    }
			    
			    int commonCount=getNumberCount(common,current);
			    
			    result=result+(firstCount*secondCount-commonCount);
			    
		   }
		   
		   System.out.println(result);
		   
	   }
        
	   
	   
    }
    


	private static int getNumberCount(Stack<Integer> secondData, int current)
	{
		int count=0;
		while(!secondData.isEmpty())
		{
			int popped=secondData.pop();
			if(popped==current)
				count++;
			else if(popped<current)
				continue;
			else if(popped>current)
			{
				secondData.add(popped);
				return count;
			}
			
		}
		return count;
	}








	private static void getNodesData(int first, int second, int common, ArrayList<Integer> resultNodes,ArrayList<BtreeNode> nodes,int[] commonNodes)
	{
		resultNodes.add(nodes.get(first).nodeData);
		resultNodes.add(nodes.get(second).nodeData);
		resultNodes.add(nodes.get(common).nodeData);
		
		commonNodes[first]=1;
		commonNodes[second]=1;
		commonNodes[common]=1;
		
        int parent=nodes.get(first).parent;
		
		while(parent!=common)
		{
			commonNodes[parent]=1;
			resultNodes.add(nodes.get(parent).nodeData);
			parent=nodes.get(parent).parent;
		}
		
        parent=nodes.get(second).parent;
		
		while(parent!=common)
		{
			commonNodes[parent]=1;
			resultNodes.add(nodes.get(parent).nodeData);
			parent=nodes.get(parent).parent;
		}
		
	}








	private static void getNodesData(int first, int second, ArrayList<Integer> resultNodes, ArrayList<BtreeNode> nodes,int[] commonNodes)
	{
		resultNodes.add(nodes.get(first).nodeData);
		resultNodes.add(nodes.get(second).nodeData);
		
		commonNodes[first]=1;
		commonNodes[second]=1;
		
		int parent=nodes.get(first).parent;
		
		while(parent!=second && parent>0)
		{
			commonNodes[parent]=1;
			resultNodes.add(nodes.get(parent).nodeData);
			parent=nodes.get(parent).parent;
		}
		
	}








	private static String getPath(int first, int second, ArrayList<BtreeNode> nodes)
	{
    	  boolean[] visited=new boolean[nodes.size()];
		   boolean firstFound=false;
		   boolean secondFound=false;
		   
		   if(nodes.get(first).parent==0)
			   return "2to1";
		   else if(nodes.get(second).parent==0)
			   return "1to2";
		   
		   int parent=nodes.get(second).parent;
		   
		   while(parent!=0)
		   {
			  visited[parent]=true;
			  if(parent==first)
			  {
				 firstFound=true;
				 break;
			  }
			 
			  
			  parent=nodes.get(parent).parent;
		   }
		   
		   if(firstFound)
		   {
			   return "2to1";
		   }
		   else
		   {
			  parent=nodes.get(first).parent;
			  while(visited[parent]!=true && parent>0)
			  {
				  if(parent==second)
				  {
					  secondFound=true;
					  break;
				  }
				  parent=nodes.get(parent).parent;
				 // System.out.println(parent);
				  
			  }
			  
			  if(secondFound)
			   return "1to2";
			  else
			  return ""+parent;
			  
		   }
	}




	




	static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
