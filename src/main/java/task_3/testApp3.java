package task_3;

import java.util.Arrays;
import java.util.Iterator;

//19-20 27.05.2021
//21-00 27.05.2021

public class testApp3 {

    public static void main(String[] args) {
        Iterator numberIterator = process(Arrays.asList(22, 22, 24, 25, 25, 66, 67, 123, 124, 125, 8000, 8000, 80000, 90000).iterator(), 90000);
        numberIterator.forEachRemaining(System.out::println);
    }

    /**
     * Возвращает итератор, который позволяет обойти только часть source,
     * ограниченную number, оставляя только элементы, значение которых меньше number
     *
     * @param source неубывающая бесконечная последовательность чисел.
     *               бесконечная - значит нельзя пытаться обработать source,
     *               например, использовать копирование итератора, удаление элементов и т.д.
     * @param number значение для отделения хвоста итератора
     *               <p>
     *               Пример:
     *               на вход подаётся бесконечная последовательность типа
     *               [22,22,24,25,25,66,67 ... 8000, 8000, 80000, 90000 ...]
     *               доступная для обхода часть source
     *               при number = 90000:
     *               [22,22,24,25,25,66,67 ... 8000, 8000, 80000]
     *               при number = 23:
     *               [22,22]
     * @return
     */
    public static Iterator process(Iterator source, Number number) {

        return new Iterator() {
            Number currentValue = null;
            Number lastValue = null;
            boolean flag = false;

            @Override
            public boolean hasNext() {
                if (source.hasNext()) {
                    if (flag) {
                        currentValue = (Number) source.next();
                        flag = !flag;
                        return strategy(currentValue);
                    } else {
                        lastValue = (Number) source.next();
                        flag = !flag;
                        return strategy(lastValue);
                    }
                }
                return false;
            }

            @Override
            public Number next() {
                if (flag) {
                    return lastValue;
                } else return currentValue;
            }

            boolean strategy(Number value) {
                if (value instanceof Integer) {
                    return (Integer) value < (Integer) number;
                } else if (value instanceof Long) {
                    return (Long) value < (Long) number;
                } else if (value instanceof Double) {
                    return (Double) value < (Double) number;
                } else if (value instanceof Float) {
                    return (Float) value < (Float) number;
                }
                return false;
            }

        };
    }

}
