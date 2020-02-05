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

7. .app file can be found at ~/Library/Developer/Xcode/DerivedData/<app name>/Build/Products/Release-iphoneos/<appname>

8. Create .ipa

   - Create folder Payload.
   - Paste .app file into Payload folder.
   - Compress the Payload folder.
   - Change the name you want and put extension as .ipa

     mkdir Payload
     cd Payload
     ln -s ../Runner.app
     cd ..
     zip -r app.ipa Payload

9. Upload the .ipa file to app center.

10. Done!
