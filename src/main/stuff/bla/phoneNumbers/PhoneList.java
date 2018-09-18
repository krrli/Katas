package main.stuff.bla.phoneNumbers;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneList {

    public PhoneList() {
    }

    public boolean checkConsistency(List<String> phoneList){

        Collections.sort(phoneList, Comparator.comparing(String::length));
        return this.compareNumbersInList(phoneList);
    }

    private boolean compareNumbersInList(List<String> phoneList) {

        boolean isConsistent = true;
        for(String phoneNumber : phoneList){
            for(String phoneNumberToCompare : phoneList){

                if((phoneNumber != phoneNumberToCompare) && (phoneNumberToCompare.startsWith(phoneNumber))){
                    isConsistent =  false;
                    System.out.println(phoneNumber + " " + phoneNumberToCompare);
                }
            }
        }

        return isConsistent ;
    }
}
