
import java.util.*;

/**
 *
 * @author DatGatto
 */

public class main {

   
    public static void printMenu(){
        System.out.println("Choose one of these options");
        System.out.println("1. Check Empty");
        System.out.println("2. Push an Element");
        System.out.println("3. Pop out head Element");
        System.out.println("4. Pop out all Elements");
        System.out.println("5. Get top");
        System.out.println("6. Clear Stack");
        System.out.println("0. Exit");

    }
    public static void checkEmpty(Stack sampleStack){
        if (sampleStack.isEmpty())
            System.out.println("Stack is Empty");
        else
            System.out.println("Stack is NOT Empty");
    }
    public static void pushAnElement(Stack sampleStack){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a Number: ");
        sampleStack.push(in.nextInt());
        System.out.println("Inserted");
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
                System.out.print("  ");
            }
    }
    public static void getTop(Stack sampleStack){
        try{
            int top = sampleStack.top();
            System.out.print(top);}
        catch (EmptyStackException e){
            
        }
    }
    public static void clearStack(Stack sampleStack){
        while (!sampleStack.isEmpty()){
            try{
                sampleStack.pop();
            }
            catch(EmptyStackException e){
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack sampleStack = new Stack();
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            int choice = in.nextInt();
            switch (choice){
                case 1: 
                    checkEmpty(sampleStack);
                    break;
                case 2:
                    pushAnElement(sampleStack);
                    break;
                case 3:
                    popHead(sampleStack);
                    System.out.println("");
                    break;
                case 4:
                    popAll(sampleStack);
                    System.out.println("");
                    break;
                case 5:
                    getTop(sampleStack);
                    System.out.println("");
                    break;
                case 6:
                    clearStack(sampleStack);
                    break;               
                case 0:
                    System.out.println("Exited");
                    isRunning = false;                            
            }
        }
               
    }
}
    

