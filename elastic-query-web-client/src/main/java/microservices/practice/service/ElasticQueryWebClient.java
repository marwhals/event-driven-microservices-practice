package microservices.practice.service;

import microservices.practice.model.ElasticQueryWebClientRequestModel;
import microservices.practice.model.ElasticQueryWebClientResponseModel;
import model.ElasticQueryWebClientAnalyticsResponseModel;

import java.util.List;

public interface ElasticQueryWebClient {

    ElasticQueryWebClientAnalyticsResponseModel getDataByText(ElasticQueryWebClientRequestModel requestModel);

}
