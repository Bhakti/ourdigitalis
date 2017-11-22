import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import {browserHistory} from 'react-router';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppHeader from './AppHeader';
import Home from './Home';
import Landing from './Landing';
import CardGrid from './CardGrid';
import CardDetails from './CardDetails';
import Dashboard from './Dashboard';
import Profile from './Profile';

export default class Main extends Component {

  constructor() {
      super();
      var customer;
      this.state = {
        hasLogin:true,
        loggedInUser:null,
        offers: [],
        categories: [],
        merchants:[]
      }
    }

  componentWillMount() {
      Api.getCategories()
      .then(data => {
            this.setState({categories:data})
      });

      Api.getMerchants()
      .then(data => {
            this.setState({merchants:data})
      });

      //call conditionally depending on params customerId, customerType, selectedCategoryName, selectedMerchantName
      Api.getOffers()
      .then(data => {
            this.setState({offers:data})
      });
  }

  render() {
      return (
        <Router history={browserHistory}>
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
                       <Route exact path='/Home/Offers' render={(props) => (
                          <CardGrid {...props} offers={this.state.offers}/>
                       )}/>
                       <Route exact path='/Home/Offers/:offerId' render={(props) => (
                            <CardDetails {...props} offers={this.state.offers}/>
                       )}/>
                       <Route exact path='/Home/Profile' render={(props) => (
                            <Profile {...props} customer={this.state.loggedInUser}/>
                       )}/>
                    </Switch>
                </div>
              </MuiThemeProvider>
            </div>
         </Router>
    );
  }
}
