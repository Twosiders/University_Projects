/**
 * Created by Alexander on 29/07/2015.
 */
public class SomeClass {

    int[] table;

    int size;

    public SomeClass(int size) {
        if(size < 0) throw new NegativeArraySizeException("Negative integer entered.");
        this.size = size;

        table = new int[size];

    }

    public static void main(String[] args) {

        int[] sizes = {5, 3, -2, 2, 6, -4};

        SomeClass testInst;

        for (int i = 0; i < 6; i++) {
            try {
                testInst = new SomeClass(sizes[i]);
                System.out.println("New example size " + testInst.size);
            } catch (NegativeArraySizeException e) {
                System.out.println(e);
            }
        }

    }

}
