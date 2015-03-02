package csc300hmwk;

import java.util.Scanner;


public class reversepolish 

{

	private stack theStack; 
	private int count; 
	private int sum; 

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
	public int sum() throws Exception 
	{
		int total = 0;
		while(!this.theStack.isEmpty())
		{
		 
		int num1 = this.theStack.pop(); 
		total = total + num1;
		sum = total; 
		}
		return sum; 
		
	}
	public void clear() throws Exception
	{
		while(!this.theStack.isEmpty())
		{
			this.theStack.pop();
			sum = 0; 
		}
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
					temp.push(this.theStack.pop());
				}
				while(!temp.isEmpty())
				{
					int num = temp.pop(); 
					System.out.println(num);
					this.theStack.push(num);

				}
			}
			else if(val.equalsIgnoreCase("clear"))
			{
				this.clear();
			}
			else if(val.equalsIgnoreCase("sum"))
			{
				this.theStack.push(this.sum());
				System.out.println(this.theStack.peek()); 
				
			}
			else if(this.isNumber(val))
			{
				this.theStack.push(Integer.parseInt(val)); 
			}
			else if(this.isOperator(val))
			{
				int num1 = this.theStack.pop();
				int num2 = this.theStack.pop();

				if(val.equals("+"))
				{
					this.theStack.push(num1 + num2); 
				}
				else if(val.equals("-"))
				{
					this.theStack.push(num1 - num2);
				}
				else if(val.equals("*"))
				{
					this.theStack.push(num1 * num2);
				}
				else if(val.equals("/"))
				{
					this.theStack.push(num1 / num2);
				}
				else
				{
					System.out.println("Illegal Input");
				}

			}

		}

	}

}
