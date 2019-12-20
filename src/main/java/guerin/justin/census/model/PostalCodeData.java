package guerin.justin.census.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostalCodeData {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String postalCode;

    @Column
    private Long population;

    @Column
    private Float medianAge;

    @Column
    private Long totalMales;

    @Column
    private Long totalFemales;

    @Column
    private Long totalHouseholds;

    @Column
    private Float avgHouseholdSize;

    public PostalCodeData() {
    }

    public PostalCodeData(String postalCode, Long population, Float medianAge, Long totalMales, Long totalFemales,
                          Long totalHouseholds, Float avgHouseholdSize) {
        this.postalCode = postalCode;
        this.population = population;
        this.medianAge = medianAge;
        this.totalMales = totalMales;
        this.totalFemales = totalFemales;
        this.totalHouseholds = totalHouseholds;
        this.avgHouseholdSize = avgHouseholdSize;
    }

    public Long getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Float getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(Float medianAge) {
        this.medianAge = medianAge;
    }

    public Long getTotalMales() {
        return totalMales;
    }

    public void setTotalMales(Long totalMales) {
        this.totalMales = totalMales;
    }

    public Long getTotalFemales() {
        return totalFemales;
    }

    public void setTotalFemales(Long totalFemales) {
        this.totalFemales = totalFemales;
    }

    public Long getTotalHouseholds() {
        return totalHouseholds;
    }

    public void setTotalHouseholds(Long totalHouseholds) {
        this.totalHouseholds = totalHouseholds;
    }

    public Float getAvgHouseholdSize() {
        return avgHouseholdSize;
    }

    public void setAvgHouseholdSize(Float avgHouseholdSize) {
        this.avgHouseholdSize = avgHouseholdSize;
    }
}