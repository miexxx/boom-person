import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

class BoomPersonGame extends JFrame implements ActionListener {
	JMenuBar menuber = new JMenuBar();
	JMenu jm1 = new JMenu("ѡ��");// ���ò˵�
	JMenuItem jm1_3 = new JMenuItem("����ģʽ(��ͼ1)");
	JMenuItem jm1_1 = new JMenuItem("˫��ģʽ(��ͼ1)");
	JMenuItem jm1_2 = new JMenuItem("�˳���Ϸ");
	JMenuItem jm1_4 = new JMenuItem("��Ϸ˵��");
	JMenuItem jm1_5 = new JMenuItem("�л�����");
	JMenuItem jm1_6 = new JMenuItem("�ر�����");
	JMenuItem jm1_7 = new JMenuItem("����ģʽ(��ͼ2)");
	JMenuItem jm1_8 = new JMenuItem("˫��ģʽ(��ͼ2)");
	MyPanel mp = null;
	Simple BGM = null;
	String BGM1 = "music/BGM1.wav";
	String BGM2 = "music/BGM2.wav";
	String BGM3 = "music/BGM3.wav";
	int i = 1;

	public BoomPersonGame() {
		BGM = new Simple();
		mp = new MyPanel();
		mp.setGame3("���", "����");
		Thread t = new Thread(mp);
		t.start();
		jm1.add(jm1_3);
		jm1.add(jm1_1);
		jm1.add(jm1_7);
		jm1.add(jm1_8);
		jm1.add(jm1_4);
		jm1.add(jm1_5);
		jm1.add(jm1_6);
		jm1.add(jm1_2);
		menuber.add(jm1);
		this.setJMenuBar(menuber);
		jm1_2.addActionListener(this);
		jm1_2.setActionCommand("�˳�");
		jm1_1.addActionListener(this);
		jm1_1.setActionCommand("˫��");
		jm1_3.addActionListener(this);
		jm1_3.setActionCommand("����");
		jm1_7.addActionListener(this);
		jm1_7.setActionCommand("����2");
		jm1_8.addActionListener(this);
		jm1_8.setActionCommand("˫��2");
		jm1_4.addActionListener(this);
		jm1_4.setActionCommand("˵��");
		jm1_5.addActionListener(this);
		jm1_5.setActionCommand("����");
		jm1_6.addActionListener(this);
		jm1_6.setActionCommand("�ر�����");
		this.setTitle("ը����");
		this.setBounds(550, 100, 910, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(mp);
		this.addKeyListener(mp);
		BGM.loopplay(BGM3);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("�˳�")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("˫��")) {
			this.remove(mp);
			BGM.stop();
			BGM.loopplay(BGM3);

			mp = new MyPanel();
			mp.mode = true;
			mp.setGame2("���", "����");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("����")) {
			BGM.stop();
			BGM.loopplay(BGM3);

			this.remove(mp);
			mp = new MyPanel();
			mp.mode = false;
			mp.setGame2("���", "����");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("˫��2")) {
			this.remove(mp);
			BGM.stop();
			BGM.loopplay(BGM3);

			mp = new MyPanel();
			mp.mode = true;
			mp.setGame3("���", "����");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("����2")) {
			BGM.stop();
			BGM.loopplay(BGM3);

			this.remove(mp);
			mp = new MyPanel();
			mp.mode = false;
			mp.setGame3("���", "����");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("˵��")) {
			JOptionPane.showMessageDialog(null, "1P��ң�W A S D ���Ʒ���,SPACE ����ը��      2P���: �� �� �� �� ���Ʒ���  ENTER����ը��");
		} else if (e.getActionCommand().equals("����")) {
			BGM.stop();
			i = (i + 1) % 3;
			if (i == 0) {
				BGM.loopplay(BGM1);
			} else if (i == 1) {
				BGM.loopplay(BGM2);
			} else {
				BGM.loopplay(BGM3);
			}
		} else if (e.getActionCommand().equals("�ر�����")) {
			BGM.stop();
		}
	}
}
