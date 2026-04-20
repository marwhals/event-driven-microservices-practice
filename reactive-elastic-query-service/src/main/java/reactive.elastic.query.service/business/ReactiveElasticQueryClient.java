package reactive.elastic.query.service.business;

import elastic.model.index.IndexModel;
import elastic.model.index.impl.TwitterIndexModel;
import reactor.core.publisher.Flux;

public interface ReactiveElasticQueryClient<T extends IndexModel> {

    Flux<TwitterIndexModel> getIndexModelByText(String text);

}
