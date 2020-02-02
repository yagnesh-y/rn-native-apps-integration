package com.example.native_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
//import com.facebook.react.ReactActivityDelegate;
//import com.facebook.react.ReactRootView;
//import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.facebook.react.bridge.ReadableMap;

import java.util.HashMap;


public class BaseReactActivity extends Activity implements DefaultHardwareBackBtnHandler  {

    private ReactRootView mReactRootView;
    protected static ReactInstanceManager sReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            SoLoader.init(getApplication(), 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (sReactInstanceManager == null) {
            sReactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(getApplication())
                    .setCurrentActivity(this)
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModulePath("index.android")
                    .addPackage(new MainReactPackage())
                    .addPackage(new StartActivityPackage())
                    .addPackage(new RNGestureHandlerPackage())
                    .addPackage(new SafeAreaContextPackage())
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();
        }
    }

    protected void startReactView(String componentName, Bundle data) {
        mReactRootView = new ReactRootView(this);

        mReactRootView.startReactApplication(sReactInstanceManager, componentName, data);

        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // let Ctrl + M bring up dev menu on emulator
        if (keyCode == KeyEvent.KEYCODE_MENU && sReactInstanceManager != null) {
            sReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (sReactInstanceManager != null) {
            sReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (sReactInstanceManager != null) {
            sReactInstanceManager.onHostPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (sReactInstanceManager != null) {
            sReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (sReactInstanceManager != null) {
            sReactInstanceManager.onHostDestroy();
        }
    }

//
//    @Override
//  protected ReactActivityDelegate createReactActivityDelegate() {
//            return new ReactActivityDelegate(this, getMainComponentName()) {
//      @Override
//      protected ReactRootView createRootView() {
//                        return new RNGestureHandlerEnabledRootView(MainActivity.this);
//                     }
//    };
//          }
}
