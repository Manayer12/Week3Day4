package com.example.employeessystems.Controller;

import com.example.employeessystems.ApiResponse.ApiResponse;
import com.example.employeessystems.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {

    ArrayList<Employee> employees=new ArrayList<Employee>();

    @GetMapping("/get")
    public ArrayList<Employee>getAllEmployee(){

        return employees;}

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));

    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index,@RequestBody @Valid Employee employee, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("user updated"));

    }

    @DeleteMapping ("/delete/{index}")
    public ResponseEntity updateUser(@PathVariable int index ){

        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));

    }


    @PutMapping("/apply/{index}")
    public ResponseEntity  employeeApplication(@PathVariable int index){
        for(int i=0;i<employees.size();i++){
            if (employees.get(i).getAnnualLeave()>0 && employees.get(i).getOnLeave() == false){
               employees.get(i).setAnnualLeave(employees.get(i).getAnnualLeave()-1);
               employees.get(i).setOnLeave(true);
                return ResponseEntity.status(200).body(employees.get(i));

            }}

        return ResponseEntity.status(400).body(new ApiResponse("annual leave not found or =0 ,or onLeave = true"));

    }










}
