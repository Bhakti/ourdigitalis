import React, {Component} from 'react';
import AppBar from 'material-ui/AppBar';
import { Link } from 'react-router-dom';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MenuItem from 'material-ui/MenuItem';
import MoreVertIcon from 'material-ui/svg-icons/navigation/more-vert';

class Logged extends React.Component  {
  handleLogout(event) {
    console.log("logout");
    //TODO logout remove from session.
  }

  render() {
    return (
  <IconMenu
    iconButtonElement={
      <IconButton><MoreVertIcon /></IconButton>
    }
    targetOrigin={{horizontal: 'right', vertical: 'top'}}
    anchorOrigin={{horizontal: 'right', vertical: 'top'}}
  >
    <MenuItem primaryText="">
        <Link to={"/Home/Profile/"}>
            Profile
        </Link>
    </MenuItem>
    <MenuItem primaryText="Help" />
    <MenuItem>
      <Link to={"/Login/"}>
          Logout
      </Link>
    </MenuItem>
  </IconMenu>
);
}
}

Logged.muiName = 'IconMenu';

/**
 * This example is taking advantage of the composability of the `AppBar`
 * to render different components depending on the application state.
 */
class AppHeader extends Component {
  handleLogout(event) {
    console.log("logout");
  }

  render() {
    return (
      <div>
        <AppBar
          title="Digitalis"
          iconElementRight={this.props.hasLogin ? <Logged /> : <p></p>}
        >
        </AppBar>
      </div>
    );
  }
}

export default AppHeader;
