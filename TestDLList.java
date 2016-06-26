import ds.DLList;
import ds.DLLNode;

import org.junit.Test;
import org.junit.Assert;
public class TestDLList {
 
  @Test 
  public void testEmpty() {
    DLList dllist = new DLList();
     
    Assert.assertNull(dllist.search(1));
    Assert.assertTrue(dllist.isEmpty());
  }

  @Test
  public void testFirstInsert() {
    DLList list = new DLList();
    list.insertFirst(1);
    DLLNode searched = list.search(1);
    Assert.assertNotNull(searched);
    Assert.assertEquals(1, searched.getData()); 
  }

  @Test
  public void testLastInsert() {
    DLList list = new DLList();
    list.insertLast(1);
    DLLNode searched = list.search(1);
    Assert.assertNotNull(searched);
    Assert.assertEquals(1, searched.getData()); 
  }
 
  @Test
  public void testDelete() {
    DLList list = new DLList();
    list.insertFirst(1);
    DLLNode deleted = list.delete(1);
    Assert.assertNotNull(deleted);
    Assert.assertEquals(1, deleted.getData()); 
    Assert.assertNull(list.search(1));
    Assert.assertTrue(list.isEmpty());   
 
  } 

  @Test
  public void testMultipleInserts() {
    DLList list = new DLList();
    list.insertFirst(1);
    list.insertLast(2);
    list.insertFirst(3);
    list.insertLast(4);
    for(int i = 1 ; i <= 4; ++i) {
      DLLNode searched = list.search(i);
      Assert.assertNotNull(searched);
      Assert.assertEquals(i, searched.getData());  
    }
  }

  @Test
  public void testMultipleDeletes() {
    DLList list = new DLList();
    list.insertFirst(1);
    list.insertLast(2);
    list.insertFirst(3);
    list.insertLast(4);
    for(int i = 1 ; i <= 4; ++i) {
      DLLNode deleted = list.delete(i);
      Assert.assertNotNull(deleted);
      Assert.assertEquals(i, deleted.getData());  
      if( i < 4) 
        Assert.assertFalse(list.isEmpty());
      else
        Assert.assertTrue(list.isEmpty());
    }
  }
}
