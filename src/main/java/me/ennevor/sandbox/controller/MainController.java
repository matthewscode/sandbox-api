package me.ennevor.sandbox.controller;


import me.ennevor.sandbox.SandboxApplication;
import me.ennevor.sandbox.entity.Entry;
import me.ennevor.sandbox.service.ImageService;
import me.ennevor.sandbox.util.ColorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController("/")
public class MainController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    ImageService imageService;


    @RequestMapping(value = "/lion/male/{bodyColor1}/{bodyColor2}/mane/{maneColor1}/{maneColor2}/eyes/{leftColor}/{rightColor}/muzzle/{muzzleColor1}/{muzzleColor2}/nose/{noseColor}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getMaleImageAsResponseEntity(@PathVariable String bodyColor1,
                                                           @PathVariable String bodyColor2,
                                                           @PathVariable String maneColor1,
                                                           @PathVariable String maneColor2,
                                                           @PathVariable String rightColor,
                                                           @PathVariable String leftColor,
                                                           @PathVariable String muzzleColor1,
                                                           @PathVariable String muzzleColor2,
                                                           @PathVariable String noseColor

    ) throws Exception {
        ResponseEntity<byte[]> responseEntity;
        final HttpHeaders headers = new HttpHeaders();
        Color bodyA = ColorUtility.colorFromRgbString(bodyColor1);
        Color bodyB = ColorUtility.colorFromRgbString(bodyColor2);
        Color maneA = ColorUtility.colorFromRgbString(maneColor1);
        Color maneB = ColorUtility.colorFromRgbString(maneColor2);
        Color eyeA = ColorUtility.colorFromRgbString(rightColor);
        Color eyeB = ColorUtility.colorFromRgbString(leftColor);
        Color muzzleA = ColorUtility.colorFromRgbString(muzzleColor1);
        Color muzzleB = ColorUtility.colorFromRgbString(muzzleColor2);
        Color noseA = ColorUtility.colorFromRgbString(noseColor);

        byte[] media =  toByteArrayAutoClosable(imageService.createMaleImage(bodyA, bodyB, maneA, maneB, eyeA, eyeB, muzzleA, muzzleB, noseA), "png");
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/lion/female/{bodyColor1}/{bodyColor2}/eyes/{leftColor}/nose/{noseColor}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getFemaleImageAsResponseEntity(@PathVariable String bodyColor1,
                                                           @PathVariable String bodyColor2,
                                                           @PathVariable String leftColor,
                                                           @PathVariable String noseColor

    ) throws Exception {
        ResponseEntity<byte[]> responseEntity;
        final HttpHeaders headers = new HttpHeaders();
        Color bodyA = ColorUtility.colorFromRgbString(bodyColor1);
        Color bodyB = ColorUtility.colorFromRgbString(bodyColor2);
        Color eyeB = ColorUtility.colorFromRgbString(leftColor);
        Color noseA = ColorUtility.colorFromRgbString(noseColor);

        byte[] media =  toByteArrayAutoClosable(imageService.createFemaleImage(bodyA, bodyB, eyeB, noseA), "png");
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> testingit() throws Exception {
        ResponseEntity<byte[]> responseEntity;
        final HttpHeaders headers = new HttpHeaders();

        byte[] media =  toByteArrayAutoClosable(imageService.createtestImage(), "png");
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

    private static byte[] toByteArrayAutoClosable(BufferedImage image, String type) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            ImageIO.write(image, type, out);
            return out.toByteArray();
        }
    }

}
