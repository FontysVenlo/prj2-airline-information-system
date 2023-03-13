package datarecords;

import java.time.LocalDate;

/**
 * Data carrier for CustomerData.
 * A record is not mutable. Getter methods (e.g. firstName(), not getFirstName()), 
 * hashCode(), equals() end toString available for free.
 * 
 * @author Informatics Fontys Venlo
 */
public record CustomerData (int id, String firstName, String lastName, LocalDate dob) {}
