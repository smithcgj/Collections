import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

public class DeepFirstSearch {

	//定义best(i,j)和M N
	private int [][] best = null;
	private int M = 0;
	private int N = 0;
	
	//定义方向常量
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	//当前搜索的方向数组
	private List<Integer> curPath = null;
	//记录最大值对应的方向数组
	private Integer [] bestPath = null;
	
	//当前的搜索点
	private int curX = 0;
	private int curY = 0;
	//当前搜索累计值
	private int value = 0;
	//记录搜索到的最大值
	private int maxValue = 0;
	
	//往某个方向前进
	private void goDir(int dir,int[][] matrix) {
		//前进
		if(dir == DOWN) {
			curX ++;
			value += matrix[curX][curY];
		}else if(dir == RIGHT) {
			curY ++;
			value += matrix[curX][curY];
		}
		//记录方向
		curPath.add(dir);
	}
	
	//往某个方向回退
	private void goBackDir(int dir,int[][] matrix) {
		//回退
		if(dir ==DOWN) {
			value -= matrix[curX][curY];
			curX--;
		}else if(dir == RIGHT) {
			value -= matrix[curX][curY];
			curY--;
		}
		//移除方向
		curPath.remove(curPath.size() - 1);
	}
	
	//深搜
	private void search(int dir,int[][] matrix) {
		//往某个方向前进
		goDir(dir, matrix);
		//到达终点
		if(curX == M - 1&&curY == N - 1) {
			if(value > maxValue) {
				//记录最大值和路径
				maxValue = value;
				bestPath = new Integer[curPath.size()];
				curPath.toArray(bestPath);
			}
		}else if(value <= best[curX][curY]) {
			//不搜索了，等着goBack，剪枝
		}else {
			//更新best(i,j)，记忆
			best[curX][curY] = value;
			//朝下一个方向搜索
			if(curX < M -1) {
				search(DOWN, matrix);
			}
			if(curY < N - 1) {
				search(RIGHT, matrix);
			}
		}
		//往某方向回退
		goBackDir(dir, matrix);
	}
	
	//获取最大值
	public int getMaxAward(int[][] matrix) {
		//初始化
		value = matrix[0][0];
		M = matrix.length;
		N = matrix[0].length;
		best = new int [M][N];
		curPath = new ArrayList<Integer>();
		//开始搜索
		if(M > 1)
			search(DOWN, matrix);
		if(N > 1)
			search(RIGHT, matrix);
		//最大值
		return maxValue;
	}
	
	//打印最佳路径
	public void printBestPath() {
		//打印路径
		for(int i = 0;i < bestPath.length; i++ ) {
			if(bestPath[i] == RIGHT) {
				System.out.print("右   ");
			}else {
				System.out.print("下   ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[][] matrix1 = {
				{300,500,560,400,160},
				{1000,100,200,340,690},
				{600,500,500,460,320},
				{300,400,250,210,760}
		};
		
		int [][] matrix2 = {
				{300,500,2560,400},
				{1000,100,200,340},
				{600,500,500,460},
				{300,400,250,210},
				{860,690,320,760}
		};
		
		DeepFirstSearch dp = new DeepFirstSearch();
		
		System.out.println(dp.getMaxAward(matrix1));
		dp.printBestPath();
		
		System.out.println(dp.getMaxAward(matrix2));
		dp.printBestPath();
	}
}
