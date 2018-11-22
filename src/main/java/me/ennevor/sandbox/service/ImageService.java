package me.ennevor.sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import static me.ennevor.sandbox.SandboxApplication.*;

@Service
public class ImageService {

    @Autowired
    ServletContext servletContext;

    public BufferedImage createtestImage() {
        String path = "src/main/webapp/WEB-INF/images/";
        int height = 950;
        int width = 900;

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage testImage = ImageIO.read(new File(path,"male_adult_body_color.png"));
         Area testArea = createArea(female_adult_body_outline, new Color(0, 0, 255));


        return result;
    }
    public BufferedImage createMaleImage(Color bodyA, Color bodyB, Color maneA, Color maneB, Color eyeA, Color eyeB, Color muzzleA, Color muzzleB, Color noseA) throws Exception {
        int height = 950;
        int width = 900;

        //create base
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        GradientPaint bodyGradient = new GradientPaint(0, 0, bodyA, 0, height,
                bodyB);
        GradientPaint maneGradient = new GradientPaint(0, 0, maneA, 0, height,
                maneB);
        GradientPaint muzzleGradient = new GradientPaint(0, 0, muzzleA, 0, height,
                muzzleB);

        g.setClip(maleAdultBodyColor);
        g.setPaint(bodyGradient);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultBodyColor);


        g.setClip(maleAdultBodyOutline);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(8));
        g.draw(maleAdultBodyOutline);

        g.setClip(maleAdultManeColor);
        g.setPaint(maneGradient);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultManeColor);

        g.setClip(maleAdultManeOutline);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(8));
        g.draw(maleAdultManeOutline);

        g.setClip(maleAdultEyeWhites);
        g.setPaint(Color.white);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultEyeWhites);

        g.setClip(maleAdultEyeRight);
        g.setPaint(eyeA);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultEyeRight);

        g.setClip(maleAdultEyeLeft);
        g.setPaint(eyeB);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultEyeLeft);

        g.setClip(maleAdultMuzzleColor);
        g.setPaint(muzzleGradient);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultMuzzleColor);

        g.setClip(maleAdultNoseColor);
        g.setPaint(noseA);
        g.fillRect(0,0, width, height);
        g.draw(maleAdultNoseColor);

        g.setClip(maleAdultFaceOutline);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(8));
        g.draw(maleAdultFaceOutline);
        return result;
    }

    public BufferedImage createFemaleImage(Color bodyA, Color bodyB, Color eyeB, Color noseA) throws Exception {
        int height = 600;
        int width = 900;

        //create base
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        GradientPaint bodyGradient = new GradientPaint(0, 0, bodyA, 0, height,
                bodyB);

        g.setClip(femaleAdultBodyColor);
        g.setPaint(bodyGradient);
        g.fillRect(0,0, width, height);
        g.draw(femaleAdultBodyColor);


        g.setClip(femaleAdultBodyOutline);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(8));
        g.draw(femaleAdultBodyOutline);


        g.setClip(femaleAdultEyeWhites);
        g.setPaint(Color.gray);
        g.fillRect(0,0, width, height);
        g.draw(femaleAdultEyeWhites);

        g.setClip(femaleAdultEyeLeft);
        g.setPaint(eyeB);
        g.fillRect(0,0, width, height);
        g.draw(femaleAdultEyeLeft);

        g.setClip(femaleAdultNoseColor);
        g.setPaint(noseA);
        g.fillRect(0,0, width, height);
        g.draw(femaleAdultNoseColor);

        return result;
    }

    public static Area getOutline(BufferedImage image, Color color, boolean include, int tolerance) {
        Area area = new Area();
        for (int x=0; x<image.getWidth(); x++) {
            for (int y=0; y<image.getHeight(); y++) {
                Color pixel = new Color(image.getRGB(x,y));
                if (include) {
                    if (isIncluded(color, pixel, tolerance)) {
                        Rectangle r = new Rectangle(x,y,1,1);
                        area.add(new Area(r));
                    }
                } else {
                    if (!isIncluded(color, pixel, tolerance)) {
                        Rectangle r = new Rectangle(x,y,1,1);
                        area.add(new Area(r));
                    }
                }
            }
        }
        return area;
    }

    public static boolean isIncluded(Color target, Color pixel, int tolerance) {
        int rT = target.getRed();
        int gT = target.getGreen();
        int bT = target.getBlue();
        int rP = pixel.getRed();
        int gP = pixel.getGreen(); 
        int bP = pixel.getBlue();
        return(
                (rP-tolerance<=rT) && (rT<=rP+tolerance) &&
                        (gP-tolerance<=gT) && (gT<=gP+tolerance) &&
                        (bP-tolerance<=bT) && (bT<=bP+tolerance) );
    }

    public static BufferedImage drawOutline(int w, int h, Area area) {
        final BufferedImage result = new BufferedImage(
                w,
                h,
                BufferedImage.TYPE_INT_RGB);
//        Graphics2D g = result.createGraphics();
//
//        g.setColor(Color.white);
//        g.fillRect(0,0,w,h);
//
//        g.setClip(area);
//        g.setColor(Color.red);
//        g.fillRect(0,0,w,h);
//
//        g.setClip(null);
//        g.setStroke(new BasicStroke(1));
//        g.setColor(Color.blue);
//        g.draw(area);

        return result;
    }

    public static BufferedImage createAndWrite(
            BufferedImage image,
            Color color,
            boolean include,
            int tolerance,
            String name)
            throws Exception {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println("Get Area: " + new Date() + " - " + name);
        Area area = getOutline(image, color, include, tolerance);
        System.out.println("Got Area: " + new Date() + " - " + name);

        final BufferedImage result = drawOutline(w,h,area);
//        displayAndWriteImage(result, name);

        return result;
    }


}
