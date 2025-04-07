package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DrugEffects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugEffectsId;
    private String drugEffects;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public DrugEffects() {
    }
    public DrugEffects(Long drugEffectsId, String drugEffects, Drug drug) {
        this.drugEffectsId = drugEffectsId;
        this.drugEffects = drugEffects;
        this.drug = drug;
    }

    public Long getDrugEffectsId() {
        return drugEffectsId;
    }

    public void setDrugEffectsId(Long drugEffectsId) {
        this.drugEffectsId = drugEffectsId;
    }

    public String getDrugEffects() {
        return drugEffects;
    }

    public void setDrugEffects(String drugEffects) {
        this.drugEffects = drugEffects;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
