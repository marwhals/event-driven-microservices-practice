package microservices.practice.elastic.query.service.config;

import microservices.practice.demo.config.ElasticQueryServiceConfigData;
import microservices.practice.elastic.query.service.business.ElasticQueryService;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final ElasticQueryServiceConfigData.WebClient elasticQueryServiceConfigData;

    public WebClientConfig(ElasticQueryServiceConfigData queryServiceConfigData) {
        this.elasticQueryServiceConfigData = queryServiceConfigData.getWebClient();
    }

    @LoadBalanced
    @Bean
    WebClient.Builder webClientBuilder() {

    }

}
