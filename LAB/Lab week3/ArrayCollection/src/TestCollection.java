
public class TestCollection {

	public static void main(String[] args) {
		Collection c = new ArrayCollection(100);
		System.out.println(c.isEmpty());
		c.add("BANGKOK");
		c.add("PHUKET");
		c.add("BANGKOK");
		c.add("SONGKLA");
		System.out.println(c.size());
		c.remove("PHUKET");
		System.out.println(c.contains("PHUKET"));
		System.out.println(c.contains("BANGKOK"));
	}

}
