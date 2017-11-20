import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class Hello extends React.Component {
	render() {
		return(
			<div className="container">
				<h1> Getting Started</h1>
			</div>
		);
	}
}

class Button extends React.Component {

	handleClick  = () => {
		this.props.onClickFunction(this.props.incrementValue);
	};

	render() {
		return(
			<div>
				<button onClick={this.handleClick}>
				{this.props.incrementValue}
				</button>
			</div>
		);
	}
}

const Result = (props) => {
		return(
		<div>{props.counter}</div>
	);
};

class App extends Component {

	state = {counter:0};

	incrementCounter = (incrementValue) => {
		//aviod race condition
		this.setState((prevState) => ({
				counter: prevState.counter + incrementValue
			}));
	};


  render() {

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Offers 4 U</h1>
        </header>

        <p className="App-intro">
          Hello Bhakti
        </p>

				<Hello/>
				<Button incrementValue={1} onClickFunction={this.incrementCounter}/>
				<Button incrementValue={5} onClickFunction={this.incrementCounter}/>
				<Button incrementValue={10} onClickFunction={this.incrementCounter}/>
				<Result counter={this.state.counter}/>
      </div>
    );
  }
}

export default App;
