import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, withRouter } from 'react-router-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppHeader from './components/AppHeader';
import Landing from './components/Landing';
import CardGrid from './components/CardGrid';
import CardDetails from './components/CardDetails';
import OfferStatisticsDashboard from './components/OfferStatisticsDashboard';
import Profile from './components/Profile';
import Login from './components/Login';
import * as Api from "./services/Api";

export default class App extends Component {

  constructor(props) {
      super(props);
      console.log(this.props);
      this.handlerPostLoginSuccess = this.handlerPostLoginSuccess.bind(this)
      this.handlerPostLogoutSuccess = this.handlerPostLogoutSuccess.bind(this)
      this.getOffers = this.getOffers.bind(this)

      this.state = {
        hasLogin:false,
        loggedInUser:null,
        customer:null,
        categories: [],
        merchants:[],
        offers:[],
        recommendedOffers:[]
      }
  }

  componentDidMount() {
    console.log(this.props);
  }

  handlerPostLoginSuccess(customerId) {
     console.log(customerId);
     this.setState({
       hasLogin:true,
       loggedInUser: customerId
     })
     if(this.state.loggedInUser) {
         Api.getCustomer(this.state.loggedInUser)
         .then(data => {
              this.setState({customer:data})
              if(data) {
                  this.getOffers();
              } else {
                console.log("customer not found");
              }
         });
     } else {
       console.log("Not Logged In");
     }
  }

  getOffers() {
    console.log(this.state.customer);
    //call conditionally depending on params customerId, customerType, selectedCategoryName, selectedMerchantName
    if(this.state.customer.customerType === 'admin') {
      Api.getOffers()
      .then(data => {
            this.setState({offers:data})
      });
    } else if(this.state.customer.customerType === 'merchant') {
      Api.getCategoryMerchantOffers(this.state.customer.name)
      .then(data => {
            this.setState({offers:data})
      });
    } else {
      this.setState({recommendedOffers:this.state.customer.recommendedOffers})
    }
  }

  handlerPostLogoutSuccess() {
    this.setState({
        hasLogin:false,
        loggedInUser: null
      })
  }

  render() {
      return (
          <Router >
              <div>
                <MuiThemeProvider>
                  <div width="80%" align="left">
                      <br/>
                      <AppHeader hasLogin={this.state.hasLogin} actionPostLogoutSuccess="{this.handlerPostLogoutSuccess}"/>
                      <br/>
                      <Switch>
                         <Route exact path='/' render={(props) => (
                            <Landing {...props} actionPostLoginSuccess={this.handlerPostLoginSuccess}/>
                         )}/>

                         <Route exact path='/Login'  render={(props) => (
                            <Landing {...props} actionPostLoginSuccess={this.handlerPostLoginSuccess}/>
                         )}/>

                         <Route exact path='/Logout' component={Login}
                            parentContext={this} handler={this.handlerPostLogoutSuccess}/>

                         <Route exact path='/Home/OfferStatisticsDashboard' render={(props) => (
                            <OfferStatisticsDashboard {...props} data={this.state}/>
                         )}/>

                         <Route exact path='/Home/:customerId/Offers' render={(props) => (
                              <CardGrid {...props} data={this.state} />
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


withRouter(App);
