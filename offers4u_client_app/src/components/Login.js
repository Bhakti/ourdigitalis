import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';


import axios from 'axios';

export default class Login extends Component {
  constructor(props){
      super(props);
      this.state={
        username:'',
        password:''
    }
   }

   handleClick(event){
    var apiBaseUrl = "http://localhost:8080/api/v1";
    var self = this;
    var payload={
      "userid":this.state.username,
	    "password":this.state.password,
      "role":this.state.loginRole
    }
    //call backend MuiThemeProvider
    //TODO
    console.log("Login successfull");

  }

  render() {
      return (
        <div width="60%" align="left">
          <MuiThemeProvider>
              <div width="60%" align="center">
                  <AppBar  title="Login" iconElementLeft={<FlatButton label="" />}/>
                   <TextField
                     hintText="Enter your Username"
                     floatingLabelText="Username"
                     onChange = {(event,newValue) => this.setState({username:newValue})}
                     />
                   <br/>
                   <TextField
                     type="password"
                     hintText="Enter your Password"
                     floatingLabelText="Password"
                     onChange = {(event,newValue) => this.setState({password:newValue})}
                     />
                   <br/>
                   <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
                   <p>Login to browse more offers from your favorite retailers and shop all Discover Deals.</p>
                </div>
            </MuiThemeProvider>
        </div>
      );
    }
}

const style = {
 margin: 15,
};
