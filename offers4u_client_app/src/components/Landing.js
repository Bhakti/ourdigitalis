import React, { Component } from 'react';
import { Card, CardTitle, CardText, CardDeck,   CardBody } from 'reactstrap';

import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import RaisedButton from 'material-ui/RaisedButton';

import logo from '../static/images/offersE4U.jpg';

import Login from './Login';
import Register from './Register';

export default class Landing extends Component {
  constructor(props){
    super(props);
    var loginButtons=[];
    loginButtons.push(
      <div>
      <MuiThemeProvider>
        <div align="center">
           <RaisedButton label={"Register as Customer"} primary={true} style={style} onClick={(event) => this.handleClick(event,'customer')}/>
       </div>
       </MuiThemeProvider>
       <MuiThemeProvider>
       <div align="center">
          <RaisedButton label={"Register as Merchant"} primary={true} style={style} onClick={(event) => this.handleClick(event,'merchant')}/>
      </div>
      </MuiThemeProvider>
      </div>
    )
    this.state={
      username:'',
      password:'',
      loginscreen:[],
      loginmessage:'',
      loginButtons:loginButtons,
      customerbuttonLabel:'Register as Customer',
      merchantbuttonLabel:'Register as Merchant',
      isLogin:true,
      hasLogin:false
    }
  }
  componentWillMount(){
    var loginscreen=[];
    loginscreen.push(<Login parentContext={this} appContext={this.props.appContext}/>);
    var loginmessage = "Not registered yet, Register Now";
    this.setState({
                  loginscreen:loginscreen,
                  loginmessage:loginmessage
                    })
  }

  handleClick(event,userRole){
    console.log("event",userRole);
    var loginmessage;
    if(this.state.isLogin){
      var loginscreen=[];
      loginscreen.push(<Register parentContext={this} appContext={this.props.appContext} role={userRole}/>);
      loginmessage = "Already registered. Go to Login";
      var loginButtons=[];
      loginButtons.push(
        <div>
        <MuiThemeProvider>
          <div>
             <RaisedButton label={"Login"} primary={true} style={style} onClick={(event) => this.handleClick(event,userRole)}/>
         </div>
         </MuiThemeProvider>
        </div>
      )
      this.setState({
                     loginscreen:loginscreen,
                     loginmessage:loginmessage,
                     loginButtons:loginButtons,
                     isLogin:false
                   })
    }  else {
      var loginscreen=[],loginButtons=[];
      loginButtons.push(
        <div>
        <MuiThemeProvider>
          <div>
             <RaisedButton label={"Register as Customer"} primary={true} style={style} onClick={(event) => this.handleClick(event,'customer')}/>
         </div>
         </MuiThemeProvider>
         <MuiThemeProvider>
         <div>
            <RaisedButton label={"Register as Merchant"} primary={true} style={style} onClick={(event) => this.handleClick(event,'merchant')}/>
        </div>
        </MuiThemeProvider>
        </div>
      )
      loginscreen.push(<Login parentContext={this} appContext={this.props.appContext} role={userRole}/>);
      loginmessage = "Not Registered yet. Go to registration";
      this.setState({
                     loginscreen:loginscreen,
                     loginmessage:loginmessage,
                     loginButtons:loginButtons,
                     isLogin:true
                   })
    }
  }

   render() {
      return (
        <div width="60%" align="left">
          <MuiThemeProvider>
              <CardDeck>
                <Card>
                  <img src={logo} top width="100%" alt="offers4u" />
                  <CardBody>
                    <CardText>As Cardmembers can enjoy extra rewards and savings when they shop deals from top brands through Digitalis Deals.</CardText>
                  </CardBody>
                </Card>
                <Card aligin="center">
                  <CardBody>
                    <div className="loginscreen">
                      {this.state.loginscreen}
                      <div aligin="center">
                        {this.state.loginmessage}
                        {this.state.loginButtons}
                      </div>
                    </div>
                  </CardBody>
                </Card>
                <Card>
                  <CardBody>
                    <CardTitle>Why Digitalis Deals</CardTitle>
                    <CardText>
                    <ol>
                        <li>
                          <div>For Customers</div>
                          <ol>
                          <li>Get Deals/Offers of your Interests</li>
                          <li>Get Recommendation of Deals on bases of your spending pattern</li>
                          <li>Get Personalized Deals</li>
                          </ol>
                        </li>
                        <li>
                          <div>For Merchants</div>
                          <ol>
                          <li>Get Recommendation of Deals on bases of your spending pattern</li>
                          <li>Target selected segment of customer with deals/Offers to get better ROI</li>
                          </ol>
                        </li>
                    </ol>
                    </CardText>
                  </CardBody>
                </Card>
              </CardDeck>
              <br/>
            </MuiThemeProvider>
        </div>
      );
    }
}

const style = {
 margin: 15,
};
