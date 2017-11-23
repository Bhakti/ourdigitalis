import React from 'react';
import { CardLink, Card, Button, CardTitle, CardHeader, CardFooter, CardText,  CardSubtitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class OfferCard extends React.Component {

    constructor(props) {
        super(props);
        this.offerClicked = this.offerClicked.bind(this);
        this.state = {
          offer:this.props.offer,
          imgSrc: require('../static/images/merchants/'+this.props.offer.merchant.merchantLogoLarge)
        }
    }

    offerClicked(event) {
        //Write code to availOffer
    }

    render() {
      return (
          <Card body>
            <CardHeader><div width="100%" align="right">{this.state.offer.offerType}</div></CardHeader>
            <img width="50%" src={this.state.imgSrc} alt=""/>
            <CardBody>
              <CardTitle>{this.state.offer.name}</CardTitle>
              <CardSubtitle><div width="100%" align="right">{this.state.offer.merchant.merchantName}</div></CardSubtitle>
              <CardText>{this.state.offer.description}</CardText>
              <div width="100%" align="right">
                <CardLink><Link to={"/Home/Offers/"+this.state.offer.offerId}
                    key={this.state.offer.offerId}  onClick={(event) => this.offerClicked(event)}>
                    Show Details
                </Link></CardLink>
              </div>
            </CardBody>
            <CardFooter className="text-muted">
              Expires on {this.state.offer.endDate}
            </CardFooter>
          </Card>
      );
   }
}
