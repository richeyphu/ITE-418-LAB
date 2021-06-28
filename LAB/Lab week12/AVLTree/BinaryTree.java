package AVLTree;

//import jlab.graphics.DWindow;
//import java.util.Scanner;

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
}