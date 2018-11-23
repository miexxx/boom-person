import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener, Runnable {
	Image img = null;
	Image redImg = null;
	Image yellowImg = null;
	Image flower = null;
	Image plant = null;
	Image TieKuai = null;
	Image BeiKE = null;
	Image BinKuai = null;
	Image Cheng = null;
	Image SBin = null;
	Image tree = null;
	Image XueRen = null;
	Image XueShu = null;
	Image BinBin = null;
	Image Bao = null;
	Image Bao1 = null;
	Image Shan = null;
	Image Btree = null;
	Image Tong = null;
	Image Long = null;
	Image Mian = null;
	Image Gang = null;
	Image HH = null;
	Image H = null;
	Image J = null;
	Image SS = null;

	Image S = null;
	Image B = null;
	Image boom = null;
	Image bg = null;
	Image good1 = null;
	Image good2 = null;
	Image good3 = null;
	boolean mode = false;
	hero me = null;
	hero you = null;
	hero X = null;
	hero Y = null;
	Vector<wall> BWall = new Vector<wall>();
	Vector<wall> DWall = new Vector<wall>();
	Vector<wall> SWall = new Vector<wall>();
	Vector<Image> wu0 = new Vector<Image>();
	Vector<Image> wu1 = new Vector<Image>();
	Vector<Image> wu2 = new Vector<Image>();
	Vector<Image> wu3 = new Vector<Image>();
	Vector<Image> hu0 = new Vector<Image>();
	Vector<Image> hu1 = new Vector<Image>();
	Vector<Image> hu2 = new Vector<Image>();
	Vector<Image> hu3 = new Vector<Image>();
	Vector<Image> xu0 = new Vector<Image>();
	Vector<Image> xu1 = new Vector<Image>();
	Vector<Image> xu2 = new Vector<Image>();
	Vector<Image> xu3 = new Vector<Image>();
	Vector<Bomb> Q = new Vector<Bomb>();
	Vector<Bomb> Q1 = new Vector<Bomb>();
	Vector<Bomb> Q2 = new Vector<Bomb>();
	Vector<Bomb> Q3 = new Vector<Bomb>();
	Vector<Good> G = new Vector<Good>();
	Simple BG = new Simple();

	public MyPanel() {
		bg = new ImageIcon("background/ÓÎÏ·´°.png").getImage();
		redImg = new ImageIcon("Brick/Ô­Ê¼×©¿éºì.png").getImage();
		yellowImg = new ImageIcon("Brick/Ô­Ê¼×©¿é.png").getImage();
		flower = new ImageIcon("Decoration/»¨Æ¿.png").getImage();
		plant = new ImageIcon("Decoration/ÏÉÈËÕÆ.png").getImage();
		TieKuai = new ImageIcon("Decoration/Ìú¿é.png").getImage();
		BeiKE = new ImageIcon("Brick/±´¿Ç.png").getImage();
		BinKuai = new ImageIcon("Brick/±ù¿é.png").getImage();
		Cheng = new ImageIcon("Brick/³Ç±¤.png").getImage();
		SBin = new ImageIcon("Brick/Éî±ù.png").getImage();
		tree = new ImageIcon("Brick/Ê÷.png").getImage();
		XueRen = new ImageIcon("Brick/Ñ©ÈË.png").getImage();
		XueShu = new ImageIcon("Brick/Ñ©Ê÷.png").getImage();
		BinBin = new ImageIcon("Brick/±ù±ù.png").getImage();
		Bao = new ImageIcon("Brick/°ü×Óµê.png").getImage();
		Bao1 = new ImageIcon("Brick/°ü×Óµê1.png").getImage();
		Shan = new ImageIcon("Brick/É½.png").getImage();
		Btree = new ImageIcon("Brick/´óÊ÷.png").getImage();
		Tong = new ImageIcon("Brick/Í°.png").getImage();
		Long = new ImageIcon("Brick/Áý.png").getImage();
		Mian = new ImageIcon("Brick/ÃÞ.png").getImage();
		Gang = new ImageIcon("Brick/¸×.png").getImage();
		HH = new ImageIcon("Brick/»Ò»Ò.png").getImage();
		H = new ImageIcon("Brick/»Ò.png").getImage();
		J = new ImageIcon("Brick/¼ýÍ·.png").getImage();
		SS = new ImageIcon("Brick/Ê÷.png").getImage();

		boom = new ImageIcon("Exploding/±¬Õ¨ÖÐ.png").getImage();
		S = new ImageIcon("Bubble/Î÷¹Ï1.png").getImage();
		B = new ImageIcon("Bubble/Ñ©»¨1.png").getImage();
		good1 = new ImageIcon("Goods/µÀ¾ß1.png").getImage();
		good2 = new ImageIcon("Goods/µÀ¾ß2.png").getImage();
		good3 = new ImageIcon("Goods/µÀ¾ß3.png").getImage();
		this.setBackground(Color.black);
		this.setNPC();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, 675, 695, this);
		g.drawImage(bg, 0, 0, 885, 760, this);
		this.DrawMapWall(g, BWall);
		g.setColor(Color.white);
		g.setFont(new Font("ËÎÌå", Font.BOLD, 30));
		g.drawString("Íæ¼Ò", 750, 70);
		g.drawString("1", 700, 145);
		if (this.mode == true) {
			g.drawString("2", 700, 215);
			this.DrawBoom(g, Q1);
			this.CheckGood(G, you);
			this.checkdir(you);
			this.DrawYou(g, you);
			this.DrawYouTable(g, you);
		}
		this.checkdir(me);
		this.CheckGood(G, me);
		this.CheckGood(G, X);
		this.CheckGood(G, Y);
		this.DrawBoom(g, Q);
		this.DrawBoom(g, Q2);
		this.DrawBoom(g, Q3);
		this.DrawGoods(g, G);
		this.DrawMe(g, me);
		this.checkdir(X);
		this.checkdir(Y);
		this.DrawNPC(g, X);
		this.DrawNPC(g, Y);
		this.DrawMeTable(g, me);
		if (X.dir == 0 && Q2.size() < 1 && X.isLive) {
			int xx = (int) ((double) X.x / 45 + 0.5) * 45;
			int yy = (int) ((double) (X.y + 15) / 45 + 0.5) * 45;
			Bomb z = new Bomb(xx, yy);
			z.Btype = 0;
			Thread t = new Thread(z);
			t.start();
			Q2.add(z);
			BG.play("music/Button10.wav");
		}
		if (Y.dir == 0 && Q3.size() < 1 && Y.isLive) {
			int xx = (int) ((double) Y.x / 45 + 0.5) * 45;
			int yy = (int) ((double) (Y.y + 15) / 45 + 0.5) * 45;
			Bomb z = new Bomb(xx, yy);
			z.Btype = 1;
			Thread t = new Thread(z);
			t.start();
			Q3.add(z);
			BG.play("music/Button10.wav");
		}
	}

	public void setNPC() {
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon("ÐÜÃ¨/ÐÜÃ¨ºó" + i + ".png").getImage();
			xu0.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon("ÐÜÃ¨/ÐÜÃ¨ÓÒ" + i + ".png").getImage();
			xu1.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon("ÐÜÃ¨/ÐÜÃ¨ÕýÃæ" + i + ".png").getImage();
			xu2.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon("ÐÜÃ¨/ÐÜÃ¨×ó" + i + ".png").getImage();
			xu3.add(L);
		}
	}

	public void setGame2(String p1, String p2) {
		this.SetMap2();
		this.SetMan(p1);
		this.SetMen(p2);
		img = new ImageIcon("Map/±ù.png").getImage();
	}

	public void setGame3(String p1, String p2) {
		this.SetMap3();
		this.SetMan(p1);
		this.SetMen(p2);
		img = new ImageIcon("Map/Ê¯Í·.png").getImage();
	}

	public void CheckGood(Vector<Good> G, hero me) {
		for (int i = 0; i < G.size(); i++) {
			int a = G.get(i).x;
			int b = G.get(i).y;
			int c = G.get(i).Btype;
			if (me.x >= a - 30 && me.x <= a + 30 && me.y >= b - 30 && me.y <= b + 30) {
				BG.play("music/go.wav");
				G.get(i).isLive = false;
				if (c == 0 && me.num < 4) {
					me.num++;
				} else if (c == 1 && me.speed < 2) {
					me.speed++;

				}
			}
		}
	}

	public void DrawGoods(Graphics g, Vector<Good> G) {
		for (int i = 0; i < G.size(); i++) {
			if (G.get(i).isLive) {
				if (G.get(i).Btype == 0) {
					if (G.get(i).a == 45 && G.get(i).b == 48)
						g.drawImage(good1, G.get(i).x, G.get(i).y, G.get(i).a, G.get(i).b, this);
					else
						g.drawImage(good1, G.get(i).x, G.get(i).y - 5, G.get(i).a, G.get(i).b, this);
				} else if (G.get(i).Btype == 1) {
					if (G.get(i).a == 45 && G.get(i).b == 48)
						g.drawImage(good2, G.get(i).x, G.get(i).y, G.get(i).a, G.get(i).b, this);
					else
						g.drawImage(good2, G.get(i).x, G.get(i).y - 5, G.get(i).a, G.get(i).b, this);
				} else {
					if (G.get(i).a == 45 && G.get(i).b == 48)
						g.drawImage(good3, G.get(i).x, G.get(i).y, G.get(i).a - 10, G.get(i).b, this);
					else
						g.drawImage(good3, G.get(i).x, G.get(i).y - 5, G.get(i).a - 10, G.get(i).b, this);
				}
			} else
				G.remove(G.get(i));
		}
	}

	public void SetMan(String name) {
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "ºó" + i + ".png").getImage();
			wu0.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "ÓÒ" + i + ".png").getImage();
			wu1.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "ÕýÃæ" + i + ".png").getImage();
			wu2.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "×ó" + i + ".png").getImage();
			wu3.add(L);
		}
	}

	public void SetMen(String name) {
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "ºó" + i + ".png").getImage();
			hu0.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "ÓÒ" + i + ".png").getImage();
			hu1.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "ÕýÃæ" + i + ".png").getImage();
			hu2.add(L);
		}
		for (int i = 1; i <= 4; i++) {
			Image L = new ImageIcon(name + "/" + name + "×ó" + i + ".png").getImage();
			hu3.add(L);
		}
	}

	public void SetMap2() {
		me = new hero(45, 45);
		you = new hero(585, 570);
		X = new hero(4 * 45, 3 * 45);
		Thread t = new Thread(X);
		t.start();
		Y = new hero(10 * 45, 3 * 45);
		Thread a = new Thread(Y);
		a.start();
		wall p1, p2, p3, p4;
		p1 = new wall(0, 0);
		p1.img = XueRen;
		DWall.add(p1);
		p2 = new wall(0, 14 * 45 - 20);
		p2.img = XueRen;
		DWall.add(p2);
		p3 = new wall(14 * 45, 0);
		p3.img = XueRen;
		DWall.add(p3);
		p4 = new wall(14 * 45, 14 * 45 - 20);
		p4.img = XueRen;
		DWall.add(p4);
		p1 = new wall(5 * 45, 6 * 45);
		p1.img = XueShu;
		DWall.add(p1);
		p2 = new wall(5 * 45, 9 * 45);
		p2.img = XueShu;
		DWall.add(p2);
		p3 = new wall(9 * 45, 6 * 45);
		p3.img = XueShu;
		DWall.add(p3);
		p4 = new wall(9 * 45, 9 * 45);
		p4.img = XueShu;
		DWall.add(p4);

		for (int i = 3; i <= 13; i++) {
			p1 = new wall(2 * 45, (i - 1) * 45);
			p1.img = SBin;
			p2 = new wall(12 * 45, (i - 1) * 45);
			p2.img = SBin;
			BWall.add(p1);
			BWall.add(p2);
			if (i >= 6 && i <= 11) {
				p1 = new wall(4 * 45, (i - 1) * 45);
				p1.img = BinBin;
				p2 = new wall(10 * 45, (i - 1) * 45);
				p2.img = BinBin;
				BWall.add(p1);
				BWall.add(p2);
			}
		}
		for (int i = 4; i <= 12; i++) {
			p1 = new wall((i - 1) * 45, 2 * 45);
			p1.img = SBin;
			p2 = new wall((i - 1) * 45, 12 * 45);
			p2.img = SBin;
			BWall.add(p1);
			BWall.add(p2);
			if (i >= 6 && i <= 10) {
				p1 = new wall((i - 1) * 45, 5 * 45);
				p1.img = BinBin;
				p2 = new wall((i - 1) * 45, 10 * 45);
				p2.img = BinBin;
				BWall.add(p1);
				BWall.add(p2);
			}
		}
		for (int i = 3; i <= 13; i++) {
			if (i % 2 != 0) {
				p1 = new wall((i - 1) * 45, 0);
				p1.img = BinBin;
				p2 = new wall((i - 1) * 45, 14 * 45);
				p2.img = BinBin;
				p3 = new wall(0, (i - 1) * 45);
				p3.img = BinBin;
				p4 = new wall(14 * 45, (i - 1) * 45);
				p4.img = BinBin;
				BWall.add(p1);
				BWall.add(p2);
				BWall.add(p3);
				BWall.add(p4);
			} else {
				p1 = new wall((i - 1) * 45, 45);
				p1.img = BinBin;
				p2 = new wall((i - 1) * 45, 13 * 45);
				p2.img = BinBin;
				p3 = new wall(45, (i - 1) * 45);
				p3.img = BinBin;
				p4 = new wall(13 * 45, (i - 1) * 45);
				p4.img = BinBin;
				BWall.add(p1);
				BWall.add(p2);
				BWall.add(p3);
				BWall.add(p4);
			}
		}
		p1 = new wall(6 * 45, 6 * 45);
		p1.img = Cheng;
		SWall.add(p1);
	}

	public void SetMap3() {
		me = new hero(2 * 45, 7 * 45);
		you = new hero(12 * 45, 7 * 45);
		X = new hero(4 * 45, 3 * 45);
		Thread t = new Thread(X);
		t.start();
		Y = new hero(10 * 45, 3 * 45);
		Thread a = new Thread(Y);
		a.start();
		wall p1, p2, p3, p4;
		p1 = new wall(7 * 45, 13 * 45);
		p1.img = J;
		DWall.add(p1);

		for (int i = 2; i <= 7; i++) {
			p1 = new wall(0, (i - 1) * 45);
			p1.img = H;
			p2 = new wall(14 * 45, (i - 1) * 45);
			p2.img = H;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 8; i <= 12; i++) {
			p1 = new wall((i - 8) * 45, (i - 1) * 45);
			p1.img = H;
			p2 = new wall((14 - (i - 8)) * 45, (i - 1) * 45);
			p2.img = H;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 9; i <= 12; i++) {
			p1 = new wall((i - 9) * 45, (i - 1) * 45);
			p1.img = SS;
			p2 = new wall((14 - (i - 9)) * 45, (i - 1) * 45);
			p2.img = SS;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 10; i <= 12; i++) {
			p1 = new wall((i - 10) * 45, (i - 1) * 45);
			p1.img = SS;
			p2 = new wall((14 - (i - 10)) * 45, (i - 1) * 45);
			p2.img = SS;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 11; i <= 12; i++) {
			p1 = new wall((i - 11) * 45, (i - 1) * 45);
			p1.img = SS;
			p2 = new wall((14 - (i - 11)) * 45, (i - 1) * 45);
			p2.img = SS;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 12; i <= 12; i++) {
			p1 = new wall((i - 12) * 45, (i - 1) * 45);
			p1.img = SS;
			p2 = new wall((14 - (i - 12)) * 45, (i - 1) * 45);
			p2.img = SS;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 1; i <= 15; i++) {
			p1 = new wall((i - 1) * 45, 12 * 45);
			p1.img = HH;
			BWall.add(p1);
		}
		for (int i = 2; i <= 4; i++) {
			p1 = new wall((i - 1) * 45, 0);
			p1.img = HH;
			p2 = new wall((15 - i) * 45, 0);
			p2.img = HH;
			BWall.add(p1);
			BWall.add(p2);
		}
		for (int i = 9; i <= 12; i++) {
			p1 = new wall(5 * 45, (i - 1) * 45);
			p1.img = Mian;
			p2 = new wall(9 * 45, (i - 1) * 45);
			p2.img = Mian;
			BWall.add(p1);
			BWall.add(p2);
		}

		p1 = new wall(45, 4 * 45);
		p1.img = Bao;
		SWall.add(p1);
		p2 = new wall(11 * 45, 4 * 45);
		p2.img = Bao1;
		SWall.add(p2);
		p3 = new wall(90, 12 * 45);
		p3.img = Shan;
		SWall.add(p3);
		p4 = new wall(9 * 45, 12 * 45);
		p4.img = Shan;
		SWall.add(p4);

		p1 = new wall(0, 0);
		p1.img = Btree;
		p2 = new wall(14 * 45, 0);
		p2.img = Btree;
		p3 = new wall(0, 14 * 45);
		p3.img = Btree;
		p4 = new wall(14 * 45, 14 * 45);
		p4.img = Btree;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);
		DWall.add(p4);

		p1 = new wall(3 * 45, 2 * 45);
		p1.img = Btree;
		p2 = new wall(5 * 45, 45);
		p2.img = Btree;
		p3 = new wall(9 * 45, 45);
		p3.img = Btree;
		p4 = new wall(11 * 45, 2 * 45);
		p4.img = Btree;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);
		DWall.add(p4);
		p1 = new wall(7 * 45, 14 * 45);
		p1.img = Btree;
		DWall.add(p1);

		p1 = new wall(7 * 45, 0);
		p1.img = Btree;
		DWall.add(p1);

		p1 = new wall(4 * 45, 0);
		p1.img = Tong;
		p2 = new wall(10 * 45, 0);
		p2.img = Tong;
		p3 = new wall(3 * 45, 9 * 45);
		p3.img = Tong;
		p4 = new wall(11 * 45, 9 * 45);
		p4.img = Tong;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);
		DWall.add(p4);

		p1 = new wall(45, 45);
		p1.img = SBin;
		p2 = new wall(13 * 45, 45);
		p2.img = SBin;
		p3 = new wall(45, 13 * 45);
		p3.img = SBin;
		p4 = new wall(13 * 45, 13 * 45);
		p4.img = SBin;
		BWall.add(p1);
		BWall.add(p2);
		BWall.add(p3);
		BWall.add(p4);

		p1 = new wall(2 * 45, 45);
		p1.img = Long;
		p2 = new wall(12 * 45, 45);
		p2.img = Long;
		p3 = new wall(7 * 45, 10 * 45);
		p3.img = Long;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);

		p1 = new wall(5 * 45, 0);
		p1.img = Mian;
		p2 = new wall(6 * 45, 0);
		p2.img = Mian;
		p3 = new wall(8 * 45, 0);
		p3.img = Mian;
		p4 = new wall(9 * 45, 0);
		p4.img = Mian;
		BWall.add(p1);
		BWall.add(p2);
		BWall.add(p3);
		BWall.add(p4);

		p1 = new wall(6 * 45, 45);
		p1.img = Mian;
		p2 = new wall(8 * 45, 45);
		p2.img = Mian;
		p3 = new wall(6 * 45, 3 * 45);
		p3.img = Mian;
		p4 = new wall(8 * 45, 3 * 45);
		p4.img = Mian;
		BWall.add(p1);
		BWall.add(p2);
		BWall.add(p3);
		BWall.add(p4);

		p1 = new wall(6 * 45, 4 * 45);
		p1.img = Gang;
		p2 = new wall(8 * 45, 4 * 45);
		p2.img = Gang;
		p3 = new wall(6 * 45, 5 * 45);
		p3.img = Gang;
		p4 = new wall(8 * 45, 5 * 45);
		p4.img = Gang;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);
		DWall.add(p4);
		p1 = new wall(7 * 45, 5 * 45);
		p1.img = Gang;
		DWall.add(p1);

		p1 = new wall(5 * 45, 6 * 45);
		p1.img = Gang;
		p2 = new wall(9 * 45, 6 * 45);
		p2.img = Gang;
		p3 = new wall(6 * 45, 7 * 45);
		p3.img = Gang;
		p4 = new wall(8 * 45, 7 * 45);
		p4.img = Gang;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);
		DWall.add(p4);

		p1 = new wall(4 * 45, 7 * 45);
		p1.img = Gang;
		p2 = new wall(10 * 45, 7 * 45);
		p2.img = Gang;
		p3 = new wall(4 * 45, 9 * 45);
		p3.img = Gang;
		p4 = new wall(10 * 45, 9 * 45);
		p4.img = Gang;
		DWall.add(p1);
		DWall.add(p2);
		DWall.add(p3);
		DWall.add(p4);

		p1 = new wall(6 * 45, 10 * 45);
		p1.img = Gang;
		p2 = new wall(8 * 45, 10 * 45);
		p2.img = Gang;
		DWall.add(p1);
		DWall.add(p2);

		p1 = new wall(0, 13 * 45);
		p1.img = H;
		p2 = new wall(45, 14 * 45);
		p2.img = HH;
		BWall.add(p1);
		BWall.add(p2);

		p1 = new wall(14 * 45, 13 * 45);
		p1.img = H;
		p2 = new wall(13 * 45, 14 * 45);
		p2.img = HH;
		BWall.add(p1);
		BWall.add(p2);

		p1 = new wall(6 * 45, 14 * 45);
		p1.img = HH;
		p2 = new wall(8 * 45, 14 * 45);
		p2.img = HH;
		BWall.add(p1);
		BWall.add(p2);

		p1 = new wall(6 * 45, 13 * 45);
		p1.img = H;
		p2 = new wall(8 * 45, 13 * 45);
		p2.img = H;
		BWall.add(p1);
		BWall.add(p2);

		for (int i = 5; i <= 11; i++) {
			p1 = new wall((i - 1) * 45, 90);
			p1.img = H;
			BWall.add(p1);
		}
	}

	public void DrawMe(Graphics g, hero me) {
		if (me.isLive == false)
			return;
		switch (me.dir) {
		case 0:
			g.drawImage(wu0.get(me.type0), me.x, me.y, 45, 60, this);
			me.holdu--;
			if (me.holdu == 0) {
				me.type0 = (me.type0 + 1) % 4;
				me.holdu = 24;
			}
			break;
		case 1:
			g.drawImage(wu1.get(me.type1), me.x, me.y, 45, 60, this);
			me.holdr--;
			if (me.holdr == 0) {
				me.type1 = (me.type1 + 1) % 4;
				me.holdr = 24;
			}
			break;
		case 2:
			g.drawImage(wu2.get(me.type2), me.x, me.y, 45, 60, this);
			me.holdd--;
			if (me.holdd == 0) {
				me.type2 = (me.type2 + 1) % 4;
				me.holdd = 24;
			}
			break;
		case 3:
			g.drawImage(wu3.get(me.type3), me.x, me.y, 45, 60, this);
			me.holdl--;
			if (me.holdl == 0) {
				me.type3 = (me.type3 + 1) % 4;
				me.holdl = 24;
			}
			break;
		}
	}

	public void DrawYou(Graphics g, hero me) {
		if (me.isLive == false)
			return;
		switch (me.dir) {
		case 0:
			g.drawImage(hu0.get(me.type0), me.x, me.y, 45, 60, this);
			me.holdu--;
			if (me.holdu == 0) {
				me.type0 = (me.type0 + 1) % 4;
				me.holdu = 24;
			}
			break;
		case 1:
			g.drawImage(hu1.get(me.type1), me.x, me.y, 45, 60, this);
			me.holdr--;
			if (me.holdr == 0) {
				me.type1 = (me.type1 + 1) % 4;
				me.holdr = 24;
			}
			break;
		case 2:
			g.drawImage(hu2.get(me.type2), me.x, me.y, 45, 60, this);
			me.holdd--;
			if (me.holdd == 0) {
				me.type2 = (me.type2 + 1) % 4;
				me.holdd = 24;
			}
			break;
		case 3:
			g.drawImage(hu3.get(me.type3), me.x, me.y, 45, 60, this);
			me.holdl--;
			if (me.holdl == 0) {
				me.type3 = (me.type3 + 1) % 4;
				me.holdl = 24;
			}
			break;
		}
	}

	public void DrawNPC(Graphics g, hero me) {
		if (me.isLive == false)
			return;
		switch (me.dir) {
		case 0:
			g.drawImage(xu0.get(me.type0), me.x, me.y, 45, 60, this);
			me.holdu--;
			if (me.holdu == 0) {
				me.type0 = (me.type0 + 1) % 4;
				me.holdu = 24;

			}
			break;
		case 1:
			g.drawImage(xu1.get(me.type1), me.x, me.y, 45, 60, this);
			me.holdr--;
			if (me.holdr == 0) {
				me.type1 = (me.type1 + 1) % 4;
				me.holdr = 24;
			}
			break;
		case 2:
			g.drawImage(xu2.get(me.type2), me.x, me.y, 45, 60, this);
			me.holdd--;
			if (me.holdd == 0) {
				me.type2 = (me.type2 + 1) % 4;
				me.holdd = 24;
			}
			break;
		case 3:
			g.drawImage(xu3.get(me.type3), me.x, me.y, 45, 60, this);
			me.holdl--;
			if (me.holdl == 0) {
				me.type3 = (me.type3 + 1) % 4;
				me.holdl = 24;
			}
			break;
		}
	}

	public void DrawMeTable(Graphics g, hero me) {
		if (me.isLive == false)
			return;
		switch (me.dir) {
		case 0:
			g.drawImage(wu0.get(me.type0), 780, 120, 30, 40, this);
			me.holdu--;
			if (me.holdu == 0) {
				me.type0 = (me.type0 + 1) % 4;
				me.holdu = 24;
			}
			break;
		case 1:
			g.drawImage(wu1.get(me.type1), 780, 120, 30, 40, this);
			me.holdr--;
			if (me.holdr == 0) {
				me.type1 = (me.type1 + 1) % 4;
				me.holdr = 24;
			}
			break;
		case 2:
			g.drawImage(wu2.get(me.type2), 780, 120, 30, 40, this);
			me.holdd--;
			if (me.holdd == 0) {
				me.type2 = (me.type2 + 1) % 4;
				me.holdd = 24;
			}
			break;
		case 3:
			g.drawImage(wu3.get(me.type3), 780, 120, 30, 40, this);
			me.holdl--;
			if (me.holdl == 0) {
				me.type3 = (me.type3 + 1) % 4;
				me.holdl = 24;
			}
			break;
		}
	}

	public void DrawYouTable(Graphics g, hero me) {
		if (me.isLive == false)
			return;
		switch (me.dir) {
		case 0:
			g.drawImage(hu0.get(me.type0), 780, 180, 30, 40, this);
			me.holdu--;
			if (me.holdu == 0) {
				me.type0 = (me.type0 + 1) % 4;
				me.holdu = 24;
			}
			break;
		case 1:
			g.drawImage(hu1.get(me.type1), 780, 180, 30, 40, this);
			me.holdr--;
			if (me.holdr == 0) {
				me.type1 = (me.type1 + 1) % 4;
				me.holdr = 24;
			}
			break;
		case 2:
			g.drawImage(hu2.get(me.type2), 780, 180, 30, 40, this);
			me.holdd--;
			if (me.holdd == 0) {
				me.type2 = (me.type2 + 1) % 4;
				me.holdd = 24;
			}
			break;
		case 3:
			g.drawImage(hu3.get(me.type3), 780, 180, 30, 40, this);
			me.holdl--;
			if (me.holdl == 0) {
				me.type3 = (me.type3 + 1) % 4;
				me.holdl = 24;
			}
			break;
		}
	}

	public void DrawBoom(Graphics g, Vector<Bomb> Q) {
		for (int i = 0; i < Q.size(); i++) {
			if (Q.get(i).isLive) {
				if (Q.get(i).a == 45 && Q.get(i).b == 48) {
					if (Q.get(i).Btype == 1)
						g.drawImage(S, Q.get(i).x, Q.get(i).y + 10, Q.get(i).a, Q.get(i).b, this);
					else
						g.drawImage(B, Q.get(i).x, Q.get(i).y + 10, Q.get(i).a, Q.get(i).b, this);
				} else {
					if (Q.get(i).Btype == 1)
						g.drawImage(S, Q.get(i).x, Q.get(i).y + 5, Q.get(i).a, Q.get(i).b, this);
					else
						g.drawImage(B, Q.get(i).x, Q.get(i).y + 5, Q.get(i).a, Q.get(i).b, this);
				}
			} else {
				int sx, sy, xx, xy, zx, zy, yx, yy;
				wall sw, xw, zw, yw;
				sx = Q.get(i).x;
				sy = Q.get(i).y - 45;
				xx = Q.get(i).x;
				xy = Q.get(i).y + 45;
				zx = Q.get(i).x - 45;
				zy = Q.get(i).y;
				yx = Q.get(i).x + 45;
				yy = Q.get(i).y;
				sw = checkwall(sx, sy);
				xw = checkwall(xx, xy);
				zw = checkwall(zx, zy);
				yw = checkwall(yx, yy);
				if (Q.get(i).live <= 14) {
					g.drawImage(boom, Q.get(i).x, Q.get(i).y, 47, 55, this);
					if (sw == null) {
						Image p = new ImageIcon("Exploding/±¬Õ¨ÉÏ¶¥µã.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
						if (X.x >= sx-5 && X.x <= sx+40 && X.y >= sy - 30 && X.y <= sy + 55
								&& Q.get(i).Btype == 1) {
							X.isLive = false;

						}
						if (Y.x >= sx-5 && Y.x <= sx + 40 && Y.y >= sy - 30 && Y.y >= sy + 55
								&& Q.get(i).Btype == 0) {
							Y.isLive = false;

						}
						if (me.x >= sx-5  && me.x <= sx + 40 && me.y >= sy - 30 && me.y <= sy + 55
								&& Q.get(i).Btype == 1) {
							me.isLive = false;

						}
						if (you.x >= sx-5 && you.x <= sx + 40 && you.y >= sy - 30 && you.y >= sy + 55
								&& Q.get(i).Btype == 0) {
							you.isLive = false;

						}
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
						BWall.remove(sw);
						int num = new Random().nextInt(100);
						if (num % 7 == 0) {
							Good a = new Good(sx, sy);
							a.Btype = new Random().nextInt(3);
							Thread t = new Thread(a);
							t.start();
							G.add(a);
						}
					}
					if (xw == null) {
						Image p = new ImageIcon("Exploding/±¬Õ¨ÏÂ¶¥µã.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
						if (X.x >= xx-5  && X.x <= xx + 40 && X.y <= xy + 20 && X.y >= xy -20
								&& Q.get(i).Btype == 1) {
							X.isLive = false;

						}
						if (Y.x >= xx-5  && Y.x <= xx + 40 && Y.y <= xy + 20 && Y.y >= xy - 20
								&& Q.get(i).Btype == 0) {
							Y.isLive = false;

						}
						if (me.x >= xx-5  && me.x <= xx + 40 && me.y <= xy + 20 && me.y >= xy - 20
								&& Q.get(i).Btype == 1) {
							me.isLive = false;

						}
						if (you.x >= xx-5 && you.x <= xx + 40 && you.y <= xy + 20 && you.y >= xy - 20&& Q.get(i).Btype == 0) {
							you.isLive = false;

						}
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
						BWall.remove(xw);
						int num = new Random().nextInt(100);
						if (num % 7 == 0) {
							Good a = new Good(xx, xy);
							a.Btype = new Random().nextInt(3);
							Thread t = new Thread(a);
							t.start();
							G.add(a);
						}
					}
					if (zw == null) {
						Image p = new ImageIcon("Exploding/±¬Õ¨×ó¶¥µã.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
						if (X.x >= zx && X.x <= zx + 90 && X.y <= zy + 40 && X.y >= zy - 30 && Q.get(i).Btype == 1) {
							X.isLive = false;

						}
						if (Y.x >= zx && Y.x <= zx + 90 && Y.y <= zy + 40 && Y.y >= zy - 30 && Q.get(i).Btype == 0) {
							Y.isLive = false;

						}
						if (me.x >= zx && me.x <= zx + 90 && me.y <= zy + 40 && me.y >= zy - 30
								&& Q.get(i).Btype == 1) {
							me.isLive = false;

						}
						if (you.x >= zx && you.x <= zx + 90 && you.y <= zy + 40 && you.y >= zy - 30
								&& Q.get(i).Btype == 0) {
							you.isLive = false;

						}
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
						BWall.remove(zw);
						int num = new Random().nextInt(100);
						if (num % 7 == 0) {
							Good a = new Good(zx, zy);
							a.Btype = new Random().nextInt(3);
							Thread t = new Thread(a);
							t.start();
							G.add(a);
						}
					}
					if (yw == null) {
						Image p = new ImageIcon("Exploding/±¬Õ¨ÓÒ¶¥µã.png").getImage();
						g.drawImage(p, yx, yy, 47, 55, this);
						if (X.x >= yx-10 && X.x <= yx + 30 && X.y <= yy + 40 && X.y >= yy - 30 && Q.get(i).Btype == 1) {
							X.isLive = false;

						}
						if (Y.x >= yx-10 && Y.x <= yx + 30 && Y.y <= yy + 40 && Y.y >= yy - 30 && Q.get(i).Btype == 0) {
							Y.isLive = false;

						}
						if (me.x >= yx-10 && me.x <= yx + 30 && me.y <= yy + 40 && me.y >= yy - 30
								&& Q.get(i).Btype == 1) {
							me.isLive = false;

						}
						if (you.x >= yx-10 && you.x <= yx + 30 && you.y <= yy + 40 && you.y >= yy - 30
								&& Q.get(i).Btype == 0) {
							you.isLive = false;

						}
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, yx, yy, 47, 55, this);
						BWall.remove(yw);

						int num = new Random().nextInt(100);
						if (num % 7 == 0) {
							Good a = new Good(yx, yy);
							a.Btype = new Random().nextInt(3);
							Thread t = new Thread(a);
							t.start();
							G.add(a);
						}
					}
				} else if (Q.get(i).live <= 26) {
					g.drawImage(boom, Q.get(i).x, Q.get(i).y, 47, 55, this);
					if (sw == null) {
						Image p = new ImageIcon("Exploding/3_±¬Õ¨ÉÏ.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
					}
					if (xw == null) {
						Image p = new ImageIcon("Exploding/3_±¬Õ¨ÏÂ.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
					}
					if (zw == null) {
						Image p = new ImageIcon("Exploding/3_±¬Õ¨×ó.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					}
					if (yw == null) {
						Image p = new ImageIcon("Exploding/3_±¬Õ¨ÓÒ.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé3.png").getImage();
						g.drawImage(p, yx, yy, 47, 55, this);
					}
				} else if (Q.get(i).live <= 38) {
					g.drawImage(boom, Q.get(i).x, Q.get(i).y, 47, 55, this);
					if (sw == null) {
						Image p = new ImageIcon("Exploding/2_±¬Õ¨ÉÏ.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé2.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
					}
					if (xw == null) {
						Image p = new ImageIcon("Exploding/2_±¬Õ¨ÏÂ.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé2.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
					}
					if (zw == null) {
						Image p = new ImageIcon("Exploding/2_±¬Õ¨×ó.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé2.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					}
					if (yw == null) {
						Image p = new ImageIcon("Exploding/2_±¬Õ¨ÓÒ.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé2.png").getImage();
						g.drawImage(p, yx, yy, 47, 55, this);
					}
				} else if (Q.get(i).live <= 49) {
					g.drawImage(boom, Q.get(i).x, Q.get(i).y, 47, 55, this);
					if (sw == null) {
						Image p = new ImageIcon("Exploding/1_±¬Õ¨ÉÏ.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé1.png").getImage();
						g.drawImage(p, sx, sy, 47, 55, this);
					}
					if (xw == null) {
						Image p = new ImageIcon("Exploding/1_±¬Õ¨ÏÂ.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé1.png").getImage();
						g.drawImage(p, xx, xy, 47, 55, this);
					}
					if (zw == null) {
						Image p = new ImageIcon("Exploding/1_±¬Õ¨×ó.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé1.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					}
					if (yw == null) {
						Image p = new ImageIcon("Exploding/1_±¬Õ¨ÓÒ.png").getImage();
						g.drawImage(p, zx, zy, 47, 55, this);
					} else {
						Image p = new ImageIcon("Brick/×©¿éÆÆËé1.png").getImage();
						g.drawImage(p, yx, yy, 47, 55, this);
					}
				} else {
					BG.play("music/boom.wav");
				}
				Q.get(i).live--;
				if (Q.get(i).live == 0) {
					Q.remove(Q.get(i));
				}
			}
		}
	}

	public void DrawMapWall(Graphics g, Vector<wall> BWall) {
		for (int i = 0; i < BWall.size(); i++) {
			if (BWall.get(i).isLive) {
				g.drawImage(BWall.get(i).img, BWall.get(i).x, BWall.get(i).y, 47, 55, this);
			}
		}
		for (int i = 0; i < DWall.size(); i++) {
			if (DWall.get(i).isLive) {
				g.drawImage(DWall.get(i).img, DWall.get(i).x, DWall.get(i).y, 47, 65, this);
			}
		}

		for (int i = 0; i < SWall.size(); i++) {
			if (SWall.get(i).isLive) {
				if (i <= 1)
					g.drawImage(SWall.get(i).img, SWall.get(i).x, SWall.get(i).y, 48 * 3, 48 * 3, this);
				else {
					g.drawImage(SWall.get(i).img, SWall.get(i).x, SWall.get(i).y, 45 * 4, 48 * 3, this);
				}
			}
		}
	}

	public void checkdir(hero me) {
		if (me.gu && !me.gr && !me.gd && !me.gl) {
			me.dir = 0;
			if (checkUp(me)) {
				me.moveUp();
			}
		} else if (!me.gu && me.gr && !me.gd && !me.gl) {
			me.dir = 1;
			if (checkRight(me)) {
				me.moveRight();
			}
		} else if (!me.gu && !me.gr && me.gd && !me.gl) {
			me.dir = 2;
			if (checkDown(me)) {
				me.moveDown();
			}
		} else if (!me.gu && !me.gr && !me.gd && me.gl) {
			me.dir = 3;
			if (checkLeft(me)) {
				me.moveLeft();
			}
		}
	}

	public wall checkwall(int x, int y) {
		for (int i = 0; i < BWall.size(); i++) {
			if (BWall.get(i).x == x && BWall.get(i).y == y)
				return BWall.get(i);
		}
		return null;
	}

	public boolean checkUp(hero me) {
		int x = me.x;
		int y = me.y;
		for (int i = 0; i < BWall.size(); i++) {
			int a = BWall.get(i).x;
			int b = BWall.get(i).y;
			if (x >= (a - 30) && x <= (a + 30) && y >= b && y <= (b + 30)) {
				return false;
			}
		}
		for (int i = 0; i < DWall.size(); i++) {
			int a = DWall.get(i).x;
			int b = DWall.get(i).y;
			if (x >= (a - 30) && x <= (a + 30) && y >= b && y <= (b + 30)) {
				return false;
			}
		}
		for (int i = 0; i < SWall.size(); i++) {
			int a = SWall.get(i).x;
			int b = SWall.get(i).y;
			if (x >= (a - 30) && x <= (a + 120) && y >= b && y <= (b + 90)) {
				return false;
			}
		}
		for (int i = 0; i < Q.size(); i++) {
			int a = Q.get(i).x;
			int b = Q.get(i).y;
			if (x >= a - 35 && x <= a + 35 && y - 10 == b) {
				return false;
			}
		}
		for (int i = 0; i < Q1.size(); i++) {
			int a = Q1.get(i).x;
			int b = Q1.get(i).y;
			if (x >= a - 35 && x <= a + 35 && y - 10 == b) {
				return false;
			}
		}
		return true;
	}

	public boolean checkRight(hero me) {
		int x = me.x;
		int y = me.y;
		for (int i = 0; i < BWall.size(); i++) {
			int a = BWall.get(i).x;
			int b = BWall.get(i).y;
			if ((x >= (a - 40) && x <= a && y >= (b - 50) && y <= (b + 22))) {
				return false;
			}
		}
		for (int i = 0; i < DWall.size(); i++) {
			int a = DWall.get(i).x;
			int b = DWall.get(i).y;
			if ((x >= (a - 40) && x <= a && y >= (b - 50) && y <= (b + 22))) {
				return false;
			}
		}
		for (int i = 0; i < SWall.size(); i++) {
			int a = SWall.get(i).x;
			int b = SWall.get(i).y;
			if ((x >= (a - 40) && x <= a && y >= (b - 20) && y <= (b + 88))) {
				return false;
			}
		}
		for (int i = 0; i < Q.size(); i++) {
			int a = Q.get(i).x;
			int b = Q.get(i).y;
			if (y >= (b - 50) && y <= (b + 22) && x + 35 == a) {
				return false;
			}
		}
		for (int i = 0; i < Q1.size(); i++) {
			int a = Q1.get(i).x;
			int b = Q1.get(i).y;
			if (y >= (b - 50) && y <= (b + 22) && x + 35 == a) {
				return false;
			}
		}
		return true;
	}

	public boolean checkDown(hero me) {
		int x = me.x;
		int y = me.y;
		for (int i = 0; i < BWall.size(); i++) {
			int a = BWall.get(i).x;
			int b = BWall.get(i).y;
			if ((x >= (a - 30) && x <= (a + 30) && y >= (b - 60) && y <= (b - 5))) {
				return false;
			}
		}
		for (int i = 0; i < DWall.size(); i++) {
			int a = DWall.get(i).x;
			int b = DWall.get(i).y;
			if ((x >= (a - 30) && x <= (a + 30) && y >= (b - 60) && y <= (b - 5))) {
				return false;
			}
		}
		for (int i = 0; i < SWall.size(); i++) {
			int a = SWall.get(i).x;
			int b = SWall.get(i).y;
			if ((x >= (a - 30) && x <= (a + 120) && y >= (b - 40) && y <= (b - 5))) {
				return false;
			}
		}
		for (int i = 0; i < Q.size(); i++) {
			int a = Q.get(i).x;
			int b = Q.get(i).y;
			if (x >= a - 35 && x <= a + 35 && y + 55 == b) {
				return false;
			}
		}
		for (int i = 0; i < Q1.size(); i++) {
			int a = Q1.get(i).x;
			int b = Q1.get(i).y;
			if (x >= a - 35 && x <= a + 35 && y + 55 == b) {
				return false;
			}
		}
		return true;
	}

	public boolean checkLeft(hero me) {
		int x = me.x;
		int y = me.y;
		for (int i = 0; i < BWall.size(); i++) {
			int a = BWall.get(i).x;
			int b = BWall.get(i).y;
			if ((x >= a && x <= (a + 40) && y >= (b - 50) && y <= (b + 20))) {
				return false;
			}
		}
		for (int i = 0; i < DWall.size(); i++) {
			int a = DWall.get(i).x;
			int b = DWall.get(i).y;
			if ((x >= a && x <= (a + 40) && y >= (b - 50) && y <= (b + 20))) {
				return false;
			}
		}
		for (int i = 0; i < SWall.size(); i++) {
			int a = SWall.get(i).x;
			int b = SWall.get(i).y;
			if ((x >= a && x <= (a + 130) && y >= (b - 20) && y <= (b + 80))) {
				return false;
			}
		}
		for (int i = 0; i < Q.size(); i++) {
			int a = Q.get(i).x;
			int b = Q.get(i).y;
			if (y >= (b - 50) && y <= (b + 20) && x - 35 == a) {
				return false;
			}
		}
		for (int i = 0; i < Q1.size(); i++) {
			int a = Q1.get(i).x;
			int b = Q1.get(i).y;
			if (y >= (b - 50) && y <= (b + 20) && x - 35 == a) {
				return false;
			}
		}
		return true;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W) {
			me.gu = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			me.gr = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			me.gd = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {

			me.gl = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			you.gu = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			you.gr = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			you.gd = true;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			you.gl = true;
			return;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (Q.size() < me.num && me.isLive) {
				int xx = (int) ((double) me.x / 45 + 0.5) * 45;
				int yy = (int) ((double) (me.y + 15) / 45 + 0.5) * 45;
				Bomb x = new Bomb(xx, yy);
				x.Btype = 0;
				Q.add(x);
				Thread t = new Thread(x);
				t.start();
				BG.play("music/Button10.wav");
			}
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (Q1.size() < you.num && this.mode == true && you.isLive) {
				int xx = (int) ((double) you.x / 45 + 0.5) * 45;
				int yy = (int) ((double) (you.y + 15) / 45 + 0.5) * 45;
				Bomb x = new Bomb(xx, yy);
				x.Btype = 1;
				Q1.add(x);
				Thread t = new Thread(x);
				t.start();
				BG.play("music/Button10.wav");
			}
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_W) {

			me.gu = false;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {

			me.gr = false;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			me.gd = false;

			return;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {

			me.gl = false;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			you.gu = false;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			you.gr = false;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			you.gd = false;
			return;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			you.gl = false;
			return;
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(10);
				this.repaint();
				if(this.mode==false){
					if(me.isLive==false&&X.isLive==false){
						JOptionPane.showMessageDialog(null,"ÓÎÏ·½áÊø,ÄúÊäÁË£¡");
						break;
					}
					else if(Y.isLive==false){
						JOptionPane.showMessageDialog(null,"ÓÎÏ·½áÊø,ÄúÓ®ÁË£¡");
						break;
					}
				}
				else if(this.mode){
					if(me.isLive==false&&X.isLive==false){
						JOptionPane.showMessageDialog(null,"ÓÎÏ·½áÊø,2PÓ®ÁË£¡");
						break;
					}
					else if(you.isLive==false&&Y.isLive==false){
						JOptionPane.showMessageDialog(null,"ÓÎÏ·½áÊø,1PÓ®ÁË£¡");
						break;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
