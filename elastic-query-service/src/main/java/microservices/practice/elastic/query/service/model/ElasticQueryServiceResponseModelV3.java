package microservices.practice.elastic.query.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor //For example breaking change
public class ElasticQueryServiceResponseModelV3 extends RepresentationModel<ElasticQueryServiceResponseModelV3> {
    private Long id;
    private Long userId;
    private String text;
    private String text2;
}
