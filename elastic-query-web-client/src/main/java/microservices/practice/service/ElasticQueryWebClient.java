package microservices.practice.service;

import microservices.practice.model.ElasticQueryWebClientRequestModel;
import microservices.practice.model.ElasticQueryWebClientResponseModel;

import java.util.List;

public interface ElasticQueryWebClient {

    List<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel requestModel);

}
