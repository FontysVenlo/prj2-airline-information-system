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

    @BeforeEach
    public void setup() {
        businessLogic = mock(BusinessLogicAPI.class);
        customerManager = mock(CustomerManager.class);
        when(businessLogic.getCustomerManager()).thenReturn(customerManager);
    }

    @Test
    public void testGetCustomers200() {
        // Arrange
        when(customerManager.list()).thenReturn(new ArrayList<>());

        // Act
        CustomerController.list(businessLogic, context);

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
        CustomerController.add(businessLogic, context);

        // Assert
        verify(context).status(201);
        verify(context).json(customerData);
    }

    @Test
    public void testPostCustomersNull400() {
        // Arrange
        when(context.body()).thenReturn(null);

        // Act
        CustomerController.add(businessLogic, context);

        // Assert
        verify(context).status(400);
    }

}
