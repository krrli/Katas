package test.stuff.bla.args;

import main.stuff.bla.args.Args;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArgsTest {

    Args argsInstance;

    @BeforeEach
    void setUp() {
        this.argsInstance = new Args();
    }

    @Test
    public void testNoArgument(){
        String[] args = {"-"};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.argsInstance.checkArgs(args);
        });
    }

    @Test
    public void testChabisArg(){
        String[] args = {"-Q"};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.argsInstance.checkArgs(args);
        });
    }

    @Test
    public void testLoggingFlag(){
        String[] args = {"-l"};
        this.argsInstance.checkArgs(args);
        Assert.assertEquals(true,argsInstance.isLogging());
    }

    @Test
    public void testDirectory(){
        String[] args = {"-d", "/usr/logs"};
        this.argsInstance.checkArgs(args);
        Assert.assertEquals("/usr/logs",argsInstance.getDirectory());
    }


    @Test
    public void testDirectoryWithEmptyValue(){
        String[] args = {"-d",};
        this.argsInstance.checkArgs(args);
        Assert.assertEquals("",argsInstance.getDirectory());
    }

    @Test
    public void testPort(){
        String[] args = {"-p", "8080"};
        this.argsInstance.checkArgs(args);
        Assert.assertEquals(8080,argsInstance.getPort());
    }


    @Test
    public void testPortWithEmptyValue(){
        String[] args = {"-p", };
        this.argsInstance.checkArgs(args);
        Assert.assertEquals(0,argsInstance.getPort());
    }

    @Test
    public void testPortWithInvalidValue(){
        String[] args = {"-p", "hoi"};
        Assertions.assertThrows(NumberFormatException.class, () -> {
            this.argsInstance.checkArgs(args);
        });
        Assert.assertEquals(0,argsInstance.getPort());
    }
}