import { Component } from '@angular/core';
import { StudentServiceService } from '../services/student-service.service';
import { Student } from '../entities/student.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-find-one-student',
  templateUrl: './find-one-student.component.html',
  styleUrls: ['./find-one-student.component.css']
})
export class FindOneStudentComponent {
  student!:Student
  stId!:number
  studentData!:Student
  constructor(private studentService:StudentServiceService,
    private route:ActivatedRoute) {

  }
    ngOnInit() {
    this.stId=this.route.snapshot.params['stId'];
    this.getOneStudent();
      console.log("hi hello")
      
   
  } 
  getOneStudent(){
    this.studentService.getStudentById(this.stId).subscribe(data=>{
      console.log("my data")
      console.log(data);
      this.studentData=data;
    })
  }
}
