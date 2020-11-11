package phonebook

class Contact(var firstName: String, var lastName: String, private var phones: MutableSet<Phone>)
{
    fun addPhone( number: String, type: PhoneType): Boolean{
        return phones.add(Phone(number, type))
    }

    fun removePhone (number: String, type: PhoneType): Boolean{
        return phones.remove(Phone(number, type))
    }
    
    fun getAllPhones(): List<Phone>{
        return phones.toList()
    }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        
        other as Contact
        
        if (firstName!= other.firstName) return false
        if (lastName != other.lastName) return false
        if (phones != other.phones) return false
        
        return true
    }
    
    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + (lastName.hashCode() ?: 0)
        result = 31 * result + phones.hashCode()
        return result
    }
    
    override fun toString(): String {
        val firstNameString = firstName
        val lastNameString = " $lastName\n"
        var phonesString = ""
        
        for (number in phones)
            phonesString += "$number\n"
        
        return "$firstNameString$lastNameString$phonesString\n"
    }
    
    
}
