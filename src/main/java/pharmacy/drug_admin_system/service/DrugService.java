package pharmacy.drug_admin_system.service;

import org.springframework.stereotype.Service;
import pharmacy.drug_admin_system.dto.DrugsDto;
import pharmacy.drug_admin_system.entity.DrugEntity;
import pharmacy.drug_admin_system.entity.DrugEffects;
import pharmacy.drug_admin_system.repository.DrugEffectsRepository;
import pharmacy.drug_admin_system.repository.DrugRepository;

import java.util.List;

@Service
public class DrugService {
    DrugRepository drugRepository;
    DrugEffectsRepository drugEffectsRepository;

    public DrugService(DrugRepository drugRepository, DrugEffectsRepository drugEffectsRepository) {
        this.drugRepository = drugRepository;
        this.drugEffectsRepository = drugEffectsRepository;
    }


//    public String createDrug(DrugEntity drug) {
//        for(DrugEffects drugEffects: drug.getSideEffects()) {
//            drugEffects.setDrug(drug);
//        }
//        drugRepository.save(drug);
//        return "Drug Created Successfully";
//    }
    public String createDrug(DrugsDto drug) {
        try {
//            // Check if the drug already exists (by name and manufacturer maybe)
//            Optional<DrugEntity> existingDrug = drugRepository.findByDrugNameAndManufacturer(
//                    drugDto.getDrugName(), drugDto.getManufacturer());
//
//            if (existingDrug.isPresent()) {
//                return "Drug already exists.";
//            }

            // Create and save new DrugEntity
            DrugEntity entity = new DrugEntity();
            entity.setDrugName(drug.getDrugName());
            entity.setManufacturer(drug.getManufacturer());
            entity.setPrecautions(drug.getPrecautions());
            entity.setSideEffects(drug.getSideEffects());

            entity = drugRepository.save(entity);


            DrugEffects drugEffects = new DrugEffects();
            drugEffects.setDrug(entity);
            drugEffects.setEffects(drug.getSideEffects().toString());

            drugEffectsRepository.save(drugEffects);

        } catch (Exception e) {
            return "Failed to create drug. please try again";
        }
        return "Drug created successfully.";
    }


    public String updateDrug(DrugsDto drug) {
        try {
            DrugEntity entity = new DrugEntity();
            entity.setDrugName(drug.getDrugName());
            entity.setManufacturer(drug.getManufacturer());
            entity.setPrecautions(drug.getPrecautions());
            entity.setSideEffects(drug.getSideEffects());

            entity = drugRepository.save(entity);

            DrugEffects drugEffects = new DrugEffects();
            drugEffects.setDrug(entity);
            drugEffects.setEffects(drug.getSideEffects().toString());

            drugEffectsRepository.save(drugEffects);
        } catch (Exception e){
            return "Drug could not be updated. Please try again.";
        }
        return "Drug Updated Successfully";
    }
    public DrugEntity getDrug(Long drugId) {
        return drugRepository.findById(drugId).get();
    }

    public String deleteDrug(Long drugId) {
       drugRepository.deleteById(drugId);
        return "Success";
    }
    public List<DrugEntity> getAllDrugs() {
        return drugRepository.findAll();
    }

}
