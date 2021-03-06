import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Experiments {

  public static void main(String[] args) {
	
	
    //TODO Check command line for number of iterations
    int iterations = 10000;
	if(args.length > 0){
		iterations = Integer.parseInt(args[0]);
	}
    
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
    
	Comparator<String> c = new StringLengthComparator();
	List<String> h = HeadInsert(iterations, "hi");
    start = System.nanoTime();
    SortedInsert(h, c);
	//SortedInsert(h);
    end = System.nanoTime();
    System.out.println("Sorted insertion took " + (end - start)/1000000.0 + "ms.\n");
    
	
	
	
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
	//List<T> input = new ArrayList<T>();
	List<T> input = new LinkedList<T>();
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
	//List<T> li = new ArrayList<T>();
	List<T> li = new LinkedList<T>();
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
   * @return A reference to the constructed List
   */
   
  public static <T> List<T> SortedInsert(List<T> items, Comparator<T> c) {
    List<T> l = new ArrayList<T>();
	for(int i=0; i<items.size(); i++){
		int index = 0;
		while(index != l.size() && c.compare(items.get(i), items.get(index))>=0){
			index++;
		}
		l.add(index, items.get(i));
		if(index%1000==0){
			System.out.println(index);
		}
	}
	return l;
  }
  
  
  /* Bert's code
  public static List<String> SortedInsert(List<String> items) {
    List<String> ret = new ArrayList<String>();
    for(int x = 0; x < items.size(); x++){
        ret.add(items.get(x));
        int swaps = 0;
        boolean finished = false;
        if(ret.size() > 1) {
            while (!finished) {
                for (int y = 0; y < ret.size() - 2; y++) {
                    if (ret.get(y).compareTo(ret.get(y + 1)) > 0) {
                        String temp = ret.get(y + 1);
                        ret.set(y + 1, ret.get(y));
                        ret.set(y, temp);
                        swaps++;
                    }
                }
                finished = (swaps == 0);
                //System.out.println("insert finished");
            }
        }
    }
    return ret;
}
*/
}

class StringLengthComparator implements Comparator<String>{
	
	//compare strings in reverse order
	public int compare(String a, String b){
		return b.compareTo(a);
	}
}