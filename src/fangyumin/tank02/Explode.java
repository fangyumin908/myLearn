package fangyumin.tank02;

import java.awt.*;

public class Explode {

    private int x, y;
    public final static int WIDTH = ResourceLoaderManager.EXPLODE[0].getWidth();
    public final static int HEIGHT = ResourceLoaderManager.EXPLODE[0].getHeight();
    private boolean live;
    private TankFrame tankFrame;

    private int step = 0;//记录画爆炸图片的位置

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceLoaderManager.EXPLODE[step++], x, y, null);
        if (step >= ResourceLoaderManager.EXPLODE.length) {
            remove();
        }

    }

    public void remove() {
        tankFrame.explodes.remove(this);
    }
}
