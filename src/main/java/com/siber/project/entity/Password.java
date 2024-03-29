package com.siber.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "#{@esConfig.getIndexName()}", createIndex = true)
public class Password {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;
}
