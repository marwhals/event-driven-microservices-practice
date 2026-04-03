package microservices.practice.elastic.query.service.impl;

import elastic.model.index.impl.TwitterIndexModel;
import microservices.practice.common.util.CollectionsUtil;
import microservices.practice.elastic.query.exception.ElasticQueryClientException;
import microservices.practice.elastic.query.repository.TwitterElasticseachQueryRepository;
import microservices.practice.elastic.query.service.ElasticQueryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class TwitterElasticRepositoryQueryClient implements ElasticQueryClient<TwitterIndexModel> {
    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticRepositoryQueryClient.class);

    private final TwitterElasticseachQueryRepository twitterElasticsearchQueryRepository;

    public TwitterElasticRepositoryQueryClient(TwitterElasticseachQueryRepository repository) {
        this.twitterElasticsearchQueryRepository = repository;
    }

    @Override
    public TwitterIndexModel getIndexModelById(String id) {
        Optional<TwitterIndexModel> searchResult = twitterElasticsearchQueryRepository.findById(id);
        LOG.info("Document with id {} retrieved successfully",
                searchResult.orElseThrow(() ->
                        new ElasticQueryClientException("No document found at elasticsearch with id " + id)).getId());
        return searchResult.get();
    }

    @Override
    public List<TwitterIndexModel> getIndexModelByText(String text) {
        List<TwitterIndexModel> searchResult = twitterElasticsearchQueryRepository.findByText(text);
        LOG.info("{} of documents with text {} retrieved successfully", searchResult.size(), text);
        return searchResult;
    }

    @Override
    public List<TwitterIndexModel> getAllIndexModels() {
        List<TwitterIndexModel> searchResult =
                CollectionsUtil.getInstance().getListFromIterable(twitterElasticsearchQueryRepository.findAll());
        LOG.info("{} number of documents retrieved successfully", searchResult.size());
        return searchResult;
    }
}
