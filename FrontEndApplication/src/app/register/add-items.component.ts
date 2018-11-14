import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';
import { BeerServiceService } from '../beer-service.service';

@Component({
  selector: 'app-add-items',
  templateUrl: './add-items.component.html',
  styleUrls: ['./add-items.component.css']
})
export class AddItemsComponent implements OnInit {
  // Virables
  setupForm: any;
  validationMessages: object = {};
  pageId: any;

  //Input data
  @Input() data: any;
  //EventEmitter
  @Output() addItemEvent = new EventEmitter<any>();
  onBlurMethod(){
    this.setupForm.controls['dateOfBirth'].setValue(this.getDob(this.setupForm.controls['IdNumber'].value));
  }
//constractor
  constructor(private formBuilder: FormBuilder, private Service: BeerServiceService) { 
//Validation massages
    this.validationMessages = {
                            'firstName':{'required':"name is required"},
                            'surName':{'required':"surname  is required",},
                            'IdNumber': {'required':"ID number is Required",'maxlength':"leng"},
                          }
                }

  ngOnInit() {
            this.pageId = 0;
            this.buildForm();
  }


  //Create add Item form
  buildForm() {
    this.formBuilder = new FormBuilder();
    this.setupForm = this.formBuilder.group({
      firstName: new FormControl('', { validators: [Validators.required,], updateOn: 'blur' }),
      surName: new FormControl('', { validators: [Validators.required], updateOn: 'blur' }),
      IdNumber: new FormControl('', { validators: [Validators.required], updateOn: 'blur' }),
      dateOfBirth: new FormControl('', { validators: [Validators.required], updateOn: 'blur' }),
    });
    this.setupForm.statusChanges.subscribe(data => this.doValidation());
    this.doValidation();

  }

  //valueChage Event
  onValueChanged(){
    alert('hklh')
    if(this.setupForm.controls['IdNumber'].value!=='')
    

    this.doValidation();
  }


  submit() {
    console.log(this.setupForm,this.formStatus);
    //do validations
    this.doValidation();
    this.markAllAsDirty();
    this.formStatus.submitClicked = true;
    var req:request=new request(this.setupForm.value.firstName,
      this.setupForm.value.surName,
      this.setupForm.value.IdNumber.toString(), 
      this.setupForm.value.dateOfBirth
    );
    var reqM:reqMother=new reqMother(req);
    if (this.setupForm.valid) {
      //invoke add Items service call
      this.Service.CustomerRegister(reqM).subscribe(res => {
        this.pageId = 1;
        console.log(res);
      }, err => console.log(err))
    }

  }
  //close utton clicked
  close() {
    //emit event to parent component
    this.addItemEvent.next({ id: 1 });
  }

  //form status objects
  formStatus = {
    formErrors: {
      'firstName':'',
      'surName':'',
      'IdNumber': '',
    },
    submitClicked: false
  };

  //Validate the form
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

 // mark form as Dirty
  markAllAsDirty() {
      // Mark fields as dirty to trigger validation
      for (const key in this.setupForm.controls) {
          this.setupForm.controls[key].markAsDirty()
      }
      //do validation
    this.doValidation();
  }

  //validate numbers
  validateNumber() {
    return (control: AbstractControl) => {
      const number = control.value; 
      if ( number.length>2) {
        return { maxlength: false }
      }
    }
}
 getDob(idNumber) {
  var Year = idNumber.toString().substring(0, 2);
  var Month = idNumber.toString().substring(2, 4)
  var Day = idNumber.toString().substring(4, 6)
  
  var cutoff = (new Date()).getFullYear() - 2000
  
  var dob = (Year > cutoff ? '19' : '20') + Year + '/' + Month + '/' + Day;
  return dob
}
}
export class request{
  firstName:String
  surName:String
  IdNumber:String 
  dateOfBirth:String
  constructor(firstName,
    surName,
    IdNumber ,
    dateOfBirth){
      this.firstName=firstName;
      this.surName=surName;
      this.IdNumber=IdNumber;
      this.dateOfBirth=dateOfBirth;
    }
}
export class reqMother{
  req:request
  constructor(req:request){
    this.req=req;
  }
}