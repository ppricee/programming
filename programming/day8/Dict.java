/**
 * Interface for a dictionary data structure
 */
public class Dict<K extends Comparable<K>, V> implements IDict<K, V>{
    DoubleLinkList<K,V> links = new DoubleLinkList<K,V>();

    /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v) {
        V a;
        if (links.size() != 0) {
            for (int i = 0; i <= links.size(); i++) {
                if (k.compareTo(links.fetch(i)) == 0) {
                    a = links.fetch(k);
                    links.remove(i);
                    links.insert(i, k, v);
                    return a;
                }
            }
//            return a;
        }
            links.append(k, v);
            return null;
        }

    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k){
        for (int i = 0; i <= links.size(); i++) {
            if (k.compareTo(links.fetch(i)) == 0) {
                V a = links.fetch(k);
                links.remove(i);
                return a;
            }
        }
            return null;
        }

    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size(){
        return links.size();
    }

    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k){
        return links.fetch(k);
    }

    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys(){
        K[] keys = (K[]) new Object[links.size()];
        for (int i = 0; i< links.size();i++) {
            keys[i] = links.fetch(i);
        }
        return keys;
    }
}