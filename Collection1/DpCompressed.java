
public class DpCompressed {

	//定义best(i) 和  M N
	private int [][] best = null;
	private int M = 0;
	private int N = 0;
	
	//计算best(i)
	private void calcDp(int[][] matrix) {
		//初始化
		M = matrix.length;
		N = matrix[0].length;
		int minMN = Math.min(M, N);
		int maxMN = Math.max(M, N);
		//best只需要M和N的最小值长度就行
		best = new int [2][minMN];
		//需要计算M-N-1条斜线
		for(int i = 0; i < M + N - 1; i++) {
			//第i条斜线的起始坐标
			int startX = 0;
			//第i条斜线的起始Y坐标
			int startY = i;
			//第i条斜线的数字个数
			int number = i + 1;
			if(i >= N) {
				startX = i + 1 - N;
				startY = N - i;
			}
			if(i >= minMN) {
				number = minMN;
			}
			if(i >= maxMN) {
				number = M + N - i - 1;
			}
			//第i条斜线上的number个数
			for(int j = 0; j < number; j++) {
				//起始点
				if(i == 0 && j == 0) {
					best[1][j] = matrix[startX + j][startY - j];
				}else {
					if(i < N) {
						//前半部分
						if(j == 0) {
							//上边界
							best[1][j] = best[0][j] + matrix[startX + j][startY - j];
						}else if(j == number -1) {
							//左边界
							best[1][j] = best[0][j - 1] + matrix[startX + j][startY - j];
						}else {
							//状态转移
							best[1][j] = Math.max(best[0][j], best[0][j - 1]) + matrix[startX + j][startY - j];
						}
					}else {
						//后半部分
						if(i < M && j == number - 1) {
							//左边界
							best[1][j] = best[0][j] + matrix[startX + j][startY - j];
						}else {
							//状态转移
							best[1][j] = Math.max(best[0][j], best[0][j + 1]) + matrix[startX + j][startY - j];
						}
					}
				}
			}
			//将best[1]上的状态拷贝到best[0]
			for(int j = 0; j < number; j++) {
				best[0][j] = best[1][j];
			}
		}
	}
	
	//获取最大值
	public int getMaxAward(int [][] matrix) {
		calcDp(matrix);
		return best[0][0];
	}
	public static void main(String[] args) {
		
		int [][] matrix1 = {
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
		
		DpCompressed dp = new DpCompressed();
		
		System.out.println(dp.getMaxAward(matrix1));
		
		System.out.println(dp.getMaxAward(matrix2));
	}
}
