package co.ciencias.avl.model;

public class AvlTree {
    private Node base;

    public AvlTree(){
        base = null;
    }

    public int height(Node N){
        if(N == null) return 0;
        return N.getHeight();
    }

    public int balance(Node N){
        if(N == null) return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    public Node rotateRight(Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    public Node rotateLeft(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }
    public void insertar(int val) {
            base = agregar(base, val);
    }
    public Node agregar(Node node, int val){
        if(node == null){
            Node newNode = new Node();
            newNode.setValue(val);
            newNode.setHeight(1); 
            return newNode;
        }

        if(val < node.getValue()){
            node.setLeft(agregar(node.getLeft(), val));
        } else if(val >= node.getValue()){
            node.setRight(agregar(node.getRight(), val));
        } 

        // altura
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        //  balance
        int balance = balance(node);

        //  LL 
        if(balance > 1 && val < node.getLeft().getValue()){
            return rotateRight(node); 
        }
        // RR 
        if(balance < -1 && val > node.getRight().getValue()){
            return rotateLeft(node);
        }
        // LR 
        if(balance > 1 && val > node.getLeft().getValue()){
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        // RL
        if(balance < -1 && val < node.getRight().getValue()){
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        
        return node;
    }

    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    public void mostrarPreOrden() {
            preOrder(base);
            System.out.println(); 
    }
}