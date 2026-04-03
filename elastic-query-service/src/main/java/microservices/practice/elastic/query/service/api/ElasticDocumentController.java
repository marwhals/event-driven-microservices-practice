package microservices.practice.elastic.query.service.api;

import microservices.practice.elastic.query.service.business.ElasticQueryService;
import microservices.practice.elastic.query.service.model.ElasticQueryServiceRequestModel;
import microservices.practice.elastic.query.service.model.ElasticQueryServiceResponseModel;
import microservices.practice.elastic.query.service.model.ElasticQueryServiceResponseModelV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/documents") // Can be used to set mapping path, http method, params, header etc
public class ElasticDocumentController {
    private static final Logger LOG = LoggerFactory.getLogger(ElasticDocumentController.class);

    private final ElasticQueryService elasticQueryService;

    public ElasticDocumentController(ElasticQueryService queryService) {
        this.elasticQueryService = queryService;
    }

//Done on the method level for simplicity
    @GetMapping("/v1")
    public @ResponseBody // @ResponseBody --- used to serialize java response object to json
    ResponseEntity<List<ElasticQueryServiceResponseModel>> getAllDocuments() {
        List<ElasticQueryServiceResponseModel> response = elasticQueryService.getAllDocuments();
        LOG.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/{id}")
    public @ResponseBody
    ResponseEntity<ElasticQueryServiceResponseModel>
    getDocumentById(@PathVariable @NotEmpty String id) { //@PathVariable - used to path a pass variable into a method
        ElasticQueryServiceResponseModel elasticQueryServiceResponseModel = elasticQueryService.getDocumentById(id);
        LOG.debug("Elasticsearch returned document with id {}", id);
        return ResponseEntity.ok(elasticQueryServiceResponseModel);
    }

    @GetMapping("/v2/{id}")
    public @ResponseBody
    ResponseEntity<ElasticQueryServiceResponseModelV2>
    getDocumentByIdV2(@PathVariable @NotEmpty String id) { //@PathVariable - used to path a pass variable into a method
        ElasticQueryServiceResponseModel elasticQueryServiceResponseModel = elasticQueryService.getDocumentById(id);
        LOG.debug("Elasticsearch returned document with id {}", id);
        ElasticQueryServiceResponseModelV2 responseModelV2 = getV2Model(elasticQueryServiceResponseModel);
        return ResponseEntity.ok(responseModelV2);
    }

    @PostMapping("/v1/get-document-by-text")
    public @ResponseBody
    ResponseEntity<List<ElasticQueryServiceResponseModel>> // Process validation for all validation annotations on the object
    getDocumentByText(@RequestBody @Valid ElasticQueryServiceRequestModel elasticQueryServiceRequestModel) { //@ReqeustBody - used to deserialize json into a Java object
        List<ElasticQueryServiceResponseModel> response =
                elasticQueryService.getDocumentByText(elasticQueryServiceRequestModel.getText());
        LOG.info("Elasticsearch returned {} of documents", response.size());
        return ResponseEntity.ok(response);
    }

    private ElasticQueryServiceResponseModelV2 getV2Model(ElasticQueryServiceResponseModel responseModel) {
        ElasticQueryServiceResponseModelV2 responseModelV2 = ElasticQueryServiceResponseModelV2.builder()
                .id(Long.parseLong(responseModel.getId()))
                .text(responseModel.getText())
                .userId(responseModel.getUserId())
                .createdAt(responseModel.getCreatedAt())
                .build();
        responseModelV2.add(responseModel.getLinks());
        return responseModelV2;
    }

}
