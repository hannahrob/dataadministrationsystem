package pharmacy.drug_admin_system.service;

import org.springframework.stereotype.Service;
import pharmacy.drug_admin_system.dto.ConcentrationDto;
import pharmacy.drug_admin_system.dto.DrugDto;
import pharmacy.drug_admin_system.entity.Drug;
import pharmacy.drug_admin_system.repository.DrugRepository;

import java.util.List;

@Service
public class DrugService {
    DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    public String createDrug(DrugDto drug) {
        try {
//            // Check if the drug already exists (by name and manufacturer maybe)
//            Optional<DrugEntity> existingDrug = drugRepository.findByDrugNameAndManufacturer(
//                    drugDto.getDrugName(), drugDto.getManufacturer());
//
//            if (existingDrug.isPresent()) {
//                return "Drug already exists.";
//            }
            ConcentrationDto concentrationDto = new ConcentrationDto();  // Create an instance
            String concentration = Double.toString(concentrationDto.getValue()) + concentrationDto.getUnit().toString();

            // Create and save new DrugEntity
            Drug entity = new Drug();
            entity.setDrugName(drug.getDrugName());
            entity.setManufacturer(drug.getManufacturer());
            entity.setPrecautions(drug.getPrecautions());
            entity.setSideEffects(drug.getSideEffects());
            entity.setConcentration(concentration);


            entity = drugRepository.save(entity);

        } catch (Exception e) {
            return "Failed to create drug. please try again";
        }
        return "Drug created successfully.";
    }
    public String updateDrug(DrugDto drug) {
        try {
            Drug entity = new Drug();
            entity.setDrugName(drug.getDrugName());
            entity.setManufacturer(drug.getManufacturer());
            entity.setPrecautions(drug.getPrecautions());
            entity.setSideEffects(drug.getSideEffects());

            entity = drugRepository.save(entity);

        } catch (Exception e){
            return "Drug could not be updated. Please try again.";
        }
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
