package csc300hmwk;

import java.util.Scanner;


public class reversepolish 

{

	private stack theStack; 


	public reversepolish()
	{
		this.theStack = new stack(); 
	}
	
	private boolean isNumber(String s)
	{
		try 
		{
			Integer.parseInt(s);
		}
		catch(Exception e)
		{
			return false; 
		}
		return true; 
	}
	
	private boolean isOperator(String s)
	{
		String map = "+-*/";
		return map.indexOf(s) != -1 && s.length() == 1; 
	}
	

	public void on() throws Exception
	{
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("=> ");
			String val = input.nextLine().trim(); 
			if(val.equalsIgnoreCase("quit"))
			{
				break; 
			}
			else if(val.equalsIgnoreCase("show"))
			{
				if(this.theStack.isEmpty())
				{
					System.out.println("empty stack");
					continue; 
				}
				stack temp = new stack(); 
				while(!this.theStack.isEmpty())
				{
					temp.pushstack(this.theStack.isEmpty());
				}
				while(!temp.isEmpty())
					{
					int num = temp.popstack(); 
					System.out.println(num);
					this.theStack.pushstack(num);
					
				}
				
			}
			else if(this.isNumber(val))
			{
				this.theStack.pushstack(Integer.parseInt(val)); 
			}
			else if(this.isOperator(val))
			{
				int num1 = this.theStack.popstack();
				int num2 = this.theStack.popstack();
				if(val.equals("+"))
				{
					this.theStack.pushstack(num1 + num2); 
				}
				else if(val.equals("-"))
				{
					this.theStack.pushstack(num1 - num2);
				}
				else if(val.equals("*"))
				{
					this.theStack.pushstack(num1 * num2);
				}
				else if(val.equals("/"))
				{
					this.theStack.pushstack(num1 / num2);
				}
			}
			else
			{
				System.out.println("Illegal Input");
			}

				System.out.println(val);

		}
	}

}
