 import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Simple {
	 AudioClip currentMusic;
	 File file = null;
	 AudioClip ac = null;

	public void loopplay(String x) {
		try {
			file = new File(x);
			ac = Applet.newAudioClip(file.toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		currentMusic = ac;
		currentMusic.loop();
	}
	public void play(String x){
		try {
			file = new File(x);
			ac = Applet.newAudioClip(file.toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		currentMusic = ac;
		currentMusic.play();
	}
	public void stop()
	{
		currentMusic.stop();
	}
}