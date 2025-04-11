package pharmacy.drug_admin_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pharmacy.drug_admin_system.dto.DrugDto;
import pharmacy.drug_admin_system.service.DrugService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/drug")
public class DrugController {
     private final DrugService drugService;

    @PostMapping
    public String addDrug(@RequestBody DrugDto drug){
       return drugService.createDrug(drug);
    }
    @PutMapping
    public String updateDrug(@RequestBody DrugDto drug){
        return drugService.updateDrug(drug);
    }
    @DeleteMapping("{drugId}")
    public String removeDrug(@PathVariable Long drugId) {
        return drugService.deleteDrug(drugId);
    }
    @GetMapping("{drugId}")
    public pharmacy.drug_admin_system.entity.Drug getDrugDetails(@PathVariable("drugId") Long drugId){
        return drugService.getDrug(drugId);
    }

    @GetMapping("/all-drugs")
    public List<pharmacy.drug_admin_system.entity.Drug> getAllDrugDetails(){
        return drugService.getAllDrugs();
    }
}
