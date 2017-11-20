import React from 'react';
import { Card, Button,  CardTitle, CardText,  CardSubtitle, CardBody } from 'reactstrap';

export default class OfferCard extends React.Component {



  render() {
    return (
        <Card body inverse color="primary">
          <img src={this.props.offer.merchant.merchantLogoSmall}  alt="{this.props.offer.merchant.merchantName}" />
          {this.props.offer.offerType}
          <CardBody>
            <CardTitle>{this.props.offer.name}</CardTitle>
            <CardSubtitle>{this.props.offer.merchant.merchantName}</CardSubtitle>
            <CardText>{this.props.offer.description}</CardText>
            Expires on : {this.props.offer.endDate}<span>           </span> <Button>Grab Me</Button>

          </CardBody>
        </Card>
  );
}
}
