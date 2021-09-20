import React, { Component } from 'react'
import { Button, Col, Row } from 'reactstrap';
const axios = require('axios').default;


export default class BookingDetails extends Component {

    constructor(props) {
        super(props);
        this.state = {

            bookingData: [],


        }
    }


    componentDidMount() {
       let email=this.props.match.params.emailId

        axios.get(`http://localhost:7005/getallbookings/${email}`).then((response) => {
        console.log(response)

            this.setState({

                bookingData: response.data.bookiList
            })


        }).catch((error) => {
            // Error
            if (error.response.status===404) {
                console.log(error.response.status);
                var d= document.getElementById("frm");
          
                  
              if (d.style.display === "none" ) {
                    d.style.display = "block";
                  } else {
                    d.style.display = "none";
                  }
                
            }  else {
                // Something happened in setting up the request that triggered an Error
                console.log('Error', error.message);
            }
            console.log(error.config);
      
         
       }
          );


    }
    handleDelete = (id, emailId) => {
        axios.delete(`http://localhost:7005/deletebooking/${id}`).then((response) => {

            this.props.history.push({  
                pathname: '/userdashboard/'+emailId
        
        })
        
      

        });

    }

    

    back = () => {
        let email=this.props.match.params.emailId


        this.props.history.push({  
            pathname: '/userDashboard/' +  email
    
    })
    }



    render() {

        return (
            <div className="m-5">
                              <Row>
            <Col sm="2">                <Button  onClick={this.back}>Back</Button>
</Col>
            <Col sm="2"></Col>
            <Col sm="1"></Col>
</Row>

                <h4 className="text-center m-3" style={{color:"Black"}}> Booking Details</h4>

                <div className="container">
                {/* <button className="btn bg-primary text-white" onClick={(e) => this.back()}>Back</button> */}
<br></br>
<br></br>
                    <table class="table" style={{ color: "white" ,backgroundColor:"Black" }}>
                        <thead class="thead-light">
                            <tr>
                                <th scope="col"> MailId</th>
                                <th scope="col">Vehicle Number</th>
                                <th scope="col">Source</th>
                                <th scope="col">Destination</th>
                                <th scope="col">Driver Name</th>

                                <th scope="col">Fare</th>




                            </tr>

                        </thead>
                        <tbody style={{ backgroundColor: "ButtonFace", color: "black" }}>

                            {
                                this.state.bookingData.map(
                                    booking =>
                                        <tr key={booking.bookingId}>
                                            <td>{booking.userName}</td>
                                            <td>{booking.vehicleNumber}</td>
                                            <td>{booking.source}</td>
                                            <td>{booking.destination}</td>
                                            <td>{booking.driverName}</td>
                                            <td>{booking.fare}</td>



                                            <td><Button style={{color:"white",backgroundColor:"red"}} onClick={(e) => this.handleDelete(booking.bookingId, booking.userName)}>Cancel</Button> &nbsp;&nbsp;

</td>

                                        </tr>
                                )
                            }


                        </tbody>

                    </table>
                    <h6 style={{display:"none"}} id="frm" >No Rides found</h6>

                </div>

            </div>
        )
    }
}
