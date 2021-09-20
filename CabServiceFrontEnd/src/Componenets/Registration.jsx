import React, {  useState } from "react";
import Form from "react-validation/build/form";

import Input from "react-validation/build/input";
import { Col, Row } from "reactstrap";
const axios = require('axios').default;



const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};



const vpassword = value => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

const vphonenumber = value => {
  if (value.pattern === "[0-9]{3}-[0-9]{2}-[0-9]{3}") {
    return (
      <div className="alert alert-danger" role="alert">
        Enter a valid phone number.
      </div>
    );
  }
};
  
export default function Registration (props) {

//   constructor(props) {
//     super(props);
//     this.handleRegister = this.handleRegister.bind(this);
//     this.onChangeName = this.onChangeName.bind(this);
//     this.onChangeDob = this.onChangeDob.bind(this);
//     this.onChangeEmail = this.onChangeEmail.bind(this);
//     this.onChangePassword = this.onChangePassword.bind(this);
//     this.onChangeUsername = this.onChangeUsername.bind(this);
//     this.onChangePhone = this.onChangePhone.bind(this);
//     this.onChangeCountry = this.onChangeCountry.bind(this);

//     this.state = {
//       name: "",
//       gender: "",
//       age: "",
//       emailId: "",
//       password: "",
//       mobileNo: "",
//       aadharNo: "",
//       city:"",
//       state:"",
//       successful: false,
//       message: ""
//     };
//   }


const initalValues = {

      name: "",
      gender: "",
      age: "",
      emailId: "",
      password: "",
      mobileNo: "",
      aadharNo: "",
      city:"",
      state:"",
}

var [userEntity, setUserEntity] = useState(initalValues);




const add = () => {
    axios.post('http://localhost:7005/adduser', userEntity
    ).then((response) => {

        if(response.data.message==="Registerd Sucessfully"){
            alert("Registerd Successfully")
      props.history.push({ pathname: '/userlogin' })
    }


    }
    ).catch((error) => {
      // Error
      if (error.response.status===404) {
          // The request was made and the server responded with a status code
          // that falls out of the range of 2xx
          // console.log(error.response.data);
          console.log(error.response.status);
          // console.log(error.response.headers);
alert("mail Id  is already present")

      }  else {
          // Something happened in setting up the request that triggered an Error
          console.log('Error', error.message);
      }
      console.log(error.config);

   
 });
  }



const handleInputChange = (e) => {
    var { name, value } = e.target
    setUserEntity({
      ...userEntity,
      [name]: value
    });
  }


  const handleSubmit = (e) => {

    e.preventDefault();
    add();

  };




    return (
      <div>
        <div>
          <br></br>
          <br></br>
        </div>
        <Form onSubmit={handleSubmit} style={{ width: "400px", marginLeft: "700px", fontFamily: "cursive", color:"black" }}>


          <p className="h1 text-center mb-4"style={{color:"black"}} >Register</p>


            <div>
              <div className="form-group">
                <Input type="text" className="form-control" placeholder="Full Name" name="name" onChange={handleInputChange} validations={[required]} />
              </div>
              <br/>
              <Row>

<Col>
              <div className="form-group">
                {/* <label htmlFor="gender">Gender</label> */}
                <Input type="text" className="form-control" placeholder="Gender" name="gender" onChange={handleInputChange} validations={[required]} />
              </div>

              </Col>
              <Col>
              <div className="form-group">
                {/* <label htmlFor="age">Age</label> */}
                <Input type="value" className="form-control" placeholder=" Enter Age" name="age" onChange={handleInputChange} validations={[required]} />
              </div>
              </Col>
</Row>
<br/>

              <div className="form-group">
                {/* <label htmlFor="emailId">Email</label> */}
                <Input type="email" className="form-control" placeholder="Enter email" name="emailId"  onChange={handleInputChange} validations={[required]} />
              </div>
              <br/>

              <div className="form-group">
                {/* <label htmlFor="password">Password</label> */}
                <Input type="password" className="form-control" placeholder="Enter password" name="password" onChange={handleInputChange} validations={[required, vpassword]} />
              </div>
              <br/>


              <div className="form-group">
                {/* <label htmlFor="mobileNo">Mobile Number</label> */}
                <Input type="tel" id="mobileNo" className="form-control" placeholder="Enter Phone No." name="mobileNo"  onChange={handleInputChange} validations={[required, vphonenumber]} />
              </div>
              <br/>

<Row>
    <Col>     <div className="form-group">
                {/* <label htmlFor="city">city</label> */}
                <Input type="text" className="form-control" placeholder="Enter City" name="city"  onChange={handleInputChange} validations={[required]} />
              </div>
              </Col>
         
         <Col>
              <div className="form-group">
                {/* <label htmlFor="state">State</label> */}
                <Input type="text" className="form-control" placeholder="Enter State" name="state"  onChange={handleInputChange} validations={[required]} />
              </div>
              </Col>
              </Row>
<br></br>
              <button type="submit" style={{height:"40px",paddingBottom:"10px"}} className="btn btn-primary btn-lg btn-block">Register</button>

            </div>
          


        </Form>
      </div>
    );
  
}