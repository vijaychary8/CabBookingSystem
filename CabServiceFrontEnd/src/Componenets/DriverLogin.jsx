import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

const axios = require('axios').default;
var login_attempts=3;

const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

export default class DriverLogin extends Component {

  constructor(props) {
    super(props);
    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);


    this.state = {
    vehicleNumber: "",
      password: "",
      loading: false,
      message: ""
    };
  }

  onChangeUsername(e) {
    this.setState({
        vehicleNumber: e.target.value
    });
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }

  handleLogin(e) {
    e.preventDefault();
  
    this.setState({
      message: "",
      loading: true
    });
    this.form.validateAll();
  
    if (this.checkBtn.context._errors.length === 0) {
      axios.post(`http://localhost:7005/driverlogin/${this.state.vehicleNumber}/${this.state.password}`).then(
        (response) => {
          alert("logged succesfully")
console.log(response)
          this.props.history.push({pathname:'/driverdashboard/'+this.state.vehicleNumber});
        }).catch((error) => {
          console.log(error)
          if (error.response.status===500) {
            alert("loggin failed")
              
          }   else
          {
           if(login_attempts===0)
           {
            alert("No Login Attempts Available");
           }
           else
           {
            login_attempts=login_attempts-1;
            alert("Login Failed Now Only "+login_attempts+" Login Attempts Available");
            if(login_attempts===0)
            {
             document.getElementById("vehicleNumber").disabled=true;
             document.getElementById("pass").disabled=true;
             document.getElementById("form1").disabled=true;
            }
           }
         
       
     }
    }
      
      );
  
    } 
  }
  

  render() {
    return (

      <div>
        <div>
          <br></br>
          <br></br>
          <br></br>
          <br></br>

        </div>
        <Form id="form1"onSubmit={this.handleLogin} ref={c => { this.form = c; }} style={{ width: "400px", color:"black", marginLeft: "700px", fontFamily: "cursive" }}>

          <p className="h1 text-center mb-4" style={{ fontFamily: "cursive" }}>Driver Login</p>

          <div className="form-group">
            <label htmlFor>Vehicle Number</label>
            <Input type="text" id="vehicleNumber" className="form-control" placeholder="Enter Vehicle Number" value={this.state.vehicleNumber} onChange={this.onChangeUsername} validations={[required]} />
          </div>

          <div className="form-group">
            <label htmlFor>Password</label>
            <Input type="password" id="pass" className="form-control" placeholder="Enter password" value={this.state.password} onChange={this.onChangePassword} validations={[required]} />
          </div>
          <br>
          </br>

          <div className="form-group" style={{marginRight:"200px"}}>
            <button
              className="btn btn-primary btn-block"
            >

              <span>Login</span>
            </button>
        &nbsp; Not <a href="/driverregistration">Registered?</a>

          </div>

          {this.state.message && (
            <div className="form-group">
              <div className="alert alert-danger" role="alert">
                {this.state.message}
              </div>
            </div>
          )}
          <CheckButton
            style={{ display: "none" }}
            ref={c => {
              this.checkBtn = c;
            }}
          />
        </Form>
      </div>
    );
  }
}