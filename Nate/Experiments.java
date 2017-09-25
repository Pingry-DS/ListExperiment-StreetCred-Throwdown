import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Experiments {

  public static void main(String[] args) {
	
	
    //TODO Check command line for number of iterations
    int iterations = 500;
    
    // Keep track of the run time for each call
    long start = System.nanoTime();
    long end;
    
    // Make the testing calls and print the time after each
    HeadInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at head took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    TailInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at tail took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    MidpointInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at midpoint took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    AlternateInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Alternate insertion took " + (end - start)/1000000.0 + "ms.\n");
	
	start = end;
    ReverseAlternateInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Reverse alternate insertion took " + (end - start)/1000000.0 + "ms.\n");
    /*
    start = end;
    SortedInsert(iterations);
    end = System.nanoTime();
    System.out.println("Sorted insertion took " + (end - start)/1000000.0 + "ms.\n");
    */
	
	
	
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times at the head of the list
   * bumping all previous entries down the List.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T> List<T> HeadInsert(int times, T payload) 
  {
	List<T> input = new ArrayList<T>();
	for(int i = 0; i < times; i++)
	{
		input.add(0, payload); 
	} 
	
	return input;
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times at the tail.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */

  public static <T> List<T> TailInsert(int times, T payload) {
	List<T> li = new ArrayList<T>();
	for(int i=0; i<times; i++){
		li.add(payload);
	}
	return li;

  }
  
  
  /**
   * Creates a List and inserts the given payload the specified number of times in the middle of the list
   * bumping previous entries down the List as necessary. When calculating the midpoint, round down to the
   * nearest integer index. For example, if the list currently contains items at indices 0, 1, and 2, the
   * next item should be inserted at index 1.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
   
  public static <T> List<T> MidpointInsert(int times, T payload) {
    List<T> l = new ArrayList<T>();
    for(int i = 0; i < times; i++) {
      l.add(l.size() / 2, payload);
    }
    return l;
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times as if the List
   * items were arranged in a circle with new items inserted after every other existing item.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T> List<T> AlternateInsert(int times, T payload) {
	List<T> l = new ArrayList<T>();
	boolean alt = true;
	while(times>0){
		for(int i=0; times>0 && i<=l.size(); i++){
			if(alt){
				l.add(i, payload);
				times--;
			}
			if(i==l.size())
				i = 0;
			alt = !alt;
		}
	}
	return l;
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times as if the List
   * items were arranged in a circle with the new items inserted before every other existing item.
   *
   * @param times How many times the payload should be inserted
   * @param payload The object to be inserted
   * @return a reference to the constructed List
   */
  public static <T> List<T> ReverseAlternateInsert(int times, T payload){
	  List<T> l = new ArrayList<T>();
	  if(times>0){
		  l.add(payload);
		  times--;
	  }
	  while(times>0){
		  for(int i=l.size()-1; times>0 && i>=0; i--){
			  l.add(i, payload);
			  times--;
		  }
	  }
	  return l;
  }
  
  //TODO Use a comparator in this method
  /**
   * Creates a List and inserts the given payload items, in the order they are given. Each item
   * is inserted in the proper location such that at all times the constructed List is
   * in sorted order.
   *
   * @param items The items to be inserted. Given in no particular order.
   * @param c The comparator used to sort the elements
   * @return A reference to the constructed List
   */
  public static <T> List<T> SortedInsert(List<T> items, Comparator<T> c) 
  {
	List<T> l = new ArrayList<T>();
	
	int index = 0;
	while(items.size()>0)
	{
		T smallest = items.get(0);
		for(int j = 1; j < items.size(); j++)
		{
			if(c.compare(items.get(j), smallest)<0)
			{
				smallest = items.get(j);
				index = j;
			}
		}
		items.remove(index);
		l.add(smallest);
	}
	return l;
  }
  //PLS TEST THIS

}
