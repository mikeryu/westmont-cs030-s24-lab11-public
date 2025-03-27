/**
 * Westmont College Spring 2025
 * CS 030 Lab 11
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 */

/**
 * Simplified version of {@link java.util.Deque} to specify the fundamental LIFO stack functionalities.
 */
public interface BasicStack extends Peekable {

  /**
   * Pushes an element onto the stack by adding an item to the head of this ordered collection.
   *
   * @param o the element to push
   */
  void push(Object o);

  /**
   * Pops an element from the stack by removing and returning the first element of this ordered collection.
   *
   * @return the first element of this ordered collection (which is the logical top of the stack)
   * @throws java.util.NoSuchElementException if this stack is empty
   */
  Object pop();
}
