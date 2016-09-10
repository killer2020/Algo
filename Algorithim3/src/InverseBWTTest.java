import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InverseBWTTest {
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
        new InverseBWTTest().run();
    }

    public void run() throws IOException {
      while(true)
      {	  
    	String str="";
    	for(int i=0;i<100;i++)
    	{
    		int j=((int) (Math.random()*100))%4;
    		if(j==0)
    			str=str+'A';
    		if(j==1)
    			str=str+'C';
    		if(j==2)
    			str=str+'G';
    		if(j==3)
    			str=str+'T';
    	}
    	
    	str=str+'$';
    	System.out.println(str);
    	
    	String bwt=BWT(str);
    	
    	String inverseBWT=inverseBWT(bwt);
    	
        System.out.println(bwt);
        System.out.println(inverseBWT);
        if(str.equals(inverseBWT))
        	{
        	System.out.println("Match ok");
        	}
        else
        	{System.out.println("Mismatch");
        	 return;
        	}
    }
    }    
}
