package io.github.fontysvenlo.ais.datarecords;

import java.time.LocalDate;

/**
 * Data carrier for CustomerData.
 * A record is not mutable. Getter methods (e.g. firstName(), not getFirstName()),
 * hashCode(), equals() end toString available for free.
 * @param id the unique identifier of the customer
 * @param firstName the first name of the customer
 * @param lastName the last name of the customer
 * @param dob the date of birth of the customer
 */
public record CustomerData (int id, String firstName, String lastName, LocalDate dob) {}
