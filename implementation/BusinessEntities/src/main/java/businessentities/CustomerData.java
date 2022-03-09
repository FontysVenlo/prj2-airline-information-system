package businessentities;

import java.time.LocalDate;

/**
 * Object to store customer data
 * 
 * @author m.bonajo@fontys.nl
 */
public class CustomerData {
    
    private final String firstName;
    private final String surName;
    private final LocalDate birthDate;

    /**
     * Create new customer data object
     * 
     * Validates that the given data is correct
     * @param firstName customer's first name
     * @param surName customer's surname
     * @param birthDate customer's birtdate
     */
    public CustomerData(String firstName, String surName, LocalDate birthDate) {
        this.firstName = firstName;
        this.surName = surName;
        
        if(birthDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Birthday cannot be in the future");
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
