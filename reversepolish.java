package csc300hmwk;

import java.util.Scanner;
import java.util.Stack;

public class reversepolish 

{

	private Stack theSack; 


	public reversepolish()
	{
		this.theSack = new Stack(); 
	}
	private boolean isNum(String s)
	{
		String map = "0123456789";
		if(s.charAt(0) == '+' || s.charAt(0) == '-')
		{
			s = s.substring(1); 
		}
		for(int i = 0; i <s.length(); i++)
		{
			if(map.indexOf(s.charAt(i)) == -1)
			{
				return false; 
			}
		}
		return true; 
	}
	private boolean isNumber(String s)
	{
		
	}

	public void on()
	{
		Scanner input = new Scanner(System.in); 
		while(true)
		{
			System.out.print("+> ");
			String val = input.nextLine(); 
			if(val.equalsIgnoreCase("quit"))
			{
				break; 
			}
			else if()
			{

			}
			System.out.println(val);

		}
	}

}
