package com.yeebee.zhc.algorithms.exercise;

/**
 * 二分查找
 * 从排序好的序列A中查找值v的位置
 * 将序列的重点与v比较，根据比较结果进行进一步查找
 * 最坏情况运行时间θ(lgn)
 * @author yeebee
 *
 */
public class EX2_3_5BinSearch {
	
	/**
	 * 二分查找
	 * @param a 查找的已排序数组
	 * @param from 数组中开始查找的位置
	 * @param to 数组中查找结束的位置
	 * @param v 查找的值
	 * @return v 在数组中的索引
	 */
	public static Integer search(int[] a,int from,int to,int v) {
		if(from>to)
			return null;
		int m=(from+to)/2;
		if(a[m]==v)
			return m;
		if(v<a[m])
			return EX2_3_5BinSearch.search(a,from,m,v);
		else
			return EX2_3_5BinSearch.search(a,m+1,to,v);
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8,9,10};
		System.out.println(EX2_3_5BinSearch.search(a,0,7,3));
	}

}
