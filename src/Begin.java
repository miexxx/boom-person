import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Begin extends JFrame {

	JButton jb1, jb2;
	JTextField jtf;
	JPasswordField jpwd;
	JLabel jl1, jl2;
	ImageIcon background;
	JPanel imagePanel;

	// TODO Auto-generated method stub
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Begin();
	}

	public Begin() {

		background = new ImageIcon("µÇÂ¼/µÇÂ¼.jpg");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.setLayout(null);
		this.add(label, new Integer(Integer.MIN_VALUE));
		this.setBounds(500, 300, background.getIconWidth(), background.getIconHeight());
		jb1 = new JButton(new ImageIcon("µÇÂ¼/°´Å¥.png"));
		this.getRootPane().setDefaultButton(jb1);
		jb1.setBounds(186, 299, 215, 37);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = jtf.getText();
				String x = a;
				String b = new String(jpwd.getPassword());
				String y = b;
				if (a.equals("1508180121") && b.equals("123")) {
					System.out.println("µÇÂ½³É¹¦");
					BoomPersonGame game = new BoomPersonGame();
					dispose();
				} else {
					Database user = new Database();
					if (user.checkuser(x, y)) {
						System.out.println("µÇÂ½³É¹¦");
						BoomPersonGame game = new BoomPersonGame();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü,Çë¼ì²éÕËºÅÃÜÂë");
					}
				}
			}
		});
		jb2 = new JButton(new ImageIcon("µÇÂ¼/ÍË³ö.png"));
		jb2.setBounds(533, 24, 35, 35);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		jtf = new JTextField(10);
		Font font = new Font("ºÚÌå", Font.PLAIN, 20);
		jtf.setFont(font);
		Font font1 = new Font("", Font.PLAIN, 30);
		jtf.setBounds(234, 222, 163, 30);
		jpwd = new JPasswordField(10);
		jpwd.setFont(font1);
		jpwd.setBounds(234, 262, 163, 30);
		this.add(jb2);
		this.add(jb1);
		this.add(jtf);
		this.add(jpwd);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setResizable(false);
		this.setUndecorated(true);
		this.setTitle("ÓÎÏ·µÇÂ¼½çÃæ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}