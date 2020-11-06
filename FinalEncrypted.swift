

import Foundation
import UIKit

class FinalEncrypted: UIViewController {

    
    //Vars and Outlets
    
    @IBOutlet weak var finalText: UITextView!
    
    open var thisText : String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print(thisText + "basnan")
        finalText.text = thisText

        
        // Do any additional setup after loading the view.
    } 

    
    @IBAction func restart(_ sender: Any) {
    finalText.text = ""
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
