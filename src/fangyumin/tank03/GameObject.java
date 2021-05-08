package fangyumin.tank03;

import fangyumin.tank03.collide.Collider;

import java.awt.*;

/**
 * 游戏对象抽象父类
 */
public abstract class GameObject {
    private int x, y;

    public abstract void paint(Graphics g);

}
