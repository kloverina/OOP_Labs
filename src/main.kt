//import test.Matrix
import shapes.*
import matrix.Matrix
import kotlin.random.Random

fun main() {
    //Lab2_Test()
    Lab1_Test()
}

fun Lab2_Test(){
    
    val figures = listOf(
            Rectangle(5.0, 10.0),
            Square(6.0),
            Circle(8.0),
            Triangle(3.0, 4.0, 5.0)
    )
    
    var totalArea = 0.0
    var biggestArea :IShape = figures[0]
    var smallestArea :IShape = figures[0]
    var biggestPerimeter :IShape = figures[0]
    var smallestPerimeter : IShape = figures[0]
    
    for (figure in figures){
        
        totalArea += figure.calcArea()
        
        if(figure.calcArea() > biggestArea.calcArea())
            biggestArea = figure
        
        if(figure.calcArea() < smallestArea.calcArea())
            smallestArea = figure
        
        if(figure.calcPerimeter() > biggestPerimeter.calcPerimeter())
            biggestPerimeter = figure
        
        if(figure.calcPerimeter() < smallestPerimeter.calcPerimeter())
            smallestPerimeter = figure
    }
    
    println("Total area of all figures = $totalArea")
    println("The biggest area: ${biggestArea.calcArea()} - $biggestArea")
    println("The smallest area: ${smallestArea.calcArea()} - $smallestArea")
    println("The biggest perimeter: ${biggestPerimeter.calcPerimeter()} - $biggestPerimeter")
    println("The smallest perimeter: ${smallestPerimeter.calcPerimeter()} - $smallestPerimeter")
}


fun Lab1_Test(){
    val testArray = Array(4) { Array(4) {0.0} }
    testArray[0] = arrayOf(1.0, 2.0, 3.0, 8.0)
    testArray[1] = arrayOf(2.0, 5.0, 6.0, 8.0)
    testArray[2] = arrayOf(7.0, 8.0, 3.0, 9.0)
    testArray[3] = arrayOf(4.0, 2.0, 5.0, 6.0)
    
    val randArray = (Array(4){ (Array(4) {
        Random.nextInt(-15, 15).toDouble() })
    })
   
    //creates null matrix with size 4*3
    val nullMatrix = Matrix(4, 3)
    println("Default constructor - creates Null Matrix: $nullMatrix")
    
    //creates matrix from two-dimensional array [testArray]
    val testMatrix = Matrix(testArray)
    println("\nSecondary constructor - creates matrix filled with elements: $testMatrix")
    
    //creates 4*4 matrix with random values
    val randMatrix = Matrix(randArray)
    println("\nRandom 4*4 matrix: $randMatrix")
    
    //gets number of rows in matrix
    val rowsAmount = testMatrix.getRowsNumber()
    println("\nAmount of rows in matrix: $rowsAmount")
    
    //gets number of columns in matrix
    val colsAmount = testMatrix.getColsNumber()
    println("Amount of columns in matrix: $colsAmount")
    
    //gets value of some element in matrix at position (rows, cols)
    println("Value of matrix at position (2, 2):  ${testMatrix[2,2]}")
    
    //replaces element at position (rows, cols) with new value
    testMatrix[2, 2] = 1.0
    println("New value of matrix at position (2, 2):  ${testMatrix[2,2]}")
    
    //ads [randMatrix] to [testMatrix]
    val sum = testMatrix + randMatrix
    println("\nSum of matrix and randMatrix: $sum")
    
    //subtract [randMatrix] from [testMatrix]
    val subtract = testMatrix - randMatrix
    println("\nSum of matrix and randMatrix: $subtract")
    
    //multiplies matrix on scalar
    val multScalar = testMatrix * 2.0
    println("\nResult of multiplying matrix on 2: $multScalar")
    
    //multiplies [testMatrix] on [randMatrix]
    val multMatrix= testMatrix * randMatrix
    println("\nResult of multiplying matrix on randMatrix: $multMatrix")
    
  
    
    /* Calculate determinant of the matrix */
    val deter = testMatrix.determinant()
    println("Determinant of the matrix: $deter")
    
    // Compare two matrices (false expected)
    val areEqualFalse = nullMatrix == testMatrix
    println("\nIs nullMatrix equals testMatrix? - $areEqualFalse")
    
    // Compare two matrices (true expected)
    val test = Matrix(4, 3)
    val areEqual = nullMatrix == test
    println("\nIs nullMatrix equals test? - $areEqual")
    
   
}


