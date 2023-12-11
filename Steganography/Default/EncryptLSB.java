package Default;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class EncryptLSB {
    public static void Encrypt(File imageFile, String message) {
        String directory = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        String newImageFileString = directory + "\\export.png";
        File newImageFile = new File(newImageFileString);

        BufferedImage image;
        try {
            image = ImageIO.read(imageFile);
            BufferedImage imageToEncrypt = GetImageToEncrypt(image);
            Pixel[] pixels = GetPixelArray(imageToEncrypt);
            String[] messageBinary = messageToBinary(message);
        }catch (IOException e) {
            e.getMessage();
        }
    }

    private static BufferedImage GetImageToEncrypt(BufferedImage image) {
        ColorModel colorModel = image.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);
        return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
    }

    private static Pixel[] GetPixelArray(BufferedImage imageToEncrypt) {
        int height = imageToEncrypt.getHeight();
        int width= imageToEncrypt.getWidth();
        Pixel[] pixels = new Pixel[height * width];
        int count = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color colorToAdd = new Color(imageToEncrypt.getRGB(x, y));
                pixels[count] = new Pixel(x, y, colorToAdd);
                count++;
            }
        }
        return pixels;
    }
    private static String[] messageToBinary(String message) {
        int[] messageAscii = ConvertMessageToAscii(message);
        String messageBinary = ConvertAsciiToBinary(messageAscii);
    }

    private static int[] ConvertMessageToAscii(String message) {
        int[] messageAscii = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            messageAscii[i] = (int) message.charAt(i);
        }
        return messageAscii;
    }

    private static String[] ConvertAsciiToBinary(int[] asciiValues) {
        String[] messageBinary = new String[asciiValues.length];
        for (int i = 0; i < asciiValues.length; i++) {
            String binary = Integer.toBinaryString(asciiValues[i]);

        }
    }
}
