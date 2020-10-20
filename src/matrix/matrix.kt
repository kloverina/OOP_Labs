package matrix

import kotlin.math.pow

class Matrix( numberOfRows : Int, numberOfColumns : Int) {
    
    init {
        if (numberOfColumns <= 0 || numberOfRows <= 0)
            throw IllegalArgumentException("ERROR! Matrix dimensions can not be non-positive.")
    }
    
    //creates a matrix and fills it with zeros
    private var elements: Array<Array<Double>> = Array(numberOfRows) { Array(numberOfColumns) { 0.0 } }
    private var columns = numberOfColumns
    private var rows = numberOfRows
    
    
    //creates matrix from two-dimensional array
    constructor(elements: Array<Array<Double>>) : this(elements[0].size, elements.size) {
        
        for (i in 0 until this.elements.size - 1)
            if (this.elements[i].size != this.elements[i + 1].size)
                throw IllegalStateException("ERR! All rows in matrix must have equal length.")
        
        for (i in 0 until this.rows)
            for (j in 0 until this.columns)
                this.elements[i][j] = elements[i][j]
    }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        
        other as Matrix
        if (!elements.contentEquals(other.elements)) return false
        return true
    }
    
    override fun hashCode(): Int {
        return elements.hashCode()
    }
    
    override fun toString(): String {
        var output = String()
        
        for (i in 0 until rows) {
            if (i !=0) output += "\n"
            for (j in 0 until columns) {
                output += elements[i][j]
                output += "  "
            }
        }
        
        return "\n" + output
    }
    /*
    checks whether two matrixes have the same dimension
     */
    private fun equalDimension(otherMatrix: Matrix) = (this.rows == otherMatrix.rows && this.columns == otherMatrix.columns)
    
    /*
    checks if both indexes are in range of matrix max possible indexes
     */
    private fun inRange(i: Int, j: Int) = (i >= 0 && j >= 0 && i <= rows && j <= columns)
    
    fun getRowsNumber():Int{
        return rows
    }
    
    fun getColsNumber():Int{
        return columns
    }
    
    
    /*
    sets new value at position [i][j] when it is possible
     */
    operator fun set(i: Int, j: Int, value: Double) {
        if (!inRange(i, j))
            throw IndexOutOfBoundsException("Error! Index is out of range!")
        elements[i][j] = value
    }
    
    /**
    *@return element in position (i, j)
    */
    operator fun get(i: Int, j: Int): Double {
        if (!inRange(i, j))
            throw IndexOutOfBoundsException("Error! Index is out of range!")
        return elements[i][j]
    }
    
    /**
    *ads this matrix to otherMatrix if possible
    *@return new matrix - result of this operation
    */
    operator fun plus(otherMatrix: Matrix): Matrix {
        if (!this.equalDimension(otherMatrix))
            throw ArithmeticException("ERR! Matrices must be of the same dimension!")
        
        val answer = Matrix(rows, columns)
        
        for (i in 0 until rows)
            for (j in 0 until columns)
                answer[i, j] = this[i, j] + otherMatrix[i, j]
        
        return answer
    }
    
    /**
    *subtracts otherMatrix from this matrix if possible
    *@return new matrix - result of this operation
     */
    operator fun minus(otherMatrix: Matrix): Matrix {
        if (!this.equalDimension(otherMatrix))
            throw ArithmeticException("ERR! Matrices must be of the same dimension!")
        
        val answer = Matrix(rows, columns)
        
        for (i in 0 until rows)
            for (j in 0 until columns)
                answer[i, j] = this[i, j] - otherMatrix[i, j]
        
        return answer
    }
    
    
    /**
    *multiplies this matrix on some scalar
    *@return new matrix - result of this operation
     */
    operator fun times(scalar: Double): Matrix {
        val answer = Matrix(rows, columns)
        
        for (i in 0 until rows)
            for (j in 0 until columns)
                answer[i, j] = this[i, j] * scalar
        return answer
    }
    
    /**
       * multiplies this matrix on otherMatrix if possible
       * @return new matrix - result of this operation
    */
    operator fun times(otherMatrix: Matrix): Matrix {
        
        //checks for columns amount in this matrix and rows amount in otherMatrix to be equal
        if (this.columns != otherMatrix.rows)
            throw ArithmeticException("Error! Matrices are not consistent.")
        
        val answer = Matrix(rows, otherMatrix.columns)
        
        for (i in 0 until answer.rows)
            for (j in 0 until answer.columns)
                for (k in 0 until this.columns)
                    answer[i, j] += this[i, k] * otherMatrix[k, j]
        
        return answer
    }
    
    
    //helps to count determinate of matrix
    private fun getSubmatrix(rowToExclude: Int, colToExclude : Int): Matrix{
        val values: Array<Array<Double>> = Array(rows-1) { Array(columns-1) { 0.0 } }
        for(i in 0 until rows){
            for(j in 0 until columns) {
                if (i != rowToExclude && j!= colToExclude)
                {
                    val rowIndex = if(i < rowToExclude)
                        i
                    else i-1
    
                    val colIndex = if (j< colToExclude)
                        j
                    else j-1
                    
                    values[rowIndex][colIndex] = this[i, j]
                }
            }
        }
        
        return Matrix(values)
    }
    
    /*
     counts determinate of matrix
     */
        fun determinant() :Double{
            if (rows != columns)
                throw ArithmeticException("Error! Matrix must be square to calculate the determinant!")
            
            if (rows ==1)
                return this[0,0]
            
            if (rows == 2)
                return (this[0, 0] * this[1, 1]) - (this[0, 1] * this[1, 0])
        
            var decompositionRow = 0
            var determinant = 0.0
        
            for (i in 0 until rows)
                if (elements[i].count { it == 0.0 } > elements[decompositionRow].count { it == 0.0 })
                    decompositionRow = i
        
            for (j in 0 until columns) {
                val complementary = (-1.0).pow(decompositionRow + j) * getSubmatrix(decompositionRow, j).determinant()
                determinant += this[decompositionRow, j] * complementary
            
            }
            
            return determinant
        }
        
}


