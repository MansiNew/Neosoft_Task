import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponentComponent } from './first-component/first-component.component';
import { DetailsDirective } from './details.directive';
import { SecondComponentComponent } from './second-component/second-component.component';
import { ThirdComponentComponent } from './third-component/third-component.component';
import { ThirdcomponenetDetailsDirective } from './thirdcomponenet-details.directive';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { StudentServiceService } from './services/student-service.service';
import { Student } from './entities/student.service';
import { CreateStudentComponent } from './create-student/create-student.component';
import { formatNumber } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormsModule ,ReactiveFormsModule } from '@angular/forms';
import { FindOneStudentComponent } from './find-one-student/find-one-student.component';
@NgModule({
  declarations: [
    AppComponent,
    FirstComponentComponent,
    DetailsDirective,
    SecondComponentComponent,
    ThirdComponentComponent,
    ThirdcomponenetDetailsDirective,
    CreateStudentComponent,
    FindOneStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,FormsModule,ReactiveFormsModule
  
  ],
  providers: [StudentServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
