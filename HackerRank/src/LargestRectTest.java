import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class LargestRectTest {

	static class Block
	{
		int minHeight;
        int maxArea;
        ArrayList<Integer> data=new ArrayList<Integer>();
        
        public Block(int height)
        {
        	minHeight=height;
        	maxArea=height;
        	data.add(height);
        }
        
       
        
        public void addBar(int height)
        {
        	minHeight=Math.min(minHeight, height);
        	data.add(height);
        	calculateMaxArea(minHeight,height);
        	
        	if(maxArea<height)
        		maxArea=height;
        	
        }



		private void calculateMaxArea(int minHeight, int height) {
			
			if(minHeight==height)
			{
				int tempArea=data.size()*height;
				if(tempArea>maxArea)
					maxArea=tempArea;
				
				return;
			}
			
			
			if(data.size()*minHeight>maxArea)
			{
				
				maxArea=data.size()*minHeight;
			}
			
			int i=2;
			int element=data.get(data.size()-i);
		    
			
			while(element>minHeight)
			{
				if(element>=height)
				{
					i++;
				}
				else
				{
					
					int tempArea=element*i;
					if(tempArea>maxArea)
						maxArea=tempArea;
					
					i++;
					
				}
				
				if(data.size()-i<0)
				{	
					if(height*data.size()>maxArea)
					  maxArea=height*data.size();
						
					return;
				}
				
				element=data.get(data.size()-i);
			}
			
			if(data.get(data.size()-(i-1))*(i-1)>maxArea)
				maxArea=data.get(data.size()-(i-1))*(i-1);
			
			
		}
        
        
        
	}

	
	
	public static void main(String[] args) throws Exception 
	{

		FastScanner scanner=new FastScanner();
		
		
		
		int count=5;
		
		ArrayList<Integer> data=new ArrayList<Integer>();
		
		int firstElement=(int) (Math.random()*10)+1;
		System.out.println(firstElement);
		
		data.add(firstElement);
		
		Block block=new Block(firstElement);
		
		for(int i=1;i<count;i++)
		{
			 int next=(int) (Math.random()*10)+1;
		      
			 block.addBar(next);
			 
			 data.add(next);
			 System.out.println(next);
		}
		
		
		System.out.println("Solution:"+block.maxArea);
		
		int bruteResult=bruteResult(data);
		
		System.out.println("Brute:"+bruteResult);
		
	}

	
	
	

	private static int bruteResult(ArrayList<Integer> data) {
		
		int area=0;
		
		for(int i=0;i<data.size();i++)
		{
			int maxArea=data.get(i);
			int minElement=data.get(i);
			for(int j=i+1;j<data.size();j++)
			{
				if(data.get(j)<minElement)
				{
					minElement=data.get(j);
				}
				
				if(minElement*(j-i+1)>maxArea)
					maxArea=minElement*(j-i+1);
			}
		
			if(maxArea>area)
				area=maxArea;
		}
		
		return area;
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
