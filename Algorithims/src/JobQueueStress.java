import java.io.*;
import java.util.StringTokenizer;



public class JobQueueStress {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;
    private int[] assignedWorker1;
    private long[] startTime1;
    private Worker[] worker;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueueStress().solve();
    }

    private void readData() throws IOException {
        numWorkers = 100000;
        
        int m = 100000;
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] =(int) (Math.random()*1000);
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

  

 
    
   private void shiftDown(int i) {
		
	   
	   
    	if(2*i+1>=worker.length)
    		return;
    	
    	if(2*i+2<worker.length)
    	{
    		if(worker[i].priority>worker[2*i+1].priority && worker[2*i+1].priority<worker[2*i+2].priority)
    		{
    			swap(i,2*i+1);
    			shiftDown(2*i+1);
    		}
    		else if(worker[i].priority>worker[2*i+2].priority && worker[2*i+2].priority<worker[2*i+1].priority )
    		{
    			swap(i,2*i+2);
    			shiftDown(2*i+2);
    		}
    		else if(worker[i].priority>worker[2*i+1].priority && worker[2*i+1].id<worker[2*i+2].id)
    		{
    			swap(i,2*i+1);
    			shiftDown(2*i+1);
    		}
    		else if(worker[i].priority>worker[2*i+1].priority && worker[2*i+1].id>worker[2*i+2].id)
    		{
    			swap(i,2*i+2);
    			shiftDown(2*i+2);
    		}
    			
    		
    		
    	}
    	else
    	 if(worker[i].priority>worker[2*i+1].priority)
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
        assignedWorker1 = new int[jobs.length];
        startTime1 = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker1[i] = bestWorker;
            startTime1[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    
    
    
    
    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobsFast();
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
