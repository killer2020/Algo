import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SortedSubSegments
{

	static class Node
	{
		int data;
		Node left;
		Node right;
		
		public Node(int data,Node right,Node left)
		{
			this.data=data;
			this.right=right;
			this.left=left;
		}
	}
	
	public static void main(String[] args) throws Exception
	{

		FastScanner scanner=new FastScanner();
		int size=scanner.nextInt();
		int queries=scanner.nextInt();
		int index=scanner.nextInt();
		
		
		int[] arr=new int[size];
		
		for(int i=0;i<size;i++)
		{
			arr[i]=scanner.nextInt();
			
		}
		
		int prevA=size;
		int prevB=0;
		
		for(int i=0;i<queries;i++)
		{
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			
			if(a>=prevA && b<=prevB)
				continue;
			else
			{
				prevA=a;
				prevB=b;
			}
			
			
			ArrayList<Integer> data=new ArrayList<Integer>();
			
			int prev=a;
			boolean sorted=true;
			for(int j=a;j<=b;j++)
			{	
				if(arr[j]<arr[prev])
					sorted=false;
					
				prev=j;
				data.add(arr[j]);
			
			}
			
			if(!sorted)
			{Collections.sort(data);
			
			int ii=0;
			for(int j=a;j<=b;j++)
			{
				arr[j]=data.get(ii);
				ii++;
			}
			}
		}
		
		System.out.println(arr[index]);
		
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
