import React from 'react';
import { CardLink, Card,  Button, CardTitle, CardText,CardBody, CardHeader, CardFooter } from 'reactstrap';
import { Container, Row, Col } from 'reactstrap';
import MenuItem from 'material-ui/MenuItem';
import Menu from 'material-ui/Menu';
import * as Api from "../services/Api";
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

export default class CardDetails extends React.Component {
  constructor(props) {
      super(props);
      console.log(this.props);
      this.availOffer = this.availOffer.bind(this);
      this.state = {
        offer:'',
        divContent:'',
        imgSrc:null,
        homeUrl:''
      }
  }

  componentWillMount() {
    console.log(this.props);
    this.setState({homeUrl:"/Home/"+this.props.data.loggedInUser+"/Offer"});

    Api.getOffersById(this.props.match.params.offerId)
    .then(data => {
          console.log(data);
          this.setState(
            {
              offer:data,
              divContent: data.offerDetails,
              imgSrc: require('../static/images/merchants/'+data.merchant.merchantLogoSmall),
              homeUrl: "/Home/"+this.props.data.loggedInUser+"/Offer"
            }
          )
    });
  }

  handleClick1(event){
    this.setState({
      divContent: this.state.offer.offerDetails
    });
  }

  handleClick2(event){
    this.setState({
      divContent: this.state.offer.tAndC
    });
  }

  availOffer(event){
      //Write code to availOffer
  }

  render() {
      return (
        <div width="80%" align="left">
        <Breadcrumb>
          <BreadcrumbItem><a href={this.state.homeUrl}>Home</a></BreadcrumbItem>
          <BreadcrumbItem><a href={this.state.homeUrl}>Offers</a></BreadcrumbItem>
          <BreadcrumbItem active>{this.state.offer.id}</BreadcrumbItem>
        </Breadcrumb>
          <Container>
          <Row>
              <Col xs="4">
                <Card body>
                  <CardHeader><div width="100%" align="right">{this.state.offer.offerType}</div></CardHeader>
                  <img width="50%" src={this.state.imgSrc} alt=""/>
                  <CardBody>
                    <CardTitle>{this.state.offer.name}</CardTitle>
                    <CardText>{this.state.offer.description}</CardText>
                    <div width="100%" align="right">
                    <Button color="warning" onClick={(event) => this.availOffer(event)}>
                        Grab Me
                    </Button>
                    </div>
                  </CardBody>
                  <CardFooter className="text-muted">
                    Expires on {this.state.offer.endDate}
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
