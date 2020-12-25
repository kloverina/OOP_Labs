package shapeAccumulator

import shapes.*

fun main(args : Array<String>){
    val rect1 = Rectangle(3.0, 6.0)
    val rect2 = Rectangle(2.0, 1.0)
    
    val shapes = listOf<IShape>(
            Square(5.0),
            Triangle(3.0, 4.0, 5.0),
            Circle(3.0),
            Square(8.0),
            Rectangle(2.0, 3.0)
    )
    
    val rectangles = listOf(
            rect2,
            rect1,
            Rectangle(7.0, 3.0),
            Rectangle(5.0, 4.0)
    )
  
    //creating an empty shape accumulator
    val accumulator = ShapeAccumulator<IShape>()
    
    //adding list of rectangles to ShapeAccumulator
    val squareAccumulator = ShapeAccumulator(rectangles)
    
    //adding list of different shapes to ShapeAccumulator
    val accumulatorAll = ShapeAccumulator(shapes)
    
    //adding one figure to Accumulator
    accumulator.add(rect1)
    accumulator.add(rect2)
    println(accumulator.toString())
    
    //adding list of figures to ShapeAccumulator
    accumulator.addAll(shapes)
    
    //calculating shapes with max/min area in [squareAccumulator]
    val biggestArea = squareAccumulator.getMaxAreaShape()
    val smallestArea = squareAccumulator.getMinAreaShape()
    println("\nThe biggest area: ${biggestArea.calcArea()} - Figure: $biggestArea" )
    println("The smallest area: ${smallestArea.calcArea()} - Figure: $smallestArea")
    
    //calculating shapes with max/min perimeter in [accumulatorAll]
    val biggestPerimeter = accumulatorAll.getMaxPerimeter()
    val smallestPerimeter = accumulatorAll.getMinPerimeter()
    println("\nThe biggest perimeter: ${biggestPerimeter.calcPerimeter()} - Figure: $biggestPerimeter")
    println("The smallest perimeter: ${smallestPerimeter.calcPerimeter()} - Figure: $smallestPerimeter")
    
    
    //calculating sum of areas/perimeters in [shapeAccumulator]
    val totalArea = accumulator.getTotalArea()
    val totalPerimeter = accumulator.getTotalPerimeter()
    println("\nTotal area: $totalArea")
    println("Total perimeter: $totalPerimeter")
    
}