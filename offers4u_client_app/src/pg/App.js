import React, { Component } from 'react';
import Hello from './components/Hello';
import logo from './static/images/logo.jpg';
import offersE4U from './static/images/offersE4U.jpg';

import './static/css/App.css';

import custOffers from './static/data/customer_offers.js';

class Button extends React.Component {
  render() {
    return (
      <button className="button button-primary">
        <i className="fa fa-chevron-right"></i> Find out more
      </button>
    )
  }
}


class CardHeader extends React.Component {
  render() {
    const { image, category } = this.props;
    var style = {
        backgroundImage: 'url(' + image + ')',
    };
    return (
      <header style={style} className="card-header">
        <h4 className="card-header--title">{category}</h4>
      </header>
    )
  }
}


class CardBody extends React.Component {
  render() {
    return (
      <div className="card-body">
        <p className="date">March 20 2015</p>

        <h2>{this.props.title}</h2>

        <p className="body-content">{this.props.text}</p>

        <Button />
      </div>
    )
  }
}


class Card extends React.Component {
  render() {
    return (
      <article className="card">
        <CardHeader category={this.props.details.category} image={this.props.details.image}/>
        <CardBody title={this.props.details.title} text={this.props.details.text}/>
      </article>
    )
  }
}

class App extends Component {

  // state will have user
	// state will have module name
	// state will have offers

	constructor() {
    super();

    this.state = {
      recommendedOffers: custOffers
    }
  }
  componentWillMount() {
    this.setState({
      recommendedOffers: custOffers
    });
  }




  render() {

    return (
      <div>
        <div>
          <img src={logo} className="App-logo" alt="Offers 4 U" />
        </div>
        <img src={offersE4U}  alt="Offers 4 U" />
				<div className="app-card-list" id="app-card-list">
					{
						Object
						.keys(this.state.recommendedOffers)
						.map(key => <Card key={key} index={key} details={this.state.recommendedOffers[key]}/>)
					}
			</div>
      </div>
    );
  }
}

export default App;
