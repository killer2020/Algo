import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxIndexProductTest
{

	public static void main(String[] args) throws Exception
	{
		FastScanner scanner =new FastScanner();
		
		int count=scanner.nextInt();

		int arr[]=new int[count];
		int left[]=new int[count];
		int right[]=new int[count];
		
		Stack<Integer> stack=new Stack<Integer>();
		
		
		for(int i=0;i<count;i++)
		{
			arr[i]=scanner.nextInt();
		}
		
		stack.push(0);
		left[0]=-1;
		
		for(int i=1;i<count;i++)
		{
		
			while(!stack.isEmpty())
			{int num=stack.peek();
				if(arr[num]>arr[i])
				{	left[i]=num;
				     stack.push(i);
				     break;
				}
				else
				{
					stack.pop();
				}
			}
			
			if(stack.isEmpty())
			{
				left[i]=-1;
				stack.push(i);
			}
			
		}
		
		
		
		
      stack=new Stack<Integer>();
		
		
		
		stack.push(count-1);
		right[count-1]=-1;
		
		for(int i=count-2;i>=0;i--)
		{
		
			while(!stack.isEmpty())
			{int num=stack.peek();
				if(arr[num]>arr[i])
				{	right[i]=num;
				     stack.push(i);
				     break;
				}
				else
				{
					stack.pop();
				}
			}
			
			if(stack.isEmpty())
			{
				right[i]=-1;
				stack.push(i);
			}
			
		}
		

		long max=0;
		 long product=0;
		
		 for(int i=0;i<count;i++)
		{
		 
		 if(left[i]==-1 || right[i]==-1)
			 product=0;
		 else
		product=(long)(left[i]+1)*(long)(right[i]+1);
		 
		 
		 
		 if(product>max)
			 max=product;
		}
		
		System.out.println(max);
		
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
