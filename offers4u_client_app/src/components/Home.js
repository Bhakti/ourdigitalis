import React from 'react';
import { Switch, Route } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import CardGrid from './CardGrid';
import CardDetails from './CardDetails';
import Dashboard from './Dashboard';
import Profile from './Profile';
import HomeNav from './HomeNav';
import * as Api from "../services/Api";

//should also route between CardGrid, CardDetails, Profile

export default class Home extends React.Component {

  constructor() {
      super();
      var customer;
      this.state = {
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
