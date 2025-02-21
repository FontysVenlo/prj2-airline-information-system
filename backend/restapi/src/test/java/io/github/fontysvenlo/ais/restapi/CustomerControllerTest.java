package io.github.fontysvenlo.ais.restapi;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.fontysvenlo.ais.businesslogic.BusinessLogicAPI;
import io.github.fontysvenlo.ais.businesslogic.CustomerManager;
import io.github.fontysvenlo.ais.datarecords.CustomerData;
import io.javalin.http.Context;

public class CustomerControllerTest {
    private final Context context = mock(Context.class);

    private BusinessLogicAPI businessLogic;
    private CustomerManager customerManager;
    private CustomerController customerController;

    @BeforeEach
    public void setup() {
        businessLogic = mock(BusinessLogicAPI.class);
        customerManager = mock(CustomerManager.class);
        when(businessLogic.getCustomerManager()).thenReturn(customerManager);
        customerController = new CustomerController(businessLogic);
    }

    @Test
    public void testGetAllCustomers200() {
        // Arrange
        when(customerManager.list()).thenReturn(new ArrayList<>());

        // Act
        customerController.getAll(context);

        // Assert
        verify(context).status(200);
    }

    @Test
    public void testPostCustomers201() {
        // Arrange
        CustomerData customerData = new CustomerData(0, "John", "Doe", LocalDate.of(2025, 1, 1));
        when(customerManager.add(customerData)).thenReturn(customerData);
        when(context.bodyAsClass(CustomerData.class)).thenReturn(customerData);

        // Act
        customerController.create(context);

        // Assert
        verify(context).status(201);
        verify(context).json(customerData);
    }

    @Test
    public void testPostCustomersNull400() {
        // Arrange
        when(context.body()).thenReturn(null);

        // Act
        customerController.create(context);

        // Assert
        verify(context).status(400);
    }
}
