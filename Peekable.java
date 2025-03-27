/**
 * Westmont College Spring 2025
 * CS 030 Lab 11
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 */

/**
 * Specifies the behavior that allows "peeking" at the head of an ordered collection.
 */
public interface Peekable {

  /**
   * Retrieves, but does not remove, the head of the ordered collection, or returns null if this collection is empty.
   *
   * @return the head of this list, or {@code null} if this list is empty
   */
  Object peek();
}
