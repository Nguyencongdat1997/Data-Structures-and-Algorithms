import java.util.Scanner;

public class Main {   
    public static void printMenu(){
        System.out.println("Choose one of these options");
        System.out.println("1. Check Empty");
        System.out.println("2. Enqueue an Element");
        System.out.println("3. Dequeue an Element");
        System.out.println("4. Get all Elements");
        System.out.println("5. Get front");
        System.out.println("6. Clear ");
        System.out.println("0. Exit");

    }
    public static void checkEmpty(Queue sampleQueue){
        if (sampleQueue.isEmpty())
            System.out.println("Queue is Empty");
        else
            System.out.println("Queue is NOT Empty");
    }
    public static void enqueueAnElement(Queue sampleQueue){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a Number: ");
        sampleQueue.enqueue(in.nextInt());
        System.out.println("Inserted");
    }
    public static void dequeueAnElement(Queue sampleQueue){
        try{
            System.out.print(sampleQueue.dequeue());}
        catch (EmptyQueueException e){
            
        }
    }
    public static void getALl(Queue sampleQueue){
        if (sampleQueue.isEmpty())
            System.out.println("This Stack is Empty");
        else
            while (!sampleQueue.isEmpty()){
                dequeueAnElement(sampleQueue);
                System.out.print("  ");
            }
    }
    public static void getFront(Queue sampleQueue){
        try{
            System.out.print(sampleQueue.front());}
        catch (EmptyQueueException e){
            
        }
    }
    public static void clearQueue(Queue sampleQueue){
        sampleQueue.clear();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue sampleQueue = new Queue();
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            int choice = in.nextInt();
            switch (choice){
                case 1: 
                    checkEmpty(sampleQueue);
                    break;
                case 2:
                    enqueueAnElement(sampleQueue);
                    break;
                case 3:
                    dequeueAnElement(sampleQueue);
                    System.out.println("");
                    break;
                case 4:
                    getALl(sampleQueue);
                    System.out.println("");
                    break;
                case 5:
                    getFront(sampleQueue);
                    System.out.println("");
                    break;
                case 6:
                    clearQueue(sampleQueue);
                    break;               
                case 0:
                    System.out.println("Exited");
                    isRunning = false;
                            
            }
        }
               
    }
    
}
