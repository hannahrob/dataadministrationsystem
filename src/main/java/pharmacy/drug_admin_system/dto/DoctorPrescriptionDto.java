package pharmacy.drug_admin_system.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPrescriptionDto {
    @NotBlank(message = "Patient ID is required.")
    private String patientId;
    @NotNull(message = "Date issued must not be null.")
    private LocalDate dateIssued;
    @NotBlank(message = "Status is required.")
    private String status;
    @NotEmpty(message = "At least one prescribed drug is required.")
    private List<PrescribedDrug> prescribedDrugs;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PrescribedDrug{
        @NotBlank(message = "Dosage is required (e.g. '2 tablets').")
        private String dosage; // how many tablets or spoons
        @NotBlank(message = "Dosage form is required (e.g. 'tablet', 'syrup').")
        private String dosageForm;
        @NotBlank(message = "Frequency is required (e.g. 'twice a day').")
        private String frequency; // how many times a day
        @NotBlank(message = "Duration is required (e.g. '5 days').")
        private String duration; // how long
        @NotBlank(message = "Drug short code is required.")
        private String drugShortCode;// short code of the drug
        @NotNull(message = "Concentration is required.")
        private ConcentrationDto concentration;
    }
}
