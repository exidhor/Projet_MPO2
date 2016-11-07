import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class MainUnitTest {

    @Test
    public void testJUnit() {
        Bidon bidon = new Bidon();
        Assert.assertEquals(bidon.get2(), 2);
    }

    @Test
    public void testMockito() {
        Bidon bidon = Mockito.mock(Bidon.class);
        Mockito.when(bidon.get2()).thenReturn(3);

        Assert.assertNotEquals(bidon.get2(), 2);
    }
}
