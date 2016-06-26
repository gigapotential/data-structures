package ds;
public class DLList {
  
  private DLLNode head;
  private DLLNode tail;

  public DLList() {
    head = tail = null;
  }

  public boolean isEmpty() {
    return head == tail && head == null;
  }

  public void insertFirst(int data) {
    DLLNode node = new DLLNode(data);
    
    if( head == null) { // first node
      head = tail = node;
    } else {
      node.next = head; 
      head.prev = node;
      head = node; 
    }
  }
  
  public void insertLast(int data) {
    DLLNode node = new DLLNode(data);
    if( head == null ) { // first node
      head = tail = node; 
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
  }

  public DLLNode search(int data) {
    DLLNode current = head;
    while(current != null) {
      if( current.data == data ) 
          return current;
      current = current.next;
    }
    return null;
  }

  public DLLNode delete(int data) {
    DLLNode search = search(data);
    
    if(search != null ) {
    
      if( head == tail && head == search ) {
        head = tail = null;
      } else if ( search == head ) {
        head = head.next;
        head.prev = null;
      } else if ( search == tail) {
        tail = tail.prev;
        tail.next = null;
      } else {
        DLLNode prev = search.prev;
        DLLNode next = search.next;
        prev.next = next;
        next.prev = prev;
      }
 
    }

    return search;
  } 

}
