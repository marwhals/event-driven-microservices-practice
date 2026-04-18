package microservices.practice.transformer;

import elastic.model.index.impl.TwitterIndexModel;
import microservices.practice.model.ElasticQueryServiceResponseModel;
import org.springframework.stereotype.Component;

@Component
public class ElasticToResponseModelTransformer {

    public ElasticQueryServiceResponseModel getResponseModel(TwitterIndexModel twitterIndexModel) {
        return ElasticQueryServiceResponseModel
                .builder()
                .id(twitterIndexModel.getId())
                .userId(twitterIndexModel.getText())
                .createdAt(twitterIndexModel.getCreatedAt())
                .build();
    }

}
