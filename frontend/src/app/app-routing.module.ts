import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '@core/guards/auth.guard';
import { LoggedInAuthGuard } from '@core/guards/logged-in-auth.guard';
import { NotFoundComponent } from '@shared/components/not-found/not-found.component';

const routes: Routes = [
  {
    path: '', //This route represents the default path that redirects to the HomeModule when the application starts
    loadChildren: () => import('./home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'auth', //route is for the 'auth' path, loading the AuthModule and activating the LoggedInAuthGuard guard
    loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule),
    canActivate: [LoggedInAuthGuard],
  },
  {
    //Route for 'student-services', loading StudentModule, activating AuthGuard, and specifying role-based authorization data.
    path: 'student-services',
    loadChildren: () =>
      import('./student/student.module').then((m) => m.StudentModule),
    canActivate: [AuthGuard],
    data: {
      allowedRoles: ['ROLE_STUDENT'],
      validationMethod: 'any',
    },
  },
  {
    //Route for 'teacher-services', loading TeacherModule, activating AuthGuard, and specifying role-based authorization data.
    path: 'teacher-services',
    loadChildren: () =>
      import('./teacher/teacher.module').then((m) => m.TeacherModule),
    canActivate: [AuthGuard],
    data: {
      allowedRoles: ['ROLE_TEACHER'],
      validationMethod: 'any',
    },
  },
  {
    //Route for 'admin-panel', loading AdminModule, activating AuthGuard, and specifying role-based authorization data.
    path: 'admin-panel',
    loadChildren: () =>
      import('./admin/admin.module').then((m) => m.AdminModule),
    canActivate: [AuthGuard],
    data: {
      allowedRoles: ['ROLE_ADMIN'],
      validationMethod: 'any',
    },
  },
  {
    path: '**',
    component: NotFoundComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
