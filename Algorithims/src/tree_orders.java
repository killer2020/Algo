import java.util.*;
import java.io.*;

public class tree_orders {
	class Node{
		int key;
		int left;
		int right;
	}
	
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

	public class TreeOrders {
		int n;
		
		List<Node> nodes=new ArrayList<Node>();
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			
			for (int i = 0; i < n; i++) { 
			
				Node node=new Node();
				
				node.key = in.nextInt();
				node.left = in.nextInt();
				node.right = in.nextInt();
				nodes.add(node);
			}
		}

		void inOrder(int root) {
			
			
			if(nodes.get(root).left!=-1)
			inOrder(nodes.get(root).left);
			
			System.out.print(nodes.get(root).key+" ");
			
			if(nodes.get(root).right!=-1)
			inOrder(nodes.get(root).right);
			
                        
		}

		void preOrder(int root) {
           
			
			System.out.print(nodes.get(root).key+" ");
			
			   if(nodes.get(root).left!=-1)
				preOrder(nodes.get(root).left);
				
				
				if(nodes.get(root).right!=-1)
				preOrder(nodes.get(root).right);
			
                        
		}

		void postOrder(int root) {
                 
			
			    if(nodes.get(root).left!=-1)
				postOrder(nodes.get(root).left);
				
				
				if(nodes.get(root).right!=-1)
				postOrder(nodes.get(root).right);
			
				System.out.print(nodes.get(root).key+" ");
                        
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		tree.inOrder(0);
		System.out.println();
		tree.preOrder(0);
		System.out.println();
		tree.postOrder(0);
	}
}
