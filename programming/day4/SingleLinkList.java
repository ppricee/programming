/**
 * List interface based on the 11/29 discussion of what a program using lists might
 * need to do. This will be our definition for the list ADT this block.
 */
public class SingleLinkList<T> implements IList<T> {
        int listsize;
        int current;
        ISLink<T> head;
        ISLink<T> tail;


        public SingleLinkList(){
                head = null;
                tail = null;
        }
//    public static void main(String[] args){
//        IList<Integer> singleList = new SingleLinkList<Integer>();
//        for(int i=0; i<10; i++) {
//            singleList.append(i);
//            System.out.println("Before: " + singleList.fetch(i));
//        }
//        singleList.remove(4);
//        for(int i=0; i<10; i++) {
//            System.out.println("After: " + singleList.fetch(i));
//        }
//
//    }
    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v){
            ISLink<T> cell = new SCell();
            ISLink<T> after = null;
            ISLink<T> before = null;
            cell.setValue(v);
            if (listsize == idx){
                    append(v);
            }
            else {
                for (int i = 0; i <= idx; i++) {
                    if (i == 0) {
                        after = head;
                    }
                    else {
                        after = after.getNext();
                    }
                }
                for (int i = 0; i<idx; i++){
                    if(i == 0){
                        before = head;
                    }
                    else{
                        before = before.getNext();
                    }
                }
        before.setNext(cell);
        cell.setNext(after);
        }
        listsize++;
        }
    /**
     * Adds an item to the end of list. Called 'Add' in class, but more usually called
     * append in other libraries. Moves <i>current</i> to the end of the list.
     * @param v Item to add
     */
public void append(T v){
        ISLink<T> node = new SCell();
        node.setValue(v);
        if (listsize == 0){
                node.setNext(node);
                tail = node;
                head = node;
        }
        else{
                node.setNext(node);
                tail.setNext(node);
                tail = node;
        }
        listsize++;
        current = listsize -1;
        }

    /**
     * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
     * the previous item in the list, if such element exists.
     */
    public void remove(){
        remove(current);
        prev();
        }
    /**
     * Removes the item at a specific index
     * @param idx index of item to remove
     */
    public void remove(int idx){
        ISLink<T> after = null;
        ISLink<T> delete = null;
        ISLink<T> before = null;
        for (int i = 0; i <= idx; i++){
           if(i == 0){
              delete = head;
           }
           else{
              delete = delete.getNext();
           }
        }
        for (int i = 0; i<idx; i++){
            if(i == 0){
                before = head;
            }
            else{
                before = before.getNext();
            }
        }
        if(idx == 0){
           after = delete.getNext();
           after.setNext(after.getNext());
           head = after;
        }
        else{
            after = delete.getNext();
            before.setNext(after);
        }
        if(current > idx){
        current--;
        }
        listsize--;
        }
    /**
     * Changes the location of an existing element in the list
     * @param sidx - The initial index for the element to move
     * @param didx - The final index for the element to move
     */
public void move(int sidx, int didx){
        ISLink<T> cell = null;
        for (int i = 0;i <= sidx;i++){
        if (i == 0){
        cell = head;
        }
        else{
        cell = cell.getNext();
        }
        }
        remove(sidx);
        insert(didx, cell.getValue());

        }
    /**
     * Fetches the value at the <i>current</i> index in the list.
     * @return the requested item
     */
public T fetch() {
        ISLink<T> fetch_cell = null;
        for(int i = 0; i <= current; i++){
        if (i == 0){
        fetch_cell = head;
        }
        else{
        fetch_cell = fetch_cell.getNext();
        }
        }
        return fetch_cell.getValue();
        }
    /**
     * Fetches the value at a specific index in the list.
     * @param idx index of the item to return
     * @return the requested item
     */
public T fetch(int idx){
        ISLink<T> fetch = null;
        for(int i = 0; i <= idx; i++){
        if (i == 0){
        fetch = head;
        }
        else{
        fetch = fetch.getNext();
        }
        }
        return fetch.getValue();
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
        current = listsize -1;
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
