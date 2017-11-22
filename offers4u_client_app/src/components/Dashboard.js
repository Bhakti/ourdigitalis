import React, {Component} from 'react';
import { Container, Row, Col } from 'reactstrap';
import {
  Table,
  TableBody,
  TableFooter,
  TableHeader,
  TableHeaderColumn,
  TableRow,
  TableRowColumn,
} from 'material-ui/Table';
import { Link } from 'react-router-dom';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

const styles = {
  propContainer: {
    width: 200,
    overflow: 'hidden',
    margin: '20px auto 0',
  },
  propToggleHeader: {
    margin: '20px auto 10px',
  },
};

const iconStyles = {
  marginRight: 24,
};

const tableData = [
  {
    name: 'John Smith',
    status: 'Employed',
  },
  {
    name: 'Randal White',
    status: 'Unemployed',
  },
  {
    name: 'Stephanie Sanders',
    status: 'Employed',
  },
  {
    name: 'Steve Brown',
    status: 'Employed',
  },
  {
    name: 'Joyce Whitten',
    status: 'Employed',
  },
  {
    name: 'Samuel Roberts',
    status: 'Employed',
  },
  {
    name: 'Adam Moore',
    status: 'Employed',
  },
];

/**
 * A more complex example, allowing the table height to be set, and key boolean properties to be toggled.
 */
export default class TableExampleComplex extends Component {
  state = {
    fixedHeader: true,
    fixedFooter: true,
    stripedRows: true,
    showRowHover: false,
    selectable: true,
    multiSelectable: false,
    enableSelectAll: false,
    deselectOnClickaway: true,
    showCheckboxes: false,
    height: '300px',
  };

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
          <BreadcrumbItem><a href="/Home/Offers">Home</a></BreadcrumbItem>
          <BreadcrumbItem active>Dashboard</BreadcrumbItem>
        </Breadcrumb>
        <Container>
            <Row>
              <Col>
                  <Table
                    height={this.state.height}
                    fixedHeader={this.state.fixedHeader}
                    fixedFooter={this.state.fixedFooter}
                    selectable={this.state.selectable}
                    multiSelectable={this.state.multiSelectable}
                  >
                    <TableHeader
                      displaySelectAll={this.state.showCheckboxes}
                      adjustForCheckbox={this.state.showCheckboxes}
                      enableSelectAll={this.state.enableSelectAll}
                    >
                      <TableRow>
                        <TableHeaderColumn colSpan="3" tooltip="Offer Statistics" style={{textAlign: 'center'}}>
                          Offers Statistics
                        </TableHeaderColumn>
                      </TableRow>
                      <TableRow>
                        <TableHeaderColumn tooltip="Name">Name</TableHeaderColumn>
                        <TableHeaderColumn tooltip="Type">Type</TableHeaderColumn>
                        <TableHeaderColumn tooltip="Merchant">Merchant</TableHeaderColumn>
                        <TableHeaderColumn tooltip="Category">Category</TableHeaderColumn>
                        <TableHeaderColumn tooltip="Total Offers Rolled Out">Rolled Out</TableHeaderColumn>
                        <TableHeaderColumn tooltip="Total Offers Showed Interest">Interested</TableHeaderColumn>
                        <TableHeaderColumn tooltip="Total Offers Availed">Availed</TableHeaderColumn>
                      </TableRow>
                    </TableHeader>
                    <TableBody
                      displayRowCheckbox={this.state.showCheckboxes}
                      deselectOnClickaway={this.state.deselectOnClickaway}
                      showRowHover={this.state.showRowHover}
                      stripedRows={this.state.stripedRows}
                    >
                      {tableData.map( (row, index) => (
                        <TableRow key={index}>
                          <TableRowColumn>{row.name}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                          <TableRowColumn>{row.status}</TableRowColumn>
                        </TableRow>
                        ))}
                    </TableBody>
                    <TableFooter
                      adjustForCheckbox={this.state.showCheckboxes}
                    >
                    </TableFooter>
                  </Table>
                </Col>
              </Row>
          </Container>
      </div>
    );
  }
}
