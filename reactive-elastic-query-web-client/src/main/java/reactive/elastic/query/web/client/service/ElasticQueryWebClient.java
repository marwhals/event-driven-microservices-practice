package reactive.elastic.query.web.client.service;

import model.ElasticQueryWebClientRequestModel;
import model.ElasticQueryWebClientResponseModel;
import reactor.core.publisher.Flux;

public interface ElasticQueryWebClient {

    Flux<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel request);

}
