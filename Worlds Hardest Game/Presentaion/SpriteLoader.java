package Presentaion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SpriteLoader {

    private static HashMap<String, BufferedImage> cache = new HashMap<>();

    public static BufferedImage load(String name) {

        if (cache.containsKey(name)) {
            return cache.get(name);
        }

        try {
            BufferedImage img = ImageIO.read(new File("images/" + name));

            cache.put(name, img);
            return img;

        } catch (IOException e) {
            System.out.println("No se pudo cargar: " + name);
            return createPlaceholder();
        }
    }

    private static BufferedImage createPlaceholder() {

        BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                img.setRGB(x, y, 0xFFFF00FF);
            }
        }

        return img;
    }
}