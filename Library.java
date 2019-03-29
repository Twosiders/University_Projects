import java.util.Arrays;

/**
 * Created by Alexander on 22/07/2015.
 */

abstract class LibraryHolding implements Comparable<LibraryHolding>{
        String name;
        String refNum;
        int acqYear;
        String author;
        String publisher;
        public int compareTo(LibraryHolding other) {
            return Integer.compare(this.acqYear, other.acqYear);
        }
}
class Book extends LibraryHolding{
    public Book (String name, String refNum, int acquisitionYear, String author, String publisher) {
        this.name = name;
        this.refNum = refNum;
        this.acqYear = acquisitionYear;
        this.author = author;
        this.publisher = publisher;
    }
    public int compareTo(Book other) {
        return Integer.compare(this.acqYear, other.acqYear);
    }
    public String toString() {
        return "Title: "+this.name+" Reference: "+this.refNum+" Acquisition Year: "+this.acqYear+" Author: "+this.author+" Publisher: "+this.publisher;
    }
}
abstract class Periodical extends LibraryHolding{
    int issueNum;
}

class AnnualPeriodical extends Periodical {
    int yearOfPub;
    public AnnualPeriodical (String name, String refNum, int acquisitionYear, int issueNum, int pubYear) {
        this.name = name;
        this.refNum = refNum;
        this.acqYear = acquisitionYear;
        this.issueNum = issueNum;
        this.yearOfPub = pubYear;
    }
    public int compareTo(AnnualPeriodical other) {
        return Integer.compare(this.acqYear, other.acqYear);
    }
    public String toString() {
        return "Title: "+this.name+" Reference: "+this.refNum+" Acquisition Year: "+this.acqYear+" Issue Number: "+this.issueNum+" Published: "+this.yearOfPub;
    }
}
class FrequentPeriodical extends Periodical {
    public FrequentPeriodical (String name, String refNum, int acquisitionYear, int issueNum) {
        this.name= name;
        this.refNum = refNum;
        this.acqYear = acquisitionYear;
        this.issueNum = issueNum;
    }
    public int compareTo(FrequentPeriodical other) {
        return Integer.compare(this.acqYear, other.acqYear);
    }
    public String toString() {
        return "Title: "+this.name+" Reference: "+this.refNum+" Acquisition Year: "+this.acqYear+" Issue Number: "+this.issueNum;
    }
}

public class Library {

    public static void main(String[] args) {
        LibraryHolding[] holdings = new LibraryHolding[5];
        holdings[0] = new Book("Java for Arachnophobes", "B0001099", 1999, "Spider,A.", "Cashin Press");
        holdings[1] = new AnnualPeriodical("Arachnids", "A0010098", 1898, 27, 1897);
        holdings[2] = new FrequentPeriodical("Tarantula Monthly", "C0090210", 2010, 35);
        holdings[3] = new Book("Python for Arachnophobes", "E0001113", 2013, "Spider,A.", "Cashin Press");
        holdings[4] = new FrequentPeriodical("Tarantula Monthly", "D0090211", 2011, 43);

        for (LibraryHolding h :  holdings) System.out.println(h);
        System.out.println();
        Arrays.sort(holdings);
        for (LibraryHolding h :  holdings) System.out.println(h);

    }
}
