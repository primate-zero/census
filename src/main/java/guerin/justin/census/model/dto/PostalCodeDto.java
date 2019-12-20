package guerin.justin.census.model.dto;

public class PostalCodeDto {
    private Long id;
    private String postalCode;
    private Long population;
    private Float medianAge;
    private Long totalMales;
    private Long totalFemales;
    private Long totalHouseholds;
    private Float avgHouseholdSize;

    public PostalCodeDto(Long id, String postalCode, Long population, Float medianAge, Long totalMales,
                         Long totalFemales, Long totalHouseholds, Float avgHouseholdSize) {
        this.id = id;
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

    public Long getPopulation() {
        return population;
    }

    public Float getMedianAge() {
        return medianAge;
    }

    public Long getTotalMales() {
        return totalMales;
    }

    public Long getTotalFemales() {
        return totalFemales;
    }

    public Long getTotalHouseholds() {
        return totalHouseholds;
    }

    public Float getAvgHouseholdSize() {
        return avgHouseholdSize;
    }
}
