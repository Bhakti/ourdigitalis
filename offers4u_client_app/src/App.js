import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, withRouter } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppHeader from './components/AppHeader';
import Landing from './components/Landing';
import CardGrid from './components/CardGrid';
import CardDetails from './components/CardDetails';
import Dashboard from './components/Dashboard';
import Profile from './components/Profile';
import Login from './components/Login';
import * as Api from "./services/Api";

export default class App extends Component {

  constructor(props) {
      super(props);
      this.handlerPostLoginSuccess = this.handlerPostLoginSuccess.bind(this)
      this.handlerPostLogoutSuccess = this.handlerPostLogoutSuccess.bind(this)
      this.getOffers = this.getOffers.bind(this)

      this.state = {
        hasLogin:false,
        loggedInUser:null,
        customer:null,
        categories: [],
        merchants:[],
        offers:[]
      }

      Api.getCategories()
      .then(data => {
            this.setState({categories:data})
      });

      Api.getMerchants()
      .then(data => {
            this.setState({merchants:data})
      });
  }

  componentDidMount() {
      Api.getCategories()
      .then(data => {
            this.setState({categories:data})
      });

      Api.getMerchants()
      .then(data => {
            this.setState({merchants:data})
      });
  }

  handlerPostLoginSuccess(customerId) {
     console.log(customerId);
     this.setState({
       hasLogin:true,
       loggedInUser: customerId
     })

     //call conditionally depending on params customerId, customerType, selectedCategoryName, selectedMerchantName
     Api.getCustomer(this.state.loggedInUser)
     .then(data => {
           this.setState({customer:data})
           this.getOffers();
     });
  }

  getOffers() {
    console.log(this.state.customer);
    //call conditionally depending on params customerId, customerType, selectedCategoryName, selectedMerchantName
    /*if(this.state.customer.customerType === 'admin') {
      Api.getOffers()
      .then(data => {
            this.setState({offers:data})
      });
    } else if(this.state.customer.customerType === 'merchant') {
      Api.getCategoryMerchantOffers(customerId)
      .then(data => {
            this.setState({offers:data})
      });
    } else {
      Api.getClientOffers(customerId)
      .then(data => {
            this.setState({offers:data})
      });
    }*/
    Api.getOffers()
    .then(data => {
          this.setState({offers:data})
    });
    console.log(this.state.offers);
  }

  handlerPostLogoutSuccess() {
    this.setState({
        hasLogin:false,
        loggedInUser: null
      })
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
                         <Route exact path='/' render={(props) => (
                            <Landing {...props} actionPostLoginSuccess={this.handlerPostLoginSuccess}/>
                         )}/>

                         <Route exact path='/Login'  render={(props) => (
                            <Landing {...props} actionPostLoginSuccess={this.handlerPostLoginSuccess}/>
                         )}/>

                         <Route exact path='/Logout' component={Login}
                            parentContext={this} handler = {this.handlerPostLogoutSuccess}/>

                         <Route exact path='/Home/Dashboard' render={(props) => (
                            <Dashboard {...props} data={this.state}/>
                         )}/>

                         <Route exact path='/Home/Offers' render={(props) => (
                              <CardGrid {...props} data={this.state}/>
                         )}/>

                         <Route exact path='/Home/Offers/:offerId' render={(props) => (
                              <CardDetails {...props} data={this.state}/>
                         )}/>

                         <Route exact path='/Home/Profile' render={(props) => (
                              <Profile {...props} data={this.state.loggedInUser}/>
                         )}/>

                      </Switch>
                  </div>
                </MuiThemeProvider>
              </div>
           </Router>
    );
  }
}
