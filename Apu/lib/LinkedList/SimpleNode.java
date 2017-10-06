package LinkedList;
public class SimpleNode<T>
{
  private T info;
  private SimpleNode<T> nextNode;
  //private int index; figure out how to add index to node

  public SimpleNode()
  {
    info = null;
    nextNode = null;
  }

  public SimpleNode(T x)
  {
    info = x;
    nextNode = null;

  }

  public SimpleNode(T x, SimpleNode y)
  {
    info = x;
    nextNode = y;

  }

  public void setNextNode(SimpleNode x)
  {
    nextNode = x;
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
}
