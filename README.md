
# react-native-minew-bridge

## Getting started

`$ npm install react-native-minew-bridge --save`

### Mostly automatic installation

`$ react-native link react-native-minew-bridge`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-minew-bridge` and add `RNMinewBridge.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNMinewBridge.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.minewbridge.reactnative.RNMinewBridgePackage;` to the imports at the top of the file
  - Add `new RNMinewBridgePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-minew-bridge'
  	project(':react-native-minew-bridge').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-minew-bridge/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-minew-bridge')
  	```


## Usage
```javascript
import RNMinewBridge from 'react-native-minew-bridge';

// TODO: What to do with the module?
RNMinewBridge;
```
  