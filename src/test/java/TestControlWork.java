import main.ControlWork;
import org.junit.Assert;
import org.junit.Test;

public class TestControlWork {
    @Test
    public void nullTest(){
        byte[] data = new byte[] {0,0,0,0,0,0,0,0,0,0};
        Assert.assertTrue(ControlWork.checkEven(data, 0));
    }
    @Test
    public void oneTest(){
        byte[] data = new byte[] {1,1,1,1,1,1,1,1,1};
        Assert.assertTrue(ControlWork.checkEven(data, 1));
    }
    @Test
    public void numberTest(){
        byte[] data = new byte[] {127};
        Assert.assertTrue(ControlWork.checkEven(data, 1));
    }
}
