import java.io.*;
import java.util.StringTokenizer;



class Worker
{
	int id;
	int priority;
	
	public Worker(int i) {
		id=i;
		priority=0;
	}
    
	
}


public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;
    private Worker[] worker;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        worker = new Worker[numWorkers];
      
        for(int i=0;i<numWorkers;i++)
        {
        	worker[i]=new Worker(i);
        }
        
        
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            assignedWorker[i]=worker[0].id;
            startTime[i]=worker[0].priority;
            
            worker[0].priority=worker[0].priority+duration;
            shiftDown(0);
           
        }
    }

 
    
   private void shiftDown(int i) {
		
	   
	   
    	if(2*i+1>=worker.length)
    		return;
    	
    	if(2*i+2<worker.length)
    	{ 
    		
    		
    		
    		if(worker[i].priority>worker[2*i+1].priority && worker[2*i+1].priority==worker[2*i+2].priority && worker[2*i+1].id<worker[2*i+2].id)
    		{
    			swap(i,2*i+1);
    			shiftDown(2*i+1);
    			
    		}
    		else if(worker[i].priority>worker[2*i+1].priority && worker[2*i+1].priority==worker[2*i+2].priority && worker[2*i+1].id>worker[2*i+2].id)
    		{
    			swap(i,2*i+2);
    			shiftDown(2*i+2);
    			
    		}
    		else if(worker[i].priority>worker[2*i+1].priority && worker[2*i+1].priority<worker[2*i+2].priority )
    		{
    			swap(i,2*i+1);
    			shiftDown(2*i+1);
    			
    		}
    		else if(worker[i].priority>worker[2*i+2].priority && worker[2*i+1].priority>worker[2*i+2].priority )
    		{
    			swap(i,2*i+2);
    			shiftDown(2*i+2);
    			
    		}
    		else if(worker[i].priority==worker[2*i+1].priority && worker[2*i+1].priority>worker[2*i+2].priority && worker[i].id>worker[2*i+1].id)
    		{
    			swap(i,2*i+1);
    			shiftDown(2*i+1);
    		}
    		else if(worker[i].priority==worker[2*i+2].priority && worker[2*i+1].priority<worker[2*i+2].priority && worker[i].id>worker[2*i+2].id)
    		{
    			swap(i,2*i+2);
    			shiftDown(2*i+2);
    		}
    		else if(worker[i].priority==worker[2*i+1].priority && worker[2*i+1].priority==worker[2*i+2].priority && worker[i].id>worker[2*i+1].id && worker[2*i+1].id<worker[2*i+2].id)
    		{
    			swap(i,2*i+1);
    			shiftDown(2*i+1);
    		}
    		else if(worker[i].priority==worker[2*i+1].priority && worker[2*i+1].priority==worker[2*i+2].priority && worker[i].id>worker[2*i+2].id && worker[2*i+2].id<worker[2*i+1].id)
    		{
    			swap(i,2*i+2);
    			shiftDown(2*i+2);
    		}
    		
    		
    		
    		
    	}
    	else if((worker[i].priority>worker[2*i+1].priority) || (worker[i].priority==worker[2*i+1].priority && worker[i].id>worker[2*i+1].id))
    	 {
    		 swap(i,2*i+1);
    	 }
    	 
    	
		
	}

    
    
	private void swap(int i, int j) {
		
		int tempid=worker[i].id;
		int tempPriority=worker[i].priority;
		
		worker[i].id=worker[j].id;
		worker[i].priority=worker[j].priority;
		worker[j].id=tempid;
		worker[j].priority=tempPriority;
		
	}
 
    
    
    
    
    
    
	private void assignJobsFast() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    
    
    
    
    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
