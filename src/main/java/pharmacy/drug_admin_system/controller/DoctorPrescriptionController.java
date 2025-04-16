package pharmacy.drug_admin_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pharmacy.drug_admin_system.dto.DoctorPrescriptionDto;
import pharmacy.drug_admin_system.entity.DoctorPrescriptionEntity;
import pharmacy.drug_admin_system.service.DoctorPrescriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/drug-prescription")
public class DoctorPrescriptionController {
    private final DoctorPrescriptionService doctorPrescriptionService;
    @PostMapping("/create-prescription")
    public String addPrescription(@RequestBody DoctorPrescriptionDto doctorPrescriptionDto){
        return doctorPrescriptionService.createPrescription(doctorPrescriptionDto);
    }
    @PutMapping("/update-prescription")
    public String updatePrescription(@RequestBody DoctorPrescriptionDto doctorPrescriptionDto){
        return doctorPrescriptionService.updatePrescription(doctorPrescriptionDto);
    }
    @DeleteMapping("/delete-prescription/{doctorPrescriptionId}")
    public String removePrescription(@PathVariable Long doctorPrescriptionId) {
        return doctorPrescriptionService.deleteDoctorPrescription(doctorPrescriptionId);
    }
    @GetMapping("/get-prescription/{doctorPrescriptionId}")
    public DoctorPrescriptionEntity getPrescriptionDetails(@PathVariable("doctorPrescriptionId") Long doctorPrescriptionId){
        return doctorPrescriptionService.getDoctorPrescription(doctorPrescriptionId);
    }
    @GetMapping("/get-all-prescriptions")
    public List<DoctorPrescriptionEntity> getAllDoctorPrescription(){
        return doctorPrescriptionService.getAllDoctorPrescription();
    }

}
