package co.ciencias.avl.controller;

import co.ciencias.avl.model.AvlTree;
import co.ciencias.avl.view.VistaConsola;

public class Controller {
    private VistaConsola vc = new VistaConsola();
    private AvlTree tree = new AvlTree();
    
    public void run(){
        tree.insertar(10);
        tree.insertar(20);
        tree.insertar(30);
        tree.insertar(40);
        tree.insertar(50);
        tree.insertar(25);
        tree.mostrarPreOrden();
    }
}
