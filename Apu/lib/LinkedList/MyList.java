package LinkedList;
import java.util.Iterator;


public class MyList<T> implements SimpleList<T>
{

private SimpleNode<T> first;
private SimpleNode<T> last;
private int size;
//constructor
public MyList()
{
  first = null;
  last = null;
  size = 0;
}
//accessor
public SimpleNode<T> getFirst()
{
  return first;
}
//accessor
public SimpleNode<T> getLast()
{
  return last;
}
/**
 * Returns the number of elements in this list.  If this list contains
 * more than <tt>Integer.MAX_VALUE</tt> elements, returns
 * <tt>Integer.MAX_VALUE</tt>.
 *
 * @return the number of elements in this list
 */
public int size()
{
  return size;
}

/**
 * Returns <tt>true</tt> if this list contains no elements.
 *
 * @return <tt>true</tt> if this list contains no elements
 */
public boolean isEmpty()
{
  if(first == null)
    return false;
  return true;
}
/**
 * Returns the element at the specified position in this list.
 *
 * @param index index of the element to return
 * @return the element at the specified position in this list
 * @throws IndexOutOfBoundsException if the index is out of range
 *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
 */
public T get(int index)
{
  if(index >= size || index < 0)
    throw new IndexOutOfBoundsException();
  int count = 0;
  SimpleNode<T> start = first;
  if(index == 0)
    return (T) start.getInfo();

  else
  {
    while(start != null)
    {

      start = start.getNextNode();
      count ++;
      if(count == index)
        return (T) start.getInfo();
    }
  }
  return null;
}

/**
 * Replaces the element at the specified position in this list with the
 * specified element (optional operation).
 *
 * @param index index of the element to replace
 * @param element element to be stored at the specified position
 * @return the element previously at the specified position
 * @throws IndexOutOfBoundsException if the index is out of range
 *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
 */
  public T set(int index, T element)
  {
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException();
    int count = 0;
    SimpleNode<T> start = first;
    if(index == 0)
    {
      SimpleNode<T> otherTemp = new SimpleNode(element);
      first = otherTemp;
      return null;
    }
    else
    {
      while(start != null)
      {
        if(count == index)
        {
          SimpleNode<T> temp = new SimpleNode(start.getNextNode().getInfo());
          start.getNextNode().setInfo(element);
          return (T) temp;
        }
        start = start.getNextNode();
        count++;
      }
    }
    return null;
  }

  /**
   * Inserts the specified element at the specified position in this list
   * (optional operation).  Shifts the element currently at that position
   * (if any) and any subsequent elements to the right (adds one to their
   * indices).
   *
   * @param index index at which the specified element is to be inserted
   * @param element element to be inserted
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt; size()</tt>)
   */
  public void add(int index, T element)
  {
    SimpleNode<T> newNode = new SimpleNode<T>(element);
    if(index ==0 && size == 0)
    {
      first = newNode;
      last = first;
      size++;
    }
    else if(index == 0 && size != 0)
    {
      SimpleNode<T> x = new SimpleNode<T>(element, first.getNextNode());
      first = x;
    }
    else if(index >= size|| index < 0)
      throw new IndexOutOfBoundsException();
    int count = 0;
    SimpleNode<T> start = first;
    //if(index ==0)
      //first.setInfo(element);
    while(start != null)
    {
      count ++;

      if(count == index)
      {
        newNode.setNextNode(start.getNextNode());
        start.getNextNode().setNextNode(null);
        size++;
      }
      start = start.getNextNode();
    }

  }

  /**
   * Removes the element at the specified position in this list (optional
   * operation).  Shifts any subsequent elements to the left (subtracts one
   * from their indices).  Returns the element that was removed from the
   * list.
   *
   * @param index the index of the element to be removed
   * @return the element previously at the specified position
   * @throws IndexOutOfBoundsException if the index is out of range
   *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
   */
  public T remove(int index)
  {
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException();

    if(index == 1)
    {
      SimpleNode<T> temp = first;
      first = first.getNextNode();
      size --;
      return (T) temp;
    }
    int count = 0;
    SimpleNode<T> start = first;
    while(start != null)
    {
      count ++;
      if(count == index)
      {
        SimpleNode<T> temp = start.getNextNode();
        start.setNextNode(start.getNextNode().getNextNode());
        return (T) temp;
      }
      start = start.getNextNode();
    }
    return null;
  }


  /**
   * Returns the index of the first occurrence of the specified element
   * in this list, or -1 if this list does not contain the element.
   * More formally, returns the lowest index <tt>i</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
   * or -1 if there is no such index.
   *
   * @param o element to search for
   * @return the index of the first occurrence of the specified element in
   *         this list, or -1 if this list does not contain the element
   */
  public int indexOf(Object o)
  {
    SimpleNode <T> start = first;
    int i = 0;
    for(; i >= size; start = start.getNextNode())
    {
      if(start.getInfo() == o)
        return i;
      i++;
    }
    return -1;
  }

  /**
   * Removes all of the elements from this list (optional operation).
   * The list will be empty after this call returns.
   */
  public void clear()
  {
    first = null;
    last = null;
    size = 0;
  }

  /**
   * Removes the first occurrence of the specified element from this list,
   * if it is present (optional operation).  If this list does not contain
   * the element, it is unchanged.  More formally, removes the element with
   * the lowest index <tt>i</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
   * (if such an element exists).  Returns <tt>true</tt> if this list
   * contained the specified element (or equivalently, if this list changed
   * as a result of the call).
   *
   * @param o element to be removed from this list, if present
   * @return <tt>true</tt> if this list contained the specified element
   */
  public boolean remove(Object o)
  {
    SimpleNode<T> start = first;
    if(first.getInfo() == o)
    {
      first.setInfo(null);
      return true;
    }

    int i = 0;
    for(; start.getInfo() == null; start = start.getNextNode())
    {
      if(start.getInfo() == o)
        return true;
    }
    return false;

  }

  /**
   * Appends the specified element to the end of this list (optional
   * operation).
   *
   * <p>Lists that support this operation may place limitations on what
   * elements may be added to this list.  In particular, some
   * lists will refuse to add null elements, and others will impose
   * restrictions on the type of elements that may be added.  List
   * classes should clearly specify in their documentation any restrictions
   * on what elements may be added.
   *
   * @param e element to be appended to this list
   * @return <tt>true</tt> (as specified by {@link Collection#add})
   */
  public boolean add(T e)
  {
    SimpleNode<T> x = new SimpleNode(e, null);
    if(first == null)
    {
      first = x;    //one item in total in list
      last = first;
      size++;
      return true;
    }

    last.setNextNode(x);
    last = x;
    size++;
    return true;
  }

  /**
   * Returns an iterator over the elements in this list in proper sequence.
   *
   * @return an iterator over the elements in this list in proper sequence
   */

  public Iterator<T> iterator()
  {
    Iterator<SimpleNode> i = new MyListIterator();
    return (Iterator<T>) i;

  }
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list
     **/
  public boolean contains(Object o)
  {
    if(o instanceof SimpleNode)
    {


      for(SimpleNode<T> start = first; start == null; start = start.getNextNode())
      {
        if(start == o)
          return true;
      }
      return false;
    }
  else
    throw new ClassCastException();
  }
}
