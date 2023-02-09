/**
 * Class representing a complex matrix
 *
 */
public class Matrix {
    /**
     * the matrix itself
     *
     */
    private final Complex[][] matrix;

    /**
     * The number of rows
     *
     */
    int rows;
    /**
     * The number of columns
     *
     */
    int cols;

    /**
     * Constructor taking 2 arguments: number of rows and columns
     * @param n rows
     * @param m columns
     */
    public Matrix(int n, int m){
        matrix = new Complex[n][m];
        rows = n;
        cols = m;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = new Complex(0, 0);
            }
        }
    }
    /**
     * Constructor taking 1 argument: array
     * @param matr array
     */
    public Matrix(Complex[][] matr){
        int n = matr.length;
        int m = matr[0].length;
        matrix = new Complex[n][m];
        for (int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                matrix[i][j] = new Complex();
            }
        }
    }

    /**
     * Constructor taking 1 argument: matrix
     * @param A matrix
     */
    public Matrix(Matrix A){
        this(A.matrix);
    }

    /**
     * Method to get the 2D array
     */
    public Complex[][] getMatrix() {
        return matrix;
    }

    /**
     * Method to get the number of rows
     * @return the number of rows
     */
    int getRows(){
        return rows;
    }
    /**
     * Method to get the number of columns
     * @return the number of columns
     */
    int getCols(){
        return cols;
    }
    /**
     * Method to transpose the matrix
     * @return the transposed matrix
     */
    public Matrix transpose(){
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < cols; ++i){
            for (int j = 0; j < rows; ++j){
                result.matrix[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    /**
     * Method to get the sum of 2 matrices if possible
     * @param other The matrix to be added
     * @return the sum of 2 matrices
     */
    public Matrix add(Matrix other){
        if (other.getRows() != rows || other.getCols() != cols){
            throw new ArithmeticException("Wrong size, bitch");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                result.matrix[i][j] = this.matrix[i][j].add(other.matrix[i][j]);
            }
        }

        return result;
    }
    /**
     * Method to get the difference of 2 matrices if possible
     * @param other The matrix to be subtracted
     * @return the difference of 2 matrices
     */

    public Matrix subtract(Matrix other){
        if (other.getRows() != rows || other.getCols() != cols){
            throw new ArithmeticException("Wrong size, bitch");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                result.matrix[i][j] = this.matrix[i][j].subtract(other.matrix[i][j]);
            }
        }

        return result;
    }
    /**
     * Method to get the product of the matrix and a double
     * @param factor the double to be multiplied
     * @return the product of a matrix and a number
     */

    public Matrix multiply(double factor){
        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                result.matrix[i][j] = this.matrix[i][j].multiply(factor);
            }
        }
        return result;
    }

    /**
     * Method to get the product of 2 matrices if possible
     * @param other The matrix to be multiplied
     * @return the product of 2 matrices
     */
    public Matrix multiply(Matrix other){
        if (cols != other.getRows()){
            throw new ArithmeticException("Wrong size, bitch");
        }
        Matrix result = new Matrix(rows, other.getCols());

        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < other.getCols(); ++j){
                for (int k = 0; k < cols; ++k){
                    result.matrix[i][j] = this.matrix[i][k].multiply(other.matrix[k][j]);
                }
            }
        }

        return result;
    }


    /**
     * Helping method for determinant()
     */
    public void getCofactor(Complex[][] mat, Complex[][] temp,
                            int p, int q, int n)
    {
        int i = 0, j = 0;
        // Looping for each element
        // of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase
                    // row index and reset col index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /**
     * Method to get the determinant of a matrix if possible
     * @param mat The matrix to find the determinant of
     * @param n rank of matrix
     * @return a Complex number: the determinant
     */
    public Complex determinantOfMatrix(Complex[][] mat, int n)
    {
        Complex result = new Complex(); // Initialize result

        // Base case : if matrix
        // contains single element
        if (mat.length == 1)
            return mat[0][0];

        // To store cofactors
        Complex[][] temp = new Complex[n-1][n-1];

        // To store sign multiplier
        double sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            result = result.add((matrix[0][f].multiply(sign)).multiply(determinantOfMatrix(temp, n - 1)));

            // terms are to be added
            // with alternate sign
            sign = -sign;
        }
        return result;
    }
    /**
     * Method to get the determinant of a matrix if possible
     * @return the determinant of a matrix
     */
    public Complex determinant() {
        if (cols != rows){
            throw new ArithmeticException("Wrong size, bitch");
        }
        return this.determinantOfMatrix(this.matrix, rows);
    }

    /**
     * Method to assign a value
     * @param row row index
     * @param col column index
     * @param elem complex number to be placed
     */
    public void assign(int row, int col, Complex elem) {
        matrix[row][col] = elem;
    }
    /**
     * Method to assign a value
     * @param row row index
     * @param col column index
     * @param elem double number to be placed
     */
    public void assign(int row, int col, double elem) {
        matrix[row][col] = new Complex(elem);
    }
}