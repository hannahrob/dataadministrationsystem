package pharmacy.drug_admin_system.service;

import org.springframework.stereotype.Service;
import pharmacy.drug_admin_system.entity.Drug;
import pharmacy.drug_admin_system.entity.DrugEffects;
import pharmacy.drug_admin_system.repository.DrugRepository;

import java.util.List;

@Service
public class DrugService {
    DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    public String createDrug(Drug drug) {
        for (DrugEffects drugEffects : drug.getDrugEffects()) {
            drugEffects.setDrug(drug);
        }
        drugRepository.save(drug);
        return "Drug Created Successfully";
    }

    public String updateDrug(Drug drug) {
        drugRepository.save(drug);
        return "Drug Updated Successfully";
    }
    public Drug getDrug(Long drugId) {
        return drugRepository.findById(drugId).get();
    }

    public String deleteDrug(Long drugId) {
       drugRepository.deleteById(drugId);
        return "Success";
    }
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

}
