//
//  ViewController.swift
//  native-ios
//
//  Created by karan Rawal on 04/02/20.
//  Copyright © 2020 karan Rawal. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBAction func onOpenDefaultScreenTap(_ sender: Any) {
        let rvc = ReactViewController(screen: nil)
        self.navigationController?.pushViewController(rvc, animated: true)
    }
    
    
    @IBAction func onOpenSecondScreenTap(_ sender: Any) {
        let rvc = ReactViewController(screen: "two")
        self.navigationController?.pushViewController(rvc, animated: true)
    }
}

