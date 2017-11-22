import React from 'react';
import { CardColumns } from 'reactstrap';
import OfferCard from './OfferCard';
import CategoryDDMenu from './CategoryDDMenu';
import HomeNav from './HomeNav';
import * as Api from "../services/Api";

export default class CardGrid extends React.Component {

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
      console.log(this.state);
      var offerList = Object.keys(this.state.offers)
      .map(key => <OfferCard key={key} index={key} offer={this.state.offers[key]}/>)
      return (
        <div width="80%" align="left">
          <HomeNav/>
          <CategoryDDMenu categories={this.state.categories}/>
          <CardColumns>
              {offerList}
          </CardColumns>
        </div>
    );
  }
}
