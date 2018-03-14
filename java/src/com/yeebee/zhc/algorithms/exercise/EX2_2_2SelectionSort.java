package com.yeebee.zhc.algorithms.exercise;

import java.util.Arrays;

/**
 * 选择算法，选择排序
 * 排序，从序列中找到最小的元素放在第一位，之后从序列中查找次小的元素放在第二位，
 * 对序列中length-1个元素按该方式继续
 * @author yeebee
 * 循环不变式：
 * a[0...i-1]
 * 最好情况运行时间和最坏情况运行时间都是Θ(n^2)
 */
public class EX2_2_2SelectionSort {
	
	/**
	 * 选择排序
	 * 排序输入数组并返回
	 * @param a 需要排序的数组
	 * @return  排序好的数组a
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
