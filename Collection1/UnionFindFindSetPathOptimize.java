
public class UnionFindFindSetPathOptimize {

	//存储并查集
	private int[] elements;
	
	public UnionFindFindSetPathOptimize(int n) {
		// TODO Auto-generated constructor stub
		//初始化为-1
		elements = new int[n];
		for(int i = 0; i < n; i++) {
			elements[i] = -1;
		}
	}
	
	//找到一个数的根
	public int find(int x) {
		//保存原始x值
		int originX = x;
		//找到根
		while (elements[x] != -1) {
			x = elements[x];
		}
		//把这一路的节点全部直接连到根上
		while(originX != x) {
			int tempX = originX;
			originX = elements[originX];
			elements[tempX] = x;
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
	
	//计算形成了多少树
	public int count() {
		int count = 0;
		for(int i=0; i<elements.length; i++) {
			if(elements[i] == -1) {
				count ++;
			}
		}
		return count;
	}
	
	//打印并查集
	public void print() {
		for(int i=0; i<elements.length;i++) {
			System.out.println(elements[i] +"  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		UnionFindFindSetPathOptimize ufspo = new UnionFindFindSetPathOptimize(10);
		
		ufspo.union(0, 1);
		ufspo.union(1, 2);
		ufspo.union(2, 3);
		ufspo.union(3, 4);
		ufspo.union(4, 5);
		ufspo.union(5, 6);
		ufspo.union(6, 7);
		ufspo.union(7, 8);
		ufspo.union(0, 9);
		
		System.out.println(ufspo.count());
	}
}
