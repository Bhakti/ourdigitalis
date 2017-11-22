import React from 'react';
import { CardColumns } from 'reactstrap';
import { Container, Row, Col } from 'reactstrap';
import OfferCard from './OfferCard';
import CategoryDDMenu from './CategoryDDMenu';
import { Link } from 'react-router-dom';
import * as Api from "../services/Api";
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

export default class CardGrid extends React.Component {

  constructor(props) {
      super(props);

      this.state = {
        offers:[]
      }

      Api.getOffers()
      .then(data => {
            this.setState({offers:data})
      });
  }

  componentWillMount() {
    Api.getOffers()
    .then(data => {
          this.setState({offers:data})
    });
  }

  render() {
      var offerList = Object.keys(this.state.offers)
      .map(key => <OfferCard key={key} index={key} offer={this.state.offers[key]}/>)
      return (
        <div width="80%" align="left">
            <Breadcrumb>
              <BreadcrumbItem><a href="/Home/Offers">Home</a></BreadcrumbItem>
              <BreadcrumbItem active>Offers</BreadcrumbItem>
            </Breadcrumb>
            <Container>
                <Row>
                  <Col>
                  <Link to='/Home/Dashboard'>Dashboard</Link>
                  <CardColumns>
                      {offerList}
                  </CardColumns>
                  </Col>
                </Row>
            </Container>
        </div>
    );
  }
}
