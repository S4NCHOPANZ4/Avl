package co.ciencias.avl.controller;

import co.ciencias.avl.model.AvlTree;
import co.ciencias.avl.view.VistaConsola;
import co.ciencias.avl.view.VistaGUI;

import javax.swing.SwingUtilities;

public class Controller {

    private VistaConsola vc   = new VistaConsola();
    private AvlTree      tree = new AvlTree();
    private VistaGUI     gui  = new VistaGUI();

    public void run() {
        // Inserciones de ejemplo
        int[] iniciales = {10, 20, 30, 40, 50, 25};
        for (int v : iniciales) tree.insertar(v);
        tree.mostrarPreOrden();

        gui.getTreePanel().setRoot(tree.getBase());

        // Listener btn Insertar
        gui.getBtnInsertar().addActionListener(e -> {
            String txt = gui.getInput();
            try {
                int val = Integer.parseInt(txt);
                String msg = tree.insertar(val);
                gui.getTreePanel().setRoot(tree.getBase());
                gui.setMensaje(msg);
            } catch (NumberFormatException ex) {
                gui.setMensaje("Ingresa un número válido.");
            }
        });

        // Listener btn Eliminar
        gui.getBtnEliminar().addActionListener(e -> {
            String txt = gui.getInput();
            try {
                int val = Integer.parseInt(txt);
                String msg = tree.eliminar(val);
                gui.getTreePanel().setRoot(tree.getBase());
                gui.setMensaje(msg);
            } catch (NumberFormatException ex) {
                gui.setMensaje("Ingresa un número válido.");
            }
        });

        SwingUtilities.invokeLater(() -> gui.mostrar());
    }
}