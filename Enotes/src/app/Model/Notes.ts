import { User } from "./User";

  export interface notes{

     
    title:string;
    content:string;
    nid:number;
    createdDate:Date;
    updatedDate:Date;
    user:{
      id:number,
      name:string,
      email:string,
      age:number
    }

  }