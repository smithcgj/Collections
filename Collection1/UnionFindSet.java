import javax.jws.soap.SOAPBinding.Use;

public class UnionFindSet {

	//存储并查集
	private int [] elements;
	
	public UnionFindSet(int n) {
		// TODO Auto-generated constructor stub
		//初始都为-1
		elements = new int[n];
		for(int  i = 0; i < n; i ++) {
			elements[i] = -1;
		}
	}
	
	//找到一个数的根
	public int find(int x) {
		while (elements[x] != -1) {
			x = elements[x];
		}
		return x;
	}
	
	//把两个数的根连起来
	public void union(int x,int y) {
		//x的根
		int rootx = find(x);
		//y的根
		int rooty = find(y);
		//如果不是同一个根就连起来
		if(rootx != rooty) {
			elements[rootx] = rooty;
		}
	}
	
	//计算形成了多少棵树
	public int count() {
		int count = 0;
		for(int i = 0; i < elements.length; i ++) {
			if(elements[i] == -1) {
				count++;
			}
		}
		return count;
	}
	
	//打印并查集
	public void print() {
		for(int i=0; i<elements.length; i++) {
			System.out.print(elements[i] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		UnionFindSet ufs = new UnionFindSet(10);
		
		ufs.union(0, 1);
		ufs.union(0, 2);
		ufs.union(3, 4);
		ufs.union(3, 1);
		ufs.union(5, 7);
		ufs.union(7, 8);
		ufs.union(7, 8);
		
		System.out.println(ufs.count());
	}
}
