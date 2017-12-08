public class DCell<K extends Comparable<K>, V>{
    DCell<K, V> prev;
    DCell<K, V> next;
    V val;
    K key;
        public DCell(){
            prev = null;
            next = null;
            val = null;
        }
        public K getKey(){
            return key;
        }
        public void setKey(K k){
            key = k;
        }
        /**
         * Gets the current value for this link cell
         * @return the value
         */
        public V getValue(){
            return val;
        }

        /**
         * Sets the current value for this link cell
         * @param v the value to place in this cell
         */
        public void setValue(V v){
            val = v;
        }

        /**
         * Gets the next cell in the list
         * @return the cell
         */
        public DCell<K, V> getNext(){
            return next;
        }

        /**
         * Gets the previous cell in the list
         * @return the cell
         */
        public DCell<K, V> getPrev(){
            return prev;
        }

        /**
         * Sets the next cell in the list
         * @param c the next cell
         */
        public void setNext(DCell<K, V> c){
            next = c;
        }

        /**
         * Sets the next cell in the list
         * @param c the next cell
         */
        public void setPrev(DCell<K, V> c){
            prev = c;
        }
    }