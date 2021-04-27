package fangyumin.tank03;

import fangyumin.tank03.factory.BaseExplode;
import fangyumin.tank03.strategy.DefaultFireStrategy;
import fangyumin.tank03.strategy.FourDirectFireStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {


    Tank myTank = new Tank(200, 200, DirectionEnum.DOWN, GroupEnum.GOOD, this);

    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> enemiesTank = new ArrayList<Tank>();
    List<BaseExplode> explodes =  new ArrayList<>();

    private final int GAME_WIDTH = 1280,GAME_HEIGHT = 768;
    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        addKeyListener(new keyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }



    @Override
    public void paint(Graphics g ) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹数量 ： " + bullets.size(), 10 , 60);
        g.drawString("坦克数量 ： " + enemiesTank.size(), 10 , 75);
        g.drawString("爆炸数量 ： " + explodes.size(), 10 , 90);
        g.setColor(c);

        myTank.paint(g, FourDirectFireStrategy.getInstance());
//        explode.paint(g);
        for (int i = 0; i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < enemiesTank.size(); i++){
            enemiesTank.get(i).paint(g, DefaultFireStrategy.getInstance());
        }

        for (int i = 0; i < explodes.size(); i++){
            explodes.get(i).paint(g);
        }

        collideCheck(bullets, enemiesTank);

    }

    private void collideCheck(List<Bullet> bullets, List<Tank> enemiesTank) {
        for (int i = 0; i < bullets.size(); i++){
            for (int j = 0;j < enemiesTank.size(); j++){
                bullets.get(i).collideCheck(enemiesTank.get(j));
            }
        }
    }

    class keyListener extends KeyAdapter{

        boolean BL = false;
        boolean BR = false;
        boolean BU = false;
        boolean BD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode){
                case KeyEvent.VK_LEFT :
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT :
                    BR = true;
                    break;
                case KeyEvent.VK_UP :
                    BU =  true;
                    break;
                case KeyEvent.VK_DOWN :
                    BD = true;
                    break;
                default:
                    break;
            }
            setTankDirection();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT :
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT :
                    BR = false;
                    break;
                case KeyEvent.VK_UP :
                    BU =  false;
                    break;
                case KeyEvent.VK_DOWN :
                    BD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    //策略模式，发射4颗子弹
                    FourDirectFireStrategy.getInstance().fire(myTank);
                default:
                    break;
            }
            setTankDirection();
        }

        private void setTankDirection() {

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

    public List<Bullet> getBullets() {
        return bullets;
    }
}


