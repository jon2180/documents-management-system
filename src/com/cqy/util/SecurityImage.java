package com.cqy.util;

/**
 * Created by goumin on 2019/10/24.
 */

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 工具类，生成验证码图片
 */
public class SecurityImage {
    public static BufferedImage createImage(String securityCode) {
        //验证码长度
        int codeLength = securityCode.length();
        //字体大小
        int fSize = 15;
        int fWidth = fSize + 1;
        //图片宽度
        int width = codeLength * fWidth + 6;
        //图片高度
        int height = fSize * 2 + 1;
        //图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        //设置背景色
        g.setColor(Color.WHITE);
        //填充背景
        g.fillRect(0, 0, width, height);
        //设置边框颜色
        g.setColor(Color.LIGHT_GRAY);
        //边框字体样式
        g.setFont(new Font("Arial", Font.BOLD, height - 2));
        //绘制边框
        g.drawRect(0, 0, width - 1, height - 1);
        //绘制噪点
        Random rand = new Random();
        //设置噪点颜色
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < codeLength * 6; i++) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            //绘制1*1大小的矩形
            g.drawRect(x, y, 1, 1);
        }
        //绘制验证码
        int codeY = height - 10;
        //设置字体颜色和样式
        g.setColor(new Color(19, 148, 246));
        g.setFont(new Font("Georgia", Font.BOLD, fSize));
        for (int i = 0; i < codeLength; i++) {
            g.drawString(String.valueOf(securityCode.charAt(i)), i * 16 + 5, codeY);
        }
        g.dispose();
        return image;
    }

    public static ByteArrayInputStream getImageAsInputStream(String securityCode) {
        BufferedImage image = createImage(securityCode);
        return convertImageToStream(image);
    }

    private static ByteArrayInputStream convertImageToStream(BufferedImage image) {
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageOutputStream imageOutputStream = null;
        try {
            imageOutputStream = ImageIO.createImageOutputStream(bos);
            ImageIO.write(image, "jpg", imageOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputStream = new ByteArrayInputStream(bos.toByteArray());
        return inputStream;
    }
}
