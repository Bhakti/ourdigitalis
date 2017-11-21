import React from 'react';
import { Card, CardTitle, CardHeader, CardFooter, CardText,  CardSubtitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';
import FlatButton from 'material-ui/FlatButton';

export default class OfferCard extends React.Component {
  render() {
    return (
        <Card body inverse color="primary">
          <CardHeader>
            <img width="50%" src={this.props.offer.merchant.merchantLogoSmall}  alt="{this.props.offer.merchant.merchantName}" />
            <p className="offerTag"><span>{this.props.offer.offerType}</span></p>
          </CardHeader>
          <CardBody>
          <CardTitle>{this.props.offer.name}</CardTitle>
            <CardSubtitle>{this.props.offer.merchant.merchantName}</CardSubtitle>
            <CardText>{this.props.offer.description}
            </CardText>
            <FlatButton className="offerShowDetails">
              <Link to={"/Home/Offers/"+this.props.offer.id}
                  key={this.props.offer.id}>
                  Show Details
              </Link>
            </FlatButton>
          </CardBody>
          <CardFooter>
            <h6>Expires on : {this.props.offer.endDate}</h6>
          </CardFooter>
        </Card>
  );
}
}
