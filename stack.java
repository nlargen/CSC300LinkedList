package csc300hmwk;

public class stack {
	private Node head; 
	private Node tail; 
	private int count; 
	
	public void pushstack(int payload) throws Exception 
	{

		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
			this.tail = n; 
		}
		else
		{
			
			this.tail.setNextNode(n); 
			n.setPrevNode(tail); 
			this.tail = n; 
		}
		this.count++;
	}
	public int popstack() throws Exception
	{
		if(head == null)
		{
			throw new Exception("The list is empty!");
		}
		else if(this.count == 1)
		{
			return this.removeFront();
		}
		else
		{
			Node curr = tail; 
			tail = curr.getPrevNode(); 
			curr.setPrevNode(null);
			tail.setNextNode(null);
			this.count--; 
			return curr.getPayload(); 
		}
	}
	public void peekstack() throws Exception 
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else 
		{
			Node currNode = tail;  
		System.out.println(currNode.getPayload());
		}
		
		}
	public int removeFront() throws Exception
	{
		if(head == null)
		{
			throw new Exception("The list is empty!");
		}
		else if (this.count == 1)
		{
			int payloadToReturn = this.head.getPayload(); 
			this.head = null; 
			this.tail = null; 
			this.count = 0; 
			return payloadToReturn; 
			
		}
		else
		{
			Node curr = head; 
			curr.getNextNode().setPrevNode(null); 
			head = curr.getNextNode();
			curr.setNextNode(null);
			this.count--; 
			return curr.getPayload(); 
		}
	}
}
