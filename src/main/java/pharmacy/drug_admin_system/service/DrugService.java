package pharmacy.drug_admin_system.service;

import org.springframework.stereotype.Service;
import pharmacy.drug_admin_system.dto.ConcentrationDto;
import pharmacy.drug_admin_system.dto.DrugDto;
import pharmacy.drug_admin_system.entity.Drug;
import pharmacy.drug_admin_system.repository.DrugRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {
    DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    public String createDrug(DrugDto drug) {
        try {
//            // Check if the drug already exists (by name and manufacturer maybe)
//            Optional<Drug> existingDrug = drugRepository.findByDrugShortCode(drugDto.getDrugShortCode());
//            if (existingDrug.isPresent()) {
//                return "Drug already exists.";
//            }
            ConcentrationDto concentrationDto = drug.getConcentration();  // Create an instance
            if (concentrationDto == null || concentrationDto.getUnit() == null) {
                return "Concentration or unit is missing!";
            }

            String concentration = concentrationDto.getValue() + " " + concentrationDto.getUnit().toString();

            Drug entity = new Drug();
            entity.setDrugName(drug.getDrugName());
            entity.setDrugShortCode(drug.getDrugShortCode());
            entity.setManufacturer(drug.getManufacturer());
            entity.setPrecautions(drug.getPrecautions());
            entity.setContraindications(drug.getContraindications());
            entity.setSideEffects(drug.getSideEffects());
            entity.setDosageForm(drug.getDosageForm());
            entity.setDrugType(drug.getDrugType());
            entity.setConcentration(concentration);


            entity = drugRepository.save(entity);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Failed to create drug. please try again";
        }
        return "Drug created successfully.";
    }
    public String updateDrug(DrugDto drug) {
        try {
            ConcentrationDto concentrationDto = new ConcentrationDto();  // Create an instance
            String concentration = Double.toString(concentrationDto.getValue()) + concentrationDto.getUnit().toString();

            Drug entity = new Drug();
            entity.setDrugName(drug.getDrugName());
            entity.setManufacturer(drug.getManufacturer());
            entity.setPrecautions(drug.getPrecautions());
            entity.setContraindications(drug.getContraindications());
            entity.setSideEffects(drug.getSideEffects());
            entity.setDosageForm(drug.getDosageForm());
            entity.setDrugType(drug.getDrugType());
            entity.setConcentration(concentration);


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
