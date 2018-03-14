package com.yeebee.zhc.algorithms.problem;

import java.util.Arrays;

/**
 * ð������
 * �����������ڵ�δ���ճ������е�Ԫ��
 * @author yeebee
 *
 */
public class P2_2BubbleSort {
	
	/**
	 * ð������
	 * ��á������ʱ�䶼�Ǧ�(n^2)
	 * @param A ��Ҫ���������
	 */
	public static void sort(Integer[] A) {
		if(A.length<2)
			return;
		for(int i=0;i<A.length-1;i++)
			for(int j=A.length-1;i<j;j--)
				if(A[j]<A[j-1])
				{
					int t=A[j];
					A[j]=A[j-1];
					A[j-1]=t;
				}
	}
	
	public static void main(String[] args) {
		Integer[] a=new Integer[] {5,2,4,7,1,3,2,6};
		P2_2BubbleSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
			

}
