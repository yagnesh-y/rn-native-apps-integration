"use strict";

import React, { useEffect } from "react";
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  Linking,
  NativeModules,
  NativeEventEmitter
} from "react-native";
import { createAppContainer } from "react-navigation";
import { createStackNavigator } from "react-navigation-stack";
// import "react-native-gesture-handler";

const ScreenOne = props => {
  useEffect(() => {
    const eventEmitter = new NativeEventEmitter(NativeModules.StartActivity);
    eventEmitter.addListener("bottomSheet", event => {
      console.log(event);
      if (event.bottomSheetState == "showAlert") {
        alert(
          "This is react native. Android's native told me to show this alert."
        );
      }
    });
  }, []);

  const handleScreeen = () => props.navigation.navigate("two");

  const handleNative = () => NativeModules.StartActivity.startAct("");

  const showBottomSheet = () => NativeModules.StartActivity.showBottomSheet();

  return (
    <View style={styles.container}>
      <Text style={styles.screen}>Screen One</Text>
      <TouchableOpacity onPress={showBottomSheet}>
        <Text>Show bottom sheet</Text>
      </TouchableOpacity>

      <TouchableOpacity onPress={handleScreeen}>
        <Text>Go to Screen 2</Text>
      </TouchableOpacity>

      <TouchableOpacity onPress={handleNative}>
        <Text>Go to native</Text>
      </TouchableOpacity>
    </View>
  );
};

const ScreenTwo = props => {
  const handleNative = () => props.navigation.navigate("one");

  return (
    <View style={styles.container}>
      <Text style={styles.screen}>Screen Two</Text>
      <TouchableOpacity onPress={handleNative}>
        <Text>Go to Screen 1</Text>
      </TouchableOpacity>
    </View>
  );
};

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center"
  },
  screen: {
    fontSize: 20,
    textAlign: "center",
    margin: 10
  }
});

const App = props => {
  console.log("props ", props);
  const Stack = createAppContainer(
    createStackNavigator(
      {
        one: ScreenOne,
        two: ScreenTwo
      },
      { initialRouteName: props.screen }
    )
  );
  return <Stack screenProps={props} />;
};

AppRegistry.registerComponent("ScreenOne", () => App);
// AppRegistry.registerComponent("ScreenTwo", () => ScreenTwo);
