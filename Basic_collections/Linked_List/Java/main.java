
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class Node {
    int info;
    Node next;
    public Node(){
        
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public String toString() {
        return ""+info; 
    }
    
}
class LinkedList {
    Node head;
    Node tail;

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        this.head.next = this.tail;
        this.tail.next = this.head;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    public void insertToHead(int x){
        if (this.head == null && this.tail == null){
            Node newNode = new Node(x,null);
            this.head = newNode;
            this.head.next = this.head;
            this.tail = newNode;
        }
        else{
            Node newNode = new Node(x,null);
            newNode.next = head;
            head = newNode;
            this.tail.next = this.head;
        }
    }
    public void insertToTail(int x){
        if (this.head == null && this.tail == null){
            Node newNode = new Node(x,null);
            this.head = newNode;
            this.tail = newNode;
            this.tail.next = this.head;
        }
        else{
            Node newNode = new Node(x,null);
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.next = this.head;
        }
    }
    public void insertAfter(int y,int x){
        //insert x after y
        if (this.head == null){
            System.out.println("There is no element to insert after");
        }
        else{
            Node temp = head;
            while (temp.next!=head && temp.info != y)
                temp = temp.next;
            if (temp.info == y){
                Node newNode = new Node(x,null);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            else{
                System.out.println("Find out no "+y+" to insert after.");
            }
        }
    }
    public void insertBefore(int y,int x){
        //insert x after y
        if (this.head == null){
            System.out.println("There is no element to insert after");
        }
        else if(head.info == y){
            Node newNode = new Node(x,null);
            newNode.next = head;
            this.head = newNode;
            this.tail.next = this.head;
        }
        else {
            Node temp = head;
            while (temp.next!= head && temp.next.info != y){
                temp = temp.next;
            }
            if (temp.next == null)
                System.out.println("Find out no "+y+" to insert after.");
            if (temp.next.info == y){
                Node newNode = new Node(x,null);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            else{
                System.out.println("Find out no "+y+" to insert after.");
            }
        }
    }
    public void displayAll(){
        if (head == null)
            System.out.println("There is no element");
        else
        {
            Node temp = new Node();
            temp = head;
            System.out.print(" "+temp);
            while (temp != this.tail){
                temp= temp.next;
                System.out.print(" "+temp);
                
            } 
            System.out.println("");
        }
    }
    public void deleteHead(){
        if (head == null){
            System.out.println("There is no element");
        }
        else{
            if (head == tail){
                this.head = null;
                this.tail = null;
            }
            else{
                this.head = head.next;
                this.tail.next = this.head;
            }
        }
    }
    public void deleteTail(){
        if (head == null){
            System.out.println("There is no element");
        }
        else{
            if (head == tail){
                this.head = null;
                this.tail = null;
            }
            else{
                Node temp = head;
                while (temp.next.next != head )
                    temp = temp.next;
                temp.next = null;
                this.tail = temp;
                this.tail.next = this.head;
            }
        }
    }
    public void deleteElement(int x){
        if (head == null){
            System.out.println("There is no element");
        }
        else if (head.info == x){
            if (head.next == null){
                this.head = null;
                this.tail = null;
            }
            else{
                this.head = this.head.next;
                this.tail.next = this.head;
            }
        }
        else{
            Node temp = head;
            while (temp.next != head && temp.next.info != x )
                temp = temp.next;
            if (temp.next == head)
                System.out.println("There is no "+x);
            else
                temp.next = temp.next.next;
            
        }
    }
}
public class main {    
    public static void printMenu(){
        System.out.println("Choose one of this options: ");
        System.out.println("1. Insert Head:");
        System.out.println("2. Insert Tail:");
        System.out.println("3. Insert After an element:");
        System.out.println("4. Insert Before an element");
        System.out.println("5. Delete Head:");
        System.out.println("6. Delete Tail:");
        System.out.println("7. Delete an element:");
        System.out.println("8. Display All:");
        System.out.println("0. Exit");
    }
    public static void main(String[] args) {
        // create list
        Scanner in = new Scanner(System.in);
        LinkedList sampleList = new LinkedList();
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            int choice = in.nextInt();
            switch (choice){
                case 1: 
                    System.out.print("Enter a number to insert to head: ");
                    System.out.println("");
                    sampleList.insertToHead(in.nextInt());
                    break;
                case 2:
                    System.out.print("Enter a number to insert to tail: ");
                    System.out.println("");
                    sampleList.insertToTail(in.nextInt());
                    break;
                case 3:
                    System.out.print("Enter a number to you will chose to be mark: ");
                    System.out.println("");
                    int mark = in.nextInt();
                    System.out.print("Enter the number to you want to insert after "+mark+": ");
                    System.out.println("");
                    sampleList.insertAfter(mark,in.nextInt());
                    break;
                case 4:
                    System.out.print("Enter a number to you will chose to be mark: ");
                    System.out.println("");
                    mark = in.nextInt();
                    System.out.print("Enter the number to you want to insert after "+mark+": ");
                    System.out.println("");
                    sampleList.insertBefore(mark,in.nextInt());
                    break;
                case 5:
                    System.out.print("Deleted from head");
                    System.out.println("");
                    sampleList.deleteHead();
                    break;
                case 6:
                    System.out.print("Deleted from tail");
                    System.out.println("");
                    sampleList.deleteTail();
                    break;
                case 7:
                    System.out.print("Enter a number to delete: ");
                    System.out.println("");
                    sampleList.deleteElement(in.nextInt());
                    break;
                case 8:
                    sampleList.displayAll();
                    break;
                case 0:
                    System.out.println("Exited");
                    isRunning = false;
                            
            }
        }
               
    }
    
}
