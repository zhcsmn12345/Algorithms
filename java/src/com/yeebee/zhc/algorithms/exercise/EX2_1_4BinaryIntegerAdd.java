package com.yeebee.zhc.algorithms.exercise;

import java.util.Arrays;

/**
 * 二进制加法
 * 将两个二进制整数加起来
 * 这两个整数分别存储在n元组A和B中
 * 这两个整数和应该按照二进制形式存储在一个(n+1)元的数组C中
 * @author ZHC
 *
 */
public class EX2_1_4BinaryIntegerAdd {

	/**
	 * 输入 两个n个元素的数组A和B包含二进制数字a和b
	 * 一个(n+1)个元素的数组C包含二进制数字a+b
	 * @param A 数组A,包含二进制数字a
	 * @param B 数组B,包含二进制数字b
	 * @param n 数组A、B元素数n
	 * @param 数组C,包含二进制数字a+b
	 */
	public static void add(Integer[] A,Integer[] B,Integer n,Integer C[]){
		Integer carry=0;
		for(int i=0;i<n;i++) {
			C[i]=(A[i]+B[i]+carry)%2;
			if(A[i]+B[i]+carry>=2)
				carry=1;
			else
				carry=0;
		}
		C[n]=carry;
	}
	
	public static void main(String[] args) {
		Integer[] A=new Integer[]{1,1,1,1,1,1,1,1,1};
		Integer[] B=new Integer[]{1,0,0,0,0,0,0,0,0};
		Integer[] C=new Integer[]{0,0,0,0,0,0,0,0,0,0};
		EX2_1_4BinaryIntegerAdd.add(A, B, A.length, C);
		System.out.println(Arrays.toString(C));
	}

}
