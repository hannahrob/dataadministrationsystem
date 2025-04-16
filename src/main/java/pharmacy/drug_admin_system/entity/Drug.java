package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity(name = "Drug_Information")
@AllArgsConstructor
@NoArgsConstructor
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Drug_ID")
    private Long drugId;

    @Column(name = "Drug_Name")
    private String drugName;

    @Column(name = "Drug_Code")
    private String drugShortCode;

    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "Precautions", columnDefinition = "TEXT")
    private String precautions;

    @Column(name = "Side_Effects", columnDefinition = "TEXT" )
    private String sideEffects;

    @Column(name = "Contraindications", columnDefinition = "TEXT")
    private String contraindications;

    @Column(name = "Dosage_Form")
    private String dosageForm;

    @Column(name = "Drug_Type")
    private String drugType;

    @Column(name = "Concentration")
    private String concentration;

//    @ManyToMany(mappedBy = "drug")
//    @Column(name = "Prescriptions")
//    private List<DoctorPrescriptionEntity> prescriptions;
}
