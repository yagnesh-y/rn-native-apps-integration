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
    var rootView: RCTRootView?;
    
    init(screen: String?) {
        if (screen != nil) {
            self.screen = screen!;
        }
        super.init(nibName: nil, bundle: nil)
        initRootView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        initRootView()
    }
    
    func initRootView() {
        // for dev
        let jsCodeLocation = URL(string: "http://localhost:8081/index.bundle?platform=ios")
        // for prod
        // let jsCodeLocation = Bundle.main.url(forResource: "index", withExtension: "jsbundle")
        let initialProps:NSDictionary = ["screen": self.screen] // two
        
        rootView = RCTRootView(
            bundleURL: jsCodeLocation!,
            moduleName: "ScreenOne",
            initialProperties: initialProps as [NSObject : AnyObject],
            launchOptions: nil
        )
    }
    
    override func viewDidLoad() {
        view = rootView
    }
    
    override func viewWillAppear(_ animated: Bool) {
        // because reactnavigation has it's own navigation bar
        self.navigationController?.navigationBar.isHidden = true
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        // because reactnavigation has it's own navigation bar
        self.navigationController?.navigationBar.isHidden = false
    }
}
