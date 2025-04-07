package pharmacy.drug_admin_system.controller;

import org.springframework.web.bind.annotation.*;
import pharmacy.drug_admin_system.entity.Drug;
import pharmacy.drug_admin_system.service.DrugService;

import java.util.List;

@RestController
@RequestMapping("api/drug")
public class DrugController {
     DrugService drugService;
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @PostMapping
    public String addDrug(@RequestBody Drug drug){
        drugService.createDrug(drug);
        return "Drug Added Successfully";
    }
    @PutMapping
    public String updateDrug(@RequestBody Drug drug){
        drugService.updateDrug(drug);
        return "Drug Updated Successfully";
    }
    @DeleteMapping("{drugId}")
    public String removeDrug(@PathVariable Long drugId) {
        return drugService.deleteDrug(drugId);
    }
    @GetMapping("{drugId}")
    public Drug getDrugDetails(@PathVariable("drugId") Long drugId){
        return drugService.getDrug(drugId);
    }

    @GetMapping("/all-drugs")
    public List<Drug> getAllDrugDetails(){
        return drugService.getAllDrugs();
    }
}
