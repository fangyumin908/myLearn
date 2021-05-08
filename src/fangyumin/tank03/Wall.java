package fangyumin.tank03;

import fangyumin.tank03.facade.GameModel;

import java.awt.*;

public class Wall extends GameObject{

    private int length;
    private int height;

    private int x;
    private int y;

    private GameModel gm;
    private Rectangle rectangle;

    public Wall(int x, int y,int length, int height, GameModel gm) {
        this.length = length;
        this.height = height;
        this.x = x;
        this.y = y;
        this.gm = gm;
        this.rectangle = new Rectangle(x,y,length,height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.PINK);
        g.fillRect(x, y, length, height);
        g.setColor(c);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
