package pharmacy.drug_admin_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pharmacy.drug_admin_system.dto.DoctorPrescriptionDto;

@RestController
@RequestMapping("api/drug-prescription")
public class DoctorPrescriptionController {
    @PostMapping
    public String createPrescription(@RequestBody DoctorPrescriptionDto doctorPrescriptionDto){
    }
}
