package DataStructures;
import java.util.LinkedList;
import java.util.Queue;


public class STAQ<E> {

	private Queue<E> oneOnly= new LinkedList<E>();
	
	public E pop()
	{
		if(!oneOnly.isEmpty())
			return oneOnly.remove();
		else
			return null;
	}
	
	public void push(E element)
	{
		if(oneOnly.isEmpty())
			oneOnly.add(element);
		else
		{
			int size = oneOnly.size();
			oneOnly.add(element);
			for(int i = 0;i<size;i++)
				oneOnly.add(oneOnly.remove());
		}
	}
}
