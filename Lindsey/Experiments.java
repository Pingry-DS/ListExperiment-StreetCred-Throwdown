import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Experiments {

  public static void main(String[] args) {


    int iterations = Integer.parseInt(args[0]);

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
  public static <T> List<T> HeadInsert(int times, T payload) {
      List<T> list = new ArrayList<T>();
      for (int i = 0; i < times; i++) {
          list.add(0, payload);
      }
      return list;
  }

  /**
   * Creates a List and inserts the given payload the specified number of times at the tail.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T> List<T> TailInsert(int times, T payload) {
      List<T> list = new ArrayList<T>();
      for(int i = 0; i < times; i++) {
        list.add(list.size(), payload);
      }
      return list;
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
    int place = 0;
    for (int i =0; i < times; i++) {
      if (place == l.size()-1) {
        place = 2;
      }
      else if(place == l.size()-2) {
        place = 1;
      }
      else if(place > l.size()-1) {
        place = place-l.size();
      }
      l.add(place, payload);
      place += 2;
    }
    return l;

     }

    /**
   * Creates a List and inserts the given payload the specified number of times as if the List
   * items were arranged in a circle with new items inserted before every other existing item.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T> List<T> ReverseAlternateInsert(int times, T payload) {
    List<T> l = new ArrayList<T>();
    int place = 0;
    for (int i =0; i < times; i++) {
      if (place == l.size()-1) {
        place = 1;
      }
      else if(place == l.size()-2) {
        place = 0;
      }
      else if(place > l.size()-1) {
        place = place-l.size();
      }
      l.add(place, payload);
      place += 1;
    }
    return l;

     }


  /**
   * Creates a List and inserts the given payload items, in the order they are given. Each item
   * is inserted in the proper location such that at all times the constructed List is
   * in sorted order.
   *
   * @param items The items to be inserted. Given in no particular order.
   * @return A reference to the constructed List
   */
  public static <T> List<T> SortedInsert(List<T> items, Comparator<T> comp) {
    List<T> l = new ArrayList<T>();

    while (items.size() > 0) {
      int place = 0;
      T shortest = items.get(place);
    for(int i = place + 1; i < items.size(); i++) {
      if (comp.compare(items.get(place), shortest) < 0) {
        shortest = items.get(i);
        place = i;
      }
      l.add(shortest);
      items.remove(i);     }
    }

    return l;
  }

}
