package fangyumin.tank03;

import fangyumin.tank03.utils.Collider;

import java.awt.*;

/**
 * 游戏对象抽象父类
 */
public abstract class GameObject implements Collider {
    private int x, y;

    public abstract void paint(Graphics g);

}
