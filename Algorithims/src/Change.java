import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
       
    	int number=0;
    	
    	number=number+n/10;
    	n=n%10;
    	number=number+n/5;
    	n=n%5;
    	number=number+n;
    	
    
    	return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

