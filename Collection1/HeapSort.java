

public class HeapSort {
		
	public void HeapAdjust (int [] array,int parent,int length) {
		int temp = array[parent];//temp保存当前父节点
		int child = 2* parent + 1;//先获得左孩子
		
		while (child < length) {
			//如果有右孩子节点，并且右孩子节点的值大于左孩子节点
			if(child + 1 < length && array[child] < array[child + 1]) {
				child ++;
			}
			//如果父节点的值已经大于孩子节点的值，则直接结束
			if(temp >= array[child])
				break;
			
			//把孩子节点的值赋给父节点
			array[parent] = array[child];
			
			//选取孩子节点的左孩子节点，继续向下筛选
			parent = child;
			child = 2*child + 1;
		}
		
		array[parent] = temp;
		
	}
	
	public void heapSort(int [] list) {
		//循环建立初始堆
		for(int i=list.length/2;i>=0;i--) {
			HeapAdjust(list, i, list.length);
		}
		
		//进行n-1次循环，完成排序
		for(int i=list.length-1;i>0;i--) {
			//最后一个元素和第一个元素交换
			int temp = list[i];
			list[i] = list[0];
			list[0] = temp;
			
			//筛选R[0]节点，得到i-1个节点堆
			HeapAdjust(list, 0, i);
			System.out.format("第  %d 趟:     ",list.length-i);
			printPart(list,0,list.length - 1);
		}
	}
	
	//打印序列
	public void printPart(int[] list,int begin,int end) {
		for(int i=0;i<begin;i++) {
			System.out.print("  ");
		}
		for(int i = begin;i<=end;i++) {
			System.out.print(list[i]+ "    ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//初始化一个序列
		int[] array = {
				1,3,4,5,2,6,9,7,8,0
		};
		
		//调用快速排序方法
		HeapSort heap = new HeapSort();
		System.out.print("排序前：                   ");
		heap.printPart(array, 0, array.length-1);
		heap.heapSort(array);
		System.out.println("排序后：             ");
		heap.printPart(array, 0, array.length-1);
		
	}
}
