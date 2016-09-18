import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.zip.CheckedInputStream;

public class SuffixArrayLong {
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

    public class Suffix implements Comparable {
        String suffix;
        int start;

        Suffix(String suffix, int start) {
            this.suffix = suffix;
            this.start = start;
        }

        @Override
        public int compareTo(Object o) {
            Suffix other = (Suffix) o;
            return suffix.compareTo(other.suffix);
        }
    }

    // Build suffix array of the string text and
    // return an int[] result of the same length as the text
    // such that the value result[i] is the index (0-based)
    // in text where the i-th lexicographically smallest
    // suffix of text starts.
    public int[] computeSuffixArray(String text) {
        int[] result = new int[text.length()];

        int[] sortCharacter=sortCharacters(text);
        int[] charClasses=computeCharClasses(sortCharacter,text);
      
        
        
       
        
        
        int l=1;
        
       
        
        
        while(l<text.length())
        {
        	sortCharacter=sortDoubled(text,l,sortCharacter,charClasses);
        	charClasses=updateClasses(sortCharacter,charClasses,l);
        	l=2*l;
        } 
        
        
        // write your code here

        return sortCharacter;
    }


    private int[] updateClasses(int[] sortCharacter, int[] charClasses, int l)
	{
    	
    	
    	
		return null;
	}


	private int[] sortDoubled(String text, int l, int[] sortCharacter, int[] charClasses)
	{
		int[] count=new int[charClasses.length];
		int[] newOrder=new int[text.length()];
    	for(int i=0;i<charClasses.length;i++)
    	{
    		count[charClasses[i]]=count[charClasses[i]]+1;
    	}
    	
    	for(int i=1;i<count.length;i++)
    	{
    		count[i]=count[i]+count[i-1];
    	}
    	
    	
		for(int i=sortCharacter.length-1;i>=0;i--)
		{
			int num=(sortCharacter[i]-l+sortCharacter.length)%sortCharacter.length;
			int charClass=charClasses[num];
			count[charClass]=count[charClass]-1;
			newOrder[count[charClass]]=num;
		}
		return newOrder;
	
	}


	private int[] computeCharClasses(int[] sortCharacter, String text)
	{
		int[] charClasses=new int[text.length()];
		charClasses[sortCharacter[0]]=0;
		
		for(int i=1;i<text.length();i++)
		{
			if(text.charAt(sortCharacter[i-1])==text.charAt(sortCharacter[i]))
				charClasses[sortCharacter[i]]=charClasses[sortCharacter[i-1]];
			else
				charClasses[sortCharacter[i]]=charClasses[sortCharacter[i-1]]+1;	
			
		}
    	
    	
		return charClasses;
	}


	private int[] sortCharacters(String text)
	{
		int[] resultArray=new int[text.length()];
    	
    	int[] countArray=new int[5];
    	
    	for(int i=0;i<text.length();i++)
    	{
    		char c=text.charAt(i);
    		int  mappedInteger=getMappedInteger(c);
    		countArray[mappedInteger]=countArray[mappedInteger]+1;
    	}
    	
    	for(int i=1;i<5;i++)
    	{
    		countArray[i]=countArray[i]+countArray[i-1];
    	}
    	
    	
    	for(int i=text.length()-1;i>=0;i--)
    	{
    		char c=text.charAt(i);
    		int integer=getMappedInteger(c);
    		countArray[integer]=countArray[integer]-1;
    		resultArray[countArray[integer]]=i;
    		
    	}
    	
    	
    	
    	return resultArray;
	}


	private int getMappedInteger(char c)
	{
		switch(c)
		{
			case '$':
			    return 0;
			case 'A':
			    return 1;
			case 'C':
				return 2;
			case 'G':
				return 3;
			case 'T':
				return 4;
			default:
				return -1;
				
		}
	}


	static public void main(String[] args) throws IOException {
        new SuffixArrayLong().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        int[] suffix_array = computeSuffixArray(text);
        print(suffix_array);
    }
}
