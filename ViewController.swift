

import UIKit
import LocalAuthentication

class ViewController: UIViewController {

    //Varriables and Outlets
    
    @IBOutlet weak var unencryptedText: UITextField!
    
    var encryptedText29: String = String()
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }//End ViewDidLoad
    
    
    @IBAction func enkryptButton(_ sender: Any) {
        print(unencryptedText.text! + "unencrypt")
        
       
        let unencryptedTextStr: String = unencryptedText.text!
        let encryptedText1 = unencryptedTextStr.replacingOccurrences(of: " ", with: "∫")
        let encryptedText2 = encryptedText1.replacingOccurrences(of: "a", with: "/")
        let encryptedText3 = encryptedText2.replacingOccurrences(of: "b", with: "œ")
        let encryptedText4 = encryptedText3.replacingOccurrences(of: "c", with: "¶")
        let encryptedText5 = encryptedText4.replacingOccurrences(of: "d", with: ";")
        let encryptedText6 = encryptedText5.replacingOccurrences(of: "e", with: "~")
        let encryptedText7 = encryptedText6.replacingOccurrences(of: "f", with: "+")
        let encryptedText8 = encryptedText7.replacingOccurrences(of: "g", with: "¬")
        let encryptedText9 = encryptedText8.replacingOccurrences(of: "h", with: "^")
        let encryptedText10 = encryptedText9.replacingOccurrences(of: "i", with: "¡")
        let encryptedText11 = encryptedText10.replacingOccurrences(of: "j", with: "£")
        let encryptedText12 = encryptedText11.replacingOccurrences(of: "k", with: "}")
        let encryptedText13 = encryptedText12.replacingOccurrences(of: "l", with: "µ")
        let encryptedText14 = encryptedText13.replacingOccurrences(of: "m", with: "<")
        let encryptedText15 = encryptedText14.replacingOccurrences(of: "n", with: "@")
        let encryptedText16 = encryptedText15.replacingOccurrences(of: "o", with: "=")
        let encryptedText17 = encryptedText16.replacingOccurrences(of: "p", with: "%")
        let encryptedText18 = encryptedText17.replacingOccurrences(of: "q", with: "∂")
        let encryptedText19 = encryptedText18.replacingOccurrences(of: "r", with: "{")
        let encryptedText20 = encryptedText19.replacingOccurrences(of: "s", with: ">")
        let encryptedText21 = encryptedText20.replacingOccurrences(of: "t", with: "_")
        let encryptedText22 = encryptedText21.replacingOccurrences(of: "u", with: "[")
        let encryptedText23 = encryptedText22.replacingOccurrences(of: "v", with: "ø")
        let encryptedText24 = encryptedText23.replacingOccurrences(of: "w", with: "*")
        let encryptedText25 = encryptedText24.replacingOccurrences(of: "x", with: "∑")
        let encryptedText26 = encryptedText25.replacingOccurrences(of: "y", with: "]")
        let encryptedText27 = encryptedText26.replacingOccurrences(of: "z", with: "Ω")
        let encryptedText28 = encryptedText27.replacingOccurrences(of: ",", with: ".")
         encryptedText29 = encryptedText28.replacingOccurrences(of: "?", with: "|");
        
        
       let pasteboard = UIPasteboard.general
       
     pasteboard.string = encryptedText29
        
        
        
        
        }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "segue1"{
        let DestViewController  = segue.destination as! FinalEncrypted
        DestViewController.thisText = encryptedText29
            print(encryptedText29)
        }
    
    }
    
    
    
    


}

