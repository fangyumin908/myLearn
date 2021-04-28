package fangyumin.tank03;

import fangyumin.tank03.facade.GameModel;
import fangyumin.tank03.strategy.FourDirectFireStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private GameModel gm = new GameModel(this);
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
        this.paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g ) {
        gm.paint(g);
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
            gm.setTankDirection(BL,BR,BU,BD);
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
                    FourDirectFireStrategy.getInstance().fire(gm.getMyTank());
                default:
                    break;
            }
            gm.setTankDirection(BL,BR,BU,BD);
        }

    }

}


