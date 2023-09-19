import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {


       BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();

        ArrayList<Object> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(6, 4));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(4, 3));
        rectangles.add(new Rectangle(8, 9));
        rectangles.add(new Rectangle(2, 1));
        rectangles.add(new Rectangle(3, 6));
        rectangles.add(new Rectangle(7, 3));
        rectangles.add(new Rectangle(3, 1));
        rectangles.add(new Rectangle(8, 10));

        rectangles = BigRectangleFilter.collectAll(rectangles, new BigRectangleFilter());

        System.out.println("Rectangles from the array list that have a perimeter over 10: ");
        for (Object x : rectangles) {
            System.out.println(x);

            if(bigRectangleFilter.accept(rectangles)){
                System.out.println(rectangles);
            }

        }

    }
}






