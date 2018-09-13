package main.stuff.bla;

import main.stuff.bla.args.Args;
import main.stuff.bla.fizzBuzz.FizzBuzz;
import main.stuff.bla.fizzBuzz.FizzBuzzV2;

public class Main {

    public static void main(String[] args) {
	    System.out.println("ello dis is kata");
        //fizzBuzz();
        //fizzBuzzV2();
        //parseArguments(args);
        System.out.println(args.length);
        System.out.println(args[2]);
    }

    private static void fizzBuzz(){
        System.out.println("---- FizzBuzz ----");
        FizzBuzz fizzBuzz = new FizzBuzz(21);
        fizzBuzz.playFizzBuzz();
        fizzBuzz.printRes();
    }

    private static void fizzBuzzV2(){
        System.out.println("---- FizzBuzz V2 ----");
        FizzBuzzV2 fizzBuzzV2 = new FizzBuzzV2();

        for(int i = 1; i <= 21; i++){
            fizzBuzzV2.fizzBuzz(i);
        }
        fizzBuzzV2.printRes();
    }

    private static void parseArguments(String[] args){

        String[] otherArgs = {"-l", "-p 8080"};
        Args argsInstance = new Args();
        //argsInstance.checkArgs(args);
        argsInstance.checkArgs(otherArgs);
    }
}
