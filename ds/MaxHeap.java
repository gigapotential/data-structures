package ds;

import java.util.ArrayList;
import java.lang.reflect.Array;

public class MaxHeap<T extends Comparable<T>> {
  
  // elements start at index 1
  private T[]  array;
  private int size;
  private int MAX_SIZE;

  public MaxHeap(Class<T> clazz, int size) {
    this.size = 0;
    MAX_SIZE = size;
    array = (T[]) Array.newInstance(clazz, size +1); //new T[size + 1];
  } 

  public boolean insert(T data) {

    if( size == MAX_SIZE ) {
      //System.out.println("HEAP FULL");
      return false;
    } 
    
    size++;
    array[size] = data; 
    bubbleUp(size);
    return true;
  }

  public T extractMax() {
     if(size == 0) 
        return null;

      T max = array[1];
      T lastElement = array[size];
      array[1] = lastElement;
      size--;
      bubbleDown(1);
      return max;
  }
  
  private void bubbleDown(int position) {
    if(position < size) {
      int maxIndex = position;
      
      int left = leftChild(position);
      if( left <= size && (array[left].compareTo(array[maxIndex]) > 0 ) ) {
        maxIndex = left;
      }
         
      int right = rightChild(position);
      if( right <= size && array[right].compareTo(array[maxIndex]) > 0) {
        maxIndex = right;
      }
     
      if( maxIndex != position ) {
        // swap
        T temp = array[position];
        array[position] = array[maxIndex];  
        array[maxIndex] = temp;
        bubbleDown(maxIndex);
      } 
    } 
  }

  private void bubbleUp(int position) {
    if(position > 1 ) {
      int parentPosition = parent(position); 
      if( array[parentPosition].compareTo(array[position]) < 0) {
        //swap
        T temp = array[parentPosition];
        array[parentPosition] = array[position];
        array[position] =  temp;
        bubbleUp(parentPosition);
      }
    } 
  }

  private int parent(int position) {
    return ((int) position/2);
  }
  
  private int leftChild(int parent) {
    return 2*parent;
  }
  
  private int rightChild(int parent) {
    return (2*parent) +1;
  }
}
