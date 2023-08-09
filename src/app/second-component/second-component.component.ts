import { Component, OnInit } from '@angular/core';
import { Student } from '../entities/student.service';
import { StudentServiceService } from '../services/student-service.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-second-component',
  templateUrl: './second-component.component.html',
  styleUrls: ['./second-component.component.css']
})
export class SecondComponentComponent implements OnInit{
  students: Student[]=[];
  constructor(private studentService:StudentServiceService) {
    
  }
  ngOnInit() {
    this.studentService.findAll().subscribe(data => {
      this.students = data;
      console.log("hi hello")
      
    });
  }
}
