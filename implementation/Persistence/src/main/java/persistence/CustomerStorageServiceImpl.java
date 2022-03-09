package persistence;

import businessentities.CustomerData;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author m.bonajo@fontys.nl
 */
public class CustomerStorageServiceImpl implements CustomerStorageService {

    @Override
    public Optional<CustomerData> add(CustomerData customer) {
        // Do the actual work to store the customer here
        return Optional.of(customer);
    }

    @Override
    public List<CustomerData> getAll() {
        // Do the actual work of retrieving the customer(s) here
        return Collections.emptyList();
    }
    
}
