import java.util.*;
import java.io.*;
import java.lang.*;

public class Converter 
{        
	String exp;
    
    public Converter(String exp)
	{
        this.exp = exp;
    }
    
    public boolean isOperand(String s)
	{
        double val = 0;
      
        try
		{
            val = Double.parseDouble(s); 
        } 
		catch (Exception e)
		{
            return false;
        }
    
        return true;
    }
    
    public static boolean isOperator(String s)
	{
        String operators="+-*/^";
        
        return (operators.indexOf(s) >= 0);
    }
    
    public int precedence(String op)
	{
        int precedence = 0;
        
        if(op.equals("+"))
		{
            precedence = 1;
		}
        else if(op.equals("-"))
		{
            precedence = 1;
		}
        else if(op.equals("*"))
		{
            precedence = 2;
		}
        else if(op.equals("/"))
		{
            precedence = 2;
		}
        else if(op.equals("^"))
		{
            precedence = 3;
		}
        
        return precedence;
    }
    
    public String toPostFix()
	{
        ArrayStack<String> stack = new ArrayStack<>();
        
        String postfix = "";
        
		Scanner token = new Scanner(exp);
        
        while(token.hasNext())
		{
            String t = token.next();
           	
			if(isOperand(t))
			{
                postfix += t + " ";
            }
            else if(t.equals("("))
			{
                stack.push(t);
			}
            else if(isOperator(t))
			{
                while(!stack.isEmpty() && precedence(stack.top()) >= precedence(t))
				{
                    postfix += stack.top() + " ";

                    stack.pop();
                }

                stack.push(t);
            }
            else if(t.equals(")"))
			{
                while(!stack.top().equals("("))
				{
                    postfix += stack.top() + " ";
                    
					stack.pop();
                }

                stack.pop();
            }
        }
        
        while(!stack.isEmpty())
		{
            postfix += stack.top() + " ";
            
			stack.pop();
        }
        
        return postfix;
    }   
}
