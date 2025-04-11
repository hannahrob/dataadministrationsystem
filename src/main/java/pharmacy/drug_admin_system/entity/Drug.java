package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.*;
import pharmacy.drug_admin_system.dto.ConcentrationDto;

import java.util.List;
@Data
@Entity(name = "drug")
@AllArgsConstructor
@NoArgsConstructor
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;
    @Column(name = "Drug Name")
    private String drugName;
    @Column(name = "Drug Code")
    private String drugShortCode;
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Column(name = "Precautions")
    private String precautions;
    @Column(name = "Side Effects")
    private String sideEffects;
    @Column(name = "Concentration")
    private String concentration;
    @ManyToMany(mappedBy = "drug")
    @Column(name = "Prescriptions")
    private List<DoctorPrescription> prescriptions;
}
