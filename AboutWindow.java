package explorer;

import javax.swing.*;

public class AboutWindow extends JFrame implements Runnable {
    

    private static final long serialVersionUID = 5058720927291970878L;

    AboutWindow(){
	initComponents();
	setVisible(true);
    }
    
    private void initComponents(){
	
	setTitle("About Guitar Tuning Explorer");
	setName("aboutWindow");
	
	//make the labels
	JLabel textHTML = new JLabel ();
	textHTML.setText(""
		+ "<html>"
		+ "<head>"
		+"<style>"
		+ "h1 {font-size: 20px}"
		+ "h2 {font-size: 13px}"
		+ "</style>"
		+ "</head>"
		+ "<body>"
			+ "<h1>"
				+ "<b>"
					+ "About the Author<br>"
				+ "</b>"
			+ "</h1>"
			+ "<h2>"
				+ "This program was written by Eric Hohlfeld to allow experimentation with alternate<br>"
				+ "tunings for stringed instruments, without having to retune in real life.<br>"
			+ "</h2>"
			+ "<br>"
			+ "<br>"
			+ "<h1>"
				+ "<b>"
					+ "Donations are welcome!<br>"
				+"</b>"
			+ "</h1>"
			+ "<h2>"
				+ "Donations can be sent via PayPal to eric_h@123mail.org<br>"
			+ "</h2>"
		+ "</body>"
		+ "</html>"
	);
	
	//make the layout
	GroupLayout layout = new GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	
	//HORIZONTAL
		GroupLayout.SequentialGroup baseHorizSeqGroup = layout.createSequentialGroup();
		baseHorizSeqGroup.addContainerGap();
		baseHorizSeqGroup.addComponent(textHTML);
		baseHorizSeqGroup.addContainerGap();
		layout.setHorizontalGroup(baseHorizSeqGroup);
		
	//VERTICAL
		GroupLayout.SequentialGroup baseVertSeqGroup = layout.createSequentialGroup();
		baseVertSeqGroup.addContainerGap();
		baseVertSeqGroup.addComponent(textHTML);
		baseVertSeqGroup.addContainerGap();
		layout.setVerticalGroup(baseVertSeqGroup);
		
	//COMPLETE
		pack();
	
    }
    
    @Override
    public void run() {
	
	//initComponents();
	
    }

}
