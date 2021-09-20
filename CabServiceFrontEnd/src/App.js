import { BrowserRouter as Router, Route } from "react-router-dom";
import { Container } from 'reactstrap';
import './App.css';
import DriverLogin from "./Componenets/DriverLogin";
import Header from './Componenets/Header';
import UserDashboard from "./Componenets/UserDashboard";
import UserLogin from './Componenets/UserLogin';
import BookingDetails from './Componenets/BookingDetails';
import Registration from "./Componenets/Registration";
import DriverDashboard from "./Componenets/DriverDashboard";
import DriverRequestDetails from "./Componenets/DriverRequestDetails";
import DriverRegistration from "./Componenets/DriverRegistration";


function App() {
  return (
    <Router >
    <div className="App"  >
      <Header/>



      <Container >
      <Route path="/" component={UserLogin} exact />
      <Route path="/userdashboard/:emailId" component={UserDashboard} exact />
      <Route path="/userdashboard" component={UserDashboard} exact />
      <Route path="/driverrequestdetails/:vehicleNumber" component={DriverRequestDetails} exact />
      <Route path="/driverdashboard/:vehicleNumber" component={DriverDashboard} exact />

      <Route path="/registration" component={Registration} exact />
      <Route path="/driverregistration" component={DriverRegistration} exact />

      <Route path="/userlogin" component={UserLogin} exact />
      <Route path="/driverlogin" component={DriverLogin} exact />
      <Route path="/bookingdetails" component={BookingDetails} exact />
      <Route path="/bookingdetails/:emailId" component={BookingDetails} exact />

      

      </Container>
    </div>
  </Router>
  );
}

export default App;
