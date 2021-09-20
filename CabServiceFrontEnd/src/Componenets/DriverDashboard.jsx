import React, { Component } from "react"
import Fade from 'react-reveal/Fade';
import { Button, Card, CardBody, CardHeader, CardImg, Col, Container, Row} from 'reactstrap';

class DriverDashboard extends Component {
    handleRequest = () => {
        const number=this.props.match.params.vehicleNumber;

        this.props.history.push({
            pathname: '/driverrequestdetails/' + number


        })
    }

    handleLogout = () => {

        this.props.history.push({
            pathname: '/'


        })
    }

  render() {

    return (
 <div>
            {/* info text */}
            <Row>
                <Col sm="1"></Col>
                <Col>
                    <h2 style={{ fontFamily: "cursive"}} className="mt-4">

                        <Fade left>
                            Easier, Faster, More Secure .
               </Fade>
                    </h2>
                </Col>
            </Row>

            <br></br>
            <br></br>



<Row>
            <Col sm="2"></Col>
            <Col sm="2"></Col>
            <Col sm="1"></Col>
            <Col sm="3">
                <Fade left duration={2000}>
                        <Card style={{ boxShadow: "0 10px 20px  0 rgba(0, 0, 0, 0.8)" }}>
                            <CardHeader>
                                <strong>
                                    Get Request
                     </strong>
                            </CardHeader>
                            <CardImg src="/request.png" width="120px" height="150px"></CardImg>
                            <CardBody style={{ fontFamily: "cursive" }}>
                                <Container className="mt-3">
                                    <Button style={{ borderRadius: "20px", width: "100%" }}
                                        outline onClick={this.handleRequest}>
                                            Get request
                                      </Button>
                                </Container>
                            </CardBody>
                        </Card>
                    </Fade>

                </Col>

</Row>
<Col >                <Button style={{marginLeft:"1100px",marginTop:"100px"}} onClick={this.handleLogout}>LogOut</Button>
</Col>

    
      </div>
    )
  }
}

export default DriverDashboard;