import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AddNotesComponent } from './add-notes/add-notes.component';
import { DetailsComponent } from './details/details.component';
import { AddUserComponent } from './add-user/add-user.component';
import { HeaderComponent } from './header/header.component';
import { NotesInfoComponent } from './notes-info/notes-info.component';


const routes: Routes = [

  {
    path:"", component:LoginComponent
  },
  {
    path:"addNotes", component:AddNotesComponent
  },
  {
    path:"updateNotes/:id", component:AddNotesComponent
  },
  {
    path:"NotesInfo/:id", component:NotesInfoComponent
  },
  {
    path:"details", component:DetailsComponent
  },
  {
    path:"addUser", component:AddUserComponent
  },
  {
    path:"header", component:HeaderComponent
  },
  {
    path:"**", component:LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
