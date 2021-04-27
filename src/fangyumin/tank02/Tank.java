package fangyumin.tank02;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x,y;
    private DirectionEnum direction = DirectionEnum.DOWN;
    private final static int ENEMIES_SPEED = 1;
    private final static int MY_SPEED = 10;
    private boolean moving = true;
    private boolean live = true;
    private Random random = new Random();
    private TankFrame tankFrame;
    private GroupEnum group;
    public final static int WIDTH = ResourceLoaderManager.goodTankD.getWidth();
    public final static int HEIGHT = ResourceLoaderManager.goodTankD.getHeight();
    public Tank(int x, int y, DirectionEnum direction, GroupEnum group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.tankFrame = tankFrame;
        if (this.group.equals(GroupEnum.BAD)) {
            moving = true;
        }else {
            moving = false;
        }
    }

    public void paint(Graphics g) {
        move(moving);
        switch (direction){
            case UP:
                g.drawImage(this.group.equals(GroupEnum.BAD) ? ResourceLoaderManager.badTankU : ResourceLoaderManager.goodTankU,
                        x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group.equals(GroupEnum.BAD) ? ResourceLoaderManager.badTankD : ResourceLoaderManager.goodTankD,
                        x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group.equals(GroupEnum.BAD) ? ResourceLoaderManager.badTankL : ResourceLoaderManager.goodTankL,
                        x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group.equals(GroupEnum.BAD) ? ResourceLoaderManager.badTankR : ResourceLoaderManager.goodTankR,
                        x, y, null);
                break;
            default:
                break;
        }

        if (!live){
            tankFrame.enemiesTank.remove(this);
        }
    }

    private void move(boolean moving) {
        if(!moving) return;
        switch (direction){
            case UP:
                if (this.group.equals(GroupEnum.BAD)){
                    y -= ENEMIES_SPEED;
                }else {
                    y -= MY_SPEED;
                }
                break;
            case DOWN:
                if (this.group.equals(GroupEnum.BAD)){
                    y += ENEMIES_SPEED;
                }else {
                    y += MY_SPEED;
                }
                break;
            case RIGHT:
                if (this.group.equals(GroupEnum.BAD)){
                    x += ENEMIES_SPEED;
                }else {
                    x += MY_SPEED;
                }
                break;
            case LEFT:
                if (this.group.equals(GroupEnum.BAD)){
                    x -=  ENEMIES_SPEED;
                }else {
                    x -=  MY_SPEED;
                }
                break;
            default:
        }

        if (this.group.equals(GroupEnum.BAD) && this.random.nextDouble() > 0.98){
            this.fire();
            randomDirection();
        }

        boundsCheck();

    }

    private void boundsCheck() {
        if (this.x < 2) this.x = 2;
        if (this.x + Tank.WIDTH > tankFrame.getWidth() - 2) this.x = tankFrame.getWidth() - Tank.WIDTH;
        if (this.y < 30) this.y = 30;
        if (this.y + Tank.HEIGHT > tankFrame.getHeight()) this.y = tankFrame.getHeight() - Tank.HEIGHT;
    }

    private void randomDirection() {
        if (this.random.nextDouble() < 0.55) {
            return;
        }
        this.direction = DirectionEnum.values()[random.nextInt(4)];
    }

    //发射子弹
    public void fire() {
        int bulletX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        //通过持有tankFrame的引用来画子弹
        tankFrame.bullets.add(new Bullet(bulletX, bulletY, direction, this.group, this.tankFrame));
    }
    public void die() {
        this.live = false;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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
