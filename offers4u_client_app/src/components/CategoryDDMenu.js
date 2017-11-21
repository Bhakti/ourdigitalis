import React from 'react';
import DropDownMenu from 'material-ui/DropDownMenu';
import Paper from 'material-ui/Paper';
import MenuItem from 'material-ui/MenuItem';


const styles = {
  customWidth: {
    width: 200,
  },
  display: 'inline-block',
  margin: '16px 32px 16px 0',
};


export default class CategoryDDMenu extends React.Component {

  constructor(props) {
    super(props);
    this.state = {value: 'Travel'};
  }

  

  handleChangeCategory = (event, index, value) => this.setState({value});

  render() {
    return (
      <div>
        <Paper style={styles}>
        <DropDownMenu value={this.state.value} onChange={this.handleChangeCategory}>
          <MenuItem value={'Travel'} primaryText="Travel" />
          <MenuItem value={'Dining'} primaryText="Dinning" />
          <MenuItem value={'Bill Payment'} primaryText="Bill Payment" />
          <MenuItem value={'Grocery'} primaryText="Grocery" />
          <MenuItem value={'Entertainment'} primaryText="Entertainment" />
          <MenuItem value={'Fashion & Accessiories'} primaryText="Fashion & Accessiories" />
          <MenuItem value={'Beauty & Health'} primaryText="Beauty & Health" />
          <MenuItem value={'Lifestyle'} primaryText="Lifestyle" />
          <MenuItem value={'Gifting'} primaryText="Gifting" />
          <MenuItem value={'Electronics'} primaryText="Electronics" />

        </DropDownMenu>
        </Paper>
      </div>
    );
  }
}
