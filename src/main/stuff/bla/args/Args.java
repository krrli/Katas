package main.stuff.bla.args;

import java.util.Arrays;
import java.util.List;

public class Args {

    /**
     * schema:
     * l: boolean / logging, no values, true if present, false if not
     * p: port, has integer value
     * d: directory, has string value
     *
     * default values:
     * boolean: false
     * number: 0
     * string: ""
     */

    private boolean logging;
    private int port;
    private boolean portToBeSet;
    private String directory;
    private boolean directoryToBeSet;
    private List<Character> allowedArgs = Arrays.asList('l', 'p', 'd');

    public Args(){
        this.logging = false;
        this.port = 0;
        this.directory = "";
        this.portToBeSet = false;
        this.directoryToBeSet = false;
    }

    public void checkArgs(String[] args){
        for(int i = 0; i < args.length; i++) {

            switch(args[i].charAt(0)){
                case '-':
                    if (args[i].length() < 2)
                        throw new IllegalArgumentException("Not a valid argument: "+args[i]);

                    if(!allowedArgs.contains(args[i].charAt(1)))
                        throw new IllegalArgumentException("Not a valid argument: " + args[i].charAt(1));

                    if(args[i].charAt(1) == 'l'){
                        this.setLogging(true);
                    }else if(args[i].charAt(1) == 'p')
                        this.portToBeSet = true;
                    else if(args[i].charAt(1) == 'd')
                        this.directoryToBeSet = true;

                    break;
                default:
                    if(portToBeSet)
                        this.port = Integer.parseInt(args[i]);
                        /*
                        try{
                            this.port = Integer.parseInt(args[i]);
                        }catch(NumberFormatException e){
                            this.port = 0;
                        }*/


                    if(directoryToBeSet)
                        this.directory = args[i];
                    // 8080 oder /usr/logs
                    // oder en chabis
                    break;
            }


        }

    }


    public boolean isLogging() {
        return logging;
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
