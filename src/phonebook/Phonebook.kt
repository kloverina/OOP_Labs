package phonebook

/**
 * This class represents a simple phonebook that contains
 * @param contacts with name, surname and a phone number
 */
 public class Phonebook(private var contacts: MutableSet<Contact>) {
    
    //ads new contact to phonebook
    fun addContact(contact: Contact){
        contacts.add(contact)
    }
    
    //deletes contact if it's in the phonebook
    fun removeContact(contact: Contact):Boolean{
        return contacts.remove(contact)
    }
    
    //deletes contact by index
    fun removeContact(index: Int):Boolean{
        if (index< 0 || index >= contacts.size){
            throw IndexOutOfBoundsException("Index is out of range!")
        }
        val contactToRemove = contacts.elementAt(index)
        return contacts.remove(contactToRemove)
    }
    
    //returns all contacts in the phonebook
    fun getAllContacts() : Set<Contact>{
        return contacts.toSet()
    }
    
    //returns contacts by its index
    fun getContact(index: Int): Contact{
        if (index< 0 || index >= contacts.size){
            throw IndexOutOfBoundsException("Index is out of range!")
        }
        return contacts.elementAt(index)
    }
    
    fun find(pattern: String): List<Contact>{
        val found = ArrayList<Contact>()
        
        if(contacts.isEmpty()){
            throw NoSuchElementException("Contacts list is empty!")
        }
        
        for (contact in contacts){
            if(contact.firstName.contains(pattern) || contact.lastName.contains(pattern)) {
                found.add(contact)
                continue
            }
            
            for(phoneNumber in contact.getAllPhones()){
              if( phoneNumber.number.contains(pattern))
                  found.add(contact)
                continue
            }
        }
         return found.toList()
    }
    
    override fun toString(): String {
        var phonebookString = ""
        for (contact in contacts)
            phonebookString += "$contact\n\n"
        
        return phonebookString
    }
}