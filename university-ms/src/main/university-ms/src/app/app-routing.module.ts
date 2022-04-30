import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuardService } from './services/auth-guard.service';
import { LoginComponent } from './login/login.component';
import { F04Component } from './f04/f04.component';
import { ProfileComponent } from './dashboard/profile/profile.component';
import { ResetComponent } from './reset/reset.component';
import { RegisterComponent } from './register/register.component';
import { FundsComponent } from './dashboard/funds/funds.component';
import { FundRaiserComponent } from './dashboard/fund-raiser/fund-raiser.component';

const routes: Routes = [{
  path: "",
  component: DashboardComponent,
  children: [{
    path: "profile",
    component: ProfileComponent
  },{
    path: "funds",
    component: FundsComponent
  },{
    path: "raiser",
    component: FundRaiserComponent
  },{
    path: "",
    redirectTo: "/funds",
    pathMatch: "full"
  }],
  canActivate: [AuthGuardService]
}, {
  path: "login",
  component: LoginComponent
}, {
  path: "register",
  component: RegisterComponent
}, {
  path: "reset/:token",
  component: ResetComponent
},
{
  path: '**',
  pathMatch: 'full',
  component: F04Component
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
