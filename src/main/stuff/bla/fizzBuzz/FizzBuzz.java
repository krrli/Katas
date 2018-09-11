package main.stuff.bla.fizzBuzz;

import java.util.ArrayList;

public class FizzBuzz {

    // :3 ohni Rest -        Fizz
    // :5 ohni Rest -        Buzz
    // :3 UND :5 ohni Rest - FizzBuzz

    private int countto;

    private static String DIVBYTHREE = "Fizz";
    private static String DIVBYFIVE = "Buzz";
    private ArrayList<String> res;

    public FizzBuzz(){
        this(21);
    }

    public FizzBuzz(int countTo){
        this.countto = countTo;
        this.res = new ArrayList<>();

    }

    public void playFizzBuzz(){
        for(int i = 1; i <= this.countto; i++){

            if((i % 3 == 0) && (i % 5 == 0)){
                this.res.add(this.DIVBYTHREE+this.DIVBYFIVE);
            }
            else if(i % 3 == 0){
                this.res.add(this.DIVBYTHREE);
            }else if(i % 5 == 0){
                this.res.add(this.DIVBYFIVE);
            }else{
                this.res.add(i+"");
            }
        }
    }



    public ArrayList<String> getRes() {
        return res;
    }

    public void printRes(){
        for(String resPart : this.res){
            System.out.println(resPart);
        }
    }

    public void setRes(ArrayList<String> res) {
        this.res = res;
    }
}
