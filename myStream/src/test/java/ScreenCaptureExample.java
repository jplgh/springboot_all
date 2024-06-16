import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenCaptureExample {
    public static void main(String[] args) {
        try {
            // 创建Robot对象
            Robot robot = new Robot();

            // 获取屏幕分辨率
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // 捕获屏幕截图
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            // 保存截图
            ImageIO.write(screenFullImage, "png", new File("screenshot.png"));

            System.out.println("屏幕截图已保存为 screenshot.png");
        } catch (AWTException | IOException ex) {
            System.err.println("屏幕截图失败：" + ex);
        }
    }
}
