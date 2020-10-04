package com.mycompany.springbootelasticgymactivities.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateActivityDto {

    @ApiModelProperty(value = "activity date", example = "2020-10-01")
    private String date;

    @ApiModelProperty(position = 1, value = "activity kind (Rest, Cardio, Strength, Stretch)", example = "Strength")
    private String kind;

    @ApiModelProperty(position = 2, value = "activity place (Indoor, Outdoor)", example = "Indoor")
    private String place;

    @ApiModelProperty(position = 3, value = "activity description", example = "8 chest exercises with high intensity.")
    private String description;
}
