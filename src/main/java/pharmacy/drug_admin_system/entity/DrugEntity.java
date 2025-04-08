package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity(name = "d")
@AllArgsConstructor
@NoArgsConstructor
public class DrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;
    private String drugName;
    private String manufacturer;
    private String precautions;
    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<String> sideEffects;
}
