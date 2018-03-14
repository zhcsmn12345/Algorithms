package com.yeebee.zhc.algorithms.exercise;

import java.util.Arrays;

/**
 * ѡ���㷨��ѡ������
 * ���򣬴��������ҵ���С��Ԫ�ط��ڵ�һλ��֮��������в��Ҵ�С��Ԫ�ط��ڵڶ�λ��
 * ��������length-1��Ԫ�ذ��÷�ʽ����
 * @author yeebee
 * ѭ������ʽ��
 * a[0...i-1]
 * ����������ʱ�����������ʱ�䶼�Ǧ�(n^2)
 */
public class EX2_2_2SelectionSort {
	
	/**
	 * ѡ������
	 * �����������鲢����
	 * @param a ��Ҫ���������
	 * @return  ����õ�����a
	 */
	public static Integer[] sort(Integer a[]) {
		if(a.length==1)
			return a;
		for(int i=0;i<a.length-1;i++) {
			Integer min=i;
			for(int j=i+1;j<a.length;j++)
				if(a[j]<a[min])
					min=j;
			int t=a[i];
			a[i]=a[min];
			a[min]=t;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] a=new Integer[]{5,2,4,6,1,3};
		System.out.println(Arrays.toString(EX2_2_2SelectionSort.sort(a)));
	}
}
