package io.github.fontysvenlo.ais.datarecords;

import java.time.LocalDate;

/**
 * Data carrier for CustomerData.
 * A record is not mutable. Getter methods (e.g. firstName(), not getFirstName()),
 * hashCode(), equals() end toString available for free.
 * @param id the unique identifier of the customer
 * @param firstName the first name of the customer
 * @param lastName the last name of the customer
 * @param dateOfBirth the date of birth of the customer
 */
public record CustomerData(Integer id, String firstName, String lastName, LocalDate dateOfBirth) {

    /**
     * Validator.
     * @param id see record JavaDoc
     * @param firstName see record JavaDoc
     * @param lastName see record JavaDoc
     * @param dateOfBirth see record JavaDoc
     * @throws IllegalArgumentException if first name is empty
     */
    public CustomerData {
        if (firstName.isBlank()) {
            throw new IllegalArgumentException("Customer first name is not allowed to be empty");
        }
    }
}
