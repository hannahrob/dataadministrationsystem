package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class DrugEffects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugEffectsId;
    private String effects;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private DrugEntity drug;

    public DrugEffects() {
    }
    public DrugEffects(Long drugEffectsId, String effects, DrugEntity drug) {
        this.drugEffectsId = drugEffectsId;
        this.effects = effects;
        this.drug = drug;
    }

}
