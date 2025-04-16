package pharmacy.drug_admin_system.dto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pharmacy.drug_admin_system.enums.ConcentrationUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcentrationDto {
    private double value;
    @Enumerated(EnumType.STRING)// Save enum as a readable string (e.g. "MG_ML")
    @NotNull
    private ConcentrationUnit unit;

    @Override
    public String toString() {
        return value+" "+unit.toString();
    }
}
