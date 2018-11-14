import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { BeerServiceService } from '../beer-service.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  //Virables
  setupForm: any;
  pageId = 0;
  headerText: string = "Create New Category";
  addData: any;
  validationMessages:any={}

  //Event Emmitor
  @Output() addItemEvent = new EventEmitter<any>();
  //Constructor
  constructor(private formBuilder: FormBuilder, private Service: BeerServiceService) { 
   //Validation massages
    this.validationMessages = {
      'IdNumber':{'required':"Please provide You ID Number"},
    }
  }

  ngOnInit() {
    //Build form
    this.buildForm()
  }

//Create form
  buildForm() {
    this.formBuilder = new FormBuilder();
    this.setupForm = this.formBuilder.group({
      IdNumber: new FormControl('', { validators: [Validators.required,], updateOn: 'blur' }),
    })
    //subscribe to form changes
    this.setupForm.statusChanges.subscribe(data => this.doValidation());
    this.doValidation();

  }

  //value change
  onValueChanged(){
    this.doValidation();
  }

//submit the form
  submit() {
    //do validations first before submit
    this.doValidation();
    this.markAllAsDirty();

    this.formStatus.submitClicked = true;

    if (this.setupForm.valid) {
      //invoke service call
      this.Service.CustomerLogin(this.setupForm.controls['IdNumber'].value).subscribe(res => {
        console.log(res,"jhhhhhhhhhhhhhhhh");
        this.dashBord(res);
      }, err => console.log(err))
    }

  }
  //handle close button click
  dashBord(data) {
    this.addItemEvent.next({ id: 0 ,data:data});
  }

  //form status and validation massages
  formStatus = {
    formErrors: {
      'IdNumber':'',
    },
    submitClicked: false
  };
// validate form and add validation massages
  private doValidation() {
    if (!this.setupForm) { return; } // Return if no form
    // for each field in formErrors check if associated control have errors and update formErrors with those.
    for (const field in this.formStatus.formErrors) {
      // clear previous error message (if any)
      this.formStatus.formErrors[field] = '';
      const control = this.setupForm.get(field);
      // Only set errors on controls that exist, is dirty and not valid.
      if (control && control.dirty && !control.valid) {
        if (this.validationMessages) {
          const messages = this.validationMessages[field]
          // tslint:disable-next-line:forin
          for (const key in control.errors) {
            this.formStatus.formErrors[field] += messages[key] + ' '
          }
        }
      }
    }
  }

  // Mark fields as dirty to trigger validation
  markAllAsDirty() {
      for (const key in this.setupForm.controls) {
          this.setupForm.controls[key].markAsDirty()
      }
    this.doValidation();
  }
}
