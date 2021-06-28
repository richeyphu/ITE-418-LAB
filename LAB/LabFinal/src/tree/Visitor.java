package tree;

//Page 26
public abstract class Visitor {

	private boolean done = false;

	public void done() {
		done = true;
	}

	public boolean isDone() {
		return done;
	}

	public abstract void visit(Object e);
}