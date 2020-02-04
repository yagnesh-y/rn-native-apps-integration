//
//  StartActivity.swift
//  native-ios
//
//  Created by karan Rawal on 04/02/20.
//  Copyright © 2020 karan Rawal. All rights reserved.
//

import Foundation

@objc(StartActivity)
class StartActivity: NSObject {
    @objc
    func startAct(_ screenName: String) {
        DispatchQueue.main.async {
            
//            let mainStoryboard: UIStoryboard = UIStoryboard(name: "Main", bundle: nil)
//            let rootViewController = mainStoryboard.instantiateViewController(withIdentifier: "rootViewController")
//
//            UIApplication.shared.keyWindow?.rootViewController = rootViewController;
       
            let rootViewController = UIApplication.shared.delegate?.window??.rootViewController as! UINavigationController
            
            let vc2 = UIStoryboard.init(name: "Main", bundle: Bundle.main).instantiateViewController(withIdentifier: "viewController2") as! ViewController2
                        
            rootViewController.pushViewController(vc2, animated: true)
        }
    }
}
