package microservices.practice.elastic.query.service.business.impl;

import elastic.model.index.impl.TwitterIndexModel;
import microservices.practice.elastic.query.service.ElasticQueryClient;
import microservices.practice.elastic.query.service.business.ElasticQueryService;
import microservices.practice.elastic.query.service.model.ElasticQueryServiceResponseModel;
import microservices.practice.elastic.query.service.model.assembler.ElasticQueryServiceResponseModelAssembler;
import microservices.practice.elastic.query.service.transformer.ElasticToResponseModelTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TwitterElasticQueryService implements ElasticQueryService {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticQueryService.class);

    private final ElasticQueryServiceResponseModelAssembler elasticQueryServiceResponseModelAssembler;

    private final ElasticQueryClient<TwitterIndexModel> elasticQueryClient;

    public TwitterElasticQueryService(ElasticQueryServiceResponseModelAssembler assembler,
                                      ElasticQueryClient<TwitterIndexModel> elasticQueryClient) {
        this.elasticQueryServiceResponseModelAssembler = assembler;
        this.elasticQueryClient = elasticQueryClient;
    }


    @Override
    public ElasticQueryServiceResponseModel getDocumentById(String id) {
        LOG.info("Querying elasticsearch by id {}", id);
        return elasticQueryServiceResponseModelAssembler.toModel(elasticQueryClient.getIndexModelById(id));
    }

    @Override
    public List<ElasticQueryServiceResponseModel> getDocumentByText(String text) {
        LOG.info("Querying elasticsearch by id {}", text);
        return elasticQueryServiceResponseModelAssembler.toModels(elasticQueryClient.getIndexModelByText(text));
    }

    @Override
    public List<ElasticQueryServiceResponseModel> getAllDocuments() {
        LOG.info("Querying all documents in elasticsearch");
        return elasticQueryServiceResponseModelAssembler.toModels(elasticQueryClient.getAllIndexModels());
    }
}
