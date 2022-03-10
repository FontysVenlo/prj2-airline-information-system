package businessentities;

import java.time.LocalDate;

/**
 * Object to store customer data
 * 
 * @author m.bonajo@fontys.nl
 */
public class CustomerData {
    
    private final int ID;
    private final String firstName;
    private final String surName;
    private final LocalDate birthDate;

    /**
     * Create new customer data object
     * 
     * Validates that the given data is correct
     * @param id customer's ID
     * @param firstName customer's first name
     * @param surName customer's surname
     * @param birthDate customer's birthdate
     */
    public CustomerData(int id, String firstName, String surName, LocalDate birthDate) {
        this.ID = id;
        this.firstName = firstName;
        this.surName = surName;
        
        if(birthDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Birthdate cannot be in the future");
        }
        this.birthDate = birthDate;
    }

    /**
     * Get the first name of the customer
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the surname of the customer
     * @return surname
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Get the birthdate of the customer
     * @return birthdate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
}
