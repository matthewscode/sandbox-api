package me.ennevor.sandbox;

import me.ennevor.sandbox.entity.Entry;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SandboxApplication {
	public static Area maleAdultBodyColor;
	public static Area maleAdultBodyOutline;
	public static Area maleAdultManeColor;
	public static Area maleAdultManeOutline;
	public static Area maleAdultEyeWhites;
	public static Area maleAdultEyeRight;
	public static Area maleAdultEyeLeft;
	public static Area maleAdultNoseColor;
	public static Area maleAdultMuzzleColor;
	public static Area maleAdultFaceOutline;

	public static Area femaleAdultBodyColor;
	public static Area femaleAdultBodyOutline;
	public static Area femaleAdultEyeWhites;
	public static Area femaleAdultEyeLeft;
	public static Area femaleAdultNoseColor;
	public static void main(String[] args) {

		SpringApplication.run(SandboxApplication.class, args);
		initializeAreas();
	}

	static void initializeAreas(){
		//male lion base
		String path = "src/main/webapp/WEB-INF/images/";
//		BufferedImage male_adult_body_color = null;
//		BufferedImage male_adult_body_outline = null;
//		BufferedImage male_adult_mane_color = null;
//		BufferedImage male_adult_mane_outline = null;
//		BufferedImage male_adult_eye_whites = null;
//		BufferedImage male_adult_eye_right = null;
//		BufferedImage male_adult_eye_left = null;
//		BufferedImage male_adult_nose_color = null;
//		BufferedImage male_adult_muzzle_color = null;
//		BufferedImage male_adult_face_outline = null;
//
//		BufferedImage female_adult_body_color = null;
//		BufferedImage female_adult_body_outline = null;
//		BufferedImage female_adult_eye_whites = null;
//		BufferedImage female_adult_eye_left = null;
//		BufferedImage female_adult_nose_color = null;

//		try {
//			male_adult_body_color  = ImageIO.read(new File(path,"male_adult_body_color.png"));
//			male_adult_body_outline = ImageIO.read(new File(path,"male_adult_body_outline.png"));
//			male_adult_mane_color = ImageIO.read(new File(path,"male_adult_mane_color.png"));
//			male_adult_mane_outline = ImageIO.read(new File(path,"male_adult_mane_outline.png"));
//			male_adult_eye_whites = ImageIO.read(new File(path,"male_adult_eye_whites.png"));
//			male_adult_eye_right = ImageIO.read(new File(path,"male_adult_eye_right.png"));
//			male_adult_eye_left = ImageIO.read(new File(path,"male_adult_eye_left.png"));
//			male_adult_nose_color = ImageIO.read(new File(path,"male_adult_nose_color.png"));
//			male_adult_muzzle_color = ImageIO.read(new File(path,"male_adult_muzzle_color.png"));
//			male_adult_face_outline = ImageIO.read(new File(path,"male_adult_face_outline.png"));

//			female_adult_body_color  = ImageIO.read(new File(path,"female_adult_body_color.png"));
//			female_adult_body_outline  = ImageIO.read(new File(path,"female_adult_body_outline.png"));
//			female_adult_eye_whites  = ImageIO.read(new File(path,"female_adult_eye_whites.png"));
//			female_adult_eye_left  = ImageIO.read(new File(path,"female_adult_eye_left.png"));
//			female_adult_nose_color  = ImageIO.read(new File(path,"female_adult_nose_color.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		System.out.println("creating areas...");
//		femaleAdultBodyOutline = createArea(female_adult_body_outline, new Color(0, 0, 255));
//		femaleAdultBodyColor = createArea(female_adult_body_color, new Color(0, 255, 0));
//		femaleAdultEyeLeft = createArea(female_adult_eye_left, new Color(0, 255, 0));
//		femaleAdultEyeWhites = createArea(female_adult_eye_whites, new Color(0, 255, 0));
//		femaleAdultEyeLeft = createArea(female_adult_eye_left, new Color(0, 255, 0));
//		femaleAdultNoseColor = createArea(female_adult_nose_color, new Color(0, 255, 0));
//		maleAdultBodyOutline = createArea(male_adult_body_outline, new Color(0, 0, 255));
//		maleAdultManeOutline = createArea(male_adult_mane_outline, new Color(0, 0, 255));
//		maleAdultFaceOutline = createArea(male_adult_face_outline, new Color(0, 0, 255));
//
//        maleAdultBodyColor = createArea(male_adult_body_color, new Color(0, 255, 0));
//		maleAdultManeColor = createArea(male_adult_mane_color, new Color(0, 255, 0));
//		maleAdultEyeWhites = createArea(male_adult_eye_whites, new Color(0, 255, 0));
//		maleAdultEyeRight = createArea(male_adult_eye_right, new Color(0, 255, 0));
//		maleAdultEyeLeft = createArea(male_adult_eye_left, new Color(0, 255, 0));
//		maleAdultNoseColor = createArea(male_adult_nose_color, new Color(0, 255, 0));
//		maleAdultMuzzleColor = createArea(male_adult_muzzle_color, new Color(0, 255, 0));

//		try {
//			maleAdultBodyOutline = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_body_outline.txt");
//			maleAdultManeOutline = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_mane_outline.txt");
//			maleAdultFaceOutline = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_face_outline.txt");
//
//			maleAdultBodyColor = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_body_color.txt");
//			maleAdultManeColor = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_mane_color.txt");
//			maleAdultEyeWhites = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_eye_whites.txt");
//			maleAdultEyeRight = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_eye_right.txt");
//			maleAdultEyeLeft = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_eye_left.txt");
//			maleAdultNoseColor = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_nose_color.txt");
//			maleAdultMuzzleColor = serializeDataIn("src/main/webapp/WEB-INF/shapes/male_adult_muzzle_color.txt");
//
//			femaleAdultBodyOutline = serializeDataIn("src/main/webapp/WEB-INF/shapes/female_adult_body_outline.txt");
//
//			femaleAdultBodyColor = serializeDataIn("src/main/webapp/WEB-INF/shapes/female_adult_body_color.txt");
//			femaleAdultEyeWhites = serializeDataIn("src/main/webapp/WEB-INF/shapes/female_adult_eye_whites.txt");
//			femaleAdultEyeLeft = serializeDataIn("src/main/webapp/WEB-INF/shapes/female_adult_eye_left.txt");
//			femaleAdultNoseColor = serializeDataIn("src/main/webapp/WEB-INF/shapes/female_adult_nose_color.txt");
//			System.out.println("areas loaded");
//        } catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

//		System.out.println("areas have been creeated");
//		System.out.println("serializing and saving...");
//		try {
//			serializeDataOut(femaleAdultBodyOutline, "female_adult_body_outline.txt");
//			serializeDataOut(femaleAdultBodyColor, "female_adult_body_color.txt");
//			serializeDataOut(femaleAdultEyeWhites, "female_adult_eye_whites.txt");
//			serializeDataOut(femaleAdultEyeLeft, "female_adult_eye_left.txt");
//			serializeDataOut(femaleAdultNoseColor, "female_adult_nose_color.txt");
//			serializeDataOut(maleAdultBodyOutline, "male_adult_body_outline.txt");
//			serializeDataOut(maleAdultManeOutline, "male_adult_mane_outline.txt");
//			serializeDataOut(maleAdultFaceOutline, "male_adult_face_outline.txt");
//
//			serializeDataOut(maleAdultBodyColor, "male_adult_body_color.txt");
//			serializeDataOut(maleAdultManeColor, "male_adult_mane_color.txt");
//			serializeDataOut(maleAdultEyeWhites, "male_adult_eye_whites.txt");
//			serializeDataOut(maleAdultEyeRight, "male_adult_eye_right.txt");
//			serializeDataOut(maleAdultEyeLeft, "male_adult_eye_left.txt");
//			serializeDataOut(maleAdultNoseColor, "male_adult_nose_color.txt");
//			serializeDataOut(maleAdultMuzzleColor, "male_adult_muzzle_color.txt");


//		} catch (IOException e) {
//			System.out.println("HOLY FUCK");
//			System.out.println(e.getCause());
//		}


	}

	public static Area createArea(BufferedImage baseImage, Color color){
		Area area = new Area();
		int width = baseImage.getWidth();
		int height = baseImage.getHeight();

		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++){
				Color pixel = new Color(baseImage.getRGB(x,y));
				if(pixel.getRGB() == color.getRGB()){
					Rectangle r = new Rectangle(x,y,1,1);
					area.add(new Area(r));
				}
			}
		}
		return area;
	}

	public static void serializeDataOut(Area area, String fileName)throws IOException{
		FileOutputStream fos = new FileOutputStream("src/main/webapp/WEB-INF/shapes/" + fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(AffineTransform.getTranslateInstance(0,0).createTransformedShape(area));
		oos.close();
	}

	public static Area serializeDataIn(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Area area = new Area((Shape) ois.readObject());
		ois.close();
		return area;
	}
}
