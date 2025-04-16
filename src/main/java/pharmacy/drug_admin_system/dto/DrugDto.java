package pharmacy.drug_admin_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugDto {
    @NotBlank(message = "Drug name is required.")
    private String drugName;
    @NotBlank(message = "Drug short code is required.")
    private String drugShortCode;
    @NotBlank(message = "Manufacturer is required.")
    private String manufacturer;
    @NotBlank(message = "Precautions information is required.")
    private String precautions;
    @NotBlank(message = "Side effects information is required.")
    private String sideEffects;
    @NotBlank(message = "Contraindications information is required.")
    private String contraindications;
    @NotBlank(message = "Dosage form is required (e.g., tablet, cream, syrup).")
    private String dosageForm;
    @NotBlank(message = "Drug type is required (e.g., antibiotic, analgesic).")
    private String drugType;
    @NotNull(message = "Concentration details are required.")
    private ConcentrationDto concentration;
}
