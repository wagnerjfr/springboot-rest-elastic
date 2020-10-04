package com.mycompany.springbootelasticgymactivities.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateActivityDto {

    @ApiModelProperty(value = "activity date", example = "2020-10-01")
    @NotBlank
    private String date;

    @ApiModelProperty(position = 1, value = "activity kind (Rest, Cardio, Strength, Stretch, Other, None)", example = "Strength")
    @NotBlank
    private String kind;

    @ApiModelProperty(position = 2, value = "activity place (Indoor, Outdoor, Other, None)", example = "Indoor")
    @NotBlank
    private String place;

    @ApiModelProperty(position = 3, value = "activity description", example = "8 chest exercises with high intensity.")
    @NotBlank
    private String description;
}
