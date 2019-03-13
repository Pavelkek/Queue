/*
 * Класс Mail
 * version - 1.0
 * Авторское право: все мое.
 */
package queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Программа реализовывает очередь на почту
 * и учитывает возраст клиента.
 * Если клиент - пенсионер,
 * то его обсуживают без очереди.
 * @version 1.0 13 Apr 2019
 * @author Pavel Samotaev
 */
public final class Mail {
    private Mail() { }
    public static void main(final String[] args) {
        final int lengthQueue = 10;
        final int[] mas = {20, 10, 15, 67, 66};
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override public int compare(final Integer o1, final Integer o2) {
                final int yearOld = 65; //CheckStyle не дает объявить, как константу
                if (o2 < yearOld && o1 >= yearOld) {
                    return -1;
                } else {
                    return 1;
                }
            } };
        Queue<Integer> mailQueue = new PriorityQueue<>(lengthQueue, comparator);
        for (int i = 0; i < mas.length; i++) {
            mailQueue.add(mas[i]);
        }
        while (!mailQueue.isEmpty()) {
            System.out.println(mailQueue.remove());
        }
    }
}
