package main.stuff.bla.args;

import java.util.Arrays;
import java.util.List;

public class ArgsV2 {

    private final String[] argsPattern;
    private final String[] realArgs;


    public ArgsV2(String argsPattern, String[] realArgs){
        this.realArgs = realArgs;
        this.argsPattern = argsPattern.split(",");
    }

    public boolean getBoolean(char argName){
        this.validateArgSchema(argName, "");
        return findBooleanArg(argName);
    }

    public int getInt(char argName){
        this.validateArgSchema(argName, "#");
        return findIntArg(argName);
    }

    public String getString(char argName) {
        this.validateArgSchema(argName, "*");
        return findStringArg(argName);
    }

    public String[] getStringList(char argName){
        this.validateArgSchema(argName, "*");
        return findStringListArg(argName);
    }

    public int[] getIntList(char argName){
        this.validateArgSchema(argName, "#");
        String[] resAsStringArray = this.findStringListArg(argName);
        return findIntListArg(resAsStringArray);
    }

    private boolean findBooleanArg(char argName) {
        for (String realArg : realArgs) {
            if (realArg.equals("-" + argName)) return true;
        }
        return false;
    }

    private int findIntArg(char argName){
        String stringArg = findStringArg(argName);
        return Integer.parseInt(stringArg);
    }

    private String findStringArg(char argName){
        boolean returnNextRealArg = false;

        for(String realArg : realArgs){
            if(returnNextRealArg)
                return realArg;
            if(realArg.startsWith("-"+argName)){
                returnNextRealArg = true;
                if(realArg.length() > 3){return realArg.substring(3);}
            }
        }

        throw new IllegalArgumentException("There's no value for arg " + argName);
    }

    private String[] findStringListArg(char argName){

        boolean returnNextRealArg = false;
        String[] resArray = new String[]{""};

        for(String realArg : realArgs){
            if(returnNextRealArg){
                resArray = realArg.split("\\,");
            }

            if(realArg.startsWith("-"+argName)){
                returnNextRealArg = true;
            }
        }
        return resArray;
    }

    private int[] findIntListArg(String[] stringArray) {
        int[] resAsIntArray = new int[stringArray.length];

        for(int i= 0; i<stringArray.length; i++){
            resAsIntArray[i] = Integer.parseInt(stringArray[i]);
        }
        return resAsIntArray;
    }


    private void validateArgSchema(char argName, String argType){
        for(String argPattern : argsPattern){
            if(argPattern.equals(argName + argType)) return;
        }

        throw new IllegalArgumentException("Schema is not valid: " + argName + " " + argType);
    }
}
