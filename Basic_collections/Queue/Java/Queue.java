/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DatGatto
 */
class EmptyQueueException extends Exception {

  public EmptyQueueException(){
      System.out.println("This Stack is empty");
  }

}
public class Queue {
    Integer [] elements; //array of integer
    int max; // max size of elements
    int n; // current number in queue
    
    public Queue() {
        elements = new Integer [8];
        this.max = 8;
        this.n = 0;
    }

    public Queue(int max) {
        this.max = max;
        elements = new Integer [max];
        n = 0;
    }
    public boolean isEmpty(){
        return n== 0;
    }
    public void enqueue(int x){
        if (n== max){
            System.out.println("Queue is full");
        }
        else{
            n+= 1;
            elements[n-1] = x;
        }
    }
    public Integer dequeue() throws EmptyQueueException{      
        if (isEmpty()) throw new EmptyQueueException();
        else{
            int x = elements[0];
            for (int i=0;i<n-1;i++)
                elements[i] = elements[i+1];
            n -= 1;
            return x;
        }        
    }
    public int getSize(){
        return max;
    }
    public void clear(){
        while (!isEmpty())
            try {
                Integer t = dequeue();
            }
            catch (EmptyQueueException e ){}
    }
    public Integer front() throws EmptyQueueException{      
        if (isEmpty()) throw new EmptyQueueException();
        else{
            
            return elements[0];
        }        
    }
    public void traverse(){
        System.out.print("Queue: ");
        for (Integer x: elements)
            System.out.print(x+" ");
        System.out.println("");
        
    }
}
