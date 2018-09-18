package main.stuff.bla.phoneNumbers;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()>o2.length()){
            final int i = 1;
            return i;
        }else{
            int bla =  o1.compareTo(o2);
            return bla;
        }
    }
}
