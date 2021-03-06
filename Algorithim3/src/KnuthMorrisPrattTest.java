import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KnuthMorrisPrattTest {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        String newString=pattern+"$"+text;
        int[] prefixFunc=new int[newString.length()];
        
        computePrefixFunction(prefixFunc,newString);
        
        for(int i=pattern.length()+1;i<newString.length();i++)
        {
        	if(prefixFunc[i]==pattern.length())
        		result.add(i-2*pattern.length());
        	
        }
        
        
        return result;
    }

    private void computePrefixFunction(int[] prefixFunc, String newString)
	{
		
    	prefixFunc[0]=0;
    	
    	int border=0;
    	for(int i=1;i<newString.length();i++)
    	{
    		border=prefixFunc[i-1];
    		while(border>0)
    		{
    			if(newString.charAt(border)==newString.charAt(i))
    			{
    				prefixFunc[i]=border+1;
    				break;
    			}
    			else
    			{
    				border=prefixFunc[border-1];
    			}
    		}
    		
    		
    		if(newString.charAt(border)==newString.charAt(i))
			{
				prefixFunc[i]=border+1;
				
			}
    		else
    		prefixFunc[i]=0;
    	}
    	
    	
	}

	static public void main(String[] args) throws IOException {
        new KnuthMorrisPrattTest().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = "";
        String text ="";
        for(int i=0;i<100000;i++)
        {
        	pattern=pattern+"A";
        	text=text+"A";
        }
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
