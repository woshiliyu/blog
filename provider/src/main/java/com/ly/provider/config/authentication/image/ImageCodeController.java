package com.ly.provider.config.authentication.image;



import com.ly.provider.util.rest.support.HttpKit;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;



@RestController
public class ImageCodeController {

    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();

    @RequestMapping(value="/imageCode" ,method = RequestMethod.GET)
    public void imageCode(HttpServletRequest request , HttpServletResponse response) throws IOException {
        //生成imageCode对象
        ImageCode imageCode=createImageCode();
        //将图形验证码存入到session中
        //sessionStrategy.setAttribute(new ServletWebRequest(request),"imageCode",imageCode);
        HttpSession session= HttpKit.getRequest().getSession();
        session.setAttribute("imageCode",imageCode);
        // 将生成的图片写到接口的响应中
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());

    }

    private ImageCode createImageCode() {
        int width=80;
        int height=30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String code = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            code += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageCode(image, code, 60);
    }
    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


}
