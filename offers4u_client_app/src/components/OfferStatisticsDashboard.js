import React, {Component} from 'react';
import { Container, Row, Col } from 'reactstrap';
import { Table } from 'reactstrap';

import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

import * as Api from "../services/Api";

/**
 * A more complex example, allowing the table height to be set, and key boolean properties to be toggled.
 */
export default class OfferStatisticsDashboard extends Component {

  constructor(props) {
      super(props);
      this.state = {
        offerStatistics: [],
        homeUrl: ''
      };
  }

  componentWillMount() {
      console.log(this.props);
      this.setState({homeUrl:"/Home/"+this.props.data.loggedInUser+"/Offer"});
      Api.getReports()
      .then(data => {this.setState({offerStatistics:data})});
  }

  handleToggle = (event, toggled) => {
    this.setState({
      [event.target.name]: toggled,
    });
  };

  handleChange = (event) => {
    this.setState({height: event.target.value});
  };

  render() {
    return (
      <div width="80%" align="left">
        <Breadcrumb>
          <BreadcrumbItem><a href={this.state.homeUrl}>Home</a></BreadcrumbItem>
          <BreadcrumbItem active>Dashboard</BreadcrumbItem>
        </Breadcrumb>
        <Container>
            <Row>
              <Col>
              <Table striped responsive>
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>Offer Name</th>
                        <th>Offer Type</th>
                        <th>Merchant</th>
                        <th>Category</th>
                        <th>Total Roll Outs</th>
                        <th>Total Interest</th>
                        <th>Total Availed</th>
                        <th>ROI</th>
                      </tr>
                    </thead>
                    <tbody>
                      {this.state.offerStatistics.map( (row, index) => (
                      <tr key={index}>
                        <th>#</th>
                        <td>{row.offer.name}</td>
                        <td>{row.offer.offerType}</td>
                        <td>{row.offer.merchant.merchantName}</td>
                        <td>{row.offer.category.categoryName}</td>
                        <td>{row.totalRollOuts}</td>
                        <td>{row.totalInterested}</td>
                        <td>{row.totalAvailed}</td>
                        <td>{row.offer.subscriptionCost}</td>
                      </tr>
                      ))}
                    </tbody>
                  </Table>
                </Col>
              </Row>
          </Container>
      </div>
    );
  }
}
