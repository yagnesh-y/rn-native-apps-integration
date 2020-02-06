package com.example.native_android;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CustomBottomSheetDialog extends BottomSheetDialogFragment {
    private ReactApplicationContext context;

    public CustomBottomSheetDialog(ReactApplicationContext reactApplicationContext) {
        this.context = reactApplicationContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.bottom_sheet, container, false);

        Button b = v.findViewById(R.id.bCallReactNative);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WritableMap params = Arguments.createMap();
                params.putString("bottomSheetState", "showAlert");

                context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("bottomSheet", params);
            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        WritableMap params = Arguments.createMap();
        params.putString("bottomSheetState", "attached");

        this.context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("bottomSheet", params);
        super.onAttach(context);
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        WritableMap params = Arguments.createMap();
        params.putString("bottomSheetState", "dismissed");

        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("bottomSheet", params);
        super.onDismiss(dialog);
    }
}
