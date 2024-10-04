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

    PhoneticAlphabet(){
        alphabet.put("A", "Alpha");
        alphabet.put("B", "Bravo");
        alphabet.put("C", "Charlie");
        alphabet.put("D", "Delta");
        alphabet.put("E", "Echo");
        alphabet.put("F", "Foxtrot");
        alphabet.put("G", "Golf");
        alphabet.put("H", "Hotel");
        alphabet.put("I", "India");
        alphabet.put("J", "Juliet");
        alphabet.put("K", "Kilo");
        alphabet.put("L", "Lima");
        alphabet.put("M", "Mike");
        alphabet.put("N", "November");
        alphabet.put("O", "Oscar");
        alphabet.put("P", "Papa");
        alphabet.put("Q", "Quebec");
        alphabet.put("R", "Romeo");
        alphabet.put("S", "Sierra");
        alphabet.put("T", "Tango");
        alphabet.put("U", "Uniform");
        alphabet.put("V", "Victor");
        alphabet.put("W", "Whiskey");
        alphabet.put("X", "Xray");
        alphabet.put("Y", "Yankee");
        alphabet.put("Z", "Zulu");

        frame = new JFrame("Game Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(60, 320, 340, 80);
        textField.setFont(myFont);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.addActionListener(this);

        textField1 = new JTextField();
        textField1.setBounds(60, 20, 340, 280);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setEditable(false);

        getLetter();

        frame.add(textField);
        frame.add(textField1);
        frame.setVisible(true);
    }

        public void getLetter(){
            int minValue = 65;
            int maxValue = 90;
            int store = (int)Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
            letter = String.valueOf((char)store);
            textField1.setFont(myFont1);
            textField1.setText(letter);
            textField1.setBackground(Color.WHITE);
        }
        
        public static void main(String[] args){
            PhoneticAlphabet p = new PhoneticAlphabet();
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == textField){
                storedText = textField.getText();
            }

            String matchingWord = alphabet.get(letter);

            if(storedText.equals(matchingWord)){
                textField1.setFont(myFont2);
                textField1.setBackground(Color.GREEN);
                textField1.setText("Correct!");
                SwingWorker<Void, Void> worker = new SwingWorker<>(){
                    @Override
                    protected Void doInBackground() throws Exception{
                        Thread.sleep(2000);
                        return null;
                    }
                

                @Override
                protected void done(){
                    textField.setText("");
                    getLetter();
                }
            };
            worker.execute();

        }
        else{
            textField1.setFont(myFont2);
            textField1.setBackground(Color.RED);
            textField1.setText("Incorrect!");

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception{
                    Thread.sleep(2000);
                    return null;
                }

                @Override
                protected void done(){
                    textField1.setFont(myFont3);
                    textField1.setBackground(Color.RED);

                    textField1.setText("The correct answer was: " + matchingWord);
                    SwingWorker<Void, Void> finalWorker = new SwingWorker<>(){
                        @Override
                        protected Void doInBackground() throws Exception {
                            Thread.sleep(2000);
                            return null;
                        }

                        @Override
                        protected void done() {
                            textField.setText("");
                            getLetter();
                        }
                    };
                    finalWorker.execute();
                    
                    }
                
            };
            worker.execute();
        }
        }

        
    }

