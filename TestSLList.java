import ds.SLList;
import ds.ListNode;

import org.junit.Test;
import org.junit.Assert;
public class TestSLList {
 
  @Test 
  public void testEmpty() {
    SLList list = new SLList();
     
    Assert.assertNull(list.search(1));
  }

  @Test
  public void testInsert() {
    SLList list = new SLList();
    list.insert(1);
    ListNode searched = list.search(1);
    Assert.assertNotNull(searched);
    Assert.assertEquals(1, searched.getData()); 
  } 

  @Test
  public void testDelete() {
    SLList list = new SLList();
    list.insert(1);
    ListNode deletedNode = list.delete(1);
    Assert.assertNotNull(deletedNode);
    Assert.assertEquals(1, deletedNode.getData());
    Assert.assertNull(list.search(1));
  } 

  @Test
  public void count() {
    SLList list = new SLList();
    list.insert(1);
    Assert.assertEquals(1, list.count());
    list.insert(200);
    Assert.assertEquals(2, list.count());
    list.delete(200);
    Assert.assertEquals(1, list.count());
  }

  @Test
  public void testHeadDeletion() {
    SLList list = new SLList();
    list.insert(1);
    list.insert(2);
    ListNode deletedNode = list.delete(1);
    Assert.assertNotNull(list.search(2));
    Assert.assertEquals(2, list.search(2).getData());
  }
}
