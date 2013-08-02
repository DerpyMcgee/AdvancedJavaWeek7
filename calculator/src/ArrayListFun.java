import java.util.ArrayList;


public class ArrayListFun {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("foo");
		list.add("bar");
		System.out.println(list.get(0) + list.get(1));
		
		list.add("baz");
		list.add("quux");
		System.out.println(list.size());
		
		ArrayList<Integer> ilist = new ArrayList <Integer> ();
		ilist.add(1);
		ilist.add(5);
		ilist.add(2);
		System.out.println(ilist);
		int first = ilist.remove(0);
		System.out.println(ilist);
		System.out.println("Removed" + first);
		

	}

}
