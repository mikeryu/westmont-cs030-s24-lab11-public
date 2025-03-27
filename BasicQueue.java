/**
 * Westmont College Spring 2025
 * CS 030 Lab 11
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 */

/**
 * Simplified version of {@link java.util.Queue} to specify the fundamental FIFO queue functionalities.
 */
public interface BasicQueue extends Peekable {

  /**
   * Inserts the specified element into the head of this queue.
   *
   * @param o the element to add
   */
  void enqueue(Object o);

  /**
   * Retrieves and removes the head of this queue.
   *
   * @return the head of this queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  Object dequeue();
}
