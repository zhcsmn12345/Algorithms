package com.yeebee.zhc.algorithms.exercise;

/**
 * ���ֲ���
 * ������õ�����A�в���ֵv��λ��
 * �����е��ص���v�Ƚϣ����ݱȽϽ�����н�һ������
 * ��������ʱ���(lgn)
 * @author yeebee
 *
 */
public class EX2_3_5BinSearch {
	
	/**
	 * ���ֲ���
	 * @param a ���ҵ�����������
	 * @param from �����п�ʼ���ҵ�λ��
	 * @param to �����в��ҽ�����λ��
	 * @param v ���ҵ�ֵ
	 * @return v �������е�����
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
