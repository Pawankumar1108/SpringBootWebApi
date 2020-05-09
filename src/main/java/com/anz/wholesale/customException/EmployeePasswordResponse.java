package com.anz.wholesale.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data  // @Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter 
@ApiModel //for the documenting our REST API allows to describe API's Properties
public class EmployeePasswordResponse {

@ApiModelProperty private String message;


protected EmployeePasswordResponse() {}


public EmployeePasswordResponse(String message) {

	this.message = message;
}



}
