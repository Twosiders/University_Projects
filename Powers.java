import java.util.Scanner;

/**
 * Created by Alexander on 20/07/2015.
 */
public class Powers {
    public static void main (String args[]) {
        System.out.print("Enter a positive integer: ");
        Scanner console = new Scanner(System.in);
        String userStrInput = console.nextLine();
        int userInput = Integer.parseInt(userStrInput);
        System.out.println(userInput);
        for (int i = 0; i <= 10; i++) {
            System.out.println(userInput+" raised to the power "+i+" is "+ (int)Math.pow(userInput,i));
        }
    }
}
