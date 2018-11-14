import { Component } from '@angular/core';
import { BeerServiceService } from './beer-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //Virable Declarations
  categories = [];
  categoriesId;
  selectedCategory: any;
  selectedItemData: any;
  Products=[];

  //constructor method
  constructor(private Service: BeerServiceService) {
              this.categoriesId=-1;
              this.getProducts();
 

  }

  ngOnInit() {
    //this.categoriesId = 0;
  }

  getProducts(){
     //Subscribing to service call
     this.Service.getProducts().subscribe(res => {

      this.categoriesId=0;
     // Build the categories data
     // this.buildcategory(res);
      this.buildProducts(res);
      console.log(res);

    },err=>{
      // Show error panel
          console.log(err)
          this.categoriesId=4;
    })
  }
  
  buildProducts(res){
    res.forEach(element => {
      
      this.Service.getProductsPrices(element.id).subscribe(res=>{
        this.Products.push({id:element.id,des:element.description,price:res.price,effactiveDate:res.effactiveDate})
        console.log(res,"itemyyyyyyyyyyy")
      })
    });
  }
  createOder(){
    
  }
  addToOrder(item) {

              }

  //Handle events            
  viewBearDetails(e) {
    switch(e.id){
      case 0:
            this.categoriesId = 0;
            this.getProducts();
            break;
      case 1:
            this.categoriesId = 1;
            break;
      case 3:
              this.selectedItemData = e.data;
              this.categoriesId = 3;
              break;
      case 5: 
              this.selectedItemData=e.data;
              this.categoriesId = 5;
              break;
     default:{
       console.log("defauld event")
     }
     break;
      
    }
  }

//Home Button Click
  goHome(){
            this.categoriesId = 0;
          }
  //Add Item Button clicked        
  register(){
            this.categoriesId = 5;
          }
//Add Category Button clicked  
  addCategory(){
          this.categoriesId = 6;
        }


}
