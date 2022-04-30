import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoaderComponent } from 'src/app/loader/loader.component';
import { ApiService } from 'src/app/services/api/api.service';
import { BotService } from 'src/app/services/notification-bot/bot.service';

@Component({
  selector: 'app-funds',
  templateUrl: './funds.component.html',
  styleUrls: ['./funds.component.css']
})
export class FundsComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private api: ApiService, private bot: BotService) { 
    this.form = this.formBuilder.group({
      amount: ['', Validators.required],
      name: ['', Validators.required],
      remarks: ['', Validators.required]
    });

    this.utForm = this.formBuilder.group({
      amount: ['', Validators.required],
      name: ['', Validators.required],
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
  utForm: FormGroup;

  list(){
    this.loader.load();
    this.api.listFunds().subscribe(response => {
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
      else if (this.form.get('name').value == "")
        this.bot.fail("Please enter a valid name !");
    else
      this.addFunds();
  }

  validateAndUtilize(){
    if (this.utForm.get('amount').value == "")
      this.bot.fail("Please enter a valid amount !");
    else if (this.utForm.get('remarks').value == "")
      this.bot.fail("Please enter a valid remarks !");
      else if (this.utForm.get('name').value == "")
        this.bot.fail("Please enter a valid name !");
    else
      this.utilizeFunds();
  }

  addFunds() {
    let funds = this.form.value;
    funds.deposit = true;
    this.loader.load();
    this.api.addFunds(funds).subscribe(response => {
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

  utilizeFunds() {
    let funds = this.utForm.value;
    funds.deposit = false;
    this.loader.load();
    this.api.addFunds(funds).subscribe(response => {
      this.loader.resume();
      this.api.validateResponse(response, data=>{
        this.funds.push(data);
        this.utForm.reset();
        this.bot.success("Funds Utilized!");
      }, error=>{
        this.bot.fail(error);
      })
    });
  }

}
