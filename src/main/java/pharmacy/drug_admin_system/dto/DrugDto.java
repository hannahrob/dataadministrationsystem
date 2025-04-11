package pharmacy.drug_admin_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugDto {
    private String drugName;
    private String manufacturer;
    private String precautions;
    private String sideEffects;
}
