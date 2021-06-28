package tree;

import java.awt.Canvas;
import java.awt.Graphics;



// (Binary Tree) Page 7
public class BinaryTree {
	static class Node {
		Object element;
		Node left;
		Node right;

		Node(Object e, Node l, Node r) {
			element = e;
			left = l;
			right = r;
		}

		boolean isLeaf() {
			return left == null && right == null;
		}
	}

	Node root;

// (Binary Tree) Page 18
	public int numNodes() {
		return numNodes(root);
	}

	public int height() {
		return height(root);
	}

	int numNodes(Node node) {
		if (node == null)
			return 0;
		return 1 + numNodes(node.left) + numNodes(node.right);
	}

	int height(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}

//Copy Tree Page 20
	Node copy(Node r) {
		if (r == null)
			return null;
		Node leftTree = copy(r.left);
		Node rightTree = copy(r.right);
		return new Node(r.element, leftTree, rightTree);
	}

// (toArray –Visitor) Page 25
	public Object[] toArray() {
		final Object[] a = new Object[numNodes()];
		Visitor v = new Visitor() {
			int k = 0;

			public void visit(Object e) {
				a[k++] = e;
			}
		};
		preOrder(root, v);
		return a;
	}

// (Tree traversal) Page 28
	public void preOrder(Visitor v) {
		preOrder(root, v);
	}

	public void inOrder(Visitor v) {
		inOrder(root, v);
	}

	public void postOrder(Visitor v) {
		postOrder(root, v);
	}

//Visitor Page 28
	void preOrder(Node r, Visitor v) {
		if (r == null || v.isDone())
			return;
		v.visit(r.element);
		preOrder(r.left, v);
		preOrder(r.right, v);
	}

	void inOrder(Node r, Visitor v) {
		if (r == null || v.isDone())
			return;
		inOrder(r.left, v);
		v.visit(r.element);
		inOrder(r.right, v);
	}

	void postOrder(Node r, Visitor v) {
		if (r == null || v.isDone())
			return;
		postOrder(r.left, v);
		postOrder(r.right, v);
		v.visit(r.element);
	}

// Create graph
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