package HW_18may;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Bst<T> {
    public static void main(String[] args) {
        Bst<String> tree = new Bst<>();
        tree.add("test", 0);
        tree.add("test", 5);
        tree.add("test", 2);
        tree.add("test", 8);
        tree.add("test", 10);
        tree.remove(8);
        tree.printTree();
    }

    protected Node<T> root;

    public Bst() {
    }

    public Node getRoot(){
        return this.root;
    }

    public Node findByKey(int key){
        if(this.getRoot() == null){
            return null;
        }
        return findByKey(this.getRoot(), key);
    }

    public Node findMin(){
        if(this.getRoot() == null){
            return null;
        }
        return findMin(this.getRoot());
    }

    // Or throw exception about key duplication
    public Node add(T value, int key){
        Node<T> newNode = new Node<>(key, value);
        if(this.getRoot() == null){
            this.root = newNode;
            return this.getRoot();
        }
        else{
            return addNode(this.getRoot(), newNode);
        }
    }

    public Node remove(int key) {
        return delete(root, key);
    }

    public void printTree() {
        inorderTraversal(root);
    }


    protected static class Node<T> {

        protected int key;
        protected final T value;

        protected Node left;
        protected Node right;

        public Node(int key, T value) {
            if(value == null){
                throw new IllegalArgumentException("Value of a node can't be NULL.");
            }

            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (key != node.key) return false;
            if (!value.equals(node.value)) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            return right != null ? right.equals(node.right) : node.right == null;

        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + value.hashCode();
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            if(this.equals(left)){
                throw new IllegalArgumentException("Can't add as child node to himself.");
            }
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            if(this.equals(left)){
                throw new IllegalArgumentException("Can't add as child node to himself.");
            }
            this.right = right;
        }

        public T getValue() {
            return value;
        }
    }

    protected static Node findByKey(Node node, int key){
        if(node == null){
            return null;
        }
        if(node.getKey() == key){
            return node;
        }
        else if(node.getKey() > key){
            return findByKey(node.getLeft(), key);
        }
        else{
            return findByKey(node.getRight(), key);
        }
    }

    protected static Node findMin(Node node){
        if(node == null){
            return null;
        }
        if(node.getLeft() != null){
            return findMin(node.getLeft());
        }
        else{
            return node;
        }
    }

    protected static Node findMax(Node node){
        if(node == null){
            return null;
        }
        if(node.getRight() != null){
            return findMax(node.getRight());
        }
        else{
            return node;
        }
    }

    protected static Node addNode(Node node, Node newNode){
        if(node == null || newNode == null){
            return null;
        }
        if(newNode.getKey() < node.getKey()){
            if(node.getLeft() == null){
                node.setLeft(newNode);
                return node;
            }
            else{
                return addNode(node.getLeft(), newNode);
            }
        }
        else if(newNode.getKey() > node.getKey()){
            if(node.getRight() == null){
                node.setRight(newNode);
                return node;
            }
            else{
                return addNode(node.getRight(), newNode);
            }
        }
        else{
            return null;// Return Null or throw exception about key duplication or add to Right
        }
    }

    protected static Node delete(Node root, int z) {
        if (root == null) return null;
        if (z < root.key) root.left = delete(root.left, z);
        else if (z > root.key) root.right = delete(root.right, z);
        else if (root.left != null && root.right != null) {
            root.key = findMin(root.right).key;
            root.right = delete(root.right, root.key);
        }
        else {
            if (root.left != null) root = root.left;
            else root = root.right;
        }
        return root;
    }

    protected static void inorderTraversal(Node x) {
        if (x != null) {
            inorderTraversal(x.left);
            System.out.println(x.key);
            inorderTraversal(x.right);
        }
    }


}