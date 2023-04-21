public interface Iterator<T> extends java.util.Iterator<T> {
    boolean hasNext();

    T next();

    @Override
    default void remove() {
        java.util.Iterator.super.remove();
    }
}
/*
Інтерфейс Iterator складається з двох методів: hasNext() та next(). Метод hasNext() повертає true, якщо ітератор містить наступний елемент, інакше - false. Метод next() повертає наступний елемент ітератора.

 */