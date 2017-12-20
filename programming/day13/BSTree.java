public class BSTree<K extends Comparable<K>,V> implements IDict<K,V> {

    //Fields
    TreeNode<K,V> root;
    TreeNode<K,V> curr;
    int size;
    K[] keys;

    public BSTree() {
        root = null;
        curr = null;
        size = 0;
    }

    public V add(K k, V v) {
        curr = root;
        if(curr==null) {
            root=new TreeNode<K,V>(k,v);
            size++;
            curr = root;
            return root.getValue();
        }
        return helper(k,v);
    }


    public V helper(K k, V v) {
        if((k.compareTo(curr.getKey()) < 0)){
            if(curr.getLeft()== null){
                curr.setLeft(new TreeNode<K,V>(k,v));
                size++;
            }
        }

        if((k.compareTo(curr.getKey()) > 0)){
            if(curr.getRight()== null){
                curr.setRight(new TreeNode<K,V>(k,v));
                size++;
            }
        }

        if(k.compareTo(curr.getKey()) == 0){
            V a = curr.getValue();
            curr.setValue(v);
            return a;
        }

        if(k.compareTo(curr.getKey()) < 0) {
            curr = curr.getLeft();
        }
        else{
            curr = curr.getRight();
        }
        helper(k,v);
        return curr.getValue();

    }

    public int size(){
        return size;
    }

    public V fetch(K k) {
        curr = root;
        if(curr == null){
            return null;
        }

        while(k.compareTo(curr.getKey()) != 0) {
            if(k.compareTo(curr.getKey()) < 0 && curr.getLeft() != null) {
                curr = curr.getLeft();
            }
            else if(k.compareTo(curr.getKey()) > 0 && curr.getRight() != null) {
                curr = curr.getRight();
            }
            else if(k.compareTo(curr.getKey()) != 0){
                return null;
            }
            else{
                return curr.getValue();
            }
        }
        return curr.getValue();
    }

    public V remove(K k){
        TreeNode<K,V> parent = null;
        curr = root;

        while(k.compareTo(curr.getKey()) != 0) {
            if(k.compareTo(curr.getKey()) == 1) {
                parent = curr;
                curr = curr.getRight();
            }
            else {
                parent = curr;
                curr = curr.getLeft();
            }
        }

        if(curr.isLeaf() == true){
            if(parent.getRight() == curr){
                parent.setRight(null);
            }
            if(parent.getLeft() == curr){
                parent.setLeft(null);
            }
            curr = root;
            return curr.getValue();
        }

        if(curr.getRight() == null || curr.getLeft() == null){
            if(curr.getRight()==null){
                if(parent.getRight() == curr){
                    parent.setRight(curr.getLeft());
                }
                else{
                    parent.setLeft(curr.getLeft());
                }
            }
            else{
                if(parent.getRight() == curr){
                    parent.setRight(curr.getRight());
                }
                else{
                    parent.setLeft(curr.getRight());
                }
            }
            curr = root;
            return curr.getValue();
        }
        TreeNode<K,V> swapparent = curr;
        TreeNode<K,V> swapnode = curr.getRight();
        swapparent = swapnode;
        swapnode = swapnode.getLeft();


        swapparent.setLeft(swapnode.getRight());
        swapnode.setLeft(curr.getLeft());
        swapnode.setRight(curr.getRight());
        if(parent.getRight() == curr){
            parent.setRight(swapnode);
        }
        if(parent.getLeft() == curr){
            parent.setLeft(swapnode);
        }

        size--;
        return curr.getValue();
    }

    public K[] keys(){
        K[] keys = (K[])new Object[size];
        curr = root;
        K p = curr.getKey();
        keys[0] = p;
        int g = 0;
        for( int i = 0; i < size/2; i++){
            curr = curr.getLeft();
            K a = curr.getKey();
            keys[i] = a;
            g = i;

        }
        curr = root;
        for(int i = g; i< size;i++){
            curr = curr.getRight();
            K a = curr.getKey();
            keys[i] = a;
        }
        return keys;
    }

}