import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InverseBWT {
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

	private int a=1,c=1,g=1,t=1;
	 ArrayList<Integer> aPos=new ArrayList<Integer>();
     ArrayList<Integer> cPos=new ArrayList<Integer>();
     ArrayList<Integer> gPos=new ArrayList<Integer>();
     ArrayList<Integer> tPos=new ArrayList<Integer>();

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();

        int[] lastColumnNumbering=new int[bwt.length()];
        for(int i=0;i<bwt.length();i++)
        {
        	updatelastColumnNumbering(bwt.charAt(i),lastColumnNumbering,i);
        }
        
        
        char[] firstColumn=bwt.toCharArray();
        Arrays.sort(firstColumn);
        
       
        
        for(int i=0;i<firstColumn.length;i++)
        {
        	updatefirstColumnNumbering(firstColumn[i],i);
        }
        
        char character=bwt.charAt(0);
        int characterIndex=0;
       
        
        while(character!='$')
        {
         result=result.append(character);	
         characterIndex=lastToFirst(character,lastColumnNumbering[characterIndex]);
         character=bwt.charAt(characterIndex);
        }
        
        result=result.reverse();
        result=result.append('$');
        return result.toString();
    }

   

	private int lastToFirst(char character, int lastColumnNumber)
	{
		switch(character)
		{
		case 'A':
			return aPos.get(lastColumnNumber-1);
		case 'C':
			return cPos.get(lastColumnNumber-1);
		case 'G':
			return gPos.get(lastColumnNumber-1);
		case 'T':
			return tPos.get(lastColumnNumber-1);
		default:
		return -1;
		}
	}



	private void updatefirstColumnNumbering(char character, int i)
	{
		switch(character)
		{
		case 'A':
			aPos.add(i);
			break;
		case 'C':
			cPos.add(i);
			break;
		case 'G':
			gPos.add(i);
			break;
		case 'T':
			tPos.add(i);
			break;
		default:
		
		}
		
	}

	private void updatelastColumnNumbering(char character, int[] lastColumnNumbering, int i)
	{
		
		switch(character)
		{ 
		case 'A':
			lastColumnNumbering[i]=a;
			a++;
			break;
		case 'C':
			lastColumnNumbering[i]=c;
			c++;
			break;
		case 'G':
			lastColumnNumbering[i]=g;
			g++;
			break;
		case 'T':
			lastColumnNumbering[i]=t;
			t++;
			break;
		default:
		}
	}

	static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
