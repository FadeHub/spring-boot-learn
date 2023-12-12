package com.sl;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @package: com.sl
 * @author: shuliangzhao
 * @description:
 * @date 2022/12/8 16:01
 */
public class ThumbnailsTest {

    public static void main(String[] args) throws IOException {
        Thumbnails.of("D:/test.jpg").size(200, 300).toFile("D:/image_200x300.jpg");
        Thumbnails.of("D:/test.jpg").size(2560, 2048).toFile("D:/image_1960x2048.jpg");

        Thumbnails.of("D:/test.jpg").scale(0.25f).outputQuality(0.8f).toFile("D:/image_25%.jpg");
        Thumbnails.of("D:/test.jpg").scale(0.75f).outputQuality(0.8f).toFile("D:/image_110%.jpg");

        Thumbnails.of("D:/test.jpg").size(120, 120).keepAspectRatio(false).toFile("D:/image_120x120.jpg");

        Thumbnails.of("D:/test.jpg").size(1280, 1024).rotate(90).toFile("D:/image+90.jpg");
        Thumbnails.of("D:/test.jpg").size(1280, 1024).rotate(-90).toFile("D:/iamge-90.jpg");

        Thumbnails.of("D:/test.jpg").size(1280, 1024).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:/watermark.png")), 0.5f)
                .outputQuality(0.8f).toFile("D:/image_watermark_bottom_right.jpg");
        Thumbnails.of("D:/test.jpg").size(1280, 1024).watermark(Positions.CENTER, ImageIO.read(new File("D:/watermark.png")), 0.5f)
                .outputQuality(0.8f).toFile("D:/image_watermark_center.jpg");

        Thumbnails.of("D:/test.jpg").sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("D:/image_region_center.jpg");
        Thumbnails.of("D:/test.jpg").size(1280, 1024).outputFormat("png").toFile("D:/image_1280x1024.png");

        OutputStream os = new FileOutputStream("D:/image_region_center.jpg");
        Thumbnails.of("D:/test.jpg").size(1280, 1024).toOutputStream(os);

        BufferedImage thumbnail = Thumbnails.of("D:/test.jpg").size(1280, 1024).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File("D:/image_1280x1024_BufferedImage.jpg"));


    }

}
