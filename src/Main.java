/*
Розробити інтерфейс Iterator (два методи hasNext та next) по масиву будь якого типу (можна тип вказати явно, а можна
створити шаблонний інтерфейс).

Для класу n-вимірного
вектора із завдання 2,  реалізувати інтерфейс
Iterator різними способами, зокрема з допомогою внутрішніх класів, anonymous
внутрішніх класів, локальних внутрішніх класів.
Порівняти
реалізації інтерфейсу та вибрати найбільш підходящий спосіб. Вибір обґрунтувати.
 */
public class Main {
    public static void main(String[] args) {
        Vector1 vector1 = new Vector1(1);
        System.out.println(vector1);
    }
}

