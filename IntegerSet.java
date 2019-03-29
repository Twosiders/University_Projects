import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Alexander on 25/07/2015.
 */
public class IntegerSet implements Cloneable {
        Boolean[] domain;
    public IntegerSet(int domainMax) {
        domain = new Boolean[domainMax];
        for(int i=0; i<domain.length; i++) {
            domain[i] = false;
        }
    }
    public void increase(int domainMax) {
        Boolean[] domainCopy = new Boolean[domainMax];
        for(int i=0; i<domainCopy.length; i++) {
            domainCopy[i] = false;
        }
        System.arraycopy(domain, 0, domainCopy, 0, domain.length);
        domain = domainCopy;
    }
    public int size() {
        return domain.length;
    }
    public String toString() {
        String arrayString = "{";
        for(int i=0; i<domain.length; i++) {
            if(domain[i]){
                arrayString+=i+",";
            }
        }
        arrayString = arrayString.replaceAll(",$","");
        arrayString+="}";
        return arrayString;
    }
    public void insert(int n){
       if(domain.length>n) domain[n] = true;
       else {
           increase(n + 1);
           domain[n]= true;
       }
    }
    public void remove(int n) {
        if(n<0) {
            System.out.println("Invalid number. Integer is less than 0.");
        }
        else if (n>=domain.length || !domain[n]){
            System.out.println(n+" is not in the list or is already removed.");
        }
        else if(domain[n]){
           domain[n] = false;
           System.out.println(n+" has been removed.");
        }

    }
    public boolean contains (int n) {
        if (n>domain.length || !domain[n]){
            return false;
        }
        return true;
    }
    public IntegerSet clone() {
        try {
            return (IntegerSet)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public IntegerSet complement (){
        IntegerSet complementSet = new IntegerSet(domain.length);
        for(int i=0; i<domain.length; i++) {
            if(!domain[i]) {
                complementSet.insert(i);
            }
        }
        return complementSet;
    }
    public boolean isSubset (IntegerSet X) {
        for (int i=0; i<domain.length; i++){
            if(domain[i] && !X.contains(i)){
                return false;
            }
        }
        return true;
    }
    public boolean equals(IntegerSet X) {
        int counterDom = 0;
        int counterX = 0;
        int equalCounter = 0;
        int shorterArray = Math.min(domain.length, X.size());
        for(int i=0; i<domain.length; i++){
            if(domain[i]) counterDom++;
        }
        for(int i=0; i<X.size(); i++){
            if(X.contains(i)) counterX++;
        }
        if(counterDom==counterX){
            for(int i=0; i<shorterArray; i++) {
                if(domain[i] && X.contains(i)) {
                    equalCounter++;
                }
            }
        }
        if(equalCounter == counterDom) return true;
        return false;
    }
    public IntegerSet union (IntegerSet X) {
        int maxDomain = Math.max(domain.length, X.size());
        IntegerSet unionSet = new IntegerSet(maxDomain);
        for(int i=0; i<domain.length; i++){
            if(domain[i]) unionSet.insert(i);
        }
        for(int i=0; i<X.size(); i++){
            if(X.contains(i)) unionSet.insert(i);
        }
        return unionSet;
    }
    public IntegerSet intersection (IntegerSet X) {
        int maxDomain = Math.min(domain.length, X.size());
        IntegerSet interSet = new IntegerSet(maxDomain);
        for(int i=0; i<maxDomain; i++){
            if(domain[i] == X.contains(i) && domain[i]) {
                interSet.insert(i);
            }
        }
        return interSet;
    }
    public IntegerSet setDifference (IntegerSet X) {
        IntegerSet diffSet = new IntegerSet(domain.length);
        for(int i=0; i<domain.length; i++) {
            if(domain[i]) diffSet.insert(i);
        }
        for(int i=0; i<X.size(); i++) {
            if(X.contains(i)) diffSet.remove(i);
        }
        return diffSet;
    }
    public static void main(String args[]) {
        /*
        IntegerSet coolNumbers = new IntegerSet(5);
        coolNumbers.insert(15);
        System.out.println(coolNumbers);
        coolNumbers.remove(15);
        coolNumbers.remove(120);
        System.out.println(coolNumbers);
        coolNumbers.insert(22);
        System.out.print(coolNumbers.contains(22));
        coolNumbers.clone();
        System.out.println(coolNumbers.complement());

        IntegerSet littleSubset = new IntegerSet(3);
        littleSubset.insert(0);
        littleSubset.insert(2);

        IntegerSet littleNotSubset = new IntegerSet(7);
        littleNotSubset.insert(0);
        littleNotSubset.insert(1);
        littleNotSubset.insert(2);
        littleNotSubset.insert(7);

        IntegerSet bigSet = new IntegerSet(5);
        bigSet.insert(0);
        bigSet.insert(2);
        bigSet.insert(3);
        bigSet.insert(4);

        System.out.println(littleSubset.isSubset(bigSet));
        System.out.println(littleNotSubset.isSubset(bigSet));

        IntegerSet trueSetOne = new IntegerSet(5);
        trueSetOne.insert(0);
        trueSetOne.insert(4);
        IntegerSet trueSetTwo = new IntegerSet(5);
        trueSetTwo.insert(0);
        trueSetTwo.insert(4);
        IntegerSet falseSetOne = new IntegerSet(3);
        falseSetOne.insert(0);
        falseSetOne.insert(1);
        IntegerSet falseSetTwo = new IntegerSet(10);
        falseSetTwo.insert(0);
        falseSetTwo.insert(7);
        IntegerSet falseSetThree = new IntegerSet(10);
        falseSetThree.insert(5);
        falseSetThree.insert(9);


        System.out.println(trueSetOne.equals(trueSetTwo));
        System.out.println(trueSetOne.equals(falseSetOne));
        System.out.println(trueSetOne.equals(falseSetTwo));
        System.out.println(trueSetOne.equals(falseSetThree));

        System.out.println((falseSetOne.union(trueSetOne)));
        System.out.println((falseSetOne.intersection(trueSetOne)));
        System.out.println(trueSetOne.setDifference(falseSetOne));
        */
    }
}
