public class TreeNode<K,V> {

    //Fields
    K key;
    V value;
    TreeNode<K,V> left;
    TreeNode<K,V> right;

    public TreeNode(K k, V v) {
        key = k;
        value = v;
    }


    public void setLeft(TreeNode<K,V> _left) {
        left = _left;
    }

    public void setRight(TreeNode<K,V> _right) {
        right = _right;
    }

    public TreeNode<K,V> getLeft() {
        return left;
    }

    public TreeNode<K,V> getRight() {
        return right;
    }

    public boolean isLeaf() {
        if(left==null && right==null) {
            return true;
        }
        return false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V v){
        value = v;
    }

    public void setKey(K k){
        key = k;
    }
}