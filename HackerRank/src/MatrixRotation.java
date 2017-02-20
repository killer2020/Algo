import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MatrixRotation
{
    static int finalArr[][];
	public static void main(String args[]) throws Exception
	{
		
		FastScanner scanner=new FastScanner();
		int rows=scanner.nextInt();
		int cols=scanner.nextInt();
		int rotations=scanner.nextInt();
		
		int arr[][]=new int[rows][cols];
		finalArr=new int[rows][cols];
		
		for(int i=0;i<rows;i++)
		for(int j=0;j<cols;j++)
		{	
			arr[i][j]=scanner.nextInt();
		}
		
		
		for(int i=0;i<cols/2;i++)
		{
			int r=rows-2*i;
			int c=cols-2*i;
			if(r>0 && c>0)
			rotate(i,i,rows-2*i,cols-2*i,rotations,arr);
		}
		
		
		for(int i=0;i<rows;i++)
		{ 
			String str="";
		     for(int j=0;j<cols;j++)
		     {
			   str=str+finalArr[i][j]+" ";
		     }
		  System.out.println(str);
		}
	}
	
	
	
	

	private static void rotate(int i,int j,int rows, int cols, int rotations, int[][] arr)
	{
		rotations=rotations%(2*(rows+cols-2));
		Queue<Integer> trail=new LinkedList<Integer>();
		
		addNumbersinQueue(i,j,rows,cols,arr,trail);
		
		Collections.reverse((List<Integer>) trail);
		
		
		int newI=i;
		int newJ=j;
		
		int counter=0;
		for(int k=0;k<rows-1;k++)
		{
			if(counter==rotations)
				break;
			newI++;
			counter++;
			trail.add(trail.poll());
			
		}
		
		for(int k=0;k<cols-1;k++)
		{
			if(counter==rotations)
				break;
			newJ++;
			counter++;
			trail.add(trail.poll());
		}
		for(int k=0;k<rows-1;k++)
		{
			if(counter==rotations)
				break;
			newI--;
			counter++;
			trail.add(trail.poll());
		}
		for(int k=0;k<cols-1;k++)
		{
			if(counter==rotations)
				break;
			newJ--;
			counter++;
			trail.add(trail.poll());
		}
		
		Collections.reverse((List<Integer>) trail);
		
		setNumbersinNewArray(i,j,rows,cols,trail);
		
	}





	private static void setNumbersinNewArray(int i, int j, int rows, int cols, Queue<Integer> trail)
	{
		int newI=i;
		int newJ=j;
		
		int rotations=(2*(rows+cols-2))-1;
		finalArr[newI][newJ]=trail.poll();
		int counter=0;
		for(int k=0;k<rows-1;k++)
		{
			if(counter==rotations)
				break;
			newI++;
			finalArr[newI][newJ]=trail.poll();
			counter++;
		}
		
		for(int k=0;k<cols-1;k++)
		{
			if(counter==rotations)
				break;
			newJ++;
			finalArr[newI][newJ]=trail.poll();
			counter++;
		}
		for(int k=0;k<rows-1;k++)
		{
			if(counter==rotations)
				break;
			newI--;
			finalArr[newI][newJ]=trail.poll();
			counter++;
		}
		for(int k=0;k<cols-1;k++)
		{
			if(counter==rotations)
				break;
			newJ--;
			finalArr[newI][newJ]=trail.poll();
			counter++;
		}
		
	}





	private static void addNumbersinQueue(int i, int j, int rows, int cols, int[][] arr, Queue<Integer> trail)
	{
		int newI=i;
		int newJ=j;
		
		int rotations=(2*(rows+cols-2))-1;
		trail.add(arr[newI][newJ]);
		int counter=0;
		for(int k=0;k<rows-1;k++)
		{
			if(counter==rotations)
				break;
			newI++;
			trail.add(arr[newI][newJ]);
			counter++;
		}
		
		for(int k=0;k<cols-1;k++)
		{
			if(counter==rotations)
				break;
			newJ++;
			trail.add(arr[newI][newJ]);
			counter++;
		}
		for(int k=0;k<rows-1;k++)
		{
			if(counter==rotations)
				break;
			newI--;
			trail.add(arr[newI][newJ]);
			counter++;
		}
		for(int k=0;k<cols-1;k++)
		{
			if(counter==rotations)
				break;
			newJ--;
			trail.add(arr[newI][newJ]);
			counter++;
		}
		
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
