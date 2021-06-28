import bst.BSTree;

public class Main {
	public static void main(String[] args) {
		BSTree test = new BSTree();
		System.out.println("=============================================");
		System.out.println("       Welcome to BST Testing Service");
		System.out.println("=============================================");
		System.out.println("------------------- BEGIN -------------------");
		double start = System.nanoTime();
		System.out.println("isEmpty() : " + test.isEmpty());
		System.out.println("size()    : " + test.size());
		test.add("ei1");
		System.out.println("add() : \"ei1\"\t" + test.size());
		test.add("ei2");
		System.out.println("add() : \"ei2\"\t" + test.size());
		test.add("ei3");
		System.out.println("add() : \"ei3\"\t" + test.size());
		test.add("ei4");
		System.out.println("add() : \"ei4\"\t" + test.size());
		test.add("ei5");
		System.out.println("add() : \"ei5\"\t" + test.size());
		System.out.println("get() : " + test.get("ei1"));
		System.out.println("getMax() : " + test.getMax());
		System.out.println("getMin() : " + test.getMin());
		test.remove(test.getMax());
		System.out.println("remove() : getMax()");
		System.out.println("getMax() : " + test.getMax());
		test.remove(test.getMin());
		System.out.println("remove() : getMin()");
		System.out.println("getMin() : " + test.getMin());
		System.out.println("---------------------------------------------");
		System.out.println("Print all objects in BSTree :");
		for (Object b : test.toArray()) {
			System.out.println(">> " + b);
		}
		test.treeSort(test.toArray());
		System.out.println("---------------------------------------------");
		System.out.println("treeSort() :");
		for (Object b : test.toArray()) {
			System.out.println(">> " + b);
		}
		double end = System.nanoTime();
		System.out.println("==================== END ====================");
		System.out.println("Overall time taken : " + (end - start) / 1000000 + " ms");
	}
}