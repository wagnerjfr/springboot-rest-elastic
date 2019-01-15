package com.mycompany.springbootelasticgymactivities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(indexName = "training", type = "activities")
public class Activity {

    @Id
    private String id;
    private String kind;
    private String place;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    public Activity(Date date, String kind, String place,String description) {
        this.date = date;
        this.kind = kind;
        this.place = place;
        this.description = description;
    }
}
