package csc300hmwk;

public class Driver {
	
	public static void main(String[] args) throws Exception
	{
		LinkedList ll = new LinkedList();
		ll.addFront(1);
		ll.addFront(8);
		ll.addFront(7);
		ll.addFront(3);
		ll.addFront(5);
		ll.addFront(9);
		ll.display();
		ll.displayInReverse();
		
	}

}
