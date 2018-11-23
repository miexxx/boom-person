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
	JMenu jm1 = new JMenu("选项");// 设置菜单
	JMenuItem jm1_3 = new JMenuItem("单人模式(地图1)");
	JMenuItem jm1_1 = new JMenuItem("双人模式(地图1)");
	JMenuItem jm1_2 = new JMenuItem("退出游戏");
	JMenuItem jm1_4 = new JMenuItem("游戏说明");
	JMenuItem jm1_5 = new JMenuItem("切换音乐");
	JMenuItem jm1_6 = new JMenuItem("关闭音乐");
	JMenuItem jm1_7 = new JMenuItem("单人模式(地图2)");
	JMenuItem jm1_8 = new JMenuItem("双人模式(地图2)");
	MyPanel mp = null;
	Simple BGM = null;
	String BGM1 = "music/BGM1.wav";
	String BGM2 = "music/BGM2.wav";
	String BGM3 = "music/BGM3.wav";
	int i = 1;

	public BoomPersonGame() {
		BGM = new Simple();
		mp = new MyPanel();
		mp.setGame3("悟空", "狐狸");
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
		jm1_2.setActionCommand("退出");
		jm1_1.addActionListener(this);
		jm1_1.setActionCommand("双人");
		jm1_3.addActionListener(this);
		jm1_3.setActionCommand("单人");
		jm1_7.addActionListener(this);
		jm1_7.setActionCommand("单人2");
		jm1_8.addActionListener(this);
		jm1_8.setActionCommand("双人2");
		jm1_4.addActionListener(this);
		jm1_4.setActionCommand("说明");
		jm1_5.addActionListener(this);
		jm1_5.setActionCommand("音乐");
		jm1_6.addActionListener(this);
		jm1_6.setActionCommand("关闭音乐");
		this.setTitle("炸弹人");
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
		if (e.getActionCommand().equals("退出")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("双人")) {
			this.remove(mp);
			BGM.stop();
			BGM.loopplay(BGM3);

			mp = new MyPanel();
			mp.mode = true;
			mp.setGame2("悟空", "狐狸");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("单人")) {
			BGM.stop();
			BGM.loopplay(BGM3);

			this.remove(mp);
			mp = new MyPanel();
			mp.mode = false;
			mp.setGame2("悟空", "狐狸");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("双人2")) {
			this.remove(mp);
			BGM.stop();
			BGM.loopplay(BGM3);

			mp = new MyPanel();
			mp.mode = true;
			mp.setGame3("悟空", "狐狸");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("单人2")) {
			BGM.stop();
			BGM.loopplay(BGM3);

			this.remove(mp);
			mp = new MyPanel();
			mp.mode = false;
			mp.setGame3("悟空", "狐狸");
			Thread t = new Thread(mp);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.revalidate();
		} else if (e.getActionCommand().equals("说明")) {
			JOptionPane.showMessageDialog(null, "1P玩家：W A S D 控制方向,SPACE 放置炸弹      2P玩家: ↑ ↓ ← → 控制方向  ENTER放置炸弹");
		} else if (e.getActionCommand().equals("音乐")) {
			BGM.stop();
			i = (i + 1) % 3;
			if (i == 0) {
				BGM.loopplay(BGM1);
			} else if (i == 1) {
				BGM.loopplay(BGM2);
			} else {
				BGM.loopplay(BGM3);
			}
		} else if (e.getActionCommand().equals("关闭音乐")) {
			BGM.stop();
		}
	}
}
