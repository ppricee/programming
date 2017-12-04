/**
 * The interface for the link cells in a singlely linked list
 */
public class SCell<T> implements ISLink<T> {
    ISLink<T> next;
    T value;
    public SCell(){
        next = null;
    }
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue(){
        return value;
    }

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v){
        value = v;
    }

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public ISLink<T> getNext(){
        return next;
    }

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(ISLink<T> c){
        next = c;
    }

}