package ds;
public class DLLNode {
  int data;
  DLLNode prev;
  DLLNode next;  

  public DLLNode(int data) {
    this.data = data;
  }
  
  public int getData() {
    return this.data;
  }
}
