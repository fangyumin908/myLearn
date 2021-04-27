package fangyumin.tank02.tank_test;


import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TestImage {

    @Test
    public void testImage() {
        try{
            BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(TestImage.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
            Assert.assertNotNull(bufferedImage);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
