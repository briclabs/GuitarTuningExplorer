/*
 * To change this license header, choose License Headers in Project Properties.
 */

package explorer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;	// this makes the code significantly more concise due to the number of explicit references that would otherwise have to be made to javax.swing."whatever"
import javax.swing.GroupLayout.Alignment;

/**
 * @author E3S / Eric P Hohlfeld Copyright 2014 All Rights Reserved
 */

public class ExplorerUI extends JFrame {
  
	//eclipse told me I need this
	private static final long serialVersionUID = -113721412761638881L;
	
	//for the open string spinner
	private String [] shortNotelist = new String[]{"0C", "0C#", "0D", "0D#", "0E", "0F", "0F#", "0G", "0G#", "0A", "0A#", "0B", "1C", "1C#", "1D", "1D#", "1E", "1F", "1F#", "1G", "1G#", "1A", "1A#", "1B", "2C", "2C#", "2D", "2D#", "2E", "2F", "2F#", "2G", "2G#", "2A", "2A#", "2B", "3C", "3C#", "3D", "3D#", "3E", "3F", "3F#", "3G", "3G#", "3A", "3A#", "3B", "4C", "4C#", "4D", "4D#", "4E", "4F", "4F#", "4G", "4G#", "4A", "4A#", "4B", "5C", "5C#", "5D", "5D#", "5E", "5F", "5F#", "5G", "5G#", "5A", "5A#", "5B", "6C", "6C#", "6D", "6D#", "6E", "6F", "6F#", "6G", "6G#", "6A", "6A#", "6B"};

	//for the possible notes for the frets to assume
	private String [] longNotelist = new String[]{"0C", "0C#", "0D", "0D#", "0E", "0F", "0F#", "0G", "0G#", "0A", "0A#", "0B", "1C", "1C#", "1D", "1D#", "1E", "1F", "1F#", "1G", "1G#", "1A", "1A#", "1B", "2C", "2C#", "2D", "2D#", "2E", "2F", "2F#", "2G", "2G#", "2A", "2A#", "2B", "3C", "3C#", "3D", "3D#", "3E", "3F", "3F#", "3G", "3G#", "3A", "3A#", "3B", "4C", "4C#", "4D", "4D#", "4E", "4F", "4F#", "4G", "4G#", "4A", "4A#", "4B", "5C", "5C#", "5D", "5D#", "5E", "5F", "5F#", "5G", "5G#", "5A", "5A#", "5B", "6C", "6C#", "6D", "6D#", "6E", "6F", "6F#", "6G", "6G#", "6A", "6A#", "6B", "7C", "7C#", "7D", "7D#", "7E", "7F", "7G", "7G#", "7A", "7A#", "7B", "8C", "8C#", "8D", "8D#", "8E", "8F", "8F#", "8G", "8G#", "8A", "8A#", "8B", "9C"};
	
	private JMenuItem aboutMenuItem;
	private JMenuItem exitMenuItem;
	private JMenu fileMenu;
	private JMenu aboutMenu;
	private JMenuBar menuBar;
	
	private JLabel labelInstructions;
	private JLabel labelFret01;
	private JLabel labelFret12;
	private JLabel labelFret24;
	private JLabel copyrightNotice;

	private int stringCount = 6;
	private int fretCount = 25;
	
	private List<JSpinner> strings = new ArrayList<JSpinner>();
	// Container for all frets for each string
	// Access is get(string number) get(fretforthatstring)
	private List<List<MidiFret>> frets = new ArrayList<List<MidiFret>>();	
	
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ExplorerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ExplorerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ExplorerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ExplorerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ExplorerUI().setVisible(true); 
			}
		});
	}
	
	public ExplorerUI() {
		initComponents();
	}

	private void configString(JSpinner string, int s){
	    	final int stringNum = s;
		string.setModel(new SpinnerListModel(shortNotelist));
		string.setToolTipText("String " + s);
		string.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		string.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
			    stringStateChanged(strings.get(stringNum), stringNum);
			}
		});
	}
	
	private void initComponents() {
		labelInstructions = new JLabel();
			labelInstructions.setText("Choose open notes:");
		
	    for (int s = 0; s < stringCount; s++){					// BUILD FRETS AND STORE AS COLLECTIONS ORGANIZED BY STRING... some serious magic happens here
		strings.add(new JSpinner());					// creates strings
		configString(strings.get(s), s); 							// configures strings
		List<MidiFret> currentString = new ArrayList<MidiFret>();	// fret container dec and init
		System.out.print("String " + s + " ::");						// string status console log START

		for (int f = 0; f < fretCount; f++){
		    MidiFret thisFret;											// init an instance of a fret
		    Thread fretThread = new Thread(thisFret = new MidiFret());	// init a thread consisting of that fret
		    fretThread.start();											// start that thread
		    currentString.add(thisFret);									// add the fret which has been started as a thread to the container for the currently iterated string
		    System.out.print(" " + f );		    							// fret status console log entry
		}

		frets.add(currentString);									// store the sub-collection of frets just created as the representation of the current string iteration in the main fret collection
		System.out.println();										// string status console log END
		
	    }
	    
	    System.out.println(strings.size() + " strings have been successfully initialized.");
	    System.out.println();
		
		labelFret01 = new JLabel(); // there's always a fret 1
			labelFret01.setText("Fret 01");
			
		labelFret12 = new JLabel(); // labels are only set if the number of chosen frets is enough to need the label at that position
			if (fretCount >= 12){
			    labelFret12.setText("Fret 12");
			}
			else{
			    labelFret12.setText(null);
			}
		labelFret24 = new JLabel(); // labels are only set if the number of chosen frets is enough to need the label at that position
			if (fretCount >= 24){
			    labelFret24.setText("Fret 24");
			}
			else{
			    labelFret24.setText(null);
			}
			
		copyrightNotice = new JLabel(); // nice to have this in there so you see it even without the About page
		copyrightNotice.setText("2014 Eric Hohlfeld / E3S");
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu();
			exitMenuItem = new JMenuItem();
		aboutMenu = new JMenu();
			aboutMenuItem = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Guitar Tuning Explorer");
		setName("mainWindow"); // NOI18N

		fileMenu.setMnemonic('f');
		fileMenu.setText("File");

		exitMenuItem.setMnemonic('x');
		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		aboutMenu.setMnemonic('a');
		aboutMenu.setText("About");

		aboutMenuItem.setMnemonic('a');
		aboutMenuItem.setText("About");

		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			aboutMenuItemActionPerformed(evt);
		    }
		});
		
		aboutMenu.add(aboutMenuItem);
		
		menuBar.add(aboutMenu);

		setJMenuBar(menuBar);

		GroupLayout layout = new GroupLayout(getContentPane()); // CREATES THE MAIN LAYOUT OBJECT
		getContentPane().setLayout(layout); // SETS THE CONTENT PANE TO USE THE MAIN LAYOUT OBJECT
		
		// HORIZONTAL GROUP GENERATION AND ASSIGNMENT
		
                		GroupLayout.Group baseHorizGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING); // CREATES THE BASIC HORIZONTAL LAYOUT GROUP OBJECT, WHICH IS JUST A CONTAINER
                		GroupLayout.SequentialGroup baseHorizSeqGroup = layout.createSequentialGroup(); // CREATES THE BASELINE SEQUENTIAL GROUP WHICH HOSTS THE CONTENT ITSELF
                		
                		// Add the label column to the sequential group
                		baseHorizSeqGroup.addContainerGap();
                		baseHorizSeqGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                			.addComponent(labelInstructions)
                			.addComponent(labelFret01)
                			.addComponent(labelFret12)
                			.addComponent(labelFret24));
                		baseHorizSeqGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
                
                		// Add the strings and frets dynamically (like a boss)
                		for (int s = 0; s < stringCount; s++){
                		    GroupLayout.ParallelGroup stringGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);		// creates a string group because each string must be encapsulated in its own group
                			    stringGroup.addComponent(strings.get(s), GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);
                			    for (int f = 0; f < fretCount; f++){
                				stringGroup.addComponent(frets.get(s).get(f), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                				if (s + 1 == stringCount && f + 1 == fretCount){
                				    stringGroup.addComponent(copyrightNotice, Alignment.TRAILING);
                				}
                			    }
                		    
                			    baseHorizSeqGroup.addGroup(stringGroup);
                			    System.out.println("Added string group " + s + " to the layout generator.");
                			    
                		    if ( s + 1  == stringCount){
                			baseHorizSeqGroup.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                			System.out.println("Horizontal layout generation completed.");
                			System.out.println();
                		    }
                		    else{
                			baseHorizSeqGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
                			
                		    }
                		};
                		
                		baseHorizGroup.addGroup(baseHorizSeqGroup);	// Add the baseline sequential group to the basic horizontal layout group
                		layout.setHorizontalGroup(baseHorizGroup);	// Set the horizontal group to be the basic horizontal layout group, which has been filled out with the appropriate content
                		
                // VERTICAL GROUP GENERATION AND ASSIGNMENT
                		
                		GroupLayout.Group baseVertGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING); // CREATES THE BASIC VERTICAL GROUP OBJECT, WHICH IS JUST A CONTAINER
                		GroupLayout.SequentialGroup baseVertSeqGroup = layout.createSequentialGroup(); // CREATES THE BASELINE SEQUENTIAL GROUP WHICH HOSTS THE CONTENT ITSELF
                		
                		// Add the initial container gap; no labels are added here because that ain't how vertical groups work bro
                		baseVertSeqGroup.addContainerGap();
                		
                		// Add the strings and frets dynamically (like a boss)
                		for (int f = -1; f < fretCount; f++){
                		    GroupLayout.ParallelGroup fretGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);		// creates a fret group because each fret must be encapsulated in its own group
                		    	if ( f == -1 ){
                		    	    fretGroup.addComponent(labelInstructions);
                		    	    System.out.println();
                		    	    System.out.print("Spinner added:");
                		    	    for ( int s = 0; s < stringCount; s++){
                		    		fretGroup.addComponent(strings.get(s), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                		    		System.out.print(" " + s);
                		    	    }
                		    	}
                		    	else if (f == 1){
                		    	    fretGroup.addComponent(labelFret01);
                		    	    System.out.println("Added Fret Label 1");
                		    	}
                		    	else if ( f == 12 ){
                		    	    fretGroup.addComponent(labelFret12);
                		    	    System.out.println("Added Fret Label 12");
                		    	}
                		    	else if ( f == 24){
                		    	    fretGroup.addComponent(labelFret24);
                		    	    System.out.println("Added Fret Label 24");
                		    	}
                		    	
                		    	if ( f > -1 ){
                		    	    System.out.println();
                		    	    System.out.print("Added string ");
                		    	    for (int s = 0; s < stringCount; s++){
                		    		fretGroup.addComponent(frets.get(s).get(f), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                		    		System.out.print( s + " ");
                		    	    }
                		    	    System.out.print("to fret " + f);
                		    	}
                		    	System.out.println();
                		    	    
                		    	baseVertSeqGroup.addGroup(fretGroup);
                		    	System.out.println("Added fret group" + f + " to the layout generator.");
                		    	
                		    	if ( f + 1 == fretCount){
                		    	    baseVertSeqGroup.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                		    	    baseVertSeqGroup.addComponent(copyrightNotice);
                		    	    baseVertSeqGroup.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
                		    	    System.out.println("Vertical layout generation completed.");
                		    	    System.out.println();
                		    	}
                		    	else {
                		    	    baseVertSeqGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
                		    	}
                		};
                		
                		baseVertGroup.addGroup(baseVertSeqGroup); // Add the baseline sequential group to the basic vertical layout group
                		layout.setVerticalGroup(baseVertGroup); // Set the vertical group to be the basic vertical layout group, which has been filled out with the appropriate content

                // GENERATION DONE
                		
                		pack();
		
	}

	
	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}
	
	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	    	java.awt.EventQueue.invokeLater(new Runnable() {
	    	    public void run() {
	    		new AboutWindow().setVisible(true); 
	    	    }
	    	});
	}
	
	// Open Note Change Reactions
	private void stringStateChanged(JSpinner string, int s){
	    	
	    	// relabel all frets in active string
		for (int f = 0; f < fretCount; f++){
		    frets.get(s).get(f).setText(nextPitch(string,f));
		   
		    // play the open fret
		    if (f == 0){
			frets.get(s).get(f).playOpen();			
		    }
		    
		}
	}

	
	// Method to determine appropriate label for a given fret
	private String nextPitch(JSpinner openString, int fretNum){
		//fretNum = fretNum - 1; // so that it starts performing iterations for the 1st fret instead of the 0th
		JSpinner dummyString = new JSpinner();
		dummyString.setModel(new SpinnerListModel(longNotelist));
		dummyString.setValue(openString.getValue());
		
		for(int nextFret = 0; nextFret < fretNum; nextFret++){
			dummyString.setValue(dummyString.getNextValue());
			}
		
		
		return dummyString.getValue().toString();
	}
	
}
