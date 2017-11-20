import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

import AppHeader from './Header';
import Home from './Home';
import Landing from './Landing';

//should just route between landing, home


export default class Main extends Component {
  constructor() {
    super();
    this.state = {
     hasLogin:true,
     loggedInUser:null
    }
  }

  componentWillMount() {

  }

  render() {
      return (
        <div>
          <MuiThemeProvider>
            <div width="80%" align="left">
                <br/>
                <AppHeader hasLogin={this.state.hasLogin}/>
                <br/>
                <Home width="60%" align="center"/>
            </div>
          </MuiThemeProvider>
      </div>
    );
  }
}
