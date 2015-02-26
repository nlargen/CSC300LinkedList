package csc300hmwk; 

public class LinkedList 
{
	private Node head;
	private Node tail; 
	private int count;
	
	
	public LinkedList()
	{
		this.head = null;
		this.tail = null; 
		this.count = 0;
	}
	
	public void displayInReverse()
	{
		Node currNode = tail; 
		while(currNode.getPrevNode() != null)
		{
			System.out.print(currNode.getPayload() + "->null");
			currNode = currNode.getPrevNode();
		}
		System.out.println(currNode.getPayload() + "-> null"); 
		
	}
	
	public int get(int index)
	{
		int count = this.count();
		if(index >= count || index < 0)
		{
			System.out.println("Illegal Index");
			return -1;
		}
		else
		{
			Node curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload();
		}
	}
	
	public int count()
	{
		return this.count;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + "->");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + "-> null");
		}
	}
	
	public void addAtIndex(int payload, int index)
	{
		
		if(index <= 0)
		{
			this.addFront(payload);
		}
		else if(index >= this.count)
		{
			this.addEnd(payload);
		}
		else
		{
			Node n = new Node(payload);
			Node curr = head;
			for(int i = 0; i < index-1; i++)
			{
				curr = curr.getNextNode();
			}
			n.setNextNode(curr.getNextNode());
			n.setPrevNode(curr.getPrevNode());
			curr.setNextNode(n);
			n.getPrevNode().setNextNode(n);
			this.count++;
		}
		
	}
	
	public void addFront(int payload)
	{
		Node n = new Node(payload);
		if(head == null)
		{
			head = n;
		}
		else
		{
			n.setNextNode(head);
			head = n;
		}
		this.count++;
	}
	
	public void addEnd(int payload)
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
	
	public int removeAtIndex(int index) throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove At Index: Empty List");
		}
		else if(index < 0 || index > this.count-1)
		{
			throw new Exception("Can Not Remove At Index: Index Out of Bounds : " + index);
		}
		else
		{
			if(index == 0)
			{
				return this.removeFront();
			}
			else if(index == this.count-1)
			{
				return this.removeEnd();
			}
			else
			{
				Node currNode = head;
				for(int i = 1; i < index; i++)
				{
					currNode = currNode.getNextNode();
				}
		
				currNode.getPrevNode().setNextNode(currNode.getNextNode()); 
				currNode.getNextNode().setPrevNode(currNode.getPrevNode());
				currNode.setNextNode(null);
				currNode.setPrevNode(null);
				this.count--; 
				return currNode.getPayload();
			}
		}
	}
	
	public int removeEnd() throws Exception
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
		
}