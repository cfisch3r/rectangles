import java.util.List;

public class Rectangles {
    public static Rectangle outline(List<Rectangle> rectangles) {
        Rectangle outline = null;
        for (Rectangle rectangle : rectangles) {
            if (outline == null) {
                outline = rectangle.clone();
            } else {
                if (rectangle.getX() < outline.getX()) {
                    outline = new Rectangle(rectangle.getX(),outline.getY(),
                            outline.getWidth() + outline.getX() - rectangle.getX(),
                            rectangle.getHeight());
                }

                if (rectangle.getX() + rectangle.getWidth() > outline.getX() + outline.getWidth()) {
                    outline = new Rectangle(outline.getX(),outline.getY(),
                            rectangle.getX() + rectangle.getWidth() - outline.getX(),
                            rectangle.getHeight());
                }

                if (rectangle.getY() < outline.getY()) {
                    outline = new Rectangle(outline.getX(),rectangle.getY(), outline.getWidth(),
                            outline.getHeight() + outline.getY() - rectangle.getY());
                }

                if (rectangle.getY() + rectangle.getHeight() > outline.getY() + outline.getHeight()) {
                    outline = new Rectangle(outline.getX(), outline.getY(), outline.getWidth(),
                            rectangle.getY() + rectangle.getHeight() - outline.getY());
                }
            }
        }

        return outline;
    }

}
