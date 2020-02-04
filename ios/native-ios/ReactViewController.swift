//
//  ReactViewController.swift
//  native-ios
//
//  Created by karan Rawal on 04/02/20.
//  Copyright © 2020 karan Rawal. All rights reserved.
//

import React
import Foundation
import UIKit

class ReactViewController: UIViewController {
    var screen = "one";
    
    init(screen: String?) {
        if (screen != nil) {
            self.screen = screen!;
        }
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        let jsCodeLocation = URL(string: "http://localhost:8081/index.bundle?platform=ios")
        let initialProps:NSDictionary = ["screen": screen] // two
        
        let rootView = RCTRootView(
            bundleURL: jsCodeLocation!,
            moduleName: "ScreenOne",
            initialProperties: initialProps as [NSObject : AnyObject],
            launchOptions: nil
        )
        view = rootView
    }
}
