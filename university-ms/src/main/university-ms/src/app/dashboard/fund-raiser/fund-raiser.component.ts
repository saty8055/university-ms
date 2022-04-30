
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoaderComponent } from 'src/app/loader/loader.component';
import { ApiService } from 'src/app/services/api/api.service';
import { BotService } from 'src/app/services/notification-bot/bot.service';
@Component({
  selector: 'app-fund-raiser',
  templateUrl: './fund-raiser.component.html',
  styleUrls: ['./fund-raiser.component.css']
})
export class FundRaiserComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private api: ApiService, private bot: BotService) { 
    this.form = this.formBuilder.group({
      amount: ['', Validators.required],
      reason: ['', Validators.required],
      remarks: ['', Validators.required]
    });
  }

  @ViewChild(LoaderComponent, { static: true })
  private loader: LoaderComponent;

  ngOnInit() {
    this.list();
  }

  funds:any[] = [];

  form: FormGroup;

  list(){
    this.loader.load();
    this.api.listFundRaisers().subscribe(response => {
      this.loader.resume();
      this.api.validateResponse(response, data => {
        this.funds = data;
      }, error => {
        this.bot.fail(error);
      });
    });
  }

  validateAndAdd(){
    if (this.form.get('amount').value == "")
      this.bot.fail("Please enter a valid amount !");
    else if (this.form.get('remarks').value == "")
      this.bot.fail("Please enter a valid remarks !");
      else if (this.form.get('reason').value == "")
        this.bot.fail("Please enter a valid reason !");
    else
      this.addFundsRaiser();
  }


  addFundsRaiser() {
    let funds = this.form.value;
    funds.deposit = true;
    this.loader.load();
    this.api.addFundRaiser(funds).subscribe(response => {
      this.loader.resume();
      this.api.validateResponse(response, data=>{
        this.funds.push(data);
        this.form.reset();
        this.bot.success("Funds Added!");
      }, error=>{
        this.bot.fail(error);
      })
    });
  }

}
