public class ArrayStack<E> implements Stack<E> 
{
	public final int CAPACITY = 1000;
	
	private E[] data;

	private int t = -1;

	public ArrayStack(int capacity)
	{
		data = (E[]) new Object[capacity];
	}

	public ArrayStack()
	{
		data = (E[]) new Object[CAPACITY];
	}

	public void push(E e)
	{
		if(isFull())
		{
			throw new IllegalStateException("Stack is full");	
		}

		data[++t] = e;
	}
  
  	public void pop()
	{
		if(!isEmpty())
		{
			data[t] = null;

			t--;
		}
	}
  	
	public E top()
	{
		if(isEmpty())
		{
			return null;
		}
		
		return data[t];
	}
  	
	public boolean isEmpty()
	{
		return (t == -1);
	}
	
	public boolean isFull()
	{
		return (t == (data.length -1));
	}
}
