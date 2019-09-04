import java.util.*;
import java.lang.*;

public class Calculator 
{
  	public static void main(String[] args) 
  	{
    	Scanner input = new Scanner(System.in);
        
    	String line;
   		String inFix = "";
		String postFix = "";

		double answer;
   
      	System.out.println("type your infix expression:");

      	line = input.nextLine();
            
     	for(int i = 0; i < line.length(); i++)
	  	{
      		char c = line.charAt(i);
                
        	if(!Character.isDigit(c))
			{
          		inFix = inFix + " " + c + " ";          
        	}
			else 
			{
          		inFix += c;
        	}
      	}
            
		Converter converter = new Converter(inFix);

		postFix = converter.toPostFix();
                
        System.out.println("converted to postfix: " + postFix);
                
        answer = calculate(postFix);
                
        System.out.println("answer is " + answer);
  	}
  
  	public static double calculate(String exp)
  	{
    	ArrayStack<Double> stack = new ArrayStack<>();
    	
		String operator;
        
    	double op1;
    	double op2;
    	double result = 0.0;
        
    	Scanner token = new Scanner(exp);
        
    	while(token.hasNext())
		{
      		if(token.hasNextInt())
			{
        		double value = token.nextInt();
        		
        		stack.push(value);
      		} 
			else 
			{
        		operator = token.next();
        
        		op2 = stack.top();
        		
				stack.pop();
                
        		op1 = stack.top();
        		
				stack.pop();
                
        		if(operator.equals("/"))
				{
					result = op1 / op2;
				}
        		else if(operator.equals("*"))
				{
					result = op1 * op2;
				}
        		else if(operator.equals("+"))
				{
					result = op1 + op2;
				}
        		else if(operator.equals("-"))
				{
					result = op1 - op2;
				}
        		else if(operator.equals("^"))
				{
					result = Math.pow(op1, op2);
				}
        		else
				{
					System.out.println("Cannot use the symbol");	
                }
        
				stack.push(result);
      		}
    	}
        
    	result = stack.top();
    	
		stack.pop();
    
    	return result;
  	}   
}
