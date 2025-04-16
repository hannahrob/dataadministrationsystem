package pharmacy.drug_admin_system.dto.dto.transit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescriptions {
    private String dosage; // how many tablets or spoons
    private String dosageForm;
    private String frequency; // how many times a day
    private String duration; // how long
    private String drugShortCode;// short code of the drug
    private String concentration;
}
