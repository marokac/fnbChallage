import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions,Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';

//Sear
@Injectable()
export class BeerServiceService {
  //Observable streams
  emitChangeSource = new Subject<any>();
  sourceBears$ = this.emitChangeSource.asObservable()

 //Constractor
  constructor(private http: Http,) { }

//////////////////////////// Service calls///////////////////////////////////
// Get categories service call

//Get Product Service call
getProducts(){
          return this.http.get("/api/getAllProducts").map((res:Response)=>{
            var response=res.json();
                   return response;
          }).catch((err) => {
            return Observable.throw(err);
          })
}

getProductsPrices(id){
  return this.http.get("/api/product/"+id+"/price ").map((res:Response)=>{
    var response=res.json();
           return response;
  }).catch((err) => {
    return Observable.throw(err);
  })
}

CustomerRegister(formValues){
  var headers = new Headers({
    "Content-Type": "application/json",
    "Accept": "application/json"
});
  return this.http.post("/api/register",formValues,{headers: headers}).map((res:Response)=>{
    return res.json();
  });
}
 
CustomerLogin(value){
  var headers = new Headers({
    "Content-Type": "application/json",
    "Accept": "application/json"
});
  return this.http.post("/api/login",value,{headers: headers}).map((res:Response)=>{
    return res.json();
  });
}
}


