public interface Stack<E>
{
  void push(E e);
  void pop(); 

  E top(); 

  boolean isEmpty();
  boolean isFull();
}
