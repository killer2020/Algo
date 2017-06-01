import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class SimilarString {
	

	static int answer=0;
	
	public static void main(String args[]) throws IOException
	{
	
		FastScanner scanner=new FastScanner();
		
		
		ArrayList<String> suffixStrings;
		
		int count=scanner.nextInt();
		
		for(int i=0;i<count;i++)
		{
			suffixStrings=new ArrayList<String>();
			answer=0;
			String input=scanner.next();
			
			answer=answer+input.length();
			
			for(int j=0;j<input.length();j++)
			{
				
				suffixStrings.add(input.substring(j,input.length()));
				Collections.sort(suffixStrings);
				
			}
			
			int index=suffixStrings.indexOf(input);
			
			
			
			
			
			ArrayList<String> up=new ArrayList<String>();
			for(int var=index-1;var>=0;var--)
			{
				up.add(suffixStrings.get(var));
			}
			
			
			ArrayList<String> down=new ArrayList<String>();
			for(int var=index+1;var<suffixStrings.size();var++)
			{
				down.add(suffixStrings.get(var));
			}
			
			
			
			
			
			
			int lowerBound1=up.size();
			int lowerBound2=down.size();
			
			for(int k=0;k<input.length();k++)
			{
				
				lowerBound1=checkAnswer(up,lowerBound1,k,input.charAt(k));
				
			}
			
			for(int k=0;k<input.length();k++)
			{
				
				lowerBound2=checkAnswer(down,lowerBound2,k,input.charAt(k));
				
			}
			
			System.out.println(answer);
			
		}
		
		
		
	}
	

	private static int checkAnswer(ArrayList<String> strings, int lowerBound, int index, char c) {
		
		int start=0;
		int end=lowerBound-1;
		int mid=(start+end)/2;
		boolean found=false;
		int finalIndex=0;
		
		while(start<=end)
		{
			int length=strings.get(mid).length();
			
			if(index<length && strings.get(mid).charAt(index)==c)
			{
				start=mid+1;
				found=true;
				finalIndex=mid+1;
			}
			else
			{
				end=mid-1;
			}
			
			mid=(start+end)/2;
		}
		
		answer=answer+finalIndex;
		
		return finalIndex;
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
