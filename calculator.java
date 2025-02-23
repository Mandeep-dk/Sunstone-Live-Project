import java.awt.*;  
import java.awt.event.*;  

class calculator {  
    calculator() {  
        Frame f = new Frame("Simple Calculator");  

        // Text field for input & result
        TextField tf = new TextField();  
        tf.setBounds(60, 50, 200, 30);  
        
        Label label = new Label("Input will appear here");  
        label.setBounds(50, 100, 300, 30); 
        
      
        // Addition Button
        Button addButton = new Button("+");  
        addButton.setBounds(60, 100, 50, 30);  
        addButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                tf.setText(tf.getText() + "+"); // Append + to the existing text
                tf.requestFocus();
                tf.setCaretPosition(tf.getText().length());
            }  
        });   

        Button equalButton = new Button("=");
        equalButton.setBounds(110, 100, 50, 30);
        equalButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {  
                try {  
                    String input = tf.getText().trim();

                    if (input.contains("+")) {
                        String[] numbers = input.split("\\+");
                        int num1 = Integer.parseInt(numbers[0].trim());  
                        int num2 = Integer.parseInt(numbers[1].trim());  
                        tf.setText(String.valueOf(num1 + num2));  

                    } else if (input.contains("-")) {
                        String[] numbers = input.split("\\-");
                        int num1 = Integer.parseInt(numbers[0].trim());  
                        int num2 = Integer.parseInt(numbers[1].trim());  
                        tf.setText(String.valueOf(num1 - num2));  

                    } 
                } catch (NumberFormatException ex) {  
                    tf.setText("Invalid input!");  
                }  
            }  
        });

        // Add components to frame
        f.add(tf);  
        f.add(addButton);  
        f.add(equalButton);  

        // Frame settings
        f.setSize(300, 200);  
        f.setLayout(null);  
        f.setVisible(true);  

        // Close Frame when clicking X
        f.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                f.dispose();  
            }  
        });  
    }  

    public static void main(String[] args) {  
        new calculator();  
    }  
}
