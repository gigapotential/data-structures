import org.junit.Test;
import static org.junit.Assert.*;
import ds.MaxHeap;

public class TestMaxHeap {
  
  @Test
  public void testEmpty() {
    MaxHeap<Integer> heap = new MaxHeap<Integer>(Integer.class , 1);
    assertNull(heap.extractMax());
  }
  
  @Test
  public void testInsertion() {
    MaxHeap<Integer> heap = new MaxHeap<Integer>(Integer.class , 1);
    heap.insert(100);
    assertEquals(100, (int) heap.extractMax());    
    assertNull(heap.extractMax());
  }

  @Test
  public void testHeapSize() {
     MaxHeap<Integer> heap = new MaxHeap<Integer>(Integer.class, 1);
      assertTrue(heap.insert(100));
      assertFalse(heap.insert(200));
      assertEquals(100, (int) heap.extractMax());
      assertNull(heap.extractMax());
  }

  @Test
  public void testMultipleInsertion() {
    
    MaxHeap<Integer> heap = new MaxHeap<Integer>(Integer.class, 5);
    
    heap.insert(300);
    heap.insert(200);
    heap.insert(50);
    heap.insert(250);
    heap.insert(900);
    
    assertEquals(900, (int) heap.extractMax());
    assertEquals(300, (int) heap.extractMax());
    assertEquals(250, (int) heap.extractMax());
    assertEquals(200, (int) heap.extractMax());
    assertEquals(50, (int) heap.extractMax());
    assertNull(heap.extractMax());
  }
  
  @Test
  public void testAlternateInsertExtract() {
    
    MaxHeap<Integer> heap = new MaxHeap<Integer>(Integer.class, 10);
    heap.insert(10);
    heap.insert(20);
    assertEquals(20, (int) heap.extractMax());
    heap.insert(30);
    heap.insert(15);
    assertEquals(30, (int) heap.extractMax());
    heap.insert(11);
    heap.insert(40);
    assertEquals(40, (int) heap.extractMax());
  
  }

}
