import java.util.List;
import java.util.ArrayList;

public class Experiments implements Comparator<String> 
{

  public static void main(String[] args) {
  
    //TODO Check command line for number of iterations
    int iterations = 10000;
    int iterations1 = 1000;
    int iterations2 = 100;
    
    // Keep track of the run time for each call
    long start = System.nanoTime();
    long end;
    
    System.out.println("");
    // Make the testing calls and print the time after each
    HeadInsert(iterations, 5);
    end = System.nanoTime();
    System.out.println("Insertion at head 10000 took " + (end - start)/1000000.0 + "ms.\n");
    
    
    HeadInsert(iterations1, 5);
    end = System.nanoTime();
    System.out.println("Insertion at head 1000 took " + (end - start)/1000000.0 + "ms.\n");
    
    
	HeadInsert(iterations2, 5);
    end = System.nanoTime();
    System.out.println("Insertion at head 100 took " + (end - start)/1000000.0 + "ms.\n");

    
    
    start = end;
    TailInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at tail 10000 took " + (end - start)/1000000.0 + "ms.\n");
    
    
    start = end;
    TailInsert(iterations1, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at tail 1000 took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    TailInsert(iterations2, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at tail 100 took " + (end - start)/1000000.0 + "ms.\n"); 
    
    start = end;
    MidpointInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at midpoint 10000 took " + (end - start)/1000000.0 + "ms.\n");
    
    
    start = end;
    MidpointInsert(iterations1, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at midpoint 1000 took " + (end - start)/1000000.0 + "ms.\n");
    
    
    start = end;
    MidpointInsert(iterations2, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at midpoint 100 took " + (end - start)/1000000.0 + "ms.\n");    
    
    
    start = end;
    AlternateInsert(iterations, "Hello");
    SortedInsert(new ArrayList<String>(), new StringLengthComparator());
    end = System.nanoTime();
    System.out.println("Alternate insertion 10000 took " + (end - start)/1000000.0 + "ms.\n");
    
    
    start = end;
    AlternateInsert(iterations1, "Hello");
    SortedInsert(new ArrayList<String>(), new StringLengthComparator());
    end = System.nanoTime();
    System.out.println("Alternate insertion 1000 took " + (end - start)/1000000.0 + "ms.\n"); 
    
    
    start = end;
    AlternateInsert(iterations2, "Hello");
    SortedInsert(new ArrayList<String>(), new StringLengthComparator());
    end = System.nanoTime();
    System.out.println("Alternate insertion 100 took " + (end - start)/1000000.0 + "ms.\n");    
       
    
    
    
    /*
    start = end;
    // pseudocode AlternateInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Alternate insertion took " + (end - start)/1000000.0 + "ms.\n");
    

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
  	List<T> l = new ArrayList<T>();
  
  	for (int i = 0; i < times; i ++)
  	{
  		l.add(0, payload);
  	}
  	return l;
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times at the tail.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T> List<T> TailInsert(int times, T payload)
  {
  	List l = new ArrayList<T>();
  	
  	for (int i = 0; i < times; i ++)
  	{
  		l.add(payload);
  	}
  	return l;
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
  public static <T> List<T> MidpointInsert(int times, T payload) 
  
  {
    	List<T> l = new ArrayList<T>();
   	    for(int i = 0; i < times; i++) 
    	{
      		l.add(l.size() / 2, payload);
   		}
    	return l;
  }
  
  //TODO Maybe make a ReverseAlternateInsert too.
  /**
   * Creates a List and inserts the given payload the specified number of times as if the List
   * items were arranged in a circle with new items inserted after every other existing item.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T> List<T> AlternateInsert(int times, T payload) 
  {
  		int x = 0;
  		List l = new ArrayList<T>();
  		
  		for (int i = 0; i < times; i ++)
  		{
			if (i == 0 || i == 1)
			{
				l.add(payload);
			}
			
			else if (x == l.size() && i == times - 1) //if at end of line, but still need to insert
			{
				x = 0; 
			}
			
			else
			{
				x++;
				
				if (x > l.size())
				{
					l.add(payload);
				}
				
				else
				{
					l.add(x, payload);
					x++;
				}
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
   * 
   * @param items The items to be inserted. Given in no particular order.
   * @param c The comparator used to sort the elements
   * @return A reference to the constructed List
   */
  public static <T>  List<T> SortedInsert(List<T> items, Comparator <T> c) 
  {
  	List l = new ArrayList<T>();
  	for (int i = 0; i < items.size(); i++)
  	{
  		compare()
  	}
  	
  	return l;
  } 

}
