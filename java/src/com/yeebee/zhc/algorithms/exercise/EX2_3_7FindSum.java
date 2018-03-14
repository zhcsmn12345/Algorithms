package com.yeebee.zhc.algorithms.exercise;

import com.yeebee.zhc.algorithms.MergeSort;

/**
 * ����һ������S������x
 * ȷ��S���Ƿ���������͸պ�Ϊx��Ԫ��
 * @author yeebee
 *
 */
public class EX2_3_7FindSum {

	/**
	 * ʵ��:�ȶ�A���й鲢����Ȼ��������Բ���
	 * ����ʱ��Ϊ ��(nlgn)
	 * @param A ��ѯ������
	 * @param sum ��ѯ���������ĺ�
	 * @return ����A���Ƿ�����������Ϊsum
	 */
	public static Boolean find(Integer[] A,Integer sum) {
		MergeSort.sort(A, 0, A.length-1);
		int i=0,j=A.length-1;
		while(i<j) {
			if((A[i]+A[j])==sum)
				return true;
			else if((A[i]+A[j])>sum)
				i++;
			else
				j--;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Integer[] a1= new Integer[]{1,2,3,4,5,6,7,8,9,10};
		Integer[] a2= new Integer[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(EX2_3_7FindSum.find(a1, 11));
		System.out.println(EX2_3_7FindSum.find(a2, 100));
	}

}
