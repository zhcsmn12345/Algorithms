package com.yeebee.zhc.algorithms;

/**
 * 矩阵方阵乘法
 * @author yeebee
 *
 */
public class SquareMatrixMultiply {
		
	/**
	 * 计算方阵矩阵乘法，三重循环
	 * 时间复杂度θ(n^3)
	 * @param a 方阵A
	 * @param b 方阵B
	 * @return 方阵A方阵B矩阵乘法结果
	 */
	public static Matrix squareMatrixMultiply(Matrix a,Matrix b) {
		int n=a.getRows();
		Matrix c = new Matrix(a.getRows(), a.getColumns());
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				c.getElements()[i][j]=0;
				for(int k=0;k<n;k++)
					c.getElements()[i][j]=c.getElements()[i][j]+a.getElements()[i][k]*b.getElements()[k][j];
			}
		return c;
	}
	/**
	 * 简单分治算法求解矩阵乘法。利用分接矩阵来完成，假定n*n矩阵中,n为2的幂
	 * 在书里说建立12个新的n/2*n/2的矩阵,将花费θ(n^2)的时间花在复制元素上,可以使用矩阵下标来表示一个子矩阵
	 * 这里用的还是元素复制的方法
	 * 时间复杂度θ(n^3)
	 * @param a 方阵A
	 * @param b 方阵B
	 * @return 方阵A方阵B矩阵乘法的结果
	 */
	public static Matrix squareMatrixMultiplyRecursive(Matrix a,Matrix b) {
		int n=a.getRows();
		Matrix c = new Matrix(a.getRows(), a.getColumns());
		if(n==1)
			c.getElements()[0][0]=a.getElements()[0][0]*b.getElements()[0][0];
		else {
			Matrix[] partitionA=Matrix.partition(a);
			Matrix a11 = partitionA[0];
            Matrix a12 = partitionA[1];
            Matrix a21 = partitionA[2];
            Matrix a22 = partitionA[3];
            
			Matrix[] partitionB=Matrix.partition(b);
			Matrix b11 = partitionB[0];
            Matrix b12 = partitionB[1];
            Matrix b21 = partitionB[2];
            Matrix b22 = partitionB[3];
            
            Matrix[] partitionC = Matrix.partition(c);
            Matrix c11 = partitionC[0];
            Matrix c12 = partitionC[1];
            Matrix c21 = partitionC[2];
            Matrix c22 = partitionC[3];
            
            c11 = Matrix.add(squareMatrixMultiplyRecursive(a11, b11),squareMatrixMultiplyRecursive(a12, b21));
            c12 = Matrix.add(squareMatrixMultiplyRecursive(a11, b12),squareMatrixMultiplyRecursive(a12, b22));
            c21 = Matrix.add(squareMatrixMultiplyRecursive(a21, b11),squareMatrixMultiplyRecursive(a22, b21));
            c22 = Matrix.add(squareMatrixMultiplyRecursive(a21, b12),squareMatrixMultiplyRecursive(a22, b22));
			
            c = Matrix.merge(c11, c12, c21, c22);
		}
		return c;
	}

}
