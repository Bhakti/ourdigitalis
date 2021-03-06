import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import {RadioButton, RadioButtonGroup} from 'material-ui/RadioButton';
import * as Api from "../services/Api";
import { Container, Row, Col } from 'reactstrap';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

const styles = {
  block: {
    maxWidth: 250,
  },
  radioButton: {
    marginBottom: 16,
  },
};

export default class Profile extends Component {
  constructor(props){
    super(props);
    this.state={
      firsName:'',
      middleName:'',
      lastName:'',
      email:''

    }
  }

   handleClick(event){
    var url = "http://localhost:8080/api/v1/users/registration";
    var self = this;
    var payload={}
    //call backend MuiThemeProvider
    console.log("registration successfull");
    //TODO
  }
  render() {
    return (
      <div width="60%" align="left">
        <Breadcrumb>
          <BreadcrumbItem><a href="/Home/Offers">Home</a></BreadcrumbItem>
          <BreadcrumbItem active>Profile</BreadcrumbItem>
        </Breadcrumb>
        <Container>
          <Row>
            <Col>
              <MuiThemeProvider>
                <div width="60%" align="left">
                        <div width="60%" align="left">
                         <TextField
                           hintText="Enter your First Name"
                           floatingLabelText="First Name"
                           onChange = {(event,newValue) => this.setState({firstName:newValue})}
                           />
                         <br/>
                         <TextField
                           hintText="Enter your Middle Name"
                           floatingLabelText="Middle Name"
                           onChange = {(event,newValue) => this.setState({middleName:newValue})}
                           />
                         <br/>
                         <TextField
                           hintText="Enter your Last Name"
                           floatingLabelText="Last Name"
                           onChange = {(event,newValue) => this.setState({lastName:newValue})}
                           />
                         <br/>
                         <TextField
                           hintText="Enter your Email"
                           type="email"
                           floatingLabelText="Email"
                           onChange = {(event,newValue) => this.setState({emailId:newValue})}
                           />
                         <br/>
                         <RadioButtonGroup name="gender" defaultSelected="male">
                            <RadioButton
                              value="male"
                              label="male"
                              style={styles.radioButton}
                            />
                            <RadioButton
                              value="female"
                              label="female"
                              style={styles.radioButton}
                            />
                          </RadioButtonGroup>

                         <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
                            </div>
                        </div>
                     </MuiThemeProvider>
                </Col>
             </Row>
          </Container>
      </div>
    );
  }
}
const style = {
  margin: 15,
};
