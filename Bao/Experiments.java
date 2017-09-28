import java.util.List;
import java.util.ArrayList;

public class Experiments {

  public static void main(String[] args) {
  
    //TODO Check command line for number of iterations
    int iterations = 10000;
    
    // Keep track of the run time for each call
    long start = System.nanoTime();
    long end;
    
    // Make the testing calls and print the time after each
    HeadInsert(iterations, "Hello");
    end = System.nanoTime();
	System.out.println();
	System.out.println();
    System.out.println("Insertion at Head took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    TailInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at Tail took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    MidpointInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at Midpoint took " + (end - start)/1000000.0 + "ms.\n");
    
    //start = end;
    //AlternateInsert(iterations, "Hello");
   //end = System.nanoTime();
    //System.out.println("Insertion at tail took " + (end - start)/1000000.0 + "ms.\n");
    
    start = end;
    AlternateInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Alternate Insertion took " + (end - start)/1000000.0 + "ms.\n");
    
    //start = end;
    //SortedInsert(iterations);
    //end = System.nanoTime();
    //System.out.println("Sorted insertion took " + (end - start)/1000000.0 + "ms.\n");
  
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times at the head of the list
   * bumping all previous entries down the List.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static List<String> HeadInsert(int times, String payload) {
      List<String> str = new ArrayList<String>();
      for(int i = 0; i > times; i++){
          str.add(0, payload);
      }
      return str;
  }
  
  /**
   * Creates a List and inserts the given payload the specified number of times at the tail.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static List<String> TailInsert(int times, String payload) {
      List<String> str = new ArrayList<String>();
      for(int i = 0; i < times; i++){
          str.add(payload);
      }
      return str;
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
  public static List<String> MidpointInsert(int times, String payload) {
      List<String> str = new ArrayList<String>();
      for(int x = 0; x < times; x++){
          str.add((str.size() / 2), payload);
      }
      return str;
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
  public static List<String> AlternateInsert(int times, String payload) {
      int count = 0;
      List<String> str = new ArrayList<String>();
      for(int i = 0; i < times; i++){
          str.add(count, payload);
          if(count >= (str.size() - 1)){
              count = count - str.size();
          }
          count += 2;
      }
      return str;
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
  public static List<String> SortedInsert(List<String> items) {
    return null;
  }

}
