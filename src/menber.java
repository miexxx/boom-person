import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

class wall {
	int x = 0;
	int y = 0;
	boolean isLive = true;
	Image img = null;

	public wall(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class hero implements Runnable {
	int x = 0;
	int y = 0;
	int dir = 2;
	int speed = 1;
	int type0 = 0;
	int type1 = 0;
	int type2 = 0;
	int type3 = 0;
	int holdu = 24;
	int holdr = 24;
	int holdd = 24;
	int holdl = 24;
	int num = 1;
	boolean isLive = true;
	boolean gu = false;
	boolean gr = false;
	boolean gd = false;
	boolean gl = false;

	public hero(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveUp() {
		if (y > -10)
			this.y -= speed;
	}

	public void moveRight() {
		if (x < 630)
			this.x += speed;
	}

	public void moveDown() {
		if (y < 610)
			this.y += speed;
	}

	public void moveLeft() {
		if (x > 0)
			this.x -= speed;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1001);
				int s = new Random().nextInt(4);
				if (s == 0) {
					gu = false;
					gr = false;
					gd = false;
					gl = true;
				} else if (s == 1) {
					gu = false;
					gr = false;
					gd = true;
					gl = false;
				} else if (s == 2) {
					gu = false;
					gr = true;
					gd = false;
					gl = false;
				} else {
					gu = true;
					gr = false;
					gd = false;
					gl = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.isLive == false)
				break;
		}

	}
}

class Bomb implements Runnable {
	int x;
	int y;
	int type = 0;
	int a = 45;
	int b = 48;
	int live = 50;
	int Btype = 0;
	boolean isLive = true;
	int time = 0;

	public Bomb(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(150);
				time++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (type == 0) {
				a = 45;
				b = 48;
				type = 1;
			} else {
				a = 40;
				b = 55;
				type = 0;
			}
			if (time == 20) {
				isLive = false;
				break;
			}
		}
	}
}

class Good implements Runnable {
	int x;
	int y;
	int type = 0;
	int a = 45;
	int b = 48;
	int Btype = 0;
	boolean isLive = true;

	public Good(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (type == 0) {
				type = 1;
				a = 45;
				b = 48;
			} else {
				type = 0;
				a = 45;
				b = 45;
			}
			if (isLive == false)
				break;
		}
	}
}