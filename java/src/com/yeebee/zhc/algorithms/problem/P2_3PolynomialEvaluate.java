package com.yeebee.zhc.algorithms.problem;

/**
 * 多项式求值问题
 * @author yeebee
 *
 */
public class P2_3PolynomialEvaluate {
	
	/**
	 * 霍纳规则
	 * 运行时间θ(n)
	 * @param coefficients 参数数组，升幂排序
	 * @param x 给定的x值
	 * @return 多项式的值
	 */
	public static Double hornerRule(Double[] coefficients,Double x) {
		Double y=0.0;
		for(int i=coefficients.length-1;i>=0;i--)
			y=coefficients[i]+y*x;
		return y;
	}
	
	/**
	 * 朴素方法
	 * 运行时间θ(n^2)
	 * @param coefficients
	 * @param x
	 * @return
	 */
	public static Double normal(Double[] coefficients,Double x) {
		Double y=0.0;
		for(int i=0;i<coefficients.length;i++) {
			Double yi=coefficients[i];
			for(int j=0;j<i;j++)
				yi*=x;
			y+=yi;
		}
		return y;		
	}
	public static void main(String[] args) {
		Double[] a=new Double[] {5.0,4.0,3.0,2.0,1.0};
		System.out.println(P2_3PolynomialEvaluate.hornerRule(a, 2.0));
		System.out.println(P2_3PolynomialEvaluate.normal(a, 2.0));
	}

}
