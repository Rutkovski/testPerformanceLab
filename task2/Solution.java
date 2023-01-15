import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Float> circleData = getCircleDate(args[0]);
        List<List<Float>> coordinates = getCoordinates(args[1]);
        if (!circleData.isEmpty() && !coordinates.isEmpty()) {
            if (coordinates.size()>=100) {
                for (int i = 0; i < 100; i++) {
                    List <Float> coordinate = coordinates.get(i);
                    calculation(circleData.get(0), circleData.get(1), circleData.get(2), coordinate.get(0), coordinate.get(1));
                }
            } else {
                for (List<Float> coordinate : coordinates) {
                    calculation(circleData.get(0), circleData.get(1), circleData.get(2), coordinate.get(0), coordinate.get(1));
                }
            }

        }
    }

    private static List<Float> getCircleDate(String fileCircle) {
        List<Float> circleData = new ArrayList<>();
        try (BufferedReader fileReaderCircle = new BufferedReader(new FileReader(fileCircle))) {

            String[] strings = fileReaderCircle.readLine().trim().split(" ");
            if (strings.length > 1) {
                circleData.add(Float.parseFloat(strings[0]));
                circleData.add(Float.parseFloat(strings[1]));
                circleData.add(Float.parseFloat(fileReaderCircle.readLine().trim()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return circleData;
    }

    private static List<List<Float>> getCoordinates(String fileCircle) {
        List<List<Float>> coordinates = new ArrayList<>();
        try (BufferedReader fileReaderCoordinates = new BufferedReader(new FileReader(fileCircle))) {
            while (fileReaderCoordinates.ready()) {
                String[] stringsCoordinates = fileReaderCoordinates.readLine().trim().split(" ");
                if (stringsCoordinates.length > 1) {
                    List<Float> pointCoordinates = new ArrayList<>();
                    pointCoordinates.add(Float.parseFloat(stringsCoordinates[0]));
                    pointCoordinates.add(Float.parseFloat(stringsCoordinates[1]));
                    coordinates.add(pointCoordinates);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return coordinates;
    }

    private static void calculation(float x_center, float y_center, float r_circle, float x_point, float y_point) {

        double hypotenuse = (Math.pow(x_point - x_center, 2) + Math.pow(y_point - y_center, 2));
        if (hypotenuse < Math.pow(r_circle, 2)) {
            System.out.print(1 + "\n");
        } else if (hypotenuse == Math.pow(r_circle, 2)) {
            System.out.print(0 + "\n");
        } else {
            System.out.print(2 + "\n");
        }
    }


}
