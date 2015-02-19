package DataStructures;

public class NODE {
		int data;
		NODE next = null;
		
		public NODE(int data)
		{
			this.data = data;
		}
		
		public void AppendToTail(int data)
		{
			NODE end = new NODE(data);
			NODE n = this;
			while(n.next!=null)
				n=n.next;
			n.next= end;
		}

}
