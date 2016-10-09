import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RectanglesTest {

    private List<Rectangle> rectangles = new ArrayList<>();

    @Test
    public void outlineRectangleReturnsSameRectangle() {
        withRectangle(0, 0, 2, 4).assertOutlineToBe(0, 0, 2, 4);
    }

    @Test
    public void outlineRectangleWithLeftNeighbour() {
        withRectangle(0, 0, 2, 4).withRectangle(-1, 0, 2, 4).assertOutlineToBe(-1, 0, 3, 4);
    }

    @Test
    public void outlineRectangleWithRightNeighbour() {
        withRectangle(0, 0, 2, 4).withRectangle(1, 0, 2, 4).assertOutlineToBe(0, 0, 3, 4);
    }

    @Test
    public void outlineRectangleWithLowerNeighbour() {
        withRectangle(0, 0, 2, 4).withRectangle(0, -1, 2, 4).assertOutlineToBe(0, -1, 2, 5);
    }

    @Test
    public void outlineRectangleWithHigherNeighbour() {
        withRectangle(0, 0, 2, 4).withRectangle(0, 1, 2, 4).assertOutlineToBe(0, 0, 2, 5);
    }

    private RectanglesTest withRectangle(int x, int y, int width, int height) {
        rectangles.add(new Rectangle(x, y, width, height));
        return this;
    }

    private void assertOutlineToBe(int x, int y, int width, int height) {
        Assert.assertEquals(new Rectangle(x, y, width, height), Rectangles.outline(rectangles));
    }
}
