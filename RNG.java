import java.util.Scanner;

/**
 * Created by Alexander on 21/07/2015.
 */
public class RNG {
    public static int randInt() {
        int range = (9) + 1;
        return (int)(Math.random() * range);
    }
    public static void randTest(int n) {
        int[] counts = new int[10];
        for(int i=0; i<n; i++){
            int randNum = randInt();;
            counts[randNum]++;
        }
        double meanD = 0;
        System.out.println("Sample size: " + n + "\n");
        System.out.printf("%5s%10s%15s%15s%20s", "Value", "Count", "Expected", "Abs Diff", "Percent Diff\n");
        for(int i=0; i<counts.length; i++) {
            double absD = (double)Math.abs((n/10)-counts[i]);
            double perD = (double)(Math.abs((n/10)-counts[i]))/10;
            meanD += perD/10;
            System.out.printf("%5s%10s%15.2f%15.2f%19.4f%1s", i, counts[i], (double) n / 10, absD, perD, "\n");
        }
        System.out.printf("%25s%10.3f", "Mean percentage difference: ", meanD);

    }
    public static void main (String args[]) {
        System.out.println("Enter a sample size: ");
        Scanner console = new Scanner(System.in);
        String stringUserInput = console.nextLine();
        int userInput = Integer.parseInt(stringUserInput);
        randTest(userInput);
    }
}

