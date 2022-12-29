//
//  AddViewController.swift
//  DailyPay
//
//  Created by 김미영 on 2022/10/31.
//

import UIKit

class AddViewController: UIViewController {

    @IBOutlet var lblPrice: UILabel!
    
    var userIsInTheMiddleOfTyping = false
    var num1: String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        //lblPrice.text = "ㅇㅇㅇㅇ"
    }
    
    
    @IBAction func btnNum(_ sender: UIButton) {
        let digit = sender.currentTitle!
        	
        if userIsInTheMiddleOfTyping {
            let textCurrentlyInDisplay = lblPrice.text!
            lblPrice.text = textCurrentlyInDisplay + digit
        }else{
            lblPrice.text = digit
        }
        userIsInTheMiddleOfTyping = true
        
    }
    
    
    
    @IBAction func btnClear(_ sender: UIButton) {
        lblPrice.text?.removeAll()
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
