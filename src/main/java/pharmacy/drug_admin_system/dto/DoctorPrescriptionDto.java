package pharmacy.drug_admin_system.dto;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pharmacy.drug_admin_system.enums.ConcentrationUnit;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPrescriptionDto {
    private LocalDate dateIssued;
    private String status;
    private List<PrescribedDrug> prescribedDrugs;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PrescribedDrug{
        private String dosage; // how many tablets or spoons
        private String frequency; // how many times a day
        private String duration; // how long
        private String drugShortCode; // short code of the drug
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class ConcentrationDto {
        private double value;
        @Enumerated(EnumType.STRING)  // Save enum as a readable string (e.g. "MG_ML")
        private ConcentrationUnit unit;
    }
}
