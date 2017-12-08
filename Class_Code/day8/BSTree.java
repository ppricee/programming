import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public class BSTree<K extends Comparable<K>,V> implements IDict<K, V>{
    Tree<K,V> branch = new Tree<K,V>();
    int listsize = 0;


    public static void main(String[] args) throws Exception{
        System.out.println("Reading in the words");
        BufferedReader br=new BufferedReader(new FileReader("shortlist.txt"));
        // !!! Choose your favorite list implementation here !!!
        IList<String> words=new WordList<String>();
        String l=br.readLine();
        while(l!=null) {
            words.append(l);
            l=br.readLine();
        }
        System.out.println("Doing the inserts");
        // Add them to the dictionaries in random order
        String[] allwords = new String[words.size()];
        IDict<String,Integer> tree   = new BSTree<String,Integer>();
        Random rand = new Random();
        for(int i=0; words.size()>0; i++) {
            int idx = rand.nextInt(words.size());
            allwords[i]=words.fetch(idx);
            words.remove(idx);
            tree.add(allwords[i],i);
        }
        long s;
        long e;
        rand.setSeed(0);
        e = System.currentTimeMillis();
        rand.setSeed(0);
        s = System.currentTimeMillis();
        for(int i=0; i<100000; i++) {
            int idx = rand.nextInt(allwords.length);
            if(tree.fetch(allwords[idx]) != idx) {
                System.out.println("bad fetch "+allwords[idx]);
            }
        }
        e = System.currentTimeMillis();
        System.out.println("Tree dict took "+(e-s)+"ms");
    }

    /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */

    public V add(K k, V v){
        if (listsize == 0){
            branch.insert(k, v);
            listsize++;
            return null;
        }
        else if (branch.fetchKey(k) == true){
            return branch.setNode(v);
        }
        else{
            branch.insert(k, v);
            listsize++;
            return null;
        }
    }

    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k){
        if (branch.fetchKey(k) == true){
            V a = branch.fetch(k);
            branch.remove(k);
            listsize--;
            return a;
        }
        else {
            return null;
        }

    }

    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size(){
        return listsize-1;
    }

    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k){
        if (branch.fetchKey(k) == true){
            return branch.fetch(k);
        }
        else {
            return null;
        }
    }

    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys(){
        K[] a = (K[]) new Object[1];
        K z = null;
        a[0] = z;
        return a;
    }
}