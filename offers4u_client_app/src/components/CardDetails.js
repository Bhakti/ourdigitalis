import React from 'react';
import { Card, Button,  CardTitle, CardText,  CardSubtitle, CardBody, CardHeader, CardFooter } from 'reactstrap';
import { Container, Row, Col } from 'reactstrap';
import MenuItem from 'material-ui/MenuItem';
import Menu from 'material-ui/Menu';
import * as Api from "../services/Api";
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

export default class CardDetails extends React.Component {
  constructor(props) {
      super(props);
      console.log(this.props);
      this.state = {
        offer:'',
        divContent:''
      }
  }

  componentWillMount() {
    //issue -- we need offer else by offer id we can get offer here...
    console.log(this.props.match.params);

    Api.getOffersById(this.props.match.params.offerId)
    .then(data => {
          console.log(data);
          this.setState(
            {
              offer:data,
              divContent: data.offerDetails
            }
          )
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
        <Breadcrumb>
          <BreadcrumbItem><a href="/Home/Offers">Home</a></BreadcrumbItem>
          <BreadcrumbItem><a href="/Home/Offers">Offers</a></BreadcrumbItem>
          <BreadcrumbItem active>{this.state.offer.id}</BreadcrumbItem>
        </Breadcrumb>
          <Container>
          <Row>
              <Col xs="4">
                <Card>
                  <CardHeader>
                    <img width="50%"/>
                    <p className="offerTag"><span></span></p>
                  </CardHeader>
                  <CardBody>
                  <CardTitle>{this.state.offer.name}</CardTitle>
                    <CardSubtitle></CardSubtitle>
                    <CardText>{this.state.offer.description}</CardText>
                    <Button primary="true" className="offerShowDetails">Grab Me</Button>
                  </CardBody>
                  <CardFooter>
                    <h6>Expires on : {this.state.offer.endDate}</h6>
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
