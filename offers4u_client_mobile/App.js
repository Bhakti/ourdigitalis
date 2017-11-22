import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import HelloWorld from './components/HelloWorld';

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text>Offers4U</Text>
        <HelloWorld/>
        <Text>Offer 1</Text>
        <Text>Offer 2</Text>

        <Text>Shake your phone to open the developer menu.</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
