package ds;
import java.util.PriorityQueue;
import java.util.Collections;

public class MedianOfStream {

  //1. at any point of time maxHeap stores all elemnts smaller than minHeap
  //2. at any point difference between sizes of two heaps is equal to 1 or 0. 
  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;

  public MedianOfStream() {
     minHeap = new PriorityQueue<Integer>();
     maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
  }
  
  public void add(Integer data) {
    // insert into heaps:
    if(minHeap.size() == 0 && maxHeap.size() == 0) {
      maxHeap.add(data);
    } else if(minHeap.size() == 0) {
      if(maxHeap.peek() < data ) {
        minHeap.add(data);
      } else {
        maxHeap.add(data);
      }
    } else {
      if(data > minHeap.peek()) {
        minHeap.add(data);
      } else {
        maxHeap.add(data);
      }
    }
  
    //balance heaps:
    if(maxHeap.size() - minHeap.size() ==2 ) {
      minHeap.add(maxHeap.poll());
    } else if( minHeap.size() - maxHeap.size() == 2) {
      maxHeap.add(minHeap.poll());
    }
  }

  public Integer getMedian() {

    if(maxHeap.size() == 0 && minHeap.size() == 0 ) {
      return null;
    }

    if(maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    } else if( minHeap.size() > maxHeap.size()) {
      return minHeap.peek();
    } else {
      return (maxHeap.peek() + minHeap.peek())/2;
    }
  }
}
