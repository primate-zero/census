package guerin.justin.census.repository;

import guerin.justin.census.model.PostalCodeData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostalCodeRepository extends JpaRepository<PostalCodeData, Long> {
    PostalCodeData findByPostalCode(String postalCode);
    PostalCodeData findById(long id);
    List<PostalCodeData> findByPopulationBetween(Long min, Long max);
    List<PostalCodeData> findByMedianAgeBetween(Float min, Float max);
    List<PostalCodeData> findByPopulationGreaterThan(Long minPopulation, Pageable pageable);
}
