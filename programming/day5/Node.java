public class Node<T>{
    T value;
    Node<T> next;
    public Node(){
        value = null;
        next = null;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> c){
        next = c;
    }
    public void setValue(T v){
        value = v;
    }
    public T getValue(){
        return value;
    }
}