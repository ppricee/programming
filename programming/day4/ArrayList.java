/**
 * List interface based on the 11/29 discussion of what a program using lists might
 * need to do. This will be our definition for the list ADT this block.
 */
public class ArrayList<T> implements IList<T>{
    T[] array;
    int current;
    int listsize;
    public ArrayList(){
        listsize = 0;
        array = (T[]) new Object[10];

    }

    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
        T[] temp_array = (T[]) new Object[listsize+1];
        for (int i = 0; i < temp_array.length; i++){
            if (i < idx) {
                temp_array[i] = array[i];
            }
            else if(i > idx) {
                temp_array[i] = array[i-1];
            }
            else {
                temp_array[idx] = v;
            }
        }
        listsize++;
        array = temp_array;
        current = listsize;
    }
    /**
     * Adds an item to the end of list. Called 'Add' in class, but more usually called
     * append in other libraries. Moves <i>current</i> to the end of the list.
     * @param v Item to add
     */
    public void append(T v){
        T[] temp_array = (T[]) new Object[listsize+1];
        for (int i = 0; i < listsize; i++){
            temp_array[i] = array[i];
            }
            temp_array[listsize] = v;
            listsize++;
            array = temp_array;
            current = listsize-1;
    }

    /**
     * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
     * the previous item in the list, if such element exists.
     */
    public void remove(){
        T[] temp_array = (T[]) new Object[listsize-1];
        for (int i = 0; i < listsize; i++){
            if (i == current){
            }
            else if (i < current){
                temp_array[i] = array[i];
            }
            else{
                temp_array[i-1] = array[i];
            }
        }
        if (current > 0){
            current--;
        }
        listsize--;
        array = temp_array;
    }

    /**
     * Removes the item at a specific index
     * @param idx index of item to remove
     */
    public void remove(int idx){
    T[] temp_array = (T[]) new Object[listsize-1];
        for (int i = 0; i < listsize; i++){
        if (i == idx){
        }
        else if (i < idx){
            temp_array[i] = array[i];
        }
        else{
            temp_array[i-1] = array[i];
        }
    }
    listsize--;
    array = temp_array;
    }
    /**
     * Changes the location of an existing element in the list
     * @param sidx - The initial index for the element to move
     * @param didx - The final index for the element to move
     */
    public void move(int sidx, int didx){
        T v = array[sidx];
        remove(sidx);
        insert(didx, v);
    }

    /**
     * Fetches the value at the <i>current</i> index in the list.
     * @return the requested item
     */
    public T fetch(){
        if (current < 0 || current > array.length){
            return null;
        }
        else {
            return array[current];
        }
    }

    /**
     * Fetches the value at a specific index in the list.
     * @param idx index of the item to return
     * @return the requested item
     */
    public T fetch(int idx){
        return array[idx];
    }

    /**
     * Advances the <i>current</i> index to the next index, if possible.
     */
    public void next(){
        if (current < listsize-1){
            current++;
        }
    }

    /**
     * Advances the <i>current</i> index to the previous index, if possible.
     */
    public void prev(){
        if (current > 0){
            current--;
        }
    }

    /**
     * Advances the <i>current</i> to the tail element
     */
    public void jumpToTail(){
        current = listsize-1;
    }

    /**
     * Advances the <i>current</i> to the head element
     */
    public void jumpToHead(){
        current = 0;
    }

    /**
     * Returns the number of elements in the list
     */
    public int size(){
        return listsize;
    }

}