package fangyumin.tank03;

import fangyumin.tank03.facade.GameModel;
import fangyumin.tank03.factory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {

    private int x, y;
    public final static int WIDTH = ResourceLoaderManager.EXPLODE[0].getWidth();
    public final static int HEIGHT = ResourceLoaderManager.EXPLODE[0].getHeight();
    private boolean live;
    private GameModel gm;

    private int step = 0;//记录画爆炸图片的位置

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceLoaderManager.EXPLODE[step++], x, y, null);
        if (step >= ResourceLoaderManager.EXPLODE.length) {
            remove();
        }

    }

    public void remove() {
        gm.getGameObjects().remove(this);
    }

    @Override
    public void compareCollide(Object o1, Object o2) {

    }
}
