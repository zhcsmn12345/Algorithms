package com.yeebee.zhc.algorithms.exercise;
/**
 * ��������,���Բ���
 * ��һ�������в���һ��ֵ���������������е�λ�ã�������������з���null
 * @author yeebee
 * 
 */
public class EX2_1_3LinearSearch{
	
	/**
	 * ���Բ���
	 * ɨ����������a������ֵv
	 * @param a ���ҵ�����
	 * @param v ���ҵ�ֵv
	 * @return
	 */
	public static Integer find(int a[],Integer v) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==v) 
				return i;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] a=new int[]{5,2,4,6,1,3};
		System.out.println(EX2_1_3LinearSearch.find(a, 4));
		System.out.println(EX2_1_3LinearSearch.find(a, 10));
	}
	

}
