package chapter2;
import java.lang.annotation.Retention;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HuaRongDao {
	
	//定义方向
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	
	//定义辅助数组
	private static final int [][] dxdy = {{0,-1},{0,1},{-1,0},{1,0}};
	
	//3*3的九宫格
	private int [][] arr;
	
	//记录空格的位置
	private int x;
	private int y;
	
	//定义移动的数组
	private List<Integer> moveArr = new LinkedList<Integer>();
	
	//定义终点状态
	private static final Integer WIN_STATE = 123456780;
	
	//保存已经搜索过的状态
	private Set<Integer> statusSet = new HashSet<Integer>();
	
	
	//代表广搜的每一步，通过lastItem链起来
	private class SearchItem {
		private Integer status;
		private Integer dir;
		private SearchItem lastItem;
		public SearchItem(Integer status,Integer dir,SearchItem lastItem) {
			// TODO Auto-generated constructor stub
			this.status = status;
			this.dir = dir;
			this.lastItem = lastItem;
		}
		public Integer getStatus() {return status;}
		public Integer getDir() {return dir;}
		public SearchItem getLastItem() {return lastItem;}
	}
	
	//广搜的存储队列
	private List<SearchItem> statusToSearch = new LinkedList<SearchItem>();
	
	//初始化，数字0代表空格，先遍历，找出空格的位置
	public HuaRongDao(int [][] arr) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
		getXY();
	}
	
	//获取空格的x和y坐标
	private void getXY() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j] == 0) {
					x = i;
					y = j;
				}
			}
		}
	}
	
	//判断是否可以朝某个方向进行移动
	private boolean canMove(int direction) {
		switch(direction) {
			//y > 0才能左移
			case LEFT:
				return y > 0;
			//y <2才能右移
			case RIGHT:
				return y < 2;
			//x > 0才能上移
			case UP:
				return x > 0;
			//x < 2才能下移
			case DOWN:
				return x < 2;
		}
		return false;
	}
	
	//找出该方向相反的方向
	private int getBackDir(int direction) {
		switch(direction) {
			//y > 0才能左移
			case LEFT:
				return RIGHT;
			//y < 2才能右移
			case RIGHT:
				return LEFT;
			//x > 0才能上移
			case UP:
				return DOWN;
			//x < 2 才能下移
			case DOWN:
				return UP;
		}
		return 0;
	}
	
	//朝某个方向进行移动，该函数不作判断，直接移动
	//调用前请自行用canMove先行判断
	private void move(int direction) {
		int temp;
		temp = arr[x + dxdy[direction][0]][y + dxdy[direction][1]];
		arr[x + dxdy[direction][0]][y + dxdy[direction][1]] = 0;
		arr[x][y] = temp;
		x = x + dxdy[direction][0];
		y = y + dxdy[direction][1];
	}
	
	//某个方向的前进，该函数不作判断，直接移动
	private void moveForward(int direction) {
		move(direction);
		//该方向记录
		moveArr.add(direction);
	}
	
	//某个方向的回退，该函数不作判断，直接移动
	//某操作和moveForward方法正好相反
	private void moveBack(int direction) {
		move(getBackDir(direction));
		//记录的移动步骤出栈
		moveArr.remove(moveArr.size() - 1);
	}
	
	//获取状态，这里吧9个数字按顺序组成一个整数来代表状态
	//方法不唯一，只要能区分九宫格状态就行
	private Integer getStatus() {
		int status = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				status = status * 10 +arr[i][j]; 
			}
		}
		return status;
	}
	
	//根据状态还有九宫格数组
	//该方法是getStatus的逆过程
	public void recoverStatus(Integer status) {
		for(int i= 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length;j++) {
				arr[2-i][2-j] = status % 10;
				status = status / 10;
			}
		}
		getXY();
	}
	
	//搜索方法
	private boolean search() {
		//如果还有要搜索的状态
		while(statusToSearch.size() > 0) {
			//队首出列
			SearchItem item = statusToSearch.remove(0);
			Integer status = item.getStatus();
			//搜到了
			if(status.equals(WIN_STATE)) {
				//找到路径
				recordRoute(item);
				return true;
			}
			//根据status还原arr和x，y
			recoverStatus(status);
			//4个方向进行遍历
			for(int i=0;i<4;i++) {
				//如果能够朝该方向行走
				if(canMove(i)) {
					moveForward(i);
					status = getStatus();
					//之前搜过的状态
					if(statusSet.contains(status)) {
						moveBack(i);
						//放弃
						continue;
					}
					//新状态加入待搜索
					statusSet.add(status);
					statusToSearch.add(new SearchItem(status, i, item));
					moveBack(i);

				}
			}
		}
		return false;
	}
	
	//解题方法入口
	public boolean solve() {
		Integer status = getStatus();
		//如果已经是胜利状态，返回true
		if(WIN_STATE.equals(status)) {
			return true;
		}
		//初始状态先记录
		statusSet.add(status);
		//初始状态进入搜索队列
		statusToSearch.add(new SearchItem(status, null, null));
		return search();
	}
	
	//根据链表顺藤摸瓜，找到路径
	private void recordRoute(SearchItem item) {
		while (null != item.getLastItem()) {
			moveArr.add(0,item.getDir());
			item = item.getLastItem();
		}
	}
	
	//打印路径
	public void printRoute() {
		for(int i=0;i<moveArr.size();i++) {
			System.out.print(getDirString(moveArr.get(i)));
			System.out.print(" ");
		}
	}
	
	//方向与其对应的字符串
	private String getDirString(int direction) {
		switch(direction) {
		case LEFT:
			return "左";
		case RIGHT:
			return "右";
		case UP:
			return "上";
		case DOWN:
			return "下";
		}
		return null;
	}
	
	//打印当前华容道的状态
	public void print() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int [][]arr = {{3,4,1},{5,6,0},{8,2,7}};
		HuaRongDao hrd = new HuaRongDao(arr);
		hrd.print();
		if(hrd.solve()) {
			System.out.print("可以胜利，路径为:");
			hrd.printRoute();
		}else {
			System.out.println("不能胜利");
		}
	}
}
