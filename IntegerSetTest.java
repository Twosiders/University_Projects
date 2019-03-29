/**
 * Created by Alexander on 29/07/2015.
 */
public class IntegerSetTest {

        static IntegerSet evens;
        static IntegerSet odds;
        static IntegerSet squares;

        public static void printSets() {
            System.out.println("Evens:   " + evens);
            System.out.println("Odds:    " + odds);
            System.out.println("Squares: " + squares);
            System.out.println();
        }

        public static void main(String[] args) {

            System.out.println("Creating initial empty sets:");
            evens = new IntegerSet(20);
            odds = new IntegerSet(20);
            squares = new IntegerSet(20);
            printSets();

            System.out.println("Initial set insertions sets:");
            for (int j=0; j<=10; j++) {
                evens.insert(2*j);
                odds.insert(2*j+1);
                squares.insert(j*j);
            }
            printSets();

            System.out.println("Testing remove:");
            odds.remove(13);
            evens.remove(0);
            squares.remove(100);
            odds.remove(14);
            evens.remove(-1);
            squares.remove(101);
            printSets();

            System.out.println("Testing contains:");
            System.out.println("Evens " +(evens.contains(4)?"contains ":"does not contain ") + 4);
            System.out.println("Evens " +(evens.contains(5)?"contains ":"does not contain ") + 5);
            System.out.println("Evens " +(evens.contains(24)?"contains ":"does not contain ") + 24);
            System.out.println();

            System.out.println("Testing clone:");
            IntegerSet evensClone = evens.clone();
            evens.insert(0);
            System.out.println("Evens clone: " + evensClone);
            System.out.println("Evens      : " + evens);
            System.out.println();

            System.out.println("Testing complement:");
            odds.insert(13);
            IntegerSet oddsComplement = odds.complement();
            System.out.println("Odds Complement: " + oddsComplement);
            System.out.println();

            System.out.println("Testing isSubset:");
            System.out.println("Evens is" +(evens.isSubset(oddsComplement)?" ":" not ") + "a subset of Odds Complement");
            System.out.println("Odds Complement is" +(oddsComplement.isSubset(evens)?" ":" not ") + "a subset of Evens");
            System.out.println("Evens is" +(evens.isSubset(evensClone)?" ":" not ") + "a subset of Evens Clone");
            System.out.println("Evens Clone is" +(evensClone.isSubset(evens)?" ":" not ") + "a subset of Evens");
            System.out.println();

            System.out.println("Testing equals:");
            System.out.println("Evens" +(evens.equals(oddsComplement)?" is ":" is not ") + "equal to Odds Complement");
            System.out.println("Evens" +(evens.equals(evensClone)?" is ":" is not ") + "equal to Evens Clone");
            System.out.println();

            System.out.println("Testing union:");
            IntegerSet unionSet = odds.union(oddsComplement);
            System.out.println("Union set: " + unionSet);
            System.out.println();

            System.out.println("Testing intersection:");
            IntegerSet oddSquares = odds.intersection(squares);
            IntegerSet evenSquares = evens.intersection(squares);
            System.out.println("Odd squares: " + oddSquares);
            System.out.println("Even squares: " + evenSquares);
            System.out.println();

            System.out.println("Testing setDifference:");
            IntegerSet nonSquareEvens = evens.setDifference(evenSquares);
            System.out.println("Non square evens: " + nonSquareEvens);
            System.out.println();


        }

    }
