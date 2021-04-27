package fangyumin.tank03;


import fangyumin.tank03.facade.GameModel;
import fangyumin.tank03.factory.RectFactory;
import fangyumin.tank03.utils.PropertiesLoaderUtil;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {

    private int x,y;
    private DirectionEnum direction;
    private final int SPEED = Integer.parseInt(PropertiesLoaderUtil.getValue("bulletSpeed"));
    private boolean live = true;//子弹是否存活
    public final static int WIDTH = ResourceLoaderManager.bulletD.getWidth();
    public final static int HEIGHT = ResourceLoaderManager.bulletD.getHeight();
    private GameModel gm = null;
    private GroupEnum group;
    public Bullet(int x, int y, DirectionEnum direction, GroupEnum group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.gm = gm;
    }

    public void paint(Graphics g) {
        switch (direction){
            case UP:
                g.drawImage(ResourceLoaderManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceLoaderManager.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceLoaderManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceLoaderManager.bulletR, x, y, null);
                break;
            default:
                break;
        }

        move();
        if (!live){
            gm.getBullets().remove(this);
        }

    }

    private void move() {
        switch (direction){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            default:
        }
        if (x < 0 || x > gm.getTankFrame().getWidth() || y < 0 || y > gm.getTankFrame().getHeight()){
            live = false;
        }
    }

    public void collideCheck(Tank enemyTank) {
        if (this.group == enemyTank.getGroup()) return;

        Rectangle r1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle r2 = new Rectangle(enemyTank.getX(), enemyTank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (r1.intersects(r2)){
            int explodeX = enemyTank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int explodeY = enemyTank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
//            tankFrame.explodes.add(new Explode(explodeX, explodeY,tankFrame));
            gm.getExplodes().add(RectFactory.getInstance().createExplode(explodeX,explodeY,gm));
            this.die();
            enemyTank.die();
        }
    }

    private void die() {
        this.live = false;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
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

    public GroupEnum getGroup() {
        return group;
    }

    public void setGroup(GroupEnum group) {
        this.group = group;
    }
}
