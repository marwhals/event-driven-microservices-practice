package microservices.practice.elastic.query.service.business;

import microservices.practice.elastic.query.service.model.ElasticQueryServiceAnalyticsResponseModel;
import microservices.practice.elastic.query.service.model.ElasticQueryServiceResponseModel;

import java.util.List;

public interface ElasticQueryService {

    ElasticQueryServiceResponseModel getDocumentById(String id);

    ElasticQueryServiceAnalyticsResponseModel getDocumentByText(String text, String accessToken);

    List<ElasticQueryServiceResponseModel> getAllDocuments();

}
