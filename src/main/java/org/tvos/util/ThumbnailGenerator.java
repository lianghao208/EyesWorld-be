package org.tvos.util;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

public class ThumbnailGenerator {

    /**
     *
     * @param originImageFile 原图片文件路径
     * @param thumbnailImageFile       要生成的缩略图文件路径
     * @param factor        缩小的倍数
     * @return
     * @throws Exception
     */
    public static boolean generate(String originImageFile,String thumbnailImageFile,int factor) throws Exception{
        File imageFile=new File(originImageFile);
        Image image= ImageIO.read(imageFile);
        int width=image.getWidth(null);
        int height=image.getHeight(null);
        // 取得图片读入器
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = readers.next();
        // 取得图片读入流
        InputStream source = new FileInputStream(originImageFile);
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        // 图片参数对象
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(width/factor, height/factor, (int)height/4, (int)height/2);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        ImageIO.write(bi, "JPG", new File(thumbnailImageFile+"thumbNail"));
        return true;
    }
}
