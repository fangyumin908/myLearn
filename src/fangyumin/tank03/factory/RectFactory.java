package fangyumin.tank03.factory;

import fangyumin.tank03.RectExplode;
import fangyumin.tank03.TankFrame;

public class RectFactory extends AbstractFactory{

    private final static RectFactory RECT_FACTORY = new RectFactory();

    private RectFactory(){

    }

    public static RectFactory getInstance(){
        return RECT_FACTORY;
    }

    @Override
    BaseTankFactory createTank() {
        return null;
    }

    @Override
    BaseBulletFactory createBullet() {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }
}
