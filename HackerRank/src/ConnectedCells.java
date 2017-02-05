import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ConnectedCells
{
	
	static class Node
	{
		ArrayList<Node> childs=new ArrayList<Node>();
		boolean visited=false;
	}	
	
	static int[][] arr;
	static String[][] root;
	static int[][] count;
	static int max=0;
	static int counter=0;
	
	static Node[][] nodes;
	
	public static void main(String args[]) throws Exception
	{
		FastScanner scanner=new FastScanner();
		int rows=scanner.nextInt();
		int columns=scanner.nextInt();
		
		arr=new int[rows][columns];
		root=new String[rows][columns];
		count=new int[rows][columns];
		nodes=new Node[rows][columns];
		
		for(int i=0;i<rows;i++)
		for(int j=0;j<columns;j++)
		{
			int data=scanner.nextInt();
			arr[i][j]=data;
			if(data==1)
			{
				root[i][j]=i+" "+j;
				Node node=new Node();
				nodes[i][j]=node;
			}
			
		}		
		
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
			{
				
				if(arr[i][j]==1)
				{
				
					setParent(i,j,rows,columns,nodes[i][j]);
					
			
				}
			}		
		
		
		
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
			{
				counter=0;
				if(arr[i][j]==1)
				bfs(nodes[i][j]);
				if(counter>max)
					max=counter;
			}	
		
		System.out.println(max);
		
	}

	private static void bfs(Node node)
	{
		if(node.visited==true)
			return;
		node.visited=true;
		counter++;
		for(Node child:node.childs)
		{
			bfs(child);
		}
		
	}

	private static void setParent(int i, int j,int rows,int columns, Node node)
	{
		    
		    addEdge(i,j,i-1,j-1,rows,columns,node);
			
			addEdge(i,j,i-1,j,rows,columns,node);
			
			addEdge(i,j,i-1,j+1,rows,columns,node);
			
			addEdge(i,j,i,j-1,rows,columns,node);
		
			addEdge(i,j,i,j+1,rows,columns,node);
			
			addEdge(i,j,i+1,j-1,rows,columns,node);
			
			addEdge(i,j,i+1,j,rows,columns,node);
			
			addEdge(i,j,i+1,j+1,rows,columns,node);
			
		
		root[i][j]=i+" "+j;
		
	}
	
	
	
	
	private static void addEdge(int i, int j, int m, int n, int rows, int columns, Node node)
	{
		if(checkValue(m,n,rows,columns) && arr[m][n]==1)
		{	root[i][j]=getParent((m)+" "+(n));
		    int r=getRow(root[i][j]);
		    int c=getColumn(root[i][j]);
		    node.childs.add(nodes[r][c]);		
		}
		
	}

	private static boolean checkValue(int i, int j, int rows, int columns)
	{
		if(i<0 || j<0 ||i>(rows-1) || j>columns-1)
			return false;
		
		return true;
	}

	

	private static String getParent(String s)
	{
		int row=getRow(s);
		int col=getColumn(s);
		
		String parentRoot=root[row][col];
		
		int parentRow=getRow(parentRoot);
		int parentCol=getColumn(parentRoot);
		
		if(row==parentRow && col==parentCol)
			return row+" "+col;
		else
			return getParent(parentRow+" "+parentCol);
		
	}

	private static int getRow(String str)
	{
        String s[]=str.split(" ");	
		return Integer.parseInt(s[0]);
	}
	
	private static int getColumn(String str)
	{
		String s[]=str.split(" ");	
		return Integer.parseInt(s[1]);
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
