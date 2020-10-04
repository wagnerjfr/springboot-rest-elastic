package com.mycompany.springbootelasticgymactivities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@Document(indexName = "training", createIndex = false)
public class Activity {

    @Id
    private String id;
    private String kind;
    private String place;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Field(type = FieldType.Date, format = DateFormat.date)
    private String date;

    public Activity(String date, String kind, String place, String description) {
        this.date = date;
        this.kind = kind;
        this.place = place;
        this.description = description;
    }
}
