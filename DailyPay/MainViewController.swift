//
//  MainViewController.swift
//  DailyPay
//
//  Created by 김미영 on 2022/10/31.
//

import UIKit

class MainViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var TableView: UITableView!
    let tableArray: [String] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will
     
     
     , sender: Any?) {
     ue.destination.
        // Pass the selected object to the new view controller.
    }
    */

    
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.tableArray.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell...
        //cell.textLabel?.text = tableArray[indexPath.row].item

        return cell
    }
    
    

    
} // MainViewController

