package com.yeebee.zhc.algorithms;

/**
 * 	������,���ھ���ļ���
 * @author yeebee
 *
 */
public class Matrix {
    /**
     * ���������ʼ�±�
     * ���ڷָ����
     */
    private int rowStartIndex;

    /**
     * ������н����±�
     * ���ڷָ����
     */
    private int rowEndIndex;

    /**
     * ���������ʼ�±�
     * ���ڷָ����
     */
    private int columnStartIndex;

    /**
     * ������н����±�
     * ���ڷָ����
     */
    private int columnEndIndex;

    /**
     * �����е���Ԫ��
     */
    private int[][] elements;

    /**
     * ���ݸ����Ķ�ά���鹹��һ������
     * @param elements
     */
    public Matrix(int[][] elements) {
        this(0, elements.length - 1, 0, elements[0].length - 1, elements);
    }

    /**
     * ���ݸ�����4���±�����ָ���������Ԫ�أ����������󣬾����е�Ԫ���������е�Ԫ�ز�һ��һ��
     * @param rowStartIndex
     * @param rowEndIndex
     * @param columnStartIndex
     * @param columnEndIndex
     * @param elements
     */
    public Matrix(int rowStartIndex, int rowEndIndex, int columnStartIndex, int columnEndIndex, int[][] elements) {
        this.rowStartIndex = rowStartIndex;
        this.rowEndIndex = rowEndIndex;
        this.columnStartIndex = columnStartIndex;
        this.columnEndIndex = columnEndIndex;
        this.elements = elements;
    }

    /**
     * ����һ��ָ���к��еĿվ���
     * @param row
     * @param column
     */
    public Matrix(int row, int column) {
        this(new int[row][column]);
    }

    /**
     * �������
     * @param a
     * @param b
     * @return
     */
    public static Matrix add(Matrix a, Matrix b) {
        Matrix matrix = new Matrix(a.getRows(),a.getColumns());
        int[][] resultElements = matrix.getElements();
        int[][] aelements = a.getElements();
        int[][] belements = b.getElements();

        for (int i = 0; i < belements.length; i++)
            for (int j = 0; j < belements.length; j++)
                resultElements[i][j] = aelements[i][j] + belements[i][j];

        return matrix;
    }
    
    /**
     * �������
     * @param a
     * @param b
     * @return
     */
    public static Matrix sub(Matrix a, Matrix b) {
        Matrix matrix = new Matrix(a.getRows(),a.getColumns());
        int[][] resultElements = matrix.getElements();
        int[][] aelements = a.getElements();
        int[][] belements = b.getElements();

        for (int i = 0; i < belements.length; i++)
            for (int j = 0; j < belements.length; j++)
                resultElements[i][j] = aelements[i][j] - belements[i][j];

        return matrix;
    }

    /**
     * ���ݵ�ǰ�����4���±��ӡ����
     */
    public void printMatrix() {
        int[][] e = this.getElements();
        for (int i = this.getRowStartIndex(); i <= this.getRowEndIndex(); i++) {
            for (int j = this.getColumnStartIndex(); j <= this.getColumnEndIndex(); j++) {
                System.out.print(e[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * ��ȡ�������
     */
    public int getRows() {
        return rowEndIndex - rowStartIndex + 1;
    }

    /**
     * ��ȡ�������
     */
    public int getColumns() {
        return columnEndIndex - columnStartIndex + 1;
    }

    public int getRowStartIndex() {
        return rowStartIndex;
    }

    public void setRowStartIndex(int rowStartIndex) {
        this.rowStartIndex = rowStartIndex;
    }

    public int getRowEndIndex() {
        return rowEndIndex;
    }

    public void setRowEndIndex(int rowEndIndex) {
        this.rowEndIndex = rowEndIndex;
    }

    public int getColumnStartIndex() {
        return columnStartIndex;
    }

    public void setColumnStartIndex(int columnStartIndex) {
        this.columnStartIndex = columnStartIndex;
    }

    public int getColumnEndIndex() {
        return columnEndIndex;
    }

    public void setColumnEndIndex(int columnEndIndex) {
        this.columnEndIndex = columnEndIndex;
    }

    public int[][] getElements() {
        return elements;
    }

    public void setElements(int[][] elements) {
        this.elements = elements;
    }
    
    /**
     * ��һ��������зֳ��ĸ�С�����װ������֮��
     * @param matrix
     * @return
     */
    public static Matrix[] partition( Matrix matrix ) {
        Matrix[] matrixs = new Matrix[4];

        int rowStart = matrix.getRowStartIndex();
        int rowEnd = matrix.getRowEndIndex();
        int rowMid = ( rowStart + rowEnd ) / 2;

        int[][] elements = matrix.getElements();

        int columnStart = matrix.getColumnStartIndex();
        int columnEnd = matrix.getColumnEndIndex();
        int columnMid = ( columnStart + columnEnd ) / 2;

        matrixs[0] = new Matrix(rowStart, rowMid, columnStart, columnMid, elements);
        matrixs[1] = new Matrix(rowStart, rowMid, columnMid + 1, columnEnd, elements);
        matrixs[2] = new Matrix(rowMid + 1, rowEnd, columnStart, columnMid, elements);
        matrixs[3] = new Matrix(rowMid + 1, rowEnd, columnMid + 1, columnEnd, elements);

        return matrixs;
    }
    
    /**
     * ��4��С����ϲ���һ�������
     * @param c11
     * @param c12
     * @param c21
     * @param c22
     * @return
     */
    public static Matrix merge(Matrix c11, Matrix c12, Matrix c21, Matrix c22) {
        Matrix matrix = new Matrix(c11.getRows() * 2, c11.getColumns() * 2);
        int[][] elements = matrix.getElements();
        int length = c11.getElements().length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                elements[i][j] = c11.getElements()[i][j];
                elements[i][j + length] = c12.getElements()[i][j];
                elements[i + length][j] = c21.getElements()[i][j];
                elements[i + length][j + length] = c22.getElements()[i][j];
            }
        }

        return matrix;
    }
}