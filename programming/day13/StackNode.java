public class StackNode<T>{
    T value;
    StackNode<T> next;
    public StackNode(){
        value = null;
        next = null;
    }
    public StackNode<T> getNext(){
        return next;
    }
    public void setNext(StackNode<T> c){
        next = c;
    }
    public void setValue(T v){
        value = v;
    }
    public T getValue(){
        return value;
    }
}