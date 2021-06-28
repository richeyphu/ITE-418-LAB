package AVLTree;
import java.awt.Canvas;
import java.awt.Graphics;
//import jlab.graphics.DWindow;
//import java.util.Scanner;
//import java.awt.*;

//Page 13
public class AVLTree extends BSTree {
	private static class AVLNode extends Node {
		private int height;

		AVLNode(Object e, Node left, Node right) {
			super(e, left, right);
			setHeight();
		}

		void setHeight() {
			height = 1 + Math.max(height(left), height(right));
		}

		int height(Node n) {
			return (n == null ? -1 : ((AVLNode) n).height);
		}

		int balanceValue() {
			return height(right) - height(left);
		}
	}

//Page 14
	Node add(Node r, Object e) {
		if (r == null) {
			r = new AVLNode(e, null, null);
			++size;
		} else {
			r = super.add(r, e);
			r = rebalance(r);
		}
		return r;
	}

	Node remove(Node r, Object e) {
		r = super.remove(r, e);
		r = rebalance(r);
		return r;

	}

//Page 19
	private Node rebalance(Node r) {
		if (r == null)
			return r;
		int balance = ((AVLNode) r).balanceValue();
		if (balance == -2) {
			if (((AVLNode) r.left).balanceValue() == 1)
				r.left = rotateRightChild(r.left);
			r = rotateLeftChild(r);
		} else if (balance == 2) {
			if (((AVLNode) r.right).balanceValue() == -1)
				r.right = rotateLeftChild(r.right);
			r = rotateRightChild(r);
		}
		((AVLNode) r).setHeight();
		return r;
	}

//Page 20
	Node rotateLeftChild(Node r) {
		r = super.rotateLeftChild(r);
		((AVLNode) r.right).setHeight();
		((AVLNode) r).setHeight();
		return r;
	}

	Node rotateRightChild(Node r) {

		r = super.rotateRightChild(r);
		((AVLNode) r.left).setHeight();
		((AVLNode) r).setHeight();
		return r;
	}
	
//2.Create graph
	public Canvas toCanvas() {
		return new TreeCanvas();
	}

	@SuppressWarnings("serial")
	private class TreeCanvas extends Canvas {
		int ppx, ppy;

		public void paint(Graphics g) {
			ppx = this.getWidth() / (2 + numNodes(root));
			ppy = this.getHeight() / (2 + height(root));
			drawTree(g, root, 1, 1);
		}

		int drawTree(Graphics g, Node r, int x0, int y0) {
			int xr = x0;
			if (r != null) {

				xr += numNodes(r.left);
				int lx = drawTree(g, r.left, x0, y0 + 1);
				int rx = drawTree(g, r.right, xr + 1, y0 + 1);
				drawNode(g, r, xr, y0);
				if (r.left != null)
					drawEdge(g, xr, y0, lx, y0 + 1);
				if (r.right != null)
					drawEdge(g, xr, y0, rx, y0 + 1);
			}
			return xr;
		}

		void drawNode(Graphics g, Node r, int x, int y) {
			int dy = r.isLeaf() ? 15 : 0;
			g.drawString(r.element.toString(), x * ppx, y * ppy + dy);
		}

		void drawEdge(Graphics g, int x1, int y1, int x2, int y2) {
			g.drawLine(x1 * ppx, y1 * ppy, x2 * ppx, y2 * ppy);
		}
	}
}