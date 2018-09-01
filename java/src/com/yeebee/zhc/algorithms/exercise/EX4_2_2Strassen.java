package com.yeebee.zhc.algorithms.exercise;

import com.yeebee.zhc.algorithms.Matrix;

/**
 * Strassen算法计算矩阵相乘 耗时θ(n^lg7)
 * 
 * @author yeebee
 *
 */
public class EX4_2_2Strassen {

	/**
	 * Strassen算法计算矩阵相乘 耗时θ(n^lg7) 这里假定n为2的幂
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Matrix strassen(Matrix a, Matrix b) {
		Matrix c = new Matrix(a.getRows(), a.getColumns());

		if (c.getRows() == 1)
			c.getElements()[0][0] = a.getElements()[a.getRowStartIndex()][a.getColumnStartIndex()]
					* b.getElements()[b.getRowStartIndex()][b.getColumnStartIndex()];
		else {
			Matrix[] partitionA = Matrix.partition(a);
			Matrix a11 = partitionA[0];
			Matrix a12 = partitionA[1];
			Matrix a21 = partitionA[2];
			Matrix a22 = partitionA[3];

			Matrix[] partitionB = Matrix.partition(b);
			Matrix b11 = partitionB[0];
			Matrix b12 = partitionB[1];
			Matrix b21 = partitionB[2];
			Matrix b22 = partitionB[3];

			Matrix s1 = Matrix.sub(b12, b22); 
			Matrix s2 = Matrix.add(a11, a12);
			Matrix s3 = Matrix.add(a21, a22);
			Matrix s4 = Matrix.sub(b21, b11);
			Matrix s5 = Matrix.add(a11, a22);
			Matrix s6 = Matrix.add(b11, b22);
			Matrix s7 = Matrix.sub(a12, a22);
			Matrix s8 = Matrix.add(b21, b22);
			Matrix s9 = Matrix.sub(a11, a21);
			Matrix s10 = Matrix.add(b11, b12);

			Matrix p1 = strassen(a11, s1);
			Matrix p2 = strassen(s2, b22);
			Matrix p3 = strassen(s3, b11);
			Matrix p4 = strassen(a22, s4);
			Matrix p5 = strassen(s5, s6);
			Matrix p6 = strassen(s7, s8);
			Matrix p7 = strassen(s9, s10);

			Matrix c11=Matrix.add(Matrix.sub(Matrix.add(p5, p4),p2),p6);
			Matrix c12=Matrix.add(p1, p2);
			Matrix c21=Matrix.add(p3, p4);
			Matrix c22=Matrix.sub(Matrix.sub(Matrix.add(p5, p1),p3),p7);

			c = Matrix.merge(c11, c12, c21, c22);
		}
		return c;

	}
}
