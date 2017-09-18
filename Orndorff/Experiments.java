import java.util.List;
import java.util.ArrayList;

public class Experiments {

  public static void main(String[] args) {

    // Determine the number of iterations
    int iterations = 0;

    if(args.length == 1) {
      iterations = Integer.parseInt(args[0]);
    } else {
      iterations = 10000;
    }

    // Keep track of the run time for each call
    long start = System.nanoTime();
    long end;

    // Head
    HeadInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at head took " + (end - start)/1000000.0 + "ms.\n");

    // Tail
    start = end;
    TailInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at tail took " + (end - start)/1000000.0 + "ms.\n");

    // Midpoint
    start = end;
    MidpointInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Insertion at midpoint took " + (end - start)/1000000.0 + "ms.\n");

    // Alternate
    start = end;
    AlternateInsert(iterations, "Hello");
    end = System.nanoTime();
    System.out.println("Alternate insertion took " + (end - start)/1000000.0 + "ms.\n");

    // Sorted
    List<String> l = new ArrayList<String>(5);
    l.add("Hello");
    l.add("ello");
    l.add("Goodbye");
    l.add("Street Cred");
    l.add("Bitcoin$$");

    //start = end;
    //SortedInsert(l, new StringLengthComparator());
    //end = System.nanoTime();
    //System.out.println("Sorted insertion took " + (end - start)/1000000.0 + "ms.\n");

  }

  public static <T> List<T> HeadInsert(int times, T payload) {
    List<T> l = new ArrayList<T>();
    for(int i = 0; i < times; i++) {
      l.add(0, payload);
    }
    return l;
  }

  public static <T> List<T> TailInsert(int times, T payload) {
    List<T> l = new ArrayList<T>();
    for(int i = 0; i < times; i++) {
      l.add(payload);
    }
    return l;
  }

  public static <T> List<T> MidpointInsert(int times, T payload) {
    List<T> l = new ArrayList<T>();
    for(int i = 0; i < times; i++) {
      l.add(l.size() / 2, payload);
    }
    return l;
  }

  //TODO Maybe make a ReverseAlternateInsert too.
  public static <T> List<T> AlternateInsert(int times, T payload) {
    int nextUp = 1;

    List<T> l = new ArrayList<T>();

    l.add(payload);
    l.add(payload);

    for(int i = 0; i < times - 2; i++) {
      nextUp = (nextUp + 2) % l.size();
      l.add(nextUp, payload);
    }
    return l;
  }

  //TODO Use a comparator in this method
  public static List<String> SortedInsert(int times) {
    return null;
  }

}
