package DataStructures;
import java.util.Stack;

/** Queue using two stacks**/
/** really simple implementation **/

public class QUEUES<E> {

	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();
	
	public void enQueue(E element)
	{
		inbox.push(element);
			
	}
	
	public E deQueue()
	{
		if(outbox.isEmpty())
		{
			while(!inbox.isEmpty())
				outbox.push(inbox.pop());
			
		}
		if(outbox.isEmpty())
			return null;
		else
			return outbox.pop();
	}
}
