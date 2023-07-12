package mom;
import java.util.Scanner;   
   
public class Vigenere   
{   
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
    
    public static String generateKey(String str, String key)
    {
     
        for (int i = 0; ; i++)
        {
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }
      
    public static String encryptData(String inputStr, String shiftKey)   
    {     
          
        String encryptStr = "";   
          
        for (int i = 0; i < inputStr.length(); i++)   
        {   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));   
            int posKey = ALPHABET.indexOf(shiftKey.charAt(i)); 
              
            int encryptPos = (posKey + pos) % 26;   
            char encryptChar = ALPHABET.charAt(encryptPos);   
              
            encryptStr += encryptChar;   
        }   
          
        return encryptStr;   
    }   
      
    public static String decryptData(String inputStr, String shiftKey)   
    {   
          
        String decryptStr = "";   
          
        for (int i = 0; i < inputStr.length(); i++)   
        {   
              
            int pos = ALPHABET.indexOf(inputStr.charAt(i)); 
            int posKey = ALPHABET.indexOf(shiftKey.charAt(i));
              
            int decryptPos = (pos - posKey) % 26;   
              
            if (decryptPos < 0){   
                decryptPos = ALPHABET.length() + decryptPos;   
            }   
            char decryptChar = ALPHABET.charAt(decryptPos);   
              
            decryptStr += decryptChar;   
        }   
        return decryptStr;   
    }   
      
    public static void main(String[] args)   
    {   
        Scanner sc = new Scanner(System.in);   
          
        System.out.println("Enter a string: ");   
        String inputStr = sc.nextLine().toLowerCase();   
          
        System.out.println("Enter the key: ");   
        String shiftKey = sc.nextLine();  
        
        shiftKey = generateKey(inputStr, shiftKey);
          
        System.out.println("Encrypted Data ===> "+encryptData(inputStr, shiftKey));   
        System.out.println("Decrypted Data ===> "+decryptData(encryptData(inputStr, shiftKey), shiftKey));   
          
        sc.close();   
    }   
} 