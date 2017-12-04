/**
 * Interface for a generic fixed length queue
 */
public class Queue<T> implements IQueue<T> {
    T[] array;
    int listsize;
    public Queue(){
        listsize = 0;
        array = (T[]) new Object[listsize];
    }
    /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     * @throws UnderFlowException if dequeueing an empty queue
     */
    public T dequeue() throws UnderFlowException{
        if (listsize == 0){
            throw new UnderFlowException();
        }
            T[] temp_array = (T[]) new Object[listsize-1];
            T v = array[0];
            for (int i = 0; i < temp_array.length; i++) {
                    temp_array[i] = array[i+1];
            }
            array = temp_array;
            listsize--;
            return v;
    }

    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     * @throws OverFlowException if enqueueing a full queue
     */
    public void enqueue(T v) throws OverFlowException{
        T[] temp_array = (T[]) new Object[listsize+1];
        if (listsize == temp_array.length){
            throw new OverFlowException();
        }
        else if(listsize == 0){
            temp_array[listsize] = v;
            listsize++;
            array = temp_array;
        }
        else {
            for (int i = 0; i < listsize; i++) {
                temp_array[i] = array[i];
            }
            temp_array[listsize] = v;
            array = temp_array;
            listsize++;
        }

    }
}