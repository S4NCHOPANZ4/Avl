package co.ciencias.avl.model;

public class Node {
    private int value;
    private int height;
    private Node left;    
    private Node right;    
    public Node(){
        this.value = 0;
        this.height = 1; 
        this.left = null;
        this.right = null;
    }
    public int getValue() {
        return value;
    }
    public int getHeight() {
        return height;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
