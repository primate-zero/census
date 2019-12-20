package guerin.justin.census.service;

import guerin.justin.census.model.PostalCodeData;
import guerin.justin.census.model.dto.PostalCodeDto;
import guerin.justin.census.repository.PostalCodeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostalCodeService {
    private final PostalCodeRepository postalCodeRepository;

    public PostalCodeService(PostalCodeRepository postalCodeRepository) {
        this.postalCodeRepository = postalCodeRepository;
    }

    public PostalCodeDto getPostalCode(String postalCode) {
        PostalCodeData postalCodeData = new PostalCodeData();
        postalCodeData.setPostalCode(postalCode);
        Example<PostalCodeData> exampleFilter = Example.of(postalCodeData);
        return postalCodeRepository.findOne(exampleFilter).map(pc -> new PostalCodeDto(pc.getId(), pc.getPostalCode(),
                pc.getPopulation(), pc.getMedianAge(), pc.getTotalMales(), pc.getTotalFemales(), pc.getTotalHouseholds(),
                pc.getAvgHouseholdSize())).orElse(null);
    }

    public List<PostalCodeData> findAll() {
        return postalCodeRepository.findAll();
    }

    public List<PostalCodeData> findFirstNByPopulationGreaterThan(Long minPopulation, int numResults) {
        Sort sort = Sort.by(Sort.Direction.DESC, "population");
        Pageable pageable = PageRequest.of(0, numResults, sort);
        return postalCodeRepository.findByPopulationGreaterThan(minPopulation, pageable).toList();
    }

    public List<PostalCodeData> insertFromFile(MultipartFile file) throws IOException {
        List<PostalCodeData> newPostCodeData = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        while ((line=br.readLine()) != null) {
            String[] tokens = line.split(",");
            if (tokens.length != 7) {
                continue;
            }
            long population;
            float medianAge;
            long males;
            long females;
            long houseCnt;
            float avgHouseSize;
            try {
                population = Long.parseLong(tokens[1]);
                medianAge = Float.parseFloat(tokens[2]);
                males = Long.parseLong(tokens[3]);
                females = Long.parseLong(tokens[4]);
                houseCnt = Long.parseLong(tokens[5]);
                avgHouseSize = Float.parseFloat(tokens[6]);
            } catch (NumberFormatException nfe) {
                continue;
            }
            PostalCodeData postalCodeData = new PostalCodeData(tokens[0], population, medianAge, males, females, houseCnt,
                    avgHouseSize);
            newPostCodeData.add(postalCodeData);
        }
        return postalCodeRepository.saveAll(newPostCodeData);
    }
}
