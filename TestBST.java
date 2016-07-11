import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ds.BST;
import ds.TreeNode;

public class TestBST {

  protected BST bst;

  @Before 
  public void setup() {
    bst = new BST();
  }

  @Test
  public void test0() {
    assertNull(bst.search(0));
  }
  
  @Test
  public void test1() {
    bst.add(12);
    assertNotNull(bst.search(12));
    assertEquals(12, bst.search(12).data);
  } 

  @Test
  public void test2() {
    bst.add(1);
    TreeNode deleted = bst.delete(1);
    assertNotNull(deleted);
    assertEquals(1, deleted.data);
    assertNull(bst.root());
  }

  @Test
  public void test3() {
    bst.add(1);
    bst.add(0);
    bst.add(2);
    
    bst.delete(2);
    assertNull(bst.search(0).right);  
  }

  @Test
  public void test4() {
    bst.add(10);
    bst.add(5);
    bst.add(20);
    bst.delete(5);
    assertNull(bst.search(10).left);
  }

  @Test
  public void test5() {
    // delete node having only right child , who is left child of its parent
    bst.add(100);
    bst.add(30);
    bst.add(50);
    bst.add(40);
    bst.add(60);
    
    TreeNode deleted = bst.delete(30);  
    assertNull(bst.search(30));
    assertEquals(30, deleted.data); 
    assertEquals(50, bst.search(100).left.data);

  }

  @Test
  public void test6() {
    // delete node having only right child, who is right child of its  parent
    bst.add(20);
    bst.add(30);
    bst.add(50);
    bst.add(40);
    bst.add(60);
    
    TreeNode deleted = bst.delete(30);
    assertNull(bst.search(30));
    assertEquals(30, deleted.data);
    assertEquals(50, bst.search(20).right.data);
    assertNull(bst.search(30));
  }
 
  @Test
  public void test7() {
    // delete node having only left child. who is left child of its parent
    bst.add(200);
    bst.add(100);
    bst.add(50);
    bst.add(40);
    bst.add(60);

    TreeNode deleted = bst.delete(100);
    assertNull(bst.search(100));
    assertEquals(100, deleted.data);
    assertEquals(50, bst.root().left.data);
    assertNull(bst.search(100));
  } 
  
  @Test
  public void test8() {
    // delete node having only left child. who is right child of its parent
    bst.add(10);
    bst.add(100);
    bst.add(50);
    bst.add(40);
    bst.add(60);

    TreeNode deleted = bst.delete(100);
    assertNull(bst.search(100));
    assertEquals(100, deleted.data);
    assertEquals(50, bst.root().right.data);
    assertNull(bst.search(100));
  } 
  
  @Test
  public void test9() {
    // delete root having only left child   
    bst.add(10);
    bst.add(5);
    TreeNode deleted = bst.delete(10);
    assertNotNull(deleted);
    assertEquals(10, deleted.data);
    assertEquals(5, bst.root().data); 
    assertNull(bst.search(10));
  }

  @Test
  public void test10() {
   // delete root having only right child   
    bst.add(10);
    bst.add(20);
    TreeNode deleted = bst.delete(10);
    assertNotNull(deleted);
    assertEquals(10, deleted.data);
    assertEquals(20, bst.root().data); 
    assertNull(bst.search(10));
  
  }

  @Test
  public void test11() {
    // delete root having both left & right child
    bst.add(10);
    bst.add(5);
    bst.add(20);
    
    TreeNode deleted = bst.delete(10);
    assertNotNull(deleted);
    assertEquals(10, deleted.data); 
    assertEquals(5, bst.search(5).data);
    assertEquals(20, bst.search(20).data);
    assertNull(bst.search(10));  

  }

  @Test
  public void test12() {
    // delete root having both left & right child
    bst.add(10);
    bst.add(20);
    bst.add(5);
    bst.add(30);
  
    TreeNode deleted = bst.delete(10);
    assertNotNull(deleted);
    assertEquals(10, deleted.data);
    assertEquals(20, bst.root().data);
    assertNull(bst.search(10));
  }

  @Test
  public void test13() {
    // delete root having both left & right child
    bst.add(10);
    bst.add(5);
    bst.add(20);
    bst.add(15);
    bst.add(30);
    
    TreeNode deleted = bst.delete(10);
    assertNotNull(deleted);   
    assertEquals(10, deleted.data);
    assertEquals(15, bst.root().data);
    assertNull(bst.search(10));
  }

}

