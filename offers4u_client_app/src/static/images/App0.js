import React, { Component } from 'react';

import offersE4U from './static/images/offersE4U.jpg';

import {CardGrid} from './components/CardGrid';

import './static/css/App.css';

import staticoffers from './static/data/offers.js';

class App extends Component {

  // state will have user
	// state will have module name
	// state will have offers

	constructor() {
    super();

    this.state = {
      recommendedOffers: staticoffers
    }
  }
  componentWillMount() {
    this.setState({
      recommendedOffers: staticoffers
    });
  }
  render() {

    return (
      <div>
        <div>
          <h1>Digitalis</h1>
          <img src={offersE4U}  alt="Offers 4 U" />
        </div>
				<CardGrid offers={this.state.recommendedOffers}/>
      </div>
    );
  }
}

export default App;
