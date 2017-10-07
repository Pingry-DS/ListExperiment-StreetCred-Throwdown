/***************************************************/
/* To run this with a default runner try:          */
/* java org.junit.runner.JUnitCore SimpleListTests */
/*                                                 */
/* Or for fancier runner option consider:          */
/* import org.junit.FixMethodOrder;                */
/* import org.junit.runners.MethodSorters;         */
/* @FixMethodOrder(MethodSorters.NAME_ASCENDING)   */
/* (Talk to Jack for details about custom runners) */
/***************************************************/

// static import gives us access to assert methods without class name
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.lang.IndexOutOfBoundsException;


public class SimpleListTests {

  /**************************************************/
  /* Setup some testing objects that will streamline*/
  /* test writing. @Before methods run before every */
  /* single test.                                   */
  /**************************************************/

  private SimpleList<String> e;
  private SimpleList<String> f;
  private SimpleList<String> s;

  @Before
  public void setUp(){
    e = new MyList<String>();
    f = new MyList<String>();
    s = new MyList<String>();
    f.add("hello");
    f.add("hello");
    f.add("world");

    s.add("Hello");
    s.add("world");
    s.add("Hello");

  }

  /**************************************************/
  /* Testing new List is created to specification   */
  /* Doubles as size test. TODO: How to isolate     */
  /* these tests?                                   */
  /**************************************************/
  //This tests if the empty MyList starts off at size 1, it does this by calling the size of e and comparing it to 0.
  //If they are equal the function assertEquals will pass true for the test.
  @Test
  public void testIndexOf()
  {
    f.remove("hello");
    assertEquals((f.indexOf("hello")),0);
  }

  @Test
  public void testCreate() {
    assertEquals(0, e.size());
  }

  @Test
  //Similiar to the test above except f is not an empty list, so it calls the size function hoping to assert equals to 2
  //however, this also tests the add function because if add did not work then it would have a size of 2.
  public void testCreate2() {
    assertEquals(3, f.size());
  }


  /**********************************/
  /* Testing valid and invalid adds */
  /**********************************/
  //This tests the other add function with two parameters to make sure it cannot add objects in not created or existing
  //parts of the list. This test is expecting an IndexOutOfBoundsException to check if it was thrown in MyList
  @Test(expected = IndexOutOfBoundsException.class)
  public void testAddNegative() {
    e.add(-1, "Hello");
  }
  //Similiar to the above test this tests if the add function that adds objects at specific indexes cannot add after
  //the existing size of the list.
  @Test(expected = IndexOutOfBoundsException.class)
  public void testAddAfterEnd() {
    e.add(2, "Hello");
  }
  //This tests tests the add at a specific index function. Hopefully it is able to add it as the first element of the list
  //and in doing so when get() is called assertEquals passes true
  @Test
  public void testAddAtEnd1() {
    e.add(0, "Hello");
    assertEquals(e.get(0), "Hello");
  }

  @Test
  //This repeats the test above except the test above was an empty list, and this one has one element in it.
  //This checks if the linked list items moved correctly, updating size, and retaining order.
  public void testAddAtEnd2() {
    e.add("Hello");
    assertEquals(e.get(0), "Hello");
  }

  /**********************************/
  /* Testing valid and invalid gets */
  /**********************************/
  //This test is trying to test the get() function asking it to get something from an empty list.
  //It is expecting an IndexOutOfBoundsException becuase it should not be able to pull anything from nothing.

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetFromEmpty() {
    e.get(0);
  }
  //Similiar to the test above this tests to see if the get function can pull negative indices which dont exists
  //So it should expect an IndexOutOfBoundsException thrown in the MyList.java
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetNegative() {
    f.get(-1);
  }
  //This test tests the add one parameter function as well as retesting the get function
  //In the beginning f used f.add() twice with two different strings so the test tests if it added them in the correct order
  //as well as adding them at all.
  @Test
  public void testGetValid() {
    String val = f.get(0);
    assertEquals("hello", val);
  }

  /*****************************************/
  /* Testing a valid and an invalid remove */
  /*****************************************/
  //This tests the remove function as well as the index of function
  //THe remove function is suppose to remove the first appearance of an object in the list
  //once removed if asked for its index, since its not in the list, it should return -1
  @Test
  public void testValidRemove() {
    f.remove("Hello");
    assertEquals(f.indexOf("Hello"), -1);
  }
  //This tests for trying to remove something outside the size of the list
  //This should not work and is expecting an IndexOutOfBoundsException
  @Test(expected = IndexOutOfBoundsException.class)
  public void testInvalidRemove() {
    f.remove(3);
  }

  //Apurva Memani Created this test
  /***********************************/
  /*Testing a valid remove that only removes once*/
  /***********************************/
  //This tests if the remove function successfully only removes the first appearance of an item in the list
  //This should asserEquals true that another "hello" is still in the list at a different index
  @Test
  public void testValidRemove2()
  {
    s.remove(0);
    assertEquals(1, s.indexOf("hello"));
  }

  /***********************************/
  /* Testing a valid and invalid set */
  /***********************************/
  //This tests the set function to make sure it replaces the correct index with the correct element
  @Test
  public void testValidSet() {
    f.set(0, "hi");
    assertEquals(f.get(0), "hi");
  }


  //This tests the set function to make sure it throws an IndexOutOfBoundsException if you try to set it
  //somewhere the list does not exist
  @Test(expected = IndexOutOfBoundsException.class)
  public void testInvalidSet() {
    f.set(6, "hi");
  }

  /***********************************/
  /* Testing isEmpty                 */
  /***********************************/

  //TODO write these tests.
}
