/*
 * To change this license header, choose License Headers in Project Properties.
 */

package explorer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author E3S / Eric P Hohlfeld Copyright 2014 All Rights Reserved
 */
public class MidiSynth {
        private Synthesizer synthesizer;
        protected MidiChannel[] midiChannel;
        
    public MidiSynth(){
            try {
                synthesizer = MidiSystem.getSynthesizer();
                midiChannel = synthesizer.getChannels();
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(MidiSynth.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      
    public void MidiStart(){
            try {
                this.synthesizer.open();
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(MidiSynth.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void MidiStop(){
        this.synthesizer.close();
    }
}
