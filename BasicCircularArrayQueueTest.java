/**
 * Westmont College Spring 2024
 * CS 030 Lab 11
 *
 * @author Assistant Professor Mike Ryu mryu@westmont.edu
 */

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BasicCircularArrayQueueTest {

  @Test
  void peekEmpty() {
    BasicCircularArrayQueue q = new BasicCircularArrayQueue();
    assertNull(q.peek());
  }

  @Test
  void peekSingleItem() {
    BasicCircularArrayQueue q = new BasicCircularArrayQueue();
    q.enqueue("First!");
    assertEquals("First!", q.peek());
  }

  @Test
  void peekMultiItem() {
    BasicCircularArrayQueue q = new BasicCircularArrayQueue();
    for (int i = 0; i < 30; i++) {
      q.enqueue(i + 1);
    }

    assertEquals(1, q.peek());
    assertEquals(1, q.peek());
    assertEquals(1, q.peek());
  }

  @Test
  void dequeueEmpty() {
    BasicCircularArrayQueue q = new BasicCircularArrayQueue();
    assertThrows(NoSuchElementException.class, q::dequeue);

    q.enqueue(null);
    assertNull(q.dequeue());
    assertThrows(NoSuchElementException.class, q::dequeue);
  }

  @Test
  void enqueueDequeueMultiItem() {
    BasicCircularArrayQueue q = new BasicCircularArrayQueue();
    for (int i = 0; i < 3456; i++) {
      assertEquals(i, q.size());
      q.enqueue(i + 1);
      assertEquals(i + 1, q.unusualMethodForTestDriverOnly()[i]);
      assertEquals(i + 1, q.size());
    }

    for (int i = 0; i < 3456; i++) {
      assertEquals(3456 - i, q.size());
      assertEquals(i + 1, q.dequeue());
      assertEquals(3456 - (i + 1), q.size());
    }
  }

  @Test
  void wrapAroundAndGrow() {
    BasicCircularArrayQueue q = new BasicCircularArrayQueue();

    q.enqueue(1);
    assertArrayEquals(new Object[]{1, null, null, null, null, null, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    assertArrayEquals(new Object[]{1, 2, 3, 4, 5, null, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.dequeue();
    assertArrayEquals(new Object[]{null, 2, 3, 4, 5, null, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.dequeue();
    assertArrayEquals(new Object[]{null, null, 3, 4, 5, null, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(6);
    q.enqueue(7);
    q.enqueue(8);
    q.enqueue(9);
    assertArrayEquals(new Object[]{null, null, 3, 4, 5, 6, 7, 8, 9, null},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(10);
    assertArrayEquals(new Object[]{null, null, 3, 4, 5, 6, 7, 8, 9, 10},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(11);
    assertArrayEquals(new Object[]{11, null, 3, 4, 5, 6, 7, 8, 9, 10},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(12);
    assertArrayEquals(new Object[]{11, 12, 3, 4, 5, 6, 7, 8, 9, 10},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(13);
    assertArrayEquals(new Object[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, null, null, null, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(14);
    q.enqueue(15);
    q.enqueue(16);
    q.enqueue(17);
    q.enqueue(18);
    assertArrayEquals(new Object[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.dequeue();
    assertArrayEquals(new Object[]{null, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, null, null, null, null},
        q.unusualMethodForTestDriverOnly());

    q.enqueue(19);
    q.enqueue(20);
    q.enqueue(21);
    q.enqueue(22);
    q.enqueue(23);
    assertArrayEquals(new Object[]{23, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22},
        q.unusualMethodForTestDriverOnly());

    for (int i = 0; i < 20; i++) {
      assertEquals(20 - i, q.size());
      q.dequeue();
    }

    assertThrows(NoSuchElementException.class, q::dequeue);
    assertArrayEquals(new Object[20], q.unusualMethodForTestDriverOnly());
  }
}