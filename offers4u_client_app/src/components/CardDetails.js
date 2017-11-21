import React from 'react';
import { Card, Button,  CardTitle, CardText,  CardSubtitle, CardBody, CardHeader, CardFooter } from 'reactstrap';
import { Container, Row, Col } from 'reactstrap';
import MenuItem from 'material-ui/MenuItem';
import Menu from 'material-ui/Menu';
import axios from 'axios';

export default class CardDetails extends React.Component {
  constructor() {
    super();
    this.state = {
     offer:'',
     divContent:''
   }
  }

  componentWillMount() {

    var localOffers = this.props.route.offers;

    console.log(localOffers);

    var id = this.props.params.offerId;

    console.log(id);

    var offer = localOffers.filter(offer => {
            if(offer.id === id) {
                return offer;
            }
        });

    this.setState({
      divContent: offer.offerDetails
    });
  }

  handleClick1(event){
    this.setState({
      divContent: 'this.props.offer.offerDetail'
    });
  }

  handleClick2(event){
    this.setState({
      divContent: 'this.props.offer.tAndC'
    });
  }

  render() {
      return (
        <div width="80%" align="left">
          <Container>
          <Row>
              <Col xs="4">
                <Card body inverse color="primary">
                  <CardHeader>
                    <img width="50%" src={this.props.offer.merchant.merchantLogoSmall}  alt="{this.props.offer.merchant.merchantName}" />
                    <p class="offerTag"><span>{this.props.offer.offerType}</span></p>
                  </CardHeader>
                  <CardBody>
                  <CardTitle>{this.props.offer.name}</CardTitle>
                    <CardSubtitle>{this.props.offer.merchant.merchantName}</CardSubtitle>
                    <CardText>{this.props.offer.description}
                    </CardText>
                    <Button primary="true" class="offerShowDetails">Grab Me</Button>
                  </CardBody>
                  <CardFooter>
                    <h6>Expires on : {this.props.offer.endDate}</h6>
                  </CardFooter>
                </Card>
              </Col>
              <Col xs="3">
                <Menu>
                  <MenuItem primaryText="Details" onClick={(event) => this.handleClick1(event)}/>
                  <MenuItem primaryText="Terms And Conditions" onClick={(event) => this.handleClick2(event)}/>
                </Menu>
              </Col>
              <Col sm="4">
                  <div>{this.state.divContent}</div>
              </Col>
          </Row>
          </Container>
        </div>
    );
  }
}
