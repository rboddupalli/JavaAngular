import { EmployeeService } from './../employee.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import {Employee} from "../Employee"

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;


  constructor(private employeeService: EmployeeService,
    private router: Router) { }

    ngOnInit() {
    }
    
    newEmployee(): void {
      this.submitted = false;
      this.employee = new Employee();
    }
    
    save() {
      this.employeeService.createEmployee(this.employee)
        .subscribe(data => console.log(data), error => console.log(error));
      this.employee = new Employee();
      this.gotoList();
    }

    gotoList() {
      this.router.navigate(['/employees']);
    }
    onSubmit() {
      this.submitted = true;
      this.save();    
    }

}
