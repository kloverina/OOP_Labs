package shapeAccumulator
import shapes.IShape


class ShapeAccumulator<T: IShape> (){
    private val shapes = mutableListOf<T>()
    /**
    * @constructor that creates
    * [ShapeAccumulator] with specified shape */
    constructor(_shape: T) : this() {
        shapes.add(_shape)
    }
    /**
     * @constructor creates [ShapeAccumulator] that contains all [shapes] from some specified collection
     * @throws IllegalArgumentException if collection is empty */
    constructor(_shapes: Collection<T>) :this(){
        if(_shapes.isEmpty())
            throw IllegalArgumentException("Error! There are no elements in the collection!")
        shapes.addAll(_shapes)
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
    fun add(figure: T) =  shapes.add(figure)
    
    /** ads all [figures] in the collection to [ShapeAccumulator]*/
    fun addAll(figures: Collection<T>) = shapes.addAll(figures)
    
    /** @return shape with the highest area shape*/
    fun getMaxAreaShape(): T? {
        if (shapes.isEmpty())
            return null
       return shapes.maxBy {it.calcArea()}
    }
    
    /** @return shape with the lowest area shape*/
    fun getMinAreaShape(): T?{
        if (shapes.isEmpty())
            return null
        return shapes.minBy {it.calcArea()}
    }
    
    /** @return shape with the highest perimeter*/
    fun getMaxPerimeter(): T?{
        if (shapes.isEmpty())
            return null
        return shapes.maxBy{it.calcPerimeter()}
    }
    
    /** @return shape with the lowest perimeter*/
    fun getMinPerimeter(): T?{
        if (shapes.isEmpty())
            return null
        return shapes.maxBy{it.calcPerimeter()}
    }
    
    /** @return sum of all area shapes*/
    fun getTotalArea():Double?{
        if (shapes.isEmpty())
            return null
        return shapes.sumByDouble {it.calcArea()}
    }
    
    /** @return sum of all perimeters*/
    fun getTotalPerimeter(): Double?{
        if (shapes.isEmpty())
            return null
        return shapes.sumByDouble {it.calcPerimeter()}
    }
}