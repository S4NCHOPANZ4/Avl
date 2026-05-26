package co.ciencias.avl.view;

import javax.swing.*;
import java.awt.*;


public class VistaGUI extends JFrame {

    private TreePanel treePanel;
    private JTextField inputField;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JLabel lblMensaje;

    public VistaGUI() {
        setTitle("Árbol AVL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        treePanel = new TreePanel();
        add(new JScrollPane(treePanel), BorderLayout.CENTER);

        JPanel controls = new JPanel(new FlowLayout());
        controls.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        inputField  = new JTextField(8);
        btnInsertar = new JButton("Insertar");
        btnEliminar = new JButton("Eliminar");
        lblMensaje  = new JLabel(" ");

        controls.add(new JLabel("Valor:"));
        controls.add(inputField);
        controls.add(btnInsertar);
        controls.add(btnEliminar);
        controls.add(lblMensaje);

        add(controls, BorderLayout.SOUTH);
    }

    public JButton getBtnInsertar() { return btnInsertar; }
    public JButton getBtnEliminar() { return btnEliminar; }

    public String getInput() {
        String txt = inputField.getText().trim();
        inputField.setText("");
        return txt;
    }

    public TreePanel getTreePanel() { return treePanel; }

    public void setMensaje(String msg) { lblMensaje.setText(msg); }

    public void mostrar() { setVisible(true); }
}