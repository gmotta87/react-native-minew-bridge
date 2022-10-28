
package com.minewbridge.reactnative;

import com.facebook.react.bridge.Promise;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.minewtech.mttrackit.MTTrackerManager;
import com.minewtech.mttrackit.interfaces.ScanTrackerCallback;
import com.minewtech.mttrackit.enums.BluetoothState;


import android.Manifest;

import android.util.Log;

import java.util.List;

import javax.security.auth.callback.PasswordCallback;

public class RNMinewBridgeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private ScanTrackerCallback scanTrackerCallback;
  private MTTrackerManager mTrackerTagManager;
  public RNMinewBridgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

  }


  @Override
  public String getName() {
    return "RNMinewBridge";
  }



  private void initManager() {
    mTrackerTagManager = mTrackerTagManager.getInstance(reactContext);
    /**
     * must set a 8 length password ,or app will crash.
     *
     */
    mTrackerTagManager.setPassword("minew123");
  }


  /**
   * PUBLIC REACT API
   *
   *  isAvailable()   Returns true if the fingerprint reader can be used
   */
  @ReactMethod
  public void scanDevices() {
    try {
                  // get sharedinstance of Manager
                  MTTrackerManager manager = MTTrackerManager.getInstance(reactContext);
                if(manager.checkBluetoothState() == BluetoothState.BluetoothStatePowerOn) {
                  // start scanning task.
                  // if manager found devices, this block will call back.
                  Log.d("msg", String.valueOf(manager.checkBluetoothState()));
                  manager.startScan(scanTrackerCallback);
                }
      Log.d("CalendarModule", "Create event called with name: " +  manager);

       
    } catch (Exception ex) {
      System.out.println("ERR_UNEXPECTED_EXCEPTION");
    }
  }

 


// @ReactMethod
// public void scanDevices(final Promise promise) {
//   MTTrackerManager manager = 	MTTrackerManager.getInstance(reactContext);
//   if(BLETool.isBluetoothTurnOn(reactContext)){
//       manager.startScan(new OnScanSensorResultListener() {
//           @Override
//           public void onScanSensorResult(ArrayList<SensorModule> result) {
//                System.out.println(result);
//           }
//       });
//   }
// }

  // /**
  //  * Returns fingerprint manager or null
  //  * @see https://stackoverflow.com/questions/34409969/how-to-check-device-compatibility-for-finger-print-authentication-in-android
  //  */
  // private FingerprintManager getFingerprintManager() {
  //   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
  //     return (FingerprintManager) reactContext.getSystemService(reactContext.FINGERPRINT_SERVICE);
  //   } else {
  //     return null;
  //   }
  // }
}