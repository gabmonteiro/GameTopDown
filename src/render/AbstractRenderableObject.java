package render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AbstractRenderableObject extends RenderableObject {

    public AbstractRenderableObject(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getSprite(), getX() - Camera.x, getY() - Camera.y, null);
    }
}
