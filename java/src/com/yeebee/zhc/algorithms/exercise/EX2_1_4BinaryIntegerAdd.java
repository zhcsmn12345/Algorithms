package com.yeebee.zhc.algorithms.exercise;

import java.util.Arrays;

/**
 * �����Ƽӷ�
 * ����������������������
 * �����������ֱ�洢��nԪ��A��B��
 * ������������Ӧ�ð��ն�������ʽ�洢��һ��(n+1)Ԫ������C��
 * @author ZHC
 *
 */
public class EX2_1_4BinaryIntegerAdd {

	/**
	 * ���� ����n��Ԫ�ص�����A��B��������������a��b
	 * һ��(n+1)��Ԫ�ص�����C��������������a+b
	 * @param A ����A,��������������a
	 * @param B ����B,��������������b
	 * @param n ����A��BԪ����n
	 * @param ����C,��������������a+b
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
