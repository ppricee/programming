public class DDCell<T> implements IDLink<T>{
    IDLink<T> prev;
    IDLink<T> next;
    T val;
    public DDCell(){
        prev = null;
        next = null;
        val = null;
    }
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue(){
        return val;
    }

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v){
        val = v;
    }

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public IDLink<T> getNext(){
        return next;
    }

    /**
     * Gets the previous cell in the list
     * @return the cell
     */
    public IDLink<T> getPrev(){
        return prev;
    }

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(IDLink<T> c){
        next = c;
    }

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setPrev(IDLink<T> c){
        prev = c;
    }
}