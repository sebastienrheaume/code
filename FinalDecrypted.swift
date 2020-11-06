

import Foundation
import UIKit

class FinalDecrypted: UIViewController {

    //Vars and Outlets
    
    
    @IBOutlet weak var finalText2: UITextView!
    
    open var thisText2 : String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print(thisText2 + "basnan")
        finalText2.text = thisText2
        // Do any additional setup after loading the view.
    }

    @IBAction func restart2(_ sender: Any) {
    finalText2.text = ""
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
