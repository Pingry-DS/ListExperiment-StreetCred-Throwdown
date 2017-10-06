import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.lang.Thread;
import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class Experiments {

  public static void main(String[] args) {

    //TODO Check command line for number of iterations
    int iterations = 10000;
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    // Keep track of the run time for each call
    long start = bean.getThreadCpuTime(Thread.currentThread().getId());
    long end;
    System.out.println("-------------------------------");

    // Make the testing calls and print the time after each

    HeadInsert(iterations, "Hello");
    end = bean.getThreadCpuTime(Thread.currentThread().getId());
    System.out.println(iterations + " iterations at head took " + (end - start)/1000000.0 + "ms.");

    System.out.println("-------------------------------");


    start = bean.getThreadCpuTime(Thread.currentThread().getId());
    TailInsert(iterations, "Hello");
    end = bean.getThreadCpuTime(Thread.currentThread().getId());
    System.out.println(iterations + " insertions at tail took " + (end - start)/1000000.0 + "ms.");
    System.out.println("-------------------------------");

    start = bean.getThreadCpuTime(Thread.currentThread().getId());
    MidpointInsert(iterations, "Hello");
    end = bean.getThreadCpuTime(Thread.currentThread().getId());
    System.out.println(iterations + " insertions at midpoint took " + (end - start)/1000000.0 + "ms.");
    System.out.println("-------------------------------");


    start = bean.getThreadCpuTime(Thread.currentThread().getId());
    AlternateInsert(iterations, "Hello");
    end = bean.getThreadCpuTime(Thread.currentThread().getId());
    System.out.println(iterations + " alternating insertions took " + (end - start)/1000000.0 + "ms.");


    start = bean.getThreadCpuTime(Thread.currentThread().getId());
/*
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
  public static <T>List<T> HeadInsert(int times, T payload) {
    List<T> list = new LinkedList<T>();
    for (int i = 0; i < times; i++)
      list.add(0, payload);

    return list;
  }

  /**
   * Creates a List and inserts the given payload the specified number of times at the tail.
   *
   * @param times How many times the payload should be inserted
   * @param payload The actual string to be inserted
   * @return A reference to the constructed List
   */
  public static <T>List<T> TailInsert(int times, T payload) {
    List<T> list = new LinkedList();
    for (int i = 0; i < times; i++){
      list.add(payload);
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
  public static <T>List<T> MidpointInsert(int times, T payload) {
    List<T> l = new ArrayList(times);
    for(int i = 0; i < times; i++) {
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
  public static <T>List<T> AlternateInsert(int times, T payload) {
    List<T> list = new LinkedList();
    if (times == 0)
      return list;
    if (times == 1){
      list.add(payload);
      return list;
    }
    list.add(payload);
    list.add(payload);

    times -= 2;
    int counter;
    for (int i = 2; i < times*100; i += 2){
      counter = 1;
      for (int n = 0; n < i; n++){
        list.add(counter, payload);
        counter += 2;
        times -= 1;
        if (times == 0){
          return list;
        }
      }
    }
    return list;
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
/**
  public static <T>List<T> SortedInsert(int items) {
    ArrayList<T> list = new ArrayList<T>(times);
    list.add(items);
    return list;
  }*/
}
