package com.ly.provider.config.authentication.image;


import java.awt.image.BufferedImage;
import java.time.LocalDateTime;


public class ImageCode  {
   private BufferedImage image;
    private  String code;
    private LocalDateTime expireTime;//过期时间
    /**
     *
     * @param image
     * @param code
     * @param expireInt :该参数是过期时间秒数,如60
     */
    public ImageCode(BufferedImage image, String code, int expireInt) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireInt);//当前时间加上60秒
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
