import React, { Component } from "react"
import Fade from 'react-reveal/Fade';
import { Button, Card, CardBody, CardHeader, Col, Container, Row} from 'reactstrap'
const axios = require('axios').default;


class DriverRequestDetails extends Component {

  constructor(props) {

    super(props)

    this.state = {

  bookingId:"",      
username:"",
emailId:"",
vehicleNumber:"",
            mobileNo:"",
            source:"",
            destination:"",
            fare:"",

        booking:[]

    };
  }


  handleRequest = () => {

        var p = document.getElementById("card");
        var d= document.getElementById("table");
  
          
      if (d.style.display === "none" ) {
            d.style.display = "block";
  p.style.display="none"
          } else {
            d.style.display = "none";
          }
    
  
        
  
  

}


handleDelete = () => {
    axios.delete(`http://localhost:7005/deletebooking/${this.state.bookingId}`).then((response) => {

        this.props.history.push({  
            pathname: '/driverdashboard/'+this.state.vehicleNumber
    
    })
    
  

    });



}


handleback = () => {
  let number=this.props.match.params.vehicleNumber;
  console.log(number)
    this.props.history.push({  
        pathname: '/driverdashboard/'+number

})


}


  componentDidMount() {
    let number=this.props.match.params.vehicleNumber

     axios.get(`http://localhost:7005/getalldriverbookings/${number}`).then((response) => {
     console.log(response.data.booking
        )

         this.setState({
             bookingId:response.data.booking.bookingId,
             emailId:response.data.booking.userName,
            vehicleNumber:response.data.booking.vehicleNumber,
             mobileNo: response.data.booking.mobileNo,
             source:response.data.booking.source,
             destination:response.data.booking.destination,
             fare:response.data.booking.fare,
booking:response.data.booking

         })

     }).catch((error) => {
        // Error
        if (error.response.status===404) {
            console.log(error.response.status);
            var d= document.getElementById("card");
            var c= document.getElementById("para");

              
          if (d.style.display === "block" ) {
                d.style.display = "none";
                c.style.display = "block";

                
              } else {
                d.style.display = "block";
              }
            
        }  else {
            // Something happened in setting up the request that triggered an Error
            console.log('Error', error.message);
        }
        console.log(error.config);
  
     
   }
      );


 }


  
  render() {

    return (
 <div>
            {/* info text */}
            <Row>
                <Col sm="1"></Col>
                <Col>
                    <h2 style={{ fontFamily: "cursive", color: "white" }} className="mt-4">

                        <Fade left>
               </Fade>
                    </h2>
                </Col>
            </Row>

            <br></br>
            <br></br>



<Row>
            <Col sm="2">                <Button  onClick={this.handleback}>Back</Button>
</Col>
            <Col sm="2"></Col>
            <Col sm="1"></Col>

                {/* transaction history card */}
                <Col sm="3">

                <Fade left duration={2000}>
                        <Card id="card" style={{ boxShadow: "0 10px 20px  0 rgba(0, 0, 0, 0.8)", display:"block" }}>
                            <CardHeader>
                                <strong>Ride details
        </strong>
                            </CardHeader>
                            <CardBody style={{ fontFamily: "cursive" }}>
                            <Row>
                                        <Col>Mobile No:</Col>
                                        <Col>{this.state.mobileNo}</Col>

                                    </Row>
                                    <Row className="mt-2">
                                        <Col>Source :</Col>
                                        <Col>{this.state.source}</Col>
                                    </Row>
                                    <Row className="mt-2">
                                        <Col>Destination :</Col>
                                        <Col>{this.state.destination}</Col>
                                    </Row>
                                    <Row className="mt-2">
                                        <Col>Fare :</Col>
                                        <Col>{this.state.fare}</Col>
                                    </Row>
                                    <hr></hr>
                                                                    </CardBody>


                            <CardBody style={{ fontFamily: "cursive" }}>
                                <Container className="mt-3">
                                    <Row>
                                        <Col>
                                    <Button style={{ borderRadius: "20px", width: "100%",backgroundColor:"#80ED99" }}
                                        outline onClick={this.handleRequest}>
                                        Accept
                                      </Button>
                                      </Col>
                                      <Col>
                                      <Button style={{ borderRadius: "20px", width: "100%",backgroundColor:"#EC4646" }}
                                        outline onClick={this.handleDelete}>
                                        Cancel
                                      </Button>
                                      </Col>
</Row>
                                </Container>
                            </CardBody>
                        </Card>
                    </Fade>

                </Col>
</Row>

<div id="table" style={{display:"none"}} className="container">
                {/* <button className="btn bg-primary text-white" onClick={(e) => this.back()}>Back</button> */}
<br></br>
<br></br>
                    <table  class="table" style={{ color: "white" ,backgroundColor:"Black" }}>
                        <thead class="thead-light">
                            <tr>
                                <th scope="col"> MobileNo</th>

                                <th scope="col">Vehicle Number</th>
                                <th scope="col">Source</th>
                                <th scope="col">Destination</th>

                                <th scope="col">Fare</th>




                            </tr>

                        </thead>
                        <tbody style={{ backgroundColor: "ButtonFace", color: "black" }}>
                            <tr>
                                            <td>{this.state.mobileNo}</td>
                                            <td>{this.state.vehicleNumber}</td>
                                            <td>{this.state.source}</td>
                                            <td>{this.state.destination}</td>
                                            <td>{this.state.fare}</td>


</tr>

                                

                        </tbody>

                    </table>

</div>
<div>
    <h3 id ="para" style={{display:"none"}}>No requests found</h3>
</div>
    
      </div>
    )
  }
}

export default DriverRequestDetails;