package pharmacy.drug_admin_system.service;

import org.springframework.stereotype.Service;
import pharmacy.drug_admin_system.repository.DrugInventoryRepository;

@Service
public class DrugInventoryService {
    DrugInventoryRepository drugInventoryRepository;
    public DrugInventoryService(DrugInventoryRepository drugInventoryRepository) {
        this.drugInventoryRepository = drugInventoryRepository;
    }



}
