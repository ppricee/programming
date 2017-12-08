//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Node<K extends Comparable<K>, V> {
    Node<K, V> left;
    Node<K, V> right;
    V val;
    K key;

    public Node(K k,V v) {
        key =k;
        val = v;
    }
    public boolean isLeaf(){
        if (left == null && right == null){
            return true;
        }
        else{
            return false;
        }
    }

    public K getKey() {
        return key;
    }

//    public void setKey(K k) {
//        key = k;
//    }

    public V getValue() {
        return val;
    }

    public void setValue(V v) {
        val = v;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setRight(Node<K, V> node) {
        right = node;
    }

    public void setLeft(Node<K, V> node) {
        left = node;
    }
}
