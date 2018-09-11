package main.stuff.bla.args;

public class ArgsV2 {

    private final String[] argsPattern;
    private final String[] realArgs;

    public ArgsV2(String argsPattern, String[] realArgs){
        this.argsPattern = argsPattern.split(",");
        this.realArgs = realArgs;
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

        throw new IllegalArgumentException("There's no value :-(");
    }



    private void validateArgSchema(char argName, String argType){
        for(String argPattern : argsPattern){
            if(argPattern.equals(argName + argType)) return;
        }

        throw new IllegalArgumentException();
    }
}
