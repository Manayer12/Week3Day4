package com.example.employeessystems.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
@Data
@AllArgsConstructor
public class Employee {
    @NotEmpty(message="should be not empty")
    @Size(min = 3,message = "Should be more than 2")
    private String id;
    @NotEmpty(message="should be not empty")
    @Size(min = 4,message = "Should be 4 or more")
    private String name;
    @NotNull
    @Min(25)
    @Positive
    private int age;
    @Pattern(regexp = "supervisor|coordinator")
    private String position;


     @Value("false")
     private Boolean onLeave;


    @NotNull
    @Positive
    @Min(1983)
    @Max(2023)
     private int employmentYear;

    @NotNull
    @Positive
    private int annualLeave;
}
