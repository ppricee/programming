public class Stack<T> implements IStack<T>{
    StackNode<T> head;
    int size;
    public Stack(){
        head = null;
    }
    /**
     * Pushes a new value onto the stack
     * @param v the value to push
     */
    public void push(T v) {
        StackNode<T> push_new = new StackNode<T>();
        push_new.setValue(v);
        push_new.setNext(head);
        head = push_new;
        size++;
    }
    /**
     * Pops the top value from the stack
     * @return the value
     */
    public T pop() {
//        if (head == null){
//            throw new UnderFlowException();
//        }
        StackNode<T> removedNode = head;
        T v = removedNode.getValue();
        head = head.getNext();
        size--;
        return v;
    }
    public int getSize(){
        return size;
    }

    public DoubleLinkList<T> getStack(){
        DoubleLinkList<T> stack = new DoubleLinkList<T>();
        int i = 0;
        while(head != null){
            stack.append(pop());
            i++;
        }
        return stack;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

}