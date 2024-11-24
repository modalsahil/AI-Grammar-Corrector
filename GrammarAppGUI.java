import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

/** Creates the GUI for the program
 * 
 * Created by Sahil Sahota
 * 
 */
public class GrammarAppGUI extends JFrame implements ActionListener, FocusListener{

private JFrame frame;
private JTextField userInput; //where user puts input. 
private JTextField output; //holds output 

private JPanel buttonPanel; //holds fix and clear button

private JButton fixGrammarButton;
private JButton clearButton; 
private JButton copyButton;

private GrammarApp grammarApp = new GrammarApp(); //needs instance of the api source code

public static void main(String[] args) {
    new GrammarAppGUI();
}

/** Constructor for Grammar App, creates GUI.
 * 
 * @param nothing  
 * @return launches the gui
 * 
 */
public GrammarAppGUI() {
    frame = new JFrame("Grammar App");
        frame.setSize(500, 400);
        frame.setLayout(null); // Using BorderLayout for main layout
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userInput = new JTextField("Enter text here...");
        userInput.setBounds(12, 10, 450, 100);
        userInput.setEditable(true);
        userInput.addFocusListener(this);
        frame.add(userInput, BorderLayout.NORTH); // Adding userInput to the north position

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBounds(125,125,200,50);
        frame.add(buttonPanel, FlowLayout.CENTER); // Adding buttonPanel to the south position

        fixGrammarButton = new JButton("Fix Grammar");
        fixGrammarButton.setSize(100,50);
        fixGrammarButton.addActionListener(this);
        buttonPanel.add(fixGrammarButton);

        clearButton = new JButton("Clear");
        clearButton.setSize(100,50);
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        output = new JTextField("Fixed grammar...");
        output.setBounds(12, 180, 450, 100);
        output.setEditable(false);
        frame.add(output); // Adding output to the center position


        copyButton = new JButton("Copy");
        copyButton.addActionListener(this);
        copyButton.setBounds(200,300,80,50);
        frame.add(copyButton);


        frame.setVisible(true);
}



/** Handles all the JButton interactions
 */
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==fixGrammarButton) {
        grammarApp.setUserInput(userInput.getText());
        output.setText(grammarApp.fixGrammar());

    }
    if(e.getSource()==clearButton) {
        userInput.setText("Enter text here...");
        output.setText("fix grammar goes here");
    }
    if(e.getSource()==copyButton) {
        StringSelection transferableOutput = new StringSelection(output.getText());
        Clipboard clipboard =  Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(transferableOutput, null);
       
    }
    }

    /** Used for the textbox in order to have shadow text.
     * 
     */
@Override
public void focusGained(FocusEvent e ) {
    if(userInput.getText().equals("Enter text here...")) {
        userInput.setText("");

    }
    } 

@Override
public void focusLost(FocusEvent arg0) {
    
}


}



