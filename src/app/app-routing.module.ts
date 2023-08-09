import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';
import { ThirdComponentComponent } from './third-component/third-component.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { FindOneStudentComponent } from './find-one-student/find-one-student.component';

const routes: Routes = [

  { path: 'first-component', component:FirstComponentComponent },
  { path: 'second-component', component: SecondComponentComponent },
  { path: 'third-component', component: ThirdComponentComponent},
  { path: 'create-component', component: CreateStudentComponent},
  { path: 'onestudent-component', component: FindOneStudentComponent},
 /* { path: 'onestudent-component/:stId', component: FindOneStudentComponent},*/
  { path: '',   redirectTo: '/first-component', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
