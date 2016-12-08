import java.io.*;
import java.util.*;

class Vertex {
    Vertex() {
        this.weight = 0;
        this.children = new ArrayList<Integer>();
        this.maxWeightCalculated=false;
        this.maxWeight=0;
    }

    int weight;
    ArrayList<Integer> children;
    boolean maxWeightCalculated;
    int maxWeight;
}

class PlanParty {
    static Vertex[] ReadTree() throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        tokenizer.nextToken();
        int vertices_count = (int) tokenizer.nval;

        Vertex[] tree = new Vertex[vertices_count];

        for (int i = 0; i < vertices_count; ++i) {
            tree[i] = new Vertex();
            tokenizer.nextToken();
            tree[i].weight = (int) tokenizer.nval;
        }

        for (int i = 1; i < vertices_count; ++i) {
            tokenizer.nextToken();
            int from = (int) tokenizer.nval;
            tokenizer.nextToken();
            int to = (int) tokenizer.nval;
            tree[from - 1].children.add(to - 1);
            tree[to - 1].children.add(from - 1);
        }

        return tree;
    }

    static int maxWeight(Vertex[] tree, int vertex, int parent) {
       
    	if(tree[vertex].maxWeightCalculated)
    		return tree[vertex].maxWeight;
    	
    	int maxWeightRoot=tree[vertex].weight;
    	int maxWeightChild=0;
    	
    	for (int child : tree[vertex].children)
         {if (child != parent)
          { maxWeightChild=maxWeightChild+maxWeight(tree, child, vertex);
              
             for(int grandChild:tree[child].children)
             { 
            	 if (grandChild != vertex)
            	 maxWeightRoot=maxWeightRoot+maxWeight(tree,grandChild,child);
             }
          }
         }
    	
    	tree[vertex].maxWeightCalculated=true;
    	tree[vertex].maxWeight=Math.max(maxWeightRoot, maxWeightChild);
    	return tree[vertex].maxWeight;
    }

    static int MaxWeightIndependentTreeSubset(Vertex[] tree) {
        int size = tree.length;
        if (size == 0)
            return 0;
       
        
        int weight=maxWeight(tree, 0, -1);
        
        
        return weight;
    }

    public static void main(String[] args) throws IOException {
      // This is to avoid stack overflow issues
      new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new PlanParty().run();
                        } catch(IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        Vertex[] tree = ReadTree();
        int weight = MaxWeightIndependentTreeSubset(tree);
        System.out.println(weight);
    }
}
