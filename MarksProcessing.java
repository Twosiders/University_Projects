/**
 * Created by Alexander on 30/07/2015.
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Arrays;

public class MarksProcessing {
    public static void main(String[] args) throws Exception {
        DecimalFormat OneD = new DecimalFormat("#.0");
        File inFile1 = new File("ABStudents.txt");
        Scanner input1 = new Scanner(inFile1);
        List<String> students = new ArrayList<String>();
        while (input1.hasNext()) {
            String line = input1.nextLine();
            students.add(line);
        }
        input1.close();

        File inFile2 = new File("AB101.txt");
        Scanner input2 = new Scanner(inFile2);
        List<String> AB1List = new ArrayList<String>();
        while (input2.hasNext()) {
            String line = input2.nextLine();
            AB1List.add(line);
        }
        input2.close();

        File inFile3 = new File("AB102.txt");
        Scanner input3 = new Scanner(inFile3);
        List<String> AB2List = new ArrayList<String>();
        while (input3.hasNext()) {
            String line = input3.nextLine();
            AB2List.add(line);
        }
        input3.close();

        Collections.sort(students);
        Collections.sort(AB1List);
        Collections.sort(AB2List);


        String[][] studentList = new String[students.size()][2];
        for (int i=0; i<AB2List.size(); i++) {
            studentList[i][0] = students.get(i).split(" ")[0];
            studentList[i][1] = students.get(i).split(" ")[1];
        }
        double[][] studentMarks = new double[students.size()][8];
        for (int i=0; i<AB2List.size(); i++) {
            studentMarks[i][0] = Double.parseDouble(students.get(i).split(" ")[0]);
            double One1 = Double.parseDouble(AB1List.get(i).split("  ")[1]);
            double One2 = Double.parseDouble(AB1List.get(i).split("  ")[2]);
            studentMarks[i][1] = One1;
            studentMarks[i][2] = One2;
            double OneAgg = (0.6*(One1)+1.4*(One2))/2;
            studentMarks[i][3] = OneAgg;
            double Two1 = Double.parseDouble(AB2List.get(i).split("  ")[1]);
            double Two2 = Double.parseDouble(AB2List.get(i).split("  ")[2]);
            studentMarks[i][4] = Two1;
            studentMarks[i][5] = Two2;
            double TwoAgg = (0.8*(Two1)+1.2*(Two2))/2;
            studentMarks[i][6] = TwoAgg;
            studentMarks[i][7] = (OneAgg+TwoAgg)/2;
        }
            java.util.Arrays.sort(studentMarks, new java.util.Comparator<double[]>() {
                public int compare(double[] a, double[] b) {
                    return Double.compare(b[7], a[7]);
                }
            });
        //System.out.println(Arrays.deepToString(studentList));
        //System.out.println(Arrays.deepToString(studentMarks));
        File outFile = new File("ABRankedList.txt");
        PrintWriter output = new PrintWriter(outFile);
        for(int i=0; i<studentMarks.length; i++){
            for(int k=0; k<8; k++) {
                if(Double.parseDouble(studentList[k][0]) == studentMarks[i][0]) {
                    output.println(studentList[k][0]+" "+studentList[k][1]);
                    output.println("AB101: "+studentMarks[i][1]+" "+studentMarks[i][2]+" "+OneD.format(studentMarks[i][3])+" "
                    +"AB102: "+studentMarks[i][4]+" "+studentMarks[i][5]+" "+OneD.format(studentMarks[i][6])+" "
                    +"Overall mark: "+OneD.format(studentMarks[i][7]));
                    output.println("--------------------------------------");
                }
            }
        }
        output.close();
    }
}
