package AVLTree;
//import jlab.graphics.DWindow;
//import java.util.Scanner;
//import java.awt.*;

//Page 6
public class BSTree extends BinaryTree {
	int size;

	public BSTree() {
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	int compare(Object a, Object b) {
		return ((Comparable) a).compareTo(b);
	}

// Page 8
	public Object get(Object e) {
		Node node = getNode(root, e);
		return node == null ? null : node.element;
	}

	Node getNode(Node r, Object e) {
		while (r != null) {
			int cmp = compare(e, r.element);
			if (cmp == 0)
				return r;
			if (cmp < 0)
				r = r.left;
			else
				r = r.right;
		}
		return null;

	}

// Page 10
	public Object getMin() {
		Node r = root;
		if (r == null)
			return null;
		while (r.left != null) {
			r = r.left;
		}
		return r.element;
	}

// Page 11
	public Object getMax() {
		Node r = root;
		if (r == null)
			return null;
		while (r.right != null) {
			r = r.right;
		}
		return r.element;
	}

// Page 15
	public void add(Object e) {
		root = add(root, e);
	}

	Node add(Node r, Object e) {
		if (r == null) {

			r = new Node(e, null, null);
			++size;
		} else {
			int cmp = compare(e, r.element);
			if (cmp < 0)
				r.left = add(r.left, e);
			else if (cmp > 0)
				r.right = add(r.right, e);
		}
		return r;
	}

// Page 18
	public void remove(Object e) {
		root = remove(root, e);
	}

	Node remove(Node r, Object e) {
		if (r == null)
			return r;
		int cmp = compare(e, r.element);
		if (cmp < 0) {
			r.left = remove(r.left, e);
		} else if (cmp > 0) {
			r.right = remove(r.right, e);
		} else {
// Page 19
			if (r.left == null || r.right == null) {

				r = (r.left == null ? r.right : r.left);
				--size;
			} else {
				Node m = r.right;
				while (m.left != null)
					m = m.left;
				r.element = m.element;
				r.right = remove(r.right, m.element);
			}
		}
		return r;
	}

// Page 23
	public static void treeSort(final Object[] data) {
		BSTree t = new BSTree();
		for (int i = 0; i < data.length; i++) {
			t.add(data[i]);
		}
		t.inOrder(new Visitor() {
			int k = 0;

			public void visit(Object e) {
				data[k++] = e;
			}
		});
	}

//Page 11 AVLTree
	Node rotateLeftChild(Node r) {
		Node newRoot = r.left;
		r.left = newRoot.right;
		newRoot.right = r;
		return newRoot;
	}

//Page 12 AVLTree
	Node rotateRightChild(Node r) {
		Node newRoot = r.right;
		r.right = newRoot.left;
		newRoot.left = r;
		return newRoot;
	}

	public static void main(String[] args) {
	}
}