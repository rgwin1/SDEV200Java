//look for WRITE YOUR CODE to write your code
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise24_3 {
  public static void main(String[] args) {
    new Exercise24_3();
  }

  public Exercise24_3() {
    TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
    System.out.print("Enter five numbers: ");
    Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++)
      v[i] = input.nextDouble();

    list.add(v[1]);
    list.add(v[2]);
    list.add(v[3]);
    list.add(v[4]);
    list.add(0, v[0]);
    list.add(2, 10.55);
    list.remove(3);

    ListIterator<Double> iterator1 = list.listIterator();
    System.out.print("The list in forward order: ");
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
    System.out.print("\nThe list in backward order: ");
    while (iterator2.hasPrevious())
      System.out.print(iterator2.previous() + " ");
  }
}

interface MyList<E> extends Collection<E> {
  public void add(int index, E e);
  public E get(int index);
  public int indexOf(Object e);
  public int lastIndexOf(E e);
  public E remove(int index);
  public E set(int index, E e);

  @Override
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  @Override
  public default boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    } else
      return false;
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    return true;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    return true;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    return true;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    return true;
  }

  @Override
  public default Object[] toArray() {
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    return null;
  }
}

class TwoWayLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size;

  public TwoWayLinkedList() {
  }

  public TwoWayLinkedList(E[] objects) {
    for (E e : objects)
      add(e);
  }

  public E getFirst() {
    if (size == 0) return null;
    return head.element;
  }

  public E getLast() {
    if (size == 0) return null;
    return tail.element;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    Node<E> current = head;
    while (current != null) {
      result.append(current.element);
      current = current.next;
      if (current != null)
        result.append(", ");
    }
    result.append("]");
    return result.toString();
  }

  public void clear() {
    head = tail = null;
    size = 0;
  }

  public boolean contains(Object e) {
    return indexOf(e) != -1;
  }

  public E get(int index) {
    if (index < 0 || index >= size) return null;
    Node<E> current = head;
    for (int i = 0; i < index; i++)
      current = current.next;
    return current.element;
  }

  public int indexOf(Object e) {
    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      if (current.element.equals(e)) return i;
      current = current.next;
    }
    return -1;
  }

  public int lastIndexOf(E e) {
    Node<E> current = tail;
    for (int i = size - 1; i >= 0; i--) {
      if (current.element.equals(e)) return i;
      current = current.previous;
    }
    return -1;
  }

  public E set(int index, E e) {
    if (index < 0 || index >= size) return null;
    Node<E> current = head;
    for (int i = 0; i < index; i++)
      current = current.next;
    E old = current.element;
    current.element = e;
    return old;
  }

  private class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;
    public Node(E e) {
      element = e;
    }
  }

  private class LinkedListIterator implements ListIterator<E> {
    private Node<E> current;
    public LinkedListIterator() {
      current = head;
    }
    public LinkedListIterator(int index) {
      current = head;
      for (int i = 0; i < index && current != null; i++)
        current = current.next;
    }
    @Override
    public boolean hasNext() {
      return current != null;
    }
    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }
    @Override
    public boolean hasPrevious() {
      return current != null;
    }
    @Override
    public E previous() {
      E e = current.element;
      current = current.previous;
      return e;
    }
    @Override public void remove() {}
    @Override public void set(E e) { current.element = e; }
    @Override public void add(E e) {}
    @Override public int nextIndex() { return 0; }
    @Override public int previousIndex() { return 0; }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    return listIterator();
  }

  public ListIterator<E> listIterator() {
    return new LinkedListIterator();
  }

  public ListIterator<E> listIterator(int index) {
    return new LinkedListIterator(index);
  }

  //add an element to the beginning of the list
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e);
    newNode.next = head;
    if (head != null)
      head.previous = newNode;
    head = newNode;
    if (tail == null)
      tail = head;
    size++;
  }

  //add an element to the end of the list
  public void addLast(E e) {
    Node<E> newNode = new Node<>(e);
    newNode.previous = tail;
    if (tail != null)
      tail.next = newNode;
    tail = newNode;
    if (head == null)
      head = tail;
    size++;
  }

  //add a new element at the specified index in this list
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    } else if (index >= size) {
      addLast(e);
    } else {
      Node<E> current = head;
      for (int i = 0; i < index; i++)
        current = current.next;
      Node<E> newNode = new Node<>(e);
      newNode.previous = current.previous;
      newNode.next = current;
      current.previous.next = newNode;
      current.previous = newNode;
      size++;
    }
  }

  //remove the head node and return the object that is contained in the removed node
  public E removeFirst() {
    if (size == 0) return null;
    Node<E> temp = head;
    head = head.next;
    if (head != null)
      head.previous = null;
    else
      tail = null;
    size--;
    return temp.element;
  }

  //remove the last node and return the object that is contained in the removed node
  public E removeLast() {
    if (size == 0) return null;
    Node<E> temp = tail;
    tail = tail.previous;
    if (tail != null)
      tail.next = null;
    else
      head = null;
    size--;
    return temp.element;
  }

  //remove the element at the specified position in this list and return it
  public E remove(int index) {
    if (index < 0 || index >= size) return null;
    if (index == 0) return removeFirst();
    if (index == size - 1) return removeLast();
    Node<E> current = head;
    for (int i = 0; i < index; i++)
      current = current.next;
    current.previous.next = current.next;
    current.next.previous = current.previous;
    size--;
    return current.element;
  }
}