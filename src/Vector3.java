import java.util.Arrays;
import java.util.NoSuchElementException;

class Vector3 implements Iterable<Double> {
    private double[] coordinates;
    // конструктор за замовчуванням створює вектор нульової довжини
    public Vector3() {
        this.coordinates = new double[0];
    }

    // конструктор, який створює вектор з заданими розміром
    public Vector3(int n) {
        this.coordinates = new double[n];
    }

    // конструктор, який створює вектор з заданими координатами
    public Vector3(double[] coordinates) {
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    // конструктор копії
    public Vector3(Vector3 other) {
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

        Vector3 vector = (Vector3) o;

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
            s+=(coordinates[i]);
            if (i < coordinates.length - 1) {
                s+="; ";
            }
        }
        s+=")";
        return s;
    }

    @Override
    public Iterator<Double> iterator() {
        class VectorIterator implements Iterator<Double> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < coordinates.length;
            }

            @Override
            public Double next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return coordinates[index++];
            }
        }

        return new VectorIterator();
    }
}
