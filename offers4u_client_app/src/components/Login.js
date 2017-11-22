import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';
import * as Api from "../services/Api";

export default class Login extends Component {
  constructor(props){
      super(props);
      this.state={
          username:'',
          password:'',
          role:'',
          error:false
        }
   }

   handleClick(event){
    const { history } = this.props.parentContext.props;
    const { username, password } = this.state;
    this.setState({ error: false });
    var payload={
      "cardNumber":this.state.username,
	    "password":this.state.password
    }
    //call backend MuiThemeProvider
    if ((username === '' || password === '')) {
      return this.setState({ error: true });
    }
    
    Api.loginUser(payload)
    .then(data => {
          console.log(data);
          history.push("/Home/Offers");
          this.props.parentContext.props.actionPostLoginSuccess(data);
          console.log("Login successfull");
    });
  }

  render() {
      return (
        <div width="60%" align="left">
          <MuiThemeProvider>
              <div width="60%" align="center">
                  <AppBar  title="Login" iconElementLeft={<FlatButton label="" />}/>
                   <TextField
                     hintText="Enter your Card Number"
                     floatingLabelText="CardNumber"
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
