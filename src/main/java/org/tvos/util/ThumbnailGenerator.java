package org.tvos.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ThumbnailGenerator {

    /**
     *
     * @param originImageFile 原图片文件路径
     * @param thumbnailImageFile       要生成的缩略图文件路径
     * @param factor        缩小的倍数
     * @return
     * @throws Exception
     */
    public static boolean generate(String originImageFile,String thumbnailImageFile,double factor) throws Exception{
        File imageFile=new File(originImageFile);
        Image image= ImageIO.read(imageFile);
        int width=image.getWidth(null);
        int height=image.getHeight(null);
        BufferedImage buffi = new BufferedImage((int) (width/factor), (int)(height / factor),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = buffi.getGraphics();
        g.drawImage(image, 0, 0, (int)(width / factor), (int)(height / factor), null);
        g.dispose();
        ImageIO.write(buffi, "JPG", new File(thumbnailImageFile+"thumbNail"));
        return true;
    }
}
