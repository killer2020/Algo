class Node
{
	int nodeData;
	
	int parent=0;
	
	public Node(int nodeData,int parent)
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
       
	   ArrayList<Node> nodes=new ArrayList<Node>();
	   nodes.add(new Node(0,0));
	   
	   for(int i=1;i<=count;i++)
	   {
		   int data=scanner.nextInt();
		   
		   nodes.add(new Node(data,0));
		   
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
