package persistence;

import datarecords.CustomerData;
import java.util.List;

/**
 * Interface that describes all services offered by the CustomerStorageService.
 * @author Richard van den Ham / Martijn Bonajo
 */
public interface CustomerStorageService {
    
    CustomerData add( CustomerData customerData);
    List<CustomerData> getAll();
}
