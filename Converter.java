/* Jonathan Cheruvelil jcheruve
   Nishanth Dara ndara
   October 8th, 2015
   Project 1   */

import java.util.Scanner;

//The Converter class is a mechanism to solve any arithmetic expression via postfix notation
public class Converter
{

    //This method takes in an arithmetic expression and converts it to postfix notation
    public static String infixToPostfix(String expression)
    {
        String output = "";
        MyStack<String> operands = new MyStack<String>();

        String[] values = expression.split(" ");

        for(String value: values)
        {
            if(!(isOperator(value)))
            {
                output += value;
                output += " ";
            }
            else
            {
                if(value.equals("("))
                {
                    operands.push(value);
                }
                else if(isArithmetic(value))
                {
                    while( (!(operands.isEmpty())) && (!(operands.peek().equals("("))) && compareOperands(value, operands.peek()))
                    {
                        output += operands.pop();
                        output += " ";
                    }
                    operands.push(value);
                }
                else
                {
                    while(!(operands.peek().equals("(")))
                    {
                        output += operands.pop();
                        output += " ";
                    }
                    operands.pop();
                }
            }
        }

        while(!(operands.isEmpty()))
        {
            output += operands.pop();
            output += " ";
        }
        return output;

    }

    //This support method will return true or false depending on if the input is an operator
    private static boolean isOperator(String value)
    {
        return (value.equals("+") || value.equals("-") || value.equals("*")
                || value.equals("/") || value.equals("(") || value.equals(")"));
    }

    //This support method will return true or false depending on if the input is a basic arithmetic operator
    private static boolean isArithmetic(String value)
    {
        return(value.equals("+") || value.equals("-") || value.equals("*")
                || value.equals("/"));
    }

    //This support method compares operands to see which one is of higher priority
    private static boolean compareOperands(String current, String top)
    {
        int current_int;
        int top_int = 5;

        if(top.equals("("))
        {
            top_int = 0;
        }

        if (current.equals("+") || current.equals("-"))
        {
            current_int = 1;
        }
        else
        {
            current_int = 2;
        }
        if (top.equals("+") || top.equals("-"))
        {
            top_int = 1;
        }
        else if (top.equals("*") || top.equals("/"))
        {
            top_int = 2;
        }
        return (current_int <= top_int);
    }

    //This method evaluates an expression given in postfix notation
    public static double postfixValue(String expression)
    {
        Scanner scan = new Scanner(expression);
        MyStack<Double> nums = new MyStack<Double>();

        while(scan.hasNext())
        {
            if(scan.hasNextDouble())
            {
                nums.push(scan.nextDouble());
            }
            else
            {
                double result;
                double num1 = nums.pop();
                double num2 = nums.pop();
                String op = scan.next();
                if(op.equals("+"))
                {
                    result = num1 + num2;
                }
                else if(op.equals("-"))
                {
                    result = num2 - num1;
                }
                else if(op.equals("*"))
                {
                    result = num1 * num2;
                }
                else
                {
                    result = num2 / num1;
                }
                nums.push(result);
            }
        }
        return nums.pop();
    }
}
