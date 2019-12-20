package guerin.justin.census.model;

public enum CensusDataFields {
    POSTAL_CODE("Zip Code"),
    POPULATION("Total Population"),
    MEDIAN_AGE("Median Age"),
    TOTAL_MALES("Total Males"),
    TOTAL_FEMALES("Total Females"),
    TOTAL_HOUSEHOLDS("Total Households"),
    AVG_HOUSEHOLD_SIZE("Average Household Size");

    private String header;
    CensusDataFields(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
