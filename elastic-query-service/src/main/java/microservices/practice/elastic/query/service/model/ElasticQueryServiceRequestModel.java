package microservices.practice.elastic.query.service.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // Spring requires a no arg constructor to create object during deserialize json to java object
@AllArgsConstructor
public class ElasticQueryServiceRequestModel {
    private String id;
    private String text;
}
