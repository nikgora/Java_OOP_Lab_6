import java.util.Arrays;
import java.util.NoSuchElementException;

public class Vector2 implements Iterable<Double> {
    private double[] coordinates;

    // конструктор за замовчуванням створює вектор нульової довжини
    public Vector2() {
        this.coordinates = new double[0];
    }

    // конструктор, який створює вектор з заданими розміром
    public Vector2(int n) {
        this.coordinates = new double[n];
    }

    // конструктор, який створює вектор з заданими координатами
    public Vector2(double[] coordinates) {
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    // конструктор копії
    public Vector2(Vector2 other) {
        this.coordinates = Arrays.copyOf(other.coordinates, other.coordinates.length);
    }

    // отримання довжини (норми) вектора
    public double getLength() {
        double sumOfSquares = 0;
        for (double coordinate : coordinates) {
            sumOfSquares += coordinate * coordinate;
        }
        return Math.sqrt(sumOfSquares);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2 vector = (Vector2) o;

        return Arrays.equals(coordinates, vector.coordinates);
    }

    // отримання координати за індексом
    public double getCoordinate(int index) {
        return coordinates[index];
    }

    // зміна координати за індексом
    public void setCoordinate(int index, double value) {
        coordinates[index] = value;
    }

    // отримання кількості координат
    public int getDimension() {
        return coordinates.length;
    }

    // виведення на екран у вигляді (x1, x2, ..., xn)
    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < coordinates.length; i++) {
            s += (coordinates[i]);
            if (i < coordinates.length - 1) {
                s += "; ";
            }
        }
        s += ")";
        return s;
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < coordinates.length;
            }

            @Override
            public Double next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return coordinates[currentIndex++];
            }
        };
    }
}
