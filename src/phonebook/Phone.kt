package phonebook


enum class PhoneType{
    MOBILE,
    OFFICE,
    HOME
}


data class Phone (
        var number: String,
        private var phoneType: PhoneType
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        
        other as Phone
        
        if (phoneType != other.phoneType) return false
        if (number != other.number) return false
        
        return true
    }
    
    override fun hashCode(): Int {
        var result = phoneType.hashCode()
        result = 31 * result + number.hashCode()
        return result
    }
    
    override fun toString(): String {
        return "$phoneType: $number"
    }
}

