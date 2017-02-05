import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ReduceString
{

/*	public static void main(String args[]) throws IOException
	{
        FastScanner scanner=new FastScanner();
        int count=scanner.nextInt();
       for(int i=0;i<count;i++)
       {  
        String s=scanner.next();
			int optimum = stringReduction(s);
		System.out.println(optimum);
       }
	} */
		public static void main(String args[]) throws IOException
	{
       FastScanner scanner=new FastScanner();
      //  int count=scanner.nextInt();
       	String s="ccccbaaaabccaaaa";
			int optimum = stringReduction(s);
		System.out.println(optimum);
       
	}

	static HashMap<String,HashSet<String>> map;
	
	 static int stringReduction(String s)
	{
		 map=new HashMap<String,HashSet<String>>();
		for (int i =1; i<=s.length(); i++)
		{
			String subStr=s.substring(0,i);
			System.out.println(subStr);
			calculateOptimal(subStr);
			//System.out.println(subStr);
             
		}

		int length=200;
		for(String str:map.get(s))
		{
			if(str.length()<length)
				length=str.length();
		}
		
		
		
		return length;
	}

	private static HashSet<String> calculateOptimal(String str)
	{   
		//System.out.println(str);
		HashSet<String> check=map.get(str);
   		if(check!=null)
   			return check;
		
   		HashSet<String> result=new HashSet<String>();
		
   		if(str.length()==1)
   		{
   			result.add(str);
   			map.put(str,result);
   			return result;
   		}
   		else
   		if(str.length()==2)
   		{
   			result.add(getResultChar(str.charAt(0),str.charAt(1)));
   			map.put(str,result);
   			return result;
   			
   		}
   		
   	
			
		String first=str.substring(0,str.length()-1);
		String second=str.substring(str.length()-1,str.length());
		String third=str.substring(0,str.length()-2)+getResultChar(str.charAt(str.length()-1),str.charAt(str.length()-2));
		
		ArrayList<String> newStrings=new ArrayList<String>();
		
		if(!str.equals(third))
		newStrings.add(third);
		
		if(map.get(first)!=null)
		for(String string:map.get(first))
		{
			newStrings.add(string+second);
			
		}
		else
		{
			calculateOptimal(first);
			for(String s1:map.get(first))
			{
				newStrings.add(s1+second);
			}
			
		}

		for(String s1:newStrings)
		{
			if(s1.charAt(s1.length()-1)!=s1.charAt(s1.length()-2))
			{   
				if(!s1.equals(str))
				{
					if(map.get(s1)!=null)
					result.addAll(map.get(s1));
					else
				result.addAll(calculateOptimal(s1));
			     }
			}
			else
			result.add(s1);	
		}
		
	    if(map.get(str)==null)
	    	map.put(str,result);
		
		return result;
	}

	private static boolean checkCharacters(String str)
	{
		char c=str.charAt(0);
		for(int i=1;i<str.length();i++)
			if(str.charAt(i)!=c)
				return false;
		
		return true;
	}
	
	private static String getResultChar(char char1, char char2)
	{
		if ((char1 == 'a' && char2 == 'b') || (char1 == 'b' && char2 == 'a'))
			return "c";
		else if ((char1 == 'a' && char2 == 'c') || (char1 == 'c' && char2 == 'a'))
			return "b";
		else if ((char1 == 'b' && char2 == 'c') || (char1 == 'c' && char2 == 'b'))
			return "a";
	
		return ""+char1+char2;
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
