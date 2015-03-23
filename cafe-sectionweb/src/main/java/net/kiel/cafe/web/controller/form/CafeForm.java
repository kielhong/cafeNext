package net.kiel.cafe.web.controller.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class CafeForm {

    @NotNull
    @Size(max=20)
    @Getter @Setter
    private String domain;

    @NotNull
    @Size(max=60)
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private Integer categoryId;
    
    @Size(max=100)
    @Getter @Setter
    private String description;
}
