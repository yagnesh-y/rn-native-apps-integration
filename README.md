# building for ios

## Run the bundling

1. react-native bundle --entry-file index.js --platform ios --dev false --bundle-output ios/index.jsbundle --assets-dest ios

Open the Xcode -> Select project target -> add index.jsbundle to Copy Bundle Resource in Build Phases

Comment out 'NSAppTransportSecurity' from info.plist

2. Products->Scheme->Edit scheme -> Change build configuration to RELEASE

3. Uncomment the prod line and comment out the dev line in ReactViewController.swift

4. Change device -> Generic iOS device

5. Product -> Clean

6. Product -> Build

7. .app file can be found at ~/Library/Developer/Xcode/DerivedData/<app name>/Build/Products/Release-iphoneos/<appname> You can use this file to create an ipa file. OR FOLLOW STEP 8 through xCode.

8. Follow the same steps as you would usually do for regular ios app.

- Select proper provisioning/distribution profile in xcode.
- Select Generic Device in xcode.
- Product -> Archive
- Product -> Distribute
  You can even create the .ipa file. Through Archive -> Distribute -> Distribute for development. Upload this ipa file to appcenter.
