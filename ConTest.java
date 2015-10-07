/* Jonathan Cheruvelil jcheruve
   Nishanth Dara ndara
   October 8th, 2015
   Project 1   */

import java.util.Scanner;

//The class ConTest is a driver to test the implementation of the Converter class using MyStack
//  The client has the option to convert from infixtopostfix or evaluate arithmetic and postfix expressions until he/she quits
public class ConTest
{

    //This method executes the ConTest class
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose one of the following operations:");
        System.out.println("-   Infix to postfix conversion (enter the letter i)");
        System.out.println("-   Postfix expression evaluation (enter the letter p)");
        System.out.println("-   Arithmetic expression evaluation (enter the letter a)");
        System.out.println("-   Quit the program (enter the letter q)");

        String input;
        boolean loop = true;
        while(loop)
        {
            input = scan.nextLine();
            switch (input)
            {
                default:
                    System.out.println("Invalid Choice");
                    break;

                case "i":
                    System.out.println("Enter an arithmetic expression");
                    String exp = Converter.infixToPostfix(scan.nextLine());
                    System.out.println("The postfix expression is: " + exp);
                    break;

                case "p":
                    System.out.println("Enter a postfix expression");
                    Double result = Converter.postfixValue(scan.nextLine());
                    System.out.println("The value of the postfix expression is: " + result);
                    break;

                case "a":
                    System.out.println("Enter an arithmetic expression");
                    String postfix = Converter.infixToPostfix(scan.nextLine());
                    Double answer = Converter.postfixValue(postfix);
                    System.out.println("The value of the arithmetic expression is " + answer);
                    break;

                case "q":
                    System.out.println("Quitting");
                    loop = false;
                    break;

            }
        }
    }
}
