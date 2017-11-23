import React from 'react';
import { CardColumns } from 'reactstrap';
import { Container, Row, Col } from 'reactstrap';
import OfferCard from './OfferCard';
import { Link } from 'react-router-dom';
import * as Api from "../services/Api";
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

export default class CardGrid extends React.Component {

  constructor(props) {
      super(props);
      this.getOffers = this.getOffers.bind(this)
      this.state = {
        offers:this.props.data.offers,
        recommendedOffers:this.props.data.recommendedOffers
      }
  }

  shouldComponentUpdate(nextProps, nextState) {
      console.log(nextProps);
      this.props = nextProps;
      return true;
  }

  componentWillMount() {
    console.log(this.props);
    console.log(this.state);
    console.log(this.props.match.params.customerId);
    //call conditionally depending on params customerId, customerType, selectedCategoryName, selectedMerchantName
    if(this.props.match.params.customerId) {
        Api.getCustomer(this.props.match.params.customerId)
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

 render() {
      var offerList;
      if(this.state.recommendedOffers && this.state.recommendedOffers.length > 0) {
        console.log("check me");
        offerList = Object.keys(this.state.recommendedOffers)
        .map(key => <OfferCard key={key} index={key} offer={this.state.recommendedOffers[key].offer}/>)
      } else if(this.state.offers && this.state.offers.length > 0) {
        offerList = Object.keys(this.state.offers)
        .map(key => <OfferCard key={key} index={key} offer={this.state.offers[key]}/>)
      }
      return (
        <div width="80%" align="left">
            <Breadcrumb>
              <BreadcrumbItem><a>Home</a></BreadcrumbItem>
              <BreadcrumbItem active>Offers</BreadcrumbItem>
            </Breadcrumb>
            <Container>
                <Row>
                  <Col>
                  <Link to='/Home/OfferStatisticsDashboard'>Dashboard</Link>
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
