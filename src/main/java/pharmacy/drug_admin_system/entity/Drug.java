package pharmacy.drug_admin_system.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;
    private String drugName;
    private String manufacturer;
    private String precautions;
    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<String> sideEffects;

    public Drug() {
    }

    public Drug(Long drugId, String drugName, String manufacturer, String precautions, List<String> sideEffects) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.manufacturer = manufacturer;
        this.precautions = precautions;
        this.sideEffects = sideEffects;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public List<String> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<String> sideEffects) {
        this.sideEffects = sideEffects;
    }
}
