package DataStructures;

public class STACK {
		NODE top;
		
		Object pop()
		{
			if(top!=null)
			{
				Object item = top.data;
				top = top.next;
				return item;
			}
			return null;
		}
		
		void push(int item)
		{
			NODE t = new NODE(item);
			t.next = top;
			top = t;
		}
		
		Object peek()
		{
			return top.data;
		}
}
