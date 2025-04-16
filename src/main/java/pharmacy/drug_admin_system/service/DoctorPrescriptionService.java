package pharmacy.drug_admin_system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pharmacy.drug_admin_system.dto.DoctorPrescriptionDto;
import pharmacy.drug_admin_system.dto.dto.transit.Prescriptions;
import pharmacy.drug_admin_system.entity.DoctorPrescriptionEntity;
import pharmacy.drug_admin_system.repository.DoctorPrescriptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorPrescriptionService {
    private  final  DoctorPrescriptionRepository doctorPrescriptionRepository;
    private  final ObjectMapper objectMapper;


    public String createPrescription(DoctorPrescriptionDto doctorPrescriptionDto) {
        try {

            DoctorPrescriptionEntity doctorPrescriptionEntity = new DoctorPrescriptionEntity();
            doctorPrescriptionEntity.setPatientId(doctorPrescriptionDto.getPatientId());
            doctorPrescriptionEntity.setDateIssued(doctorPrescriptionDto.getDateIssued());
            doctorPrescriptionEntity.setStatus(doctorPrescriptionDto.getStatus());

            List<Prescriptions> prescribedDrugs = new ArrayList<>();

            for (DoctorPrescriptionDto.PrescribedDrug drug : doctorPrescriptionDto.getPrescribedDrugs()){
                Prescriptions prescription = new Prescriptions();
                prescription.setDuration(drug.getDuration());
                prescription.setFrequency(drug.getFrequency());
                prescription.setDosage(drug.getDosage());
                prescription.setDosageForm(drug.getDosageForm());
                prescription.setDrugShortCode(drug.getDrugShortCode());
                prescription.setConcentration(drug.getConcentration().toString());
                prescribedDrugs.add(prescription);
            }
            try {
                doctorPrescriptionEntity.setPrescribedDrugs(objectMapper.writeValueAsString(prescribedDrugs));
            } catch (JsonProcessingException e) {
                System.out.println("Error converting drugs to JSON");
                doctorPrescriptionEntity.setPrescribedDrugs(prescribedDrugs.toString());
            }
            doctorPrescriptionEntity = doctorPrescriptionRepository.save(doctorPrescriptionEntity);
            return "Doctor's Prescription created successfully!";
        } catch (Exception e) {
            return "Doctor's Prescription could not be created";
        }
    }
    public String updatePrescription(DoctorPrescriptionDto doctorPrescriptionDto) {
        try {

            Optional<DoctorPrescriptionEntity> existingOpt = doctorPrescriptionRepository.findByPatientId(doctorPrescriptionDto.getPatientId());
            if (existingOpt.isEmpty()) {
                return "Prescription not found!";
            }

            DoctorPrescriptionEntity doctorPrescriptionEntity = existingOpt.get();
            doctorPrescriptionEntity.setPatientId(doctorPrescriptionDto.getPatientId());
            doctorPrescriptionEntity.setDateIssued(doctorPrescriptionDto.getDateIssued());
            doctorPrescriptionEntity.setStatus(doctorPrescriptionDto.getStatus());

            List<Prescriptions> prescribedDrugs = new ArrayList<>();

            for (DoctorPrescriptionDto.PrescribedDrug drug : doctorPrescriptionDto.getPrescribedDrugs()){
                Prescriptions prescription = new Prescriptions();
                prescription.setDuration(drug.getDuration());
                prescription.setFrequency(drug.getFrequency());
                prescription.setDosageForm(drug.getDosageForm());
                prescription.setDosage(drug.getDosage());
                prescription.setDrugShortCode(drug.getDrugShortCode());
                prescription.setConcentration(drug.getConcentration().toString());
                prescribedDrugs.add(prescription);
            }
            try {
                doctorPrescriptionEntity.setPrescribedDrugs(objectMapper.writeValueAsString(prescribedDrugs));
            } catch (JsonProcessingException e) {
                System.out.println("Error converting drugs to JSON");
                doctorPrescriptionEntity.setPrescribedDrugs(prescribedDrugs.toString());
            }
            doctorPrescriptionEntity = doctorPrescriptionRepository.save(doctorPrescriptionEntity);
            return "Doctor's Prescription Updated successfully!";
        } catch (Exception e) {
            return "Doctor's Prescription could not be Updated";
        }
    }
    public DoctorPrescriptionEntity getDoctorPrescription(Long doctorPrescriptionId) {
        return doctorPrescriptionRepository.findById(doctorPrescriptionId).get();
    }

    public String deleteDoctorPrescription(Long doctorPrescriptionId) {
        doctorPrescriptionRepository.deleteById(doctorPrescriptionId);
        return "Success";
    }
    public List<DoctorPrescriptionEntity> getAllDoctorPrescription() {
        return doctorPrescriptionRepository.findAll();
    }

}

