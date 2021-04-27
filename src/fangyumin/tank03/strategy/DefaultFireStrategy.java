package fangyumin.tank03.strategy;

import fangyumin.tank03.Bullet;
import fangyumin.tank03.Tank;

public class DefaultFireStrategy implements FireStrategy {
    //饿汉单例
//    private final static DefaultFireStrategy DEFAULT_FIRE_STRATEGY = new DefaultFireStrategy();
//
//    private DefaultFireStrategy(){
//    }
//
//    public static DefaultFireStrategy getInstance(){
//        return DEFAULT_FIRE_STRATEGY;
//    }

    //静态内部类单例
    static class DefaultFireHolder{
        private static final DefaultFireStrategy DEFAULT_FIRE_STRATEGY = new DefaultFireStrategy();

    }

    private DefaultFireStrategy() {}

    public static DefaultFireStrategy getInstance(){
        return DefaultFireHolder.DEFAULT_FIRE_STRATEGY;
    }



    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bulletY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        //通过持有tankFrame的引用来画子弹
        tank.getGm().getBullets().add(new Bullet(bulletX, bulletY, tank.getDirection(),
                tank.getGroup(), tank.getGm()));
    }



}
