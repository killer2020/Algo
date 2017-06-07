
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TwoArrayProblemTest
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

	static LinkedList<Integer> arr1;
	static LinkedList<Integer> arr2;
	
	public static void main(String[] args) throws Exception
	{
		FastScanner scanner =new FastScanner();
		
		int size=100000;
		int queries=10;
        
		
		arr1=new LinkedList<Integer>();
		arr2=new LinkedList<Integer>();
		
		for(int i=0;i<size;i++)
		{
			arr1.add((int)(Math.random()*100));
		}
		
		for(int i=0;i<size;i++)
		{
			arr2.add((int)(Math.random()*100));
		}
		
	
		
		for(int i=0;i<queries;i++)
		{
			int q=1+((int)(Math.random()*100))%3;
			
			switch(q)
			{
			case 1:
				int arrNum1=((int)(Math.random()*100))%2;
				int start=1;
				int end=size-1;
				reverseSubArray(arrNum1,start-1,end-1);
			break;
			
			case 2:
				
				int arrNum2=((int)(Math.random()*100))%2;
				int l1=1;
				int r1=size/2;
				int l2=r1+1;
				int r2=size-1;
				
				swapSubSegements(arrNum2,l1-1,r1-1,l2-1,r2-1);
				
			break;
			
			case 3:
				
				int ll=1;
				int rr=size-1;
				
				swapArraySegements(ll-1,rr-1);
				
			break;
			
			case 4:
			
			
			}
			
			System.out.println(arr1);
			System.out.println(arr2);
			
		}
		
	
	}	
	

	private static void swapArraySegements(int ll, int rr) {
		LinkedList<Integer> l1=new LinkedList<Integer>();
		LinkedList<Integer> l2=new LinkedList<Integer>();
		
		
		l1.addAll(arr1.subList(0, ll));
		l1.addAll(arr2.subList(ll,rr+1));
		l1.addAll(arr1.subList(rr+1,arr1.size()));
		
		l2.addAll(arr2.subList(0, ll));
		l2.addAll(arr1.subList(ll,rr+1));
		l2.addAll(arr2.subList(rr+1,arr2.size()));
		
		
		
		arr1=l1;
		arr2=l2;
	}


	private static void swapSubSegements(int arrNum, int l1, int r1, int l2, int r2) {

		LinkedList<Integer> newList=new LinkedList<Integer>();
		if(arrNum==0)
		{
			newList.addAll(arr1.subList(0,l1));
			newList.addAll(arr1.subList(l2,r2+1));
			newList.addAll(arr1.subList(r1+1,l2));
			newList.addAll(arr1.subList(l1,r1+1));
			newList.addAll(arr1.subList(r2+1,arr1.size()));
			
			arr1=newList;
			
		}
		else
		if(arrNum==1)
		{
			newList.addAll(arr2.subList(0,l1));
			newList.addAll(arr2.subList(l2,r2+1));
			newList.addAll(arr2.subList(r1+1,l2));
			newList.addAll(arr2.subList(l1,r1+1));
			newList.addAll(arr2.subList(r2+1,arr1.size()));
			
			arr2=newList;
		}
		
		
	}


	private static void reverseSubArray(int arrNum, int start, int end) {
		if(arrNum==0)
			Collections.reverse(arr1.subList(start,end+1));
		else
		if(arrNum==1)
			Collections.reverse(arr2.subList(start,end+1));
		
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
