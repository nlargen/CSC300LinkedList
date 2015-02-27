package csc300hmwk;

public class stack {
	private Node top; 
	public stack()
	{
		this.top = null; 
	}
	
	public boolean isEmpty()
	{
		return this.top == null; 
	}
	
	public void push(int payload) 
	{
		Node n = new Node(payload); 
		if(this.top == null)
		{
			this.top = n; 
		}
		else 
		{
			n.setNextNode(this.top);
			this.top = n; 
		}
	}
	public int pop() throws Exception 
	{
		if(this.top == null)
		{
			throw new Exception("This stack is empty");
			
		}
		else 
		{
			int valToReturn = this.top.getPayload(); 
			this.top = this.top.getNextNode(); 
			return valToReturn; 
		}
	}
	public int peek() throws Exception 
	{
		if(this.top == null)
		{
			throw new Exception("Hey the stack is empty add a goat!");
			
		}
		else 
		{
			return this.top.getPayload(); 
		}
	}
}
