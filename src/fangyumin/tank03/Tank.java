package fangyumin.tank03;

import fangyumin.tank03.facade.GameModel;
import fangyumin.tank03.strategy.DefaultFireStrategy;
import fangyumin.tank03.strategy.FireStrategy;
import fangyumin.tank03.utils.PropertiesLoaderUtil;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject{
    private int x,y;  //坦克当前位置
    private int oldX, oldY; //记录移动前坦克的位置
    private DirectionEnum direction = DirectionEnum.DOWN;
    private int ENEMIES_SPEED = Integer.parseInt(PropertiesLoaderUtil.getValue("enemyTankSpeed"));;
    private int MY_SPEED = Integer.parseInt(PropertiesLoaderUtil.getValue("myTankSpeed"));;
    private boolean moving = true;
    private boolean live = true;
    private Random random = new Random();
    private GameModel gm;
    private GroupEnum group;
    public Rectangle rectangle = new Rectangle();
    public final static int WIDTH = ResourceLoaderManager.goodTankD.getWidth();
    public final static int HEIGHT = ResourceLoaderManager.goodTankD.getHeight();
    public final static int BAD_WIDTH = ResourceLoaderManager.badTankU.getWidth();
    public final static int BAD_HEIGHT = ResourceLoaderManager.badTankU.getHeight();

    public Tank() {
    }

    public Tank(int x, int y, DirectionEnum direction, GroupEnum group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.gm = gm;

        rectangle.x = this.x;
        rectangle.y = this.y;

        if (this.group.equals(GroupEnum.BAD)) {
            moving = true;
        }else {
            moving = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        move(moving);
        //更新坦克图形坐标
        rectangle.x = this.x;
        rectangle.y = this.y;

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
            gm.getGameObjects().remove(this);
        }
    }

    public void paint(Graphics g, FireStrategy fireStrategy) {
        move(moving);
        this.paint(g);
    }

    private void move(boolean moving) {
        if(!moving) return;
        //坦克移动前的位置先记录下来
        oldX = x;
        oldY = y;

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
            DefaultFireStrategy.getInstance().fire(this);
            randomDirection();
        }

        boundsCheck();

    }

    /**
     * 边界检测，不让坦克走出界面
     */
    private void boundsCheck() {
        TankFrame tankFrame = gm.getTankFrame();
        if (this.x < 2) this.x = 2;
        if (this.x + Tank.WIDTH > tankFrame.getWidth() - 2) this.x = tankFrame.getWidth() - Tank.WIDTH - 2;
        if (this.y < 30) this.y = 30;
        if (this.y + Tank.HEIGHT > tankFrame.getHeight()) this.y = tankFrame.getHeight() - Tank.HEIGHT;
    }

    private void randomDirection() {
        if (this.random.nextDouble() < 0.55) {
            return;
        }
        this.direction = DirectionEnum.values()[random.nextInt(4)];
    }

    //未使用策略模式前，只有一种发射子弹模式
    //发射子弹
    public void fire() {
        TankFrame tankFrame = gm.getTankFrame();
        int bulletX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        //通过持有tankFrame的引用来画子弹
        gm.getGameObjects().add(new Bullet(bulletX, bulletY, direction, this.group, gm));
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

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }
}
