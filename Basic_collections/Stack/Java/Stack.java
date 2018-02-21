/**
 *
 * @author DatGatto
 */
class EmptyStackException extends Exception {

  public EmptyStackException(){
      System.out.println("This Stack is empty");
  }

}
class Node {
    
    public int info;
    public Node  next;
    public Node(int x, Node p)
      { info=x; next=p; }
    public Node(int x)
      { this(x,null); }  
}
public class Stack {
    
    private Node head;

    public Stack() 
      { head = null; }

    public boolean isEmpty()
      { return(head==null);}
    public int top() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        return(head.info);
      }
    public void push(int x)
      { head = new Node(x,head);
      }
    public int pop() throws EmptyStackException
      { if(isEmpty())
          throw new EmptyStackException();
      else{
        int x = head.info;
        head=head.next;
        return(x);}
      }
    public  void clear(){
        while (!isEmpty()){
            try{
                pop();
            }
            catch(EmptyStackException e){
            }
        }
    }
}
