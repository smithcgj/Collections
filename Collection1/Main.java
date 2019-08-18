
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryTree dt = new DictionaryTree();
		dt.add("interest");
		dt.add("interesting");
		dt.add("interested");
		dt.add("inside");
		dt.add("insert");
		dt.add("apple");
		dt.add("inter");
		dt.add("interesting");
		
		dt.print();
		
		boolean isFind = dt.find("inside");
		System.out.println("find inside :"+isFind);
		
		int count = dt .count("inter");
		System.out.println("count prefix inter :" + count);

	}

}
