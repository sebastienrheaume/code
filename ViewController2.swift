

import UIKit

class ViewController2: UIViewController {

    //Varriables and Outlets
    
    @IBOutlet weak var encryptedText: UITextField!
    
    var dunencryptedText29: String = String()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }// End ViewDidLoad

    
    @IBAction func dekryptButton(_ sender: Any) {
    print(encryptedText)
    
        
        let dunencryptedTextStr: String = encryptedText.text!
        let dencryptedText1 = dunencryptedTextStr.replacingOccurrences(of: "∫", with: " ")
        let dencryptedText2 = dencryptedText1.replacingOccurrences(of: "/", with: "a")
        let dencryptedText3 = dencryptedText2.replacingOccurrences(of: "œ", with: "b")
        let dencryptedText4 = dencryptedText3.replacingOccurrences(of: "¶", with: "c")
        let dencryptedText5 = dencryptedText4.replacingOccurrences(of: ";", with: "d")
        let dencryptedText6 = dencryptedText5.replacingOccurrences(of: "~", with: "e")
        let dencryptedText7 = dencryptedText6.replacingOccurrences(of: "+", with: "f")
        let dencryptedText8 = dencryptedText7.replacingOccurrences(of: "¬", with: "g")
        let dencryptedText9 = dencryptedText8.replacingOccurrences(of: "^", with: "h")
        let dencryptedText10 = dencryptedText9.replacingOccurrences(of: "¡", with: "i")
        let dencryptedText11 = dencryptedText10.replacingOccurrences(of: "£", with: "j")
        let dencryptedText12 = dencryptedText11.replacingOccurrences(of: "}", with: "k")
        let dencryptedText13 = dencryptedText12.replacingOccurrences(of: "µ", with: "l")
        let dencryptedText14 = dencryptedText13.replacingOccurrences(of: "<", with: "m")
        let dencryptedText15 = dencryptedText14.replacingOccurrences(of: "@", with: "n")
        let dencryptedText16 = dencryptedText15.replacingOccurrences(of: "=", with: "o")
        let dencryptedText17 = dencryptedText16.replacingOccurrences(of: "%", with: "p")
        let dencryptedText18 = dencryptedText17.replacingOccurrences(of: "∂", with: "q")
        let dencryptedText19 = dencryptedText18.replacingOccurrences(of: "{", with: "r")
        let dencryptedText20 = dencryptedText19.replacingOccurrences(of: ">", with: "s")
        let dencryptedText21 = dencryptedText20.replacingOccurrences(of: "_", with: "t")
        let dencryptedText22 = dencryptedText21.replacingOccurrences(of: "[", with: "u")
        let dencryptedText23 = dencryptedText22.replacingOccurrences(of: "ø", with: "v")
        let dencryptedText24 = dencryptedText23.replacingOccurrences(of: "*", with: "w")
        let dencryptedText25 = dencryptedText24.replacingOccurrences(of: "∑", with: "x")
        let dencryptedText26 = dencryptedText25.replacingOccurrences(of: "]", with: "y")
        let dencryptedText27 = dencryptedText26.replacingOccurrences(of: "Ω", with: "z")
        let dencryptedText28 = dencryptedText27.replacingOccurrences(of: ".", with: ",")
        dunencryptedText29 = dencryptedText28.replacingOccurrences(of: "|", with: "?");
    
        let pasteboard2 = UIPasteboard.general
        
        pasteboard2.string = dunencryptedText29
        
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "segue2" {
            let DestViewController2  = segue.destination as! FinalDecrypted
            DestViewController2.thisText2 = dunencryptedText29
            
        }
        
    }
    
    
    
    

}
