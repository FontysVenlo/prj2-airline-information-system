package io.github.fontysvenlo.ais.persistence;

import io.github.fontysvenlo.ais.datarecords.CustomerData;
import java.util.List;

/**
 * Interface that describes all services offered by the CustomerStorageService.
 * @author Informatics Fontys Venlo
 */
public interface CustomerStorageService {

    CustomerData add( CustomerData customerData);
    List<CustomerData> getAll();
}
