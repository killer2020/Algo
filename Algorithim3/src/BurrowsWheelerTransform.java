import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BurrowsWheelerTransform {
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

    String BWT(String text) {
        StringBuilder result = new StringBuilder();
        
        String str=text;
        int length=str.length();
        
    //    ArrayList<String> stringMatrix=new ArrayList<String>();

        String[] stringMatrix=new String[length];
        
        for(int i=0;i<length;i++)
        {
        	stringMatrix[i]=str;
        	char last=str.charAt(length-1);
        	str=last+str.substring(0,length-1);
        	
        }
        
        
        Arrays.sort(stringMatrix);
        for(int i=0;i<length;i++)
        {
        	result=result.append(stringMatrix[i].charAt(length-1));
        	
        }
        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}
