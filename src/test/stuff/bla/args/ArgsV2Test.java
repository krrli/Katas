package test.stuff.bla.args;

import main.stuff.bla.args.ArgsV2;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgsV2Test {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testBooleanTrue() {
        ArgsV2 args = new ArgsV2("l", new String[]{"-l"});
        boolean logFlag = args.getBoolean('l');
        Assert.assertEquals(true, logFlag);
    }

    @Test
    public void testBooleanFalse() {
        ArgsV2 args = new ArgsV2("l", new String[]{"-d", "/etc/"});
        boolean logFlag = args.getBoolean('l');
        Assert.assertEquals(false, logFlag);
    }

    @Test
    public void testFindPortInOneArg(){
        ArgsV2 args = new ArgsV2("p#", new String[]{"-p 8080"});
        int portNumber = args.getInt('p');
        Assert.assertEquals(8080, portNumber);
    }

    @Test
    public void testFindPortSplitted(){
        ArgsV2 args = new ArgsV2("p#", new String[]{"-p", "8080"});
        int portNumber = args.getInt('p');
        Assert.assertEquals(8080, portNumber);
    }

    @Test
    public void testPortAsString(){
        ArgsV2 args = new ArgsV2("p#", new String[]{"-p hoi"});
        Assertions.assertThrows(NumberFormatException.class, () -> args.getInt('p'));
    }


    @Test
    public void testFindDirectoryInOneArg(){
        ArgsV2 args = new ArgsV2("d*", new String[]{"-l", "-d /hoi/"});
        String dir = args.getString('d');
        Assert.assertEquals("/hoi/", dir);
    }

    @Test
    public void testFindDirectorySplitted(){
        ArgsV2 args = new ArgsV2("d*", new String[]{"-l", "-d", "/hoi/"});
        String dir = args.getString('d');
        Assert.assertEquals("/hoi/", dir);
    }

    @Test
    public void testDirectoryWithoutValue(){
        ArgsV2 args = new ArgsV2("d*", new String[]{"-l", "-d"});
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->args.getString('d'));
        Assert.assertEquals("There's no value for arg d", exception.getMessage());
    }

    @Test
    public void testArgumentsComposition(){
        String expectedDir = "/usr/logs";
        int expectedPort = 8080;
        ArgsV2 args = new ArgsV2("l,d*,p#", new String[]{"-l", "-p", expectedPort+"", "-d", expectedDir});

        boolean logFlag = args.getBoolean('l');
        String dir = args.getString('d');
        int port = args.getInt('p');

        Assert.assertEquals(true, logFlag);
        Assert.assertEquals(expectedDir, dir);
        Assert.assertEquals(expectedPort, port);

    }

    @Test
    public void testAnotherArgumentsComposition(){
        String expectedDir = "/usr/logs";
        int expectedPort = 8080;
        ArgsV2 args = new ArgsV2("l,d*,p#,i#", new String[]{"-l", "-p", expectedPort+"", "-d", expectedDir, "-i", "2,7000"});

        boolean logFlag = args.getBoolean('l');
        String dir = args.getString('d');
        int port = args.getInt('p');
        int[] intList = args.getIntList('i');

        Assert.assertEquals(true, logFlag);
        Assert.assertEquals(expectedDir, dir);
        Assert.assertEquals(expectedPort, port);
        Assert.assertEquals(2, intList.length);
    }

    @Test
    public void testNegativeInteger(){
        ArgsV2 args = new ArgsV2("p#", new String[]{"-p", "-5"});
        int portNumber = args.getInt('p');
        Assert.assertEquals(-5, portNumber);
    }


    @Test
    void testStringListAsArg() {
        ArgsV2 args = new ArgsV2("g*", new String[]{"-g", "this,is,a,list"});
        String[] resList = args.getStringList('g');
        Assert.assertEquals(4,resList.length);
        Assert.assertEquals("this", resList[0]);
        Assert.assertEquals("is", resList[1]);
        Assert.assertEquals("a", resList[2]);
        Assert.assertEquals("list", resList[3]);
    }

    @Test
    void testIntListAsArg() {
        ArgsV2 args = new ArgsV2("i#", new String[]{"-i", "1,2,-3,5"});
        int[] resList = args.getIntList('i');
        Assert.assertEquals(4,resList.length);
        Assert.assertEquals(1, resList[0]);
        Assert.assertEquals(2, resList[1]);
        Assert.assertEquals(-3, resList[2]);
        Assert.assertEquals(5, resList[3]);
    }

}