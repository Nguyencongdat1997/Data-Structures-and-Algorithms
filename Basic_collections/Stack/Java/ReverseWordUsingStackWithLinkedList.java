/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversewordusingstackwithlinkedlist;
import java.util.*;
/**
 *
 * @author Admin
 */
public class ReverseWordUsingStackWithLinkedList {
    public static void printMenu(){
        System.out.println("Choose one of these options");
        System.out.println("1. Enter word to reverse");
        System.out.println("0. Exit");
    }
    public static void popHead(Stack sampleStack){
        try{
            System.out.print(sampleStack.pop());}
        catch (EmptyStackException e){
            
        }
    }
    public static void popAll(Stack sampleStack){
        if (sampleStack.isEmpty())
            System.out.println("This Stack is Empty");
        else
            while (!sampleStack.isEmpty()){
                popHead(sampleStack);
              
            }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        Stack inputedString = new Stack();
        boolean isRunning= true;
        while (isRunning){
            printMenu();
            int choice = in.nextInt();
            switch (choice){
                case 1: 
                    System.out.println("Input a word to reverse: ");
                    String input = in.next();
                    inputedString.clear();
                    for (int i =0;i<input.length();i++){
                        inputedString.push(input.charAt(i));
                    }
                    System.out.println("Reversed String:");
                    popAll(inputedString);
                    System.out.println("");
                    break;
            
                case 0: 
                    isRunning = false;
            }
        }
    }
    
}
