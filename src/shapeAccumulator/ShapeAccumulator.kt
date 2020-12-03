package shapeAccumulator
import shapes.IShape

/**
 * @constructor creates [ShapeAccumulator] that contains all [shapes] from some specified collection
 * @throws IllegalArgumentException if collection is empty
* */
class ShapeAccumulator<T: IShape> (shapes: Collection<T>){
    private var shapes: ArrayList<T> = ArrayList()
    
    /**
    * @constructor that creates
    * [ShapeAccumulator] with specified shape
    * */
    constructor(shape: T) : this(listOf(shape))
    
    init {
        if(shapes.isEmpty())
            throw IllegalArgumentException("Error! There are no elements in the collection!")
        this.shapes.addAll(shapes)
    }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        
        other as ShapeAccumulator<*>
        
        if (shapes != other.shapes) return false
        
        return true
    }
    
    override fun hashCode(): Int {
        return shapes.hashCode()
    }
    
    override fun toString(): String {
        return "ShapeAccumulator(shapes: $shapes)"
    }
    
    /** ads one [figure] to [ShapeAccumulator]*/
    fun add(figure: T){
        shapes.add(figure)
    }
    
    /** ads all [figures] in the collection to [ShapeAccumulator]*/
    fun addAll(figures: Collection<T>)
    {
        shapes.addAll(figures)
    }
    
    /** @return shape with the highest area shape*/
    fun getMaxAreaShape(): T{
       return shapes.maxBy { iterator -> iterator.calcArea()}!!
    }
    
    /** @return shape with the lowest area shape*/
    fun getMinAreaShape(): T{
        return shapes.minBy { iterator -> iterator.calcArea()}!!
    }
    
    /** @return shape with the highest perimeter*/
    fun getMaxPerimeter(): T{
        return shapes.maxBy { iterator -> iterator.calcPerimeter()}!!
    }
    
    /** @return shape with the lowest perimeter*/
    fun getMinPerimeter(): T{
        return shapes.minBy { iterator -> iterator.calcPerimeter()}!!
    }
    
    /** @return sum of all area shapes*/
    fun getTotalArea():Double{
        return shapes.sumByDouble {iterator -> iterator.calcArea()}
    }
    
    /** @return sum of all perimeters*/
    fun getTotalPerimeter(): Double{
        return shapes.sumByDouble { iterator -> iterator.calcPerimeter()}
    }
}