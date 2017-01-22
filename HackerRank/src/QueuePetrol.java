import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node
{
	int number;
	int data;
	
	public Node(int number,int data)
	{
		this.number=number;
		this.data=data;
	}
}

public class QueuePetrol
{
   
	static Queue<Node> dataNodes=new LinkedList<Node>();
	
	public static void main(String args[]) throws Exception
	{
		FastScanner scanner = new FastScanner();
		
		int number=scanner.nextInt();
		
		
		for(int i=0;i<number;i++)
		{
			int fuel=scanner.nextInt();
			int distance=scanner.nextInt();
			int surplus=fuel-distance;
			dataNodes.add(new Node(i,surplus));
			
		}
		
	   int count=0;
	   int sum=0;
	   
	   while(count!=number-1)
	   {
         int next=poll();
         sum=sum+next;
         if(sum<0 ||(next<0 && count==0))
         {
        	 sum=0;
        	 count=0;
         }
         else
         {
        	 count=count+1;
        	 
         }
         
	   
	   }
	   
	   dataNodes.poll();
	   System.out.println(dataNodes.poll().number);
	}
	
	
	
	private static int poll()
	{
		Node next=dataNodes.poll();
		dataNodes.add(next);
		return next.data;
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
