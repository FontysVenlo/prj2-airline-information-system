package datarecords;

import java.time.LocalDate;

/**
 * Data carrier for CustomerData.
 * As of Java14, you would typically use so-calles Records. The idea is to have
 * immutable objects, that can only be set using the constructor. The constructor 
 * can do validation and throws an IllegalArgumentException in case of invalid
 * values (no validation in the example below). Furthermore class contains getters 
 * for all fields, and NO SETTERS! Typically this class also contains a toString() 
 * method and if necessary equals() and hashCode().
 * 
 * @author Informatics Fontys Venlo
 */
public class CustomerData {
    
    private final int id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dob;

    public CustomerData(int id, String firstName, String lastName, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "CustomerData{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + '}';
    }
    
}
