import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import { Container, Row, Col } from 'reactstrap';
import CardGrid from './CardGrid';
import OffersMenu from './OffersMenu';
import staticoffers from '../static/data/offers.js';

//should also route between CardGrid, CardDetails, Profile

export default class Home extends React.Component {

  constructor() {
    super();
    this.state = {
      recommendedOffers: staticoffers,
    }
  }

  componentWillMount() {
    //get all categories, get all merchant
    //Call api to get recommendedOffers, All offers,
    this.setState({
      recommendedOffers: staticoffers
    });
  }

  render() {
      return (
        <div>
          <MuiThemeProvider>
            <OffersMenu/>
            <Container>
              <Row>
                <Col>
                  <OffersMenu/>
                  <h3>Recommended Offers 4 U</h3>
                  <CardGrid offers={this.state.recommendedOffers}/>
                  </Col>
                </Row>
            </Container>
          </MuiThemeProvider>
        </div>
    );
  }
}
