package ds;
public class SLList {
  private ListNode head;
  
  public SLList() {
    head = null;
  }

  public void insert(int data) {
    ListNode newNode = new ListNode(data);
    newNode.next = head;
    head = newNode;
  }

  public ListNode search(int data) {
    ListNode current = head;
    while(current != null) {
      if(current.data == data) 
        return current;
    } 
    return null;
  }

  public ListNode delete(int data) {
    ListNode removedNode = null;  

    if(head == null) 
      return null;

    if(head.data == data) {
      removedNode = head;
      head = head.next;
      return removedNode;
    }

    ListNode current = head.next;
    ListNode previous = head;
    while(current != null) {
      if(current.data == data) {
        removedNode = current;
        previous.next = current.next;
        break;
      } 
      previous = current;
      current = current.next;
    }
     
    return removedNode;
  }

  public int count() {
    int count = 0;
    ListNode current = head;
    while(current != null) {
      count++;
      current = current.next;
    }
    return count;
  }
}
