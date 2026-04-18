package elastic.model.index.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import elastic.model.index.IndexModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@Builder // Apply builder pattern and create a builder to provide flexible object creation
@Document(indexName = "#{elasticConfigData.indexName}") // Indicates this class is a candidate for mapping to elasticsearch
public class TwitterIndexModel implements IndexModel {

    @JsonProperty
    private String id;
    @JsonProperty
    private Long userId;
    @JsonProperty
    private String text;

    @Field(type = FieldType.Date, format = DateFormat.basic_ordinal_date, pattern = "uuuu-MM-dd'T'HH:mm:ssZZ") // TemporalAccessor properties must have @Field or custom converters
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "uuuu-MM-dd'T'HH:mm:ssZZ") // Formats the field when converting object to json by using the pattern specified
    @JsonProperty
    private LocalDateTime createdAt;

    @Override
    public String getId() {
        return id;
    }

}
