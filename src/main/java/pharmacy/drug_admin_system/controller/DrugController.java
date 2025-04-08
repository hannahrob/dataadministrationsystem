package pharmacy.drug_admin_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pharmacy.drug_admin_system.dto.DrugsDto;
import pharmacy.drug_admin_system.entity.DrugEntity;
import pharmacy.drug_admin_system.service.DrugService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/drug")
public class DrugController {
     private final DrugService drugService;

    @PostMapping
    public String addDrug(@RequestBody DrugsDto drug){
        drugService.createDrug(drug);
        return "Drug Added Successfully";
    }
    @PutMapping
    public String updateDrug(@RequestBody DrugsDto drug){
        return drugService.updateDrug(drug);
    }
    @DeleteMapping("{drugId}")
    public String removeDrug(@PathVariable Long drugId) {
        return drugService.deleteDrug(drugId);
    }
    @GetMapping("{drugId}")
    public DrugEntity getDrugDetails(@PathVariable("drugId") Long drugId){
        return drugService.getDrug(drugId);
    }

    @GetMapping("/all-drugs")
    public List<DrugEntity> getAllDrugDetails(){
        return drugService.getAllDrugs();
    }
}
