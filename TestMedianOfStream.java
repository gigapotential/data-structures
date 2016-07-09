import ds.MedianOfStream;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestMedianOfStream {
  protected MedianOfStream mos;

  @Before
  public void setup() {
    mos = new MedianOfStream();
  }
  
  @Test
  public void test0() {
    assertNull(mos.getMedian());
  }

  @Test
  public void test1() {
    mos.add(10);
    assertEquals(new Integer(10), mos.getMedian());
  }
  
  @Test
  public void test2() {
    mos.add(10);
    mos.add(12);
    assertEquals(new Integer(11), mos.getMedian());
  }
  
  @Test
  public void test3() {
    mos.add(10);
    mos.add(12);
    mos.add(8);
    assertEquals(new Integer(10), mos.getMedian());
  }
  
  @Test
  public void test4() {
    mos.add(10);
    mos.add(12);
    mos.add(8);
    mos.add(14);
    assertEquals(new Integer(11), mos.getMedian());
  }
  
  @Test
  public void test5() {
    mos.add(8);
    mos.add(10);
    mos.add(12);
    mos.add(14);
    assertEquals(new Integer(11), mos.getMedian());
  }
  
  @Test
  public void test6() {
    mos.add(14);
    mos.add(12);
    mos.add(10);
    mos.add(8);
    assertEquals(new Integer(11), mos.getMedian());
  }
  
  
}
