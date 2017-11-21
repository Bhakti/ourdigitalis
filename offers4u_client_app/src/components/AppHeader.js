import React, {Component} from 'react';
import AppBar from 'material-ui/AppBar';
import { Link } from 'react-router-dom';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MenuItem from 'material-ui/MenuItem';
import MoreVertIcon from 'material-ui/svg-icons/navigation/more-vert';

const Logged = (props) => (
  <IconMenu
    {...props}
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
    <MenuItem primaryText="Sign out" />
  </IconMenu>
);

Logged.muiName = 'IconMenu';

/**
 * This example is taking advantage of the composability of the `AppBar`
 * to render different components depending on the application state.
 */
class AppHeader extends Component {
  render() {
    return (
      <div>
        <Link to={'/Home/Dashboard'}>Temp Home</Link>
        <Link to={'/Login'}>Temp Login</Link>
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
