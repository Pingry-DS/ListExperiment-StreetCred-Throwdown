package LinkedList;
import java.util.Iterator;

public class MyListIterator extends MyList implements Iterator<SimpleNode>
{
  private SimpleNode head = super.getFirst();
  public boolean hasNext()
  {
    if(head.getNextNode() == null)
      return false;
    return true;
  }

  public SimpleNode next()
{
    SimpleNode temp = head;
    head = head.getNextNode();
    return temp;
  }

}
