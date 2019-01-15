package com.mycompany.springbootelasticgymactivities.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateActivityDto {

    @ApiModelProperty(value = "activity date", example = "2019-01-01")
    @NotNull
    private Date date;

    @ApiModelProperty(position = 1, value = "activity kind (Rest, Cardio, Strength, Stretch, Other, None)", example = "Strength")
    @NotNull
    @NotEmpty
    private String kind;

    @ApiModelProperty(position = 2, value = "activity place (Indoor, Outdoor, Other, None)", example = "Indoor")
    @NotNull
    @NotEmpty
    private String place;

    @ApiModelProperty(position = 3, value = "activity description", example = "8 chest exercises with high intensity.")
    @NotNull
    @NotEmpty
    private String description;
}
