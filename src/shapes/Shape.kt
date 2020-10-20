package shapes

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

/*
    Represents a simple rectangle for area & perimeter calc
    @constructor creates a rectangle from 2 different sides: width and height
 */
 open class Rectangle(width: Double, height: Double) :IShape {
     
     private var A = width
     private var B = height
     

    override fun calcArea(): Double {
        return A * B
    }

    override fun calcPerimeter(): Double {
        return (A + B) * 2
    }

     override fun toString(): String {
         return "Rectangle: width = SA, height = $B"
     }
    
     override fun equals(other: Any?): Boolean {
         if (this == other)
             return true
         if(javaClass != other?.javaClass)
             return false
         
         other as Rectangle
         if (A != other.A)  return false
         if (B != other.B) return false
         
         return true
     }
    
     override fun hashCode(): Int {
         var result = 1;
         result = 31 * result + A.hashCode()
         result = 31 * result + B.hashCode()
         return result
     }
}


/*
    Represents a simple square based on Rectangle class
    @constructor creates a square from 1 given side
* */
 class Square(side: Double)
     : Rectangle(side, side)



/*
    Represents a simple circle for area & perimeter calc
*/
class Circle(radius : Double) :IShape{
    private var R = radius
    
    override fun calcArea(): Double {
        return PI * R.pow(2)
    }
    
    override fun calcPerimeter(): Double {
        return 2 * PI * R
    }
    
    override fun toString(): String {
        return "Circle: R = $R"
    }
    
    override fun equals(other: Any?): Boolean {
        if (this == other) return true
        if(javaClass != other?.javaClass) return false
        
        other as Circle
        if (R != other.R) return false
        
        return true
    }
    
    override fun hashCode(): Int {
        return R.hashCode();
    }
}

/*
    Represents a simple triangle for area & perimeter calc
    @constructor creates a rectangle from 2 sides
    throws ArithmeticException when triangle with given sides cannot exists
* */
class Triangle(sideA: Double, sideB: Double, sideC: Double) :IShape{
    
    var A = sideA
    var B = sideB
    var C = sideC
    init {
        if (A + B < C || A + C < B || B + C < A)
            throw ArithmeticException("Triangle with given sides cannot exists!")
    }
    
    override fun calcArea(): Double {
        val p = calcPerimeter() / 2.0
        return sqrt(p * (p - A) * (p - B) * (p - C)) //Heron's formula for triangles
    }
    
    override fun calcPerimeter(): Double {
        return A + B + C
    }
    
    override fun toString(): String {
        return "Triangle: A = $A, B = $B, C = $C"
    }
    
    override fun equals(other: Any?): Boolean {
       if (this == other) return true
        if(javaClass != this?.javaClass) return false
        
        other as Triangle
        if(A != other.A) return false
        if(B != other.B) return false
        if(C != other.C) return false
        
        return true
    }
    
    override fun hashCode(): Int {
        var result = A.hashCode()
        result = 31* result + B.hashCode()
        result = 31* result + C.hashCode()
        return result
    }
    
}