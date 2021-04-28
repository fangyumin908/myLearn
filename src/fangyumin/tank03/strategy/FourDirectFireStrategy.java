package fangyumin.tank03.strategy;

import fangyumin.tank03.Bullet;
import fangyumin.tank03.DirectionEnum;
import fangyumin.tank03.Tank;

public class FourDirectFireStrategy implements FireStrategy {

    private static FourDirectFireStrategy fourDirectFireStrategy;

    private FourDirectFireStrategy(){

    }

    //双重判断加锁单例
    public static FourDirectFireStrategy getInstance(){
        if (null == fourDirectFireStrategy){
            synchronized (FourDirectFireStrategy.class){
                if (null == fourDirectFireStrategy){
                    fourDirectFireStrategy = new FourDirectFireStrategy();
                }
            }
        }
        return fourDirectFireStrategy;
    }

    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (DirectionEnum dir : DirectionEnum.values()){
            tank.getGm().getGameObjects().add(new Bullet(bulletX,bulletY,dir,tank.getGroup(),tank.getGm()));
        }
    }
}
