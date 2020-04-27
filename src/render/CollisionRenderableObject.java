package render;

import java.awt.image.BufferedImage;

public class CollisionRenderableObject extends AbstractRenderableObject implements CollisionObject {

    public CollisionRenderableObject(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    @Override
    public boolean checkCollision(RenderableObject object) {
        return false;
    }
}
