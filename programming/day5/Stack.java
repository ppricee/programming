public class Stack<T> implements IStack<T>{
    Node<T> head;
    public Stack(){
        head = null;
    }
    /**
     * Pushes a new value onto the stack
     * @param v the value to push
     */
    public void push(T v) throws OverFlowException {
        Node<T> push_new = new Node<T>();
        push_new.setValue(v);
        push_new.setNext(head);
        head = push_new;
    }
    /**
     * Pops the top value from the stack
     * @return the value
     */
    public T pop() throws UnderFlowException{
        if (head == null){
            throw new UnderFlowException();
        }
        Node<T> removedNode = head;
        T v = removedNode.getValue();
        head = head.getNext();
        return v;
    }


}