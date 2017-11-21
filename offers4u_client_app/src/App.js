import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppHeader from './components/AppHeader';
import Home from './components/Home';
import Landing from './components/Landing';
import CardGrid from './components/CardGrid';
import CardDetails from './components/CardDetails';
import Dashboard from './components/Dashboard';
import Profile from './components/Profile';

export default class App extends Component {
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
        <Router>
            <div>
              <MuiThemeProvider>
                <div width="80%" align="left">
                    <br/>
                    <AppHeader hasLogin={this.state.hasLogin}/>
                    <br/>
                    <Switch>
                       <Route exact path='/Login' component={Landing} />
                       <Route exact path='/Home' component={Home} />
                       <Route exact path='/Home/Dashboard' component={Dashboard} />
                       <Route exact path='/Home/Offers' component={CardGrid} />
                       <Route exact path='/Home/Offers/:offerId' component={CardDetails} />
                       <Route exact path='/Home/Profile' component={Profile} />
                    </Switch>
                </div>
              </MuiThemeProvider>
            </div>
         </Router>
    );
  }
}
