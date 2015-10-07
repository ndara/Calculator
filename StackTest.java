/* Jonathan Cheruvelil jcheruve
   Nishanth Dara ndara
   October 8th, 2015
   Project 1   */

import java.util.EmptyStackException;
import java.util.Scanner;

//The StackTest class is a driver in place to test the methods of the MyStack class
//  The client has the option to run any method of MyStack until he/she quits the program
public class StackTest
{

    //This method executes the StackTest
    public static void main(String[] args)
    {
        MyStack<String> stack = new MyStack<String>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Choose one of the following operations:");
        System.out.println("-   push/add (enter the letter a)");
        System.out.println("-   pop/delete (enter the letter d)");
        System.out.println("-   peek (enter the letter p)");
        System.out.println("-   check if the list is empty (enter the letter e");
        System.out.println("-   Quit (enter the letter q");

        String input;
        boolean loop = true;
        while(loop)
        {
            input = scan.nextLine();
            switch (input)
            {
                default:
                    System.out.println("Invalid choice");
                    break;

                case "a":
                    System.out.println("Enter a String");
                    String str = scan.nextLine();
                    stack.push(str);
                    System.out.println(str + " pushed in");
                    break;

                case "d":
                    try
                    {
                        String front = stack.pop();
                        System.out.println(front + " popped out");
                    }
                    catch (EmptyStackException e)
                    {
                        System.out.println("Invalid operation on an empty stack");
                    }
                    break;

                case "e":
                    if (stack.isEmpty())
                    {
                        System.out.println("empty");
                    }
                    else
                    {
                        System.out.println("not empty");
                    }
                    break;

                case "p":
                    try
                    {
                        System.out.println(stack.peek() + " on the top");
                    }
                    catch (EmptyStackException e)
                    {
                        System.out.println("Invalid operation on an empty stack");
                    }

                    break;

                case "q":
                    loop = false;
                    System.out.println("quitting");
                    break;
            }
        }
    }
}

