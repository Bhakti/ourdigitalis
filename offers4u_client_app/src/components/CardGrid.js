import React from 'react';
import { CardColumns } from 'reactstrap';

import OfferCard from './OfferCard';

export default class CardGrid extends React.Component {
  render() {
      var offerList = Object.keys(this.props.offers)
      .map(key => <OfferCard key={key} index={key} offer={this.props.offers[key]}/>)
      return (
        <div width="80%" align="left">
          <CardColumns>
              {offerList}
          </CardColumns>
        </div>
    );
  }
}
