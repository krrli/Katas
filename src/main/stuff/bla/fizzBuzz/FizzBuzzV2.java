package main.stuff.bla.fizzBuzz;

import java.util.ArrayList;

public class FizzBuzzV2 {

    private static String FIZZ = "Fizz";
    private static String BUZZ = "Buzz";
    private static String WHIZZ = "Whizz";

    private ArrayList<String> res;

    public FizzBuzzV2(){
        this.res = new ArrayList<>();
    }

    public void fizzBuzz(int number){
        boolean fizz = (number % 3 == 0);
        boolean buzz = (number % 5 == 0);
        boolean whizz = (number % 7 == 0);

        String res = "";

        if(fizz)
            res = res + FIZZ;

        if(buzz)
            res = res + BUZZ;

        if(whizz)
            res = res + WHIZZ;

        if(res == "")
            res = number+"";

        this.res.add(res);
    }

    public ArrayList<String> getRes() {
        return res;
    }

    public void printRes(){
        for(String resPart : this.res){
            System.out.println(resPart);
        }
    }
}
