package fangyumin.tank03.facade;

import fangyumin.tank03.*;
import fangyumin.tank03.strategy.FourDirectFireStrategy;
import fangyumin.tank03.utils.PropertiesLoaderUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 门面模式，与TankFrame,Tank,Bullets等游戏类交互，避免它们之间直接交互
 */
public class GameModel {
    Tank myTank = new Tank(200, 200, DirectionEnum.DOWN, GroupEnum.GOOD, this);

    //这里的不同类对象就可以统一写进一个List了
//    private List<Bullet> bullets = new ArrayList<Bullet>();
//    private List<Tank> enemiesTank = new ArrayList<Tank>();
//    private List<BaseExplode> explodes =  new ArrayList<>();
    private List<GameObject> gameObjects = new ArrayList<>();

    private TankFrame tankFrame;

    public GameModel(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
        int enemiesCount = Integer.parseInt(Objects.requireNonNull(PropertiesLoaderUtil.getValue("enemiesInitializationCount")));
        gameObjects.add(myTank);
        for (int i = 0; i < enemiesCount; i++) {
            gameObjects.add(new Tank(i * 100, 100, DirectionEnum.DOWN, GroupEnum.BAD, this));
        }

    }


    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

    public Tank getMyTank() {
        return myTank;
    }

    public void setMyTank(Tank myTank) {
        this.myTank = myTank;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹数量 ： " + bullets.size(), 10 , 60);
//        g.drawString("坦克数量 ： " + enemiesTank.size(), 10 , 75);
//        g.drawString("爆炸数量 ： " + explodes.size(), 10 , 90);
        g.setColor(c);

//        myTank.paint(g);
//        explode.paint(g);
        for (int i = 0; i < gameObjects.size();i++){
            gameObjects.get(i).paint(g);
        }

        //碰撞检测旧写法
//        for (int i = 0; i < enemiesTank.size(); i++){
//            enemiesTank.get(i).paint(g, DefaultFireStrategy.getInstance());
//        }
//
//        for (int i = 0; i < explodes.size(); i++){
//            explodes.get(i).paint(g);
//        }
//
//        collideCheck(bullets, enemiesTank);
    }

    private void collideCheck(List<Bullet> bullets, List<Tank> enemiesTank) {
        for (int i = 0; i < bullets.size(); i++){
            for (int j = 0;j < enemiesTank.size(); j++){
                bullets.get(i).collideCheck(enemiesTank.get(j));
            }
        }
    }

    public void setTankDirection(boolean BL,boolean BR,boolean BU,boolean BD) {

        if (!BL && !BR && !BD && !BU) {
            myTank.setMoving(false);
        } else {
            myTank.setMoving(true);
            if (BL) {
                myTank.setDirection(DirectionEnum.LEFT);
            }
            if (BR) {
                myTank.setDirection(DirectionEnum.RIGHT);
            }
            if (BU) {
                myTank.setDirection(DirectionEnum.UP);
            }
            if (BD) {
                myTank.setDirection(DirectionEnum.DOWN);
            }
        }
    }
}
