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
   * Retrieves and removes an element at the "end" of this queue.
   * <br><br>
   * <b>NOTE</b> It is not exactly important where in the underlying ordered collection
   * data structure this operation occurs at, as long as it is at the logical opposite end
   * of the location where {@link BasicQueue#dequeue()} would occur at.
   *
   * @param o the element to add
   */
  void enqueue(Object o);

  /**
   * Retrieves and removes an element at the front of this queue, if one exists.
   * Throws {@link java.util.NoSuchElementException} if the queue is empty.
   * <br><br>
   * <b>NOTE</b> It is not exactly important where in the underlying ordered collection
   * data structure this operation occurs at, as long as it is at the logical opposite end
   * of the location where {@link BasicQueue#enqueue(Object)} would occur at.
   *
   * @return the head of this queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  Object dequeue();
}
