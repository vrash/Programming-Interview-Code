package DataStructures;

public class qu {
	NODE front,rear;
	
	public void enQueue(int item)
	{
		NODE n = new NODE(item);
		if(front==null)
		{
			rear = n;
			front=rear;
		}
		else
		{
			rear.next=n;
			rear = rear.next;
		}
	}
	
	public Object deQueue()
	{
		if(front!=null)
		{
			Object item = front.data;
			front = front.next;
			return item;
		}
		return null;
	}
}
