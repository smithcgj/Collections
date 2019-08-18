//定义节点
class AvlNode{
	int data;
	AvlNode lchild;//左孩子
	AvlNode rchild;//右孩子
	int height;//记录节点高度
}

//在这里定义各种操作
public class AVLTree {
	//计算节点高度
	static int height(AvlNode T) {
		if(T == null) {
			return -1;
		}else {
			return T.height;
		}
	}
	
	//左左型，右旋操作
	static AvlNode R_Rotate(AvlNode K2) {
		AvlNode k1;
		
		//进行旋转
		k1 = K2.rchild;
		K2.rchild = k1.rchild;
		k1.rchild = K2;
		
		//重新计算节点高度
		K2.height = Math.max(height(K2.lchild), height(K2.rchild)) + 1;
		k1.height = Math.max(height(k1.lchild), height(k1.rchild)) + 1;
		
		return k1;
	}
	
	//进行左旋
	static AvlNode L_Rotate(AvlNode k2) {
		AvlNode k1;
		
		k1 = k2.rchild;
		k2.rchild = k1.lchild;
		k1.lchild = k2;
		
		//重新计算节点高度
		k2.height = Math.max(height(k2.lchild), height(k2.rchild)) + 1;
		k1.height = Math.max(height(k1.lchild), height(k1.rchild)) + 1;

		return k1;
	}
	
	//左-右型，进行右旋，再左旋
	static AvlNode R_L_Rotate(AvlNode k3) {
		//先对气化站进行左旋
		k3.lchild = R_Rotate(k3.lchild);
		//再进行右旋
		return L_Rotate(k3);
	}
	
	//右-左型
	static AvlNode L_R_Rotate(AvlNode k3) {
		//先对孩子进行左旋
		k3.rchild = L_Rotate(k3.rchild);
		return R_Rotate(k3);
	}
	
	//插入数值操作
	static AvlNode insert(int data,AvlNode T) {
		if(T == null) {
			T = new AvlNode();
			T .data = data;
			T.lchild = T.rchild = null;
		}else if(data < T.data) {
			//向左孩子递归插入
			T.lchild = insert(data, T.lchild);
			//进行调整操作
			//如果左孩子的高度比右孩子大2
			if(height(T.lchild) - height(T.rchild) == 2) {
				//左左型
				if(data < T.lchild.data) {
					T = R_Rotate(T);
				}else {
					//左右型
					T = R_Rotate(T);
				}
			}
		}else if(data > T.data) {
			T.rchild = insert(data, T.rchild);
			//进行调整
			//右孩子比左孩子高度大2
			if(height(T.rchild) - height(T.lchild) == 2) {
				//右右型
				if(data > T.rchild.data) {
					T = L_Rotate(T);
				}else {
					T = L_R_Rotate(T);
				}
			}
		}
		//否则，这个节点已经在书上存在了，我们什么也不做
		
		//重新计算T的高度
		T.height = Math.max(height(T.lchild), height(T.rchild)) + 1;
		return T;
	}
}
