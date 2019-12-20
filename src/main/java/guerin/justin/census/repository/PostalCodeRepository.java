package guerin.justin.census.repository;

import guerin.justin.census.model.PostalCodeData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

public interface PostalCodeRepository extends JpaRepository<PostalCodeData, Long> {
    PostalCodeData findByPostalCode(String postalCode);
    PostalCodeData findById(long id);
    Streamable<PostalCodeData> findByPopulationBetween(Long min, Long max);
    Streamable<PostalCodeData> findByMedianAgeBetween(Float min, Float max);
    Streamable<PostalCodeData> findByPopulationGreaterThan(Long minPopulation, Pageable pageable);
}
