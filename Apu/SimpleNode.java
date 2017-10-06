
public class SimpleNode<T>
{
  private T info;
  private SimpleNode<T> nextNode;
  private SimpleNode<T> prevNode;
  //private int index; figure out how to add index to node

  public SimpleNode()
  {
    info = null;
    nextNode = null;
    prevNode = null;
  }

  public SimpleNode(T x)
  {
    info = x;
    nextNode = null;
    prevNode = null;

  }
  public SimpleNode(T x, SimpleNode y)
  {
    info = x;
    nextNode = y;
    prevNode = null;

  }

  public SimpleNode(T x, SimpleNode y, SimpleNode z)
  {
    info = x;
    nextNode = y;
    prevNode = z;

  }

  public void setNextNode(SimpleNode x)
  {
    nextNode = x;
  }

  public void setPrevNode(SimpleNode z)
  {
    prevNode = z;
  }

  public void setInfo(T x)
  {
    info = x;
  }

  public T getInfo()
  {
    return info;
  }

  public SimpleNode getNextNode()
  {
    return nextNode;
  }

  public SimpleNode getPrevNode()
  {
    return prevNode;
  }
}
