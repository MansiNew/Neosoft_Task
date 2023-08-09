import { Injectable } from '@angular/core';
import { Student } from '../entities/student.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  private findUrl: string;
  private saveUrl:string;
  
  private getStudentIdUrl:string;
  constructor( private http: HttpClient) { 
    this.findUrl = 'http://localhost:6060/findAllStudents';
    this.saveUrl = 'http://localhost:6060/createStudent';
    this.getStudentIdUrl='http://localhost:6060/findStudentById/1';
  }
  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.findUrl);
  }
  public saveStudent(student:Student) {
    return this.http.post<Student>(this.saveUrl, student);
  }
  public getStudentById(stId: number): Observable<Student> {
    
   return this.http.get<Student>(this.getStudentIdUrl);

}
/*getStudentById(stId:number){
return this.http.get('http://localhost:6060/findStudentById/'+stId)
}*/
}
