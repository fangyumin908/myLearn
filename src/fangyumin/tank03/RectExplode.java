package fangyumin.tank03;

import fangyumin.tank03.facade.GameModel;
import fangyumin.tank03.factory.BaseExplode;

import java.awt.*;

public class RectExplode extends BaseExplode {

    private int x, y;

    private int step = 0;//记录画爆炸图片的位置
    private GameModel gm;

    public RectExplode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x, y, step * 10, step * 10);
        step ++;
        if (step >= 15) {
            remove();
        }

        g.setColor(c);
    }

    public void remove() {
        gm.getGameObjects().remove(this);
    }


    @Override
    public boolean compareCollide(Object o1, Object o2) {
        return false;
    }
}
