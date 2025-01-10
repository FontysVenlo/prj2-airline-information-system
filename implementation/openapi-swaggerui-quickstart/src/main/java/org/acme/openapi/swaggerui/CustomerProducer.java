/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.openapi.swaggerui;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

/**
 *
 * @author hvd
 */
@ApplicationScoped
public class CustomerProducer {

    @Produces
    public CustomerResource customerResource() {
        System.out.println("Customer resource instantiated");
        return new CustomerResource(5);
    }
}
