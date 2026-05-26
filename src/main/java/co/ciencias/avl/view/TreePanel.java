package co.ciencias.avl.view;

import co.ciencias.avl.model.Node;
import javax.swing.JPanel;
import java.awt.*;


public class TreePanel extends JPanel {

    private Node root;

    private static final int NODE_RADIUS = 20;
    private static final int VERTICAL_GAP = 60;

    public TreePanel() {
        setBackground(Color.WHITE);
    }

    public void setRoot(Node root) {
        this.root = root;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawNode(g, root, getWidth() / 2, 40, getWidth() / 4);
        }
    }


    private void drawNode(Graphics g, Node node, int x, int y, int offset) {
        if (node == null) return;

        if (node.getLeft() != null) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(x, y, x - offset, y + VERTICAL_GAP);
            drawNode(g, node.getLeft(), x - offset, y + VERTICAL_GAP, offset / 2);
        }
        if (node.getRight() != null) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(x, y, x + offset, y + VERTICAL_GAP);
            drawNode(g, node.getRight(), x + offset, y + VERTICAL_GAP, offset / 2);
        }

        g.setColor(new Color(70, 130, 180));
        g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));

        String val = String.valueOf(node.getValue());
        FontMetrics fm = g.getFontMetrics();
        int textX = x - fm.stringWidth(val) / 2;
        int textY = y + fm.getAscent() / 2 - 1;
        g.drawString(val, textX, textY);
    }
}