
package tudien;

import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.Voice;
public class Voice1  {    
    VoiceManager voiceManager;
    Voice voice;
    public Voice1(String text){
        System.setProperty("mbrola.base", "mbrola");
        voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("mbrola_us1");
        voice.allocate();       
    }
    public void say(String text){
        this.voice.speak(text);
    }
    
    
}
