import React from 'react';
import { Switch, Route } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import CardGrid from './CardGrid';
import CardDetails from './CardDetails';
import Dashboard from './Dashboard';
import Profile from './Profile';
import HomeNav from './HomeNav';
import axios from 'axios';

//should also route between CardGrid, CardDetails, Profile

export default class Home extends React.Component {

  constructor() {
    super();
    var customer;
    this.state = {
      customer:''
    }
  }

  render() {
      return (
        <div>
          <MuiThemeProvider>
              <div width="80%" align="left">
                <HomeNav/>
                <Switch>
                <Route exact path='/Home/Dashboard' component={Dashboard} />
                <Route exact path='/Home/Offers' component={CardGrid} />
                <Route exact path='/Home/Offers/:offerId' component={CardDetails} />
                <Route exact path='/Home/Profile' component={Profile} />
                </Switch>
              </div>
          </MuiThemeProvider>
        </div>
    );
  }
}
