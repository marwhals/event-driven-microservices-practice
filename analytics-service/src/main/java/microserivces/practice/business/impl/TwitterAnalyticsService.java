package microserivces.practice.business.impl;

import microserivces.practice.business.AnalyticsService;
import microserivces.practice.dataaccess.repository.AnalyticsRepository;
import microserivces.practice.model.AnalyticsResponseModel;
import microserivces.practice.transformer.EntityToResponseModelTransformer;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TwitterAnalyticsService implements AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    private final EntityToResponseModelTransformer entityToResponseModelTransformer;

    public TwitterAnalyticsService(AnalyticsRepository analyticsRepository, EntityToResponseModelTransformer entityToResponseModelTransformer) {
        this.analyticsRepository = analyticsRepository;
        this.entityToResponseModelTransformer = entityToResponseModelTransformer;
    }

    @Override
    public Optional<AnalyticsResponseModel> getWordAnalytics(String word) {
        return entityToResponseModelTransformer.getResponseModel(
                analyticsRepository.getAnalyticsEntitiesByWord(word, PageRequest.of(0,1))
                        .stream().findFirst().orElse(null));
    }

}
