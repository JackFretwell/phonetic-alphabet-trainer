import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class PhoneticAlphabet implements ActionListener{

    JFrame frame;
    JTextField textField;
    JTextField textField1;

    Font myFont = new Font("Dialog", Font.BOLD, 30);
    Font myFont1 = new Font("Dialog", Font.BOLD, 150);
    Font myFont2 = new Font("Dialog", Font.BOLD, 50);
    Font myFont3 = new Font("Dialog", Font.BOLD, 20);

    String storedText;
    public String letter;
    HashMap<String, String> alphabet = new HashMap<String, String>();

}