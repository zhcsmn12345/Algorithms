package com.yeebee.zhc.algorithms;

/**
 * 	矩阵类,用于矩阵的计算
 * @author yeebee
 *
 */
public class Matrix {
    /**
     * 矩阵的行起始下标
     * 用于分割矩阵
     */
    private int rowStartIndex;

    /**
     * 矩阵的行结束下标
     * 用于分割矩阵
     */
    private int rowEndIndex;

    /**
     * 矩阵的列起始下标
     * 用于分割矩阵
     */
    private int columnStartIndex;

    /**
     * 矩阵的列结束下标
     * 用于分割矩阵
     */
    private int columnEndIndex;

    /**
     * 矩阵中的数元素
     */
    private int[][] elements;

    /**
     * 根据给定的二维数组构建一个矩阵
     * @param elements
     */
    public Matrix(int[][] elements) {
        this(0, elements.length - 1, 0, elements[0].length - 1, elements);
    }

    /**
     * 根据给定的4个下标来拆分给定的数组元素，并构建矩阵，矩阵中的元素与数组中的元素不一定一致
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
     * 构造一个指定行和列的空矩阵
     * @param row
     * @param column
     */
    public Matrix(int row, int column) {
        this(new int[row][column]);
    }

    /**
     * 矩阵相加
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
     * 矩阵相减
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
     * 根据当前矩阵的4个下标打印矩阵
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
     * 获取矩阵的行
     */
    public int getRows() {
        return rowEndIndex - rowStartIndex + 1;
    }

    /**
     * 获取矩阵的列
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
     * 把一个大矩阵切分成四个小矩阵封装到数组之中
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
     * 把4个小矩阵合并成一个大矩阵
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