package microserivces.practice.transformer;


import microserivces.practice.dataaccess.entity.AnalyticsEntity;
import microserivces.practice.model.AnalyticsResponseModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityToResponseModelTransformer {

    public Optional<AnalyticsResponseModel> getResponseModel(AnalyticsEntity twitterAnalyticsEntity) {
        if (twitterAnalyticsEntity == null)
            return Optional.empty();
        return Optional.ofNullable(AnalyticsResponseModel
                .builder()
                .id(twitterAnalyticsEntity.getId())
                .word(twitterAnalyticsEntity.getWord())
                .wordCount(twitterAnalyticsEntity.getWordCount())
                .build());
    }
}
