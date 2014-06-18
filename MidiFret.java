/*
 * To change this license header, choose License Headers in Project Properties.
 */

package explorer;

/**
 *
 * @author E3S / Eric P Hohlfeld Copyright 2014 All Rights Reserved
 */
public class MidiFret extends javax.swing.JToggleButton implements Runnable {

    	//eclipse told me I need this
	private static final long serialVersionUID = -1624226476941801601L;
	
	private int freq;
	private String note;
    	final MidiSynth synth = new MidiSynth();
    	javax.swing.JToggleButton button;
    	public int getFreq (String note){
        
        // Maps note name to MIDI pitch index        
        switch(note){
             case "0C":
                freq = 12;
                break;
            case "0C#":
                freq = 13;
                break;
            case "0D":
                freq = 14;
                break;
            case "0D#":
                freq = 15;
                break;
            case "0E":
                freq = 16;
                break;
            case "0F":
                freq = 17;
                break;
            case "0F#":
                freq = 18;
                break;
            case "0G":
                freq = 19;
                break;
            case "0G#":
                freq = 20;
                break;
            case "0A":
                freq = 21;
                break;
            case "0A#":
                freq = 22;
                break;
            case "0B":
                freq = 23;
                break;
            case "1C":
                freq = 24;
                break;
            case "1C#":
                freq = 25;
                break;
            case "1D":
                freq = 26;
                break;
            case "1D#":
                freq = 27;
                break;
            case "1E":
                freq = 28;
                break;
            case "1F":
                freq = 29;
                break;
            case "1F#":
                freq = 30;
                break;
            case "1G":
                freq = 31;
                break;
            case "1G#":
                freq = 32;
                break;
            case "1A":
                freq = 33;
                break;
            case "1A#":
                freq = 34;
                break;
            case "1B":
                freq = 35;
                break;
            case "2C":
                freq = 36;
                break;
            case "2C#":
                freq = 37;
                break;
            case "2D":
                freq = 38;
                break;
            case "2D#":
                freq = 39;
                break;
            case "2E":
                freq = 40;
                break;
            case "2F":
                freq = 41;
                break;
            case "2F#":
                freq = 42;
                break;
            case "2G":
                freq = 43;
                break;
            case "2G#":
                freq = 44;
                break;
            case "2A":
                freq = 45;
                break;
            case "2A#":
                freq = 46;
                break;
            case "2B":
                freq = 47;
                break;
            case "3C":
                freq = 48;
                break;
            case "3C#":
                freq = 49;
                break;
            case "3D":
                freq = 50;
                break;
            case "3D#":
                freq = 51;
                break;
            case "3E":
                freq = 52;
                break;
            case "3F":
                freq = 53;
                break;
            case "3F#":
                freq = 54;
                break;
            case "3G":
                freq = 55;
                break;
            case "3G#":
                freq = 56;
                break;
            case "3A": 
                freq = 57;
                break;
            case "3A#":
                freq = 58;
                break;
            case "3B":
                freq = 59;
                break;
            case "4C":
                freq = 60;
                break;
            case "4C#":
                freq = 61;
                break;
            case "4D":
                freq = 62;
                break;
            case "4D#":
                freq = 63;
                break;
            case "4E":
                freq = 64;
                break;
            case "4F":
                freq = 65;
                break;
            case "4F#":
                freq = 66;
                break;
            case "4G":
                freq = 67;
                break;
            case "4G#":
                freq = 68;
                break;
            case "4A":
                freq = 69;
                break;
            case "4A#":
                freq = 70;
                break;
            case "4B":
                freq = 71;
                break;
            case "5C":
                freq = 72;
                break;
            case "5C#":
                freq = 73;
                break;
            case "5D":
                freq = 74;
                break;
            case "5D#":
                freq = 75;
                break;
            case "5E":
                freq = 76;
                break;
            case "5F":
                freq = 77;
                break;
            case "5F#":
                freq = 78;
                break;
            case "5G":
                freq = 79;
                break;
            case "5G#":
                freq = 80;
                break;
            case "5A":
                freq = 81;
                break;
            case "5A#":
                freq = 82;
                break;
            case "5B":
                freq = 83;
                break;
            case "6C":
                freq = 84;
                break;
            case "6C#":
                freq = 85;
                break;
            case "6D":
                freq = 86;
                break;
            case "6D#":
                freq = 87;
                break;
            case "6E":
                freq = 88;
                break;
            case "6F":
                freq = 89;
                break;
            case "6F#":
                freq = 90;
                break;
            case "6G":
                freq = 91;
                break;
            case "6G#":
                freq = 92;
                break;
            case "6A":
                freq = 93;
                break;
            case "6A#":
                freq = 94;
                break;
            case "6B":
                freq = 95;
                break;
            case "7C":
                freq = 96;
                break;
            case "7C#":
                freq = 97;
                break;
            case "7D":
                freq = 98;
                break;
            case "7D#":
                freq = 99;
                break;
            case "7E":
                freq = 100;
                break;
            case "7F":
                freq = 101;
                break;
            case "7F#":
                freq = 102;
                break;
            case "7G":
                freq = 103;
                break;
            case "7G#":
                freq = 104;
                break;
            case "7A":
                freq = 105;
                break;
            case "7A#":
                freq = 106;
                break;
            case "7B":
                freq = 107;
                break;
            case "8C":
                freq = 108;
                break;
            case "8C#":
                freq = 109;
                break;
            case "8D":
                freq = 110;
                break;
            case "8D#":
                freq = 111;
                break;
            case "8E":
                freq = 112;
                break;
            case "8F":
                freq = 113;
                break;
            case "8F#":
                freq = 114;
                break;
            case "8G":
                freq = 115;
                break;
            case "8G#":
                freq = 116;
                break;
            case "8A":
                freq = 117;
                break;
            case "8A#":
                freq = 118;
                break;
            case "8B":
                freq = 119;
                break;
            case "9C":
                freq = 120;
                break;
                
            default:
                break;
        }
        return freq;
    }
    
    // CONSTRUCTOR
    public MidiFret () {
    	 setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
         setPreferredSize(new java.awt.Dimension(50, 20));
         addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseReleased(java.awt.event.MouseEvent evt) {
                 react();
             }
         });
         button = this;
    }
    
    //OLD CONSTRUCTOR
    public MidiFret (javax.swing.JToggleButton Button){
        button = Button;
    }
    
    public void react(){
        if(this.button.isSelected()){
            this.playFret();
        }
        if(!button.isSelected()){
            this.stop();
        }
    }
    
    // Play the current note set for the open string
    public void playOpen() {
        note = this.button.getText();
        freq = getFreq(note);
        
        synth.MidiStart();
        synth.midiChannel[0].programChange(0, 25); // ensure this is a nice sound for a brief note play
        synth.midiChannel[0].noteOn(freq, 50);
    }
    
    // Continuously play the current note set for the given fret
    private void playFret() {
        note = this.button.getText();
        freq = getFreq(note);
        synth.MidiStart();
        synth.midiChannel[0].programChange(0, 30); // ensure this is a continuous sound for a continuous note play
        synth.midiChannel[0].noteOn(freq, 50);
    }
    
    // Used to terminate the playing of a continuous note
    private void stop() {
        synth.midiChannel[0].noteOff(freq, 0);
    }

    @Override
    public void run() {
        //the only thing this does is allow the instantiation of new frets as threads
    }
    
}
