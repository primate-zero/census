package guerin.justin.census.rest;

import guerin.justin.census.model.PostalCodeData;
import guerin.justin.census.model.dto.PostalCodeDto;
import guerin.justin.census.service.PostalCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/postalCodes")
public class PostalCodeController {
    private final Logger LOG = LoggerFactory.getLogger(PostalCodeController.class);
    private final PostalCodeService postalCodeService;

    public PostalCodeController(PostalCodeService postalCodeService) {
        this.postalCodeService = postalCodeService;
    }
    @GetMapping("")
    public List<PostalCodeData> getAll(@RequestParam MultiValueMap<String, String> parameters) {
        LOG.info("Getting all postal codes.");
        for (Map.Entry<String, List<String>> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            LOG.info("Parameter key [" + key + "] value [" + value + "].");
        }
        return postalCodeService.findAll();
    }
    @GetMapping("/{postalCode}")
    public PostalCodeDto get(@PathVariable String postalCode) {
        return postalCodeService.getPostalCode(postalCode);
    }
    @PostMapping("/upload")
    public ResponseEntity<Resource> upload(@RequestParam("file")MultipartFile file) {
        try {
            postalCodeService.insertFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
