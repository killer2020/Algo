
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class TwoArrayProblem
{

	static class Node
	{
		int data;
		Node next;
		
		public Node(int data,Node next)
		{
			this.data=data;
			this.next=next;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		FastScanner scanner =new FastScanner();
		
		int size=scanner.nextInt();
		int queries=scanner.nextInt();
        
		
		Node root1=new Node(scanner.nextInt(),null);
		Node prev=root1;
		
		
		for(int i=1;i<size;i++)
		{
			Node newNode=new Node(scanner.nextInt(),null);
			prev.next=newNode;
			prev=newNode;
		}
		
		Node root2=new Node(scanner.nextInt(),null);
		prev=root2;
		
		for(int i=1;i<size;i++)
		{
			Node newNode=new Node(scanner.nextInt(),null);
			prev.next=newNode;
			prev=newNode;
		}
		
	
		
		for(int i=0;i<queries;i++)
		{
			int q=scanner.nextInt();
			
			switch(q)
			{
			case 1:
				int arrNum1=scanner.nextInt();
				int start=scanner.nextInt();
				int end=scanner.nextInt();
				reverseSubArray(arrNum1,start-1,end-1);
			break;
			
			case 2:
				
				int arrNum2=scanner.nextInt();
				int l1=scanner.nextInt();
				int r1=scanner.nextInt();
				int l2=scanner.nextInt();
				int r2=scanner.nextInt();
				
				swapSubSegements(arrNum2,l1-1,r1-1,l2-1,r2-1);
				
			break;
			
			case 3:
				
				int ll=scanner.nextInt();
				int rr=scanner.nextInt();
				
				swapArraySegements(ll-1,rr-1);
				
			break;
			
			case 4:
			
			
			}
			
			
		}
		
		Node n1=root2;
		for(int i=0;i<size;i++)
		{
			System.out.println(n1.data);
			n1=n1.next;
		}
		
	
	}	
	

	private static void swapArraySegements(int ll, int rr) {
		
	}


	private static void swapSubSegements(int arrNum, int l1, int r1, int l2, int r2) {

		
		
	}


	private static void reverseSubArray(int arrNum, int start, int end) {
		
		
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
