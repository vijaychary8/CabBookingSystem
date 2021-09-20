import React, { useState } from 'react';

import {
    Card, CardBody, Button, Modal, ModalHeader, ModalBody, Col
  } from 'reactstrap';
  
  import { Form, FormGroup, Input } from 'reactstrap';
  import GroupIcon from '@material-ui/icons/Group';


const axios = require('axios').default;


 export default function UserDashboard(props){
  const emailId=props.match.params.emailId;


  const initalValues = {
    phoneNumber:"",
    username: "",
    vehicleNumber:"",
    driverName:"",
    source:"",
    destination:"",
    fare:"",
  }
const [bookingEntity,setBookingEntity]=useState(initalValues);

const [driverList,setDriverList]=useState([]);

  const [modal, setModal] = useState(false);

const toggle = () =>setModal(!modal);



  const  handleSourceInputChange=(e)=> {
      bookingEntity.source=e.target.value
  
  }

  const  handleDestinationInput=(e)=> {
    bookingEntity.destination=e.target.value

}
console.log(bookingEntity.source)
console.log(bookingEntity.destination)

const handleSubmit = (e) => {

  e.preventDefault();

}


const handleVehicle = () =>{
  setModal(!modal);


  axios.get(`http://localhost:7005/getuserdetails/${emailId}`).then((response) => {

    console.log(response.data.user.mobileNo
      )
  bookingEntity.phoneNumber=response.data.user.mobileNo;
  console.log(bookingEntity.phoneNumber)
  
    });
  

  axios.get(`http://localhost:7005/getallvehicles`).then((response) => {

  console.log(response.data)

      // this.setState({

      //     stationData: response.data.stationList
      // })

      setDriverList(response.data.driverList)
  });




}


const handlePrice = (object) => {
  setModal(false);

  console.log(object.vehicleNumber)



axios.get(`http://localhost:7005/getpricedetails/${object.vehicleNumber}`).then((response) => {

  console.log(response.data
    )

add(object);

  });




}

const viewRides=()=>{
      
  props.history.push({  
    pathname: '/bookingdetails/'  + emailId

})



}

const add=(obj)=>{

  console.log(obj)
  console.log(obj.vehicleNumber)
  console.log(obj.driverName)
  console.log(emailId)
let data={
  mobileNo:bookingEntity.phoneNumber,
  userName: emailId,
  vehicleNumber:obj.vehicleNumber,
  driverName:obj.driverName,
  source:bookingEntity.source,
  destination:bookingEntity.destination,
  fare:obj.price

}



      axios.post('http://localhost:7005/addBooking', data
      ).then((response) => {
    
        console.log(response)
    
        props.history.push({  
          pathname: '/bookingdetails/'  + emailId
  
  })
  
    
      })
    


}




const handleLogout = () => {

  props.history.push({
      pathname: '/'


  })
}



        return(
            <div  >
               <Card style={{ width: "300px", color:"black", marginLeft: "800px" ,marginTop:"40px"}}>
        <CardBody style={{backgroundColor:"black",fontSize:"25px",color:"white",paddingTop:"40px",paddingLeft:"30px",borderBlockColor: "none",textAlign:"justify"}} > <p>Where can we pick<br/> you up?</p></CardBody>
        <CardBody>
        <Form onSubmit={handleSubmit}>
      <FormGroup>
      <Input style={{backgroundColor:"#F1F6F9"}}
          type="text"
          name="source"
          id="source"
          placeholder="Add a pick up location"
          onChange={handleSourceInputChange}
          required

        />      </FormGroup>
        <br/>
      <FormGroup>
        <Input style={{backgroundColor:"#F1F6F9"}}
          type="text"
          name="destination"
          id="destination"
          placeholder="Add a drop location"
          onChange={handleDestinationInput}
          required
        />
      </FormGroup>
      <br/>
      </Form>
          <Button style={{backgroundColor:"black"}} onClick={handleVehicle}>Try requesting a ride now</Button>
        </CardBody>
      </Card>
      <br/>
      <Button style={{marginLeft: "1000px"}} onClick={viewRides}>View Rides</Button>

      <div>
      <Modal isOpen={modal} toggle={toggle} style={{width:"600px"}}>
        
          <ModalHeader toggle={toggle}>
          Request for Cab          </ModalHeader>
            
        <ModalBody>

        <table class="table" style={{ color: "black" ,backgroundColor:"white" }}>
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Type</th>

                                <th scope="col">Capacity</th>
                                <th>availability</th>
                                <th scope="col">Fare</th>





                            </tr>

                        </thead>
                        <tbody style={{ backgroundColor: "ButtonFace", color: "black" }}>
                        {
                                driverList.map(
                                    vehicle =>
                                        <tr key={vehicle.vehicleId}>
                                            <td>{vehicle.vehicleType}</td>
                                            <td>{vehicle.capacity}&nbsp;<GroupIcon/></td>
                                            <td>{vehicle.isAvailable}</td>

                                            <td>₹{vehicle.price}</td>
                                            <td><Button id="btun" style={{height:"30px" ,fontSize:"10px"}} onClick={(e) =>handlePrice(vehicle)}>Book now</Button></td>





                                        </tr>
                                )
                            }
                        </tbody>
                    </table>




          </ModalBody>
          </Modal>
</div>
<Button style={{marginRight:"1100px",marginTop:"50px",backgroundColor:"yellowgreen"}} onClick={handleLogout}>LogOut</Button>

   </div>



        )
    
}
