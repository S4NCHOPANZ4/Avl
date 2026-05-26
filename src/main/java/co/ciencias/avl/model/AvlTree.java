package co.ciencias.avl.model;

public class AvlTree {
    private Node base;

    public AvlTree(){
        base = null;
    }

    public Node getBase() {
        return base;
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

    public String insertar(int val) {
        if (buscarNodo(base, val) != null) return "Elemento repetido omitido: " + val;
        base = agregar(base, val);
        return "Insertado: " + val;
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
        } else if(val > node.getValue()){
            node.setRight(agregar(node.getRight(), val));
        }

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        int balance = balance(node);

        if(balance > 1 && val < node.getLeft().getValue())
            return rotateRight(node);
        if(balance < -1 && val > node.getRight().getValue())
            return rotateLeft(node);
        if(balance > 1 && val > node.getLeft().getValue()){
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
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

    private Node buscarNodo(Node node, int val) {
        if (node == null) return null;
        if (val == node.getValue()) return node;
        if (val < node.getValue())
            return buscarNodo(node.getLeft(), val);
        else
            return buscarNodo(node.getRight(), val);
    }

    public String eliminar(int val) {
        if (buscarNodo(base, val) == null) return "No encontrado: " + val;
        base = borrar(base, val);
        return "Eliminado: " + val;
    }

    public Node borrar(Node node, int val) {
        if (node == null) return null;

        if (val < node.getValue()) {
            node.setLeft(borrar(node.getLeft(), val));
        } else if (val > node.getValue()) {
            node.setRight(borrar(node.getRight(), val));
        } else {
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            Node sucesor = node.getRight();
            while (sucesor.getLeft() != null)
                sucesor = sucesor.getLeft();

            node.setValue(sucesor.getValue());
            node.setRight(borrar(node.getRight(), sucesor.getValue()));
        }

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        int balance = balance(node);

        if (balance > 1 && balance(node.getLeft()) >= 0)
            return rotateRight(node);
        if (balance > 1 && balance(node.getLeft()) < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balance < -1 && balance(node.getRight()) <= 0)
            return rotateLeft(node);
        if (balance < -1 && balance(node.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }
}