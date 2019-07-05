package arithmetic.stack;

import java.util.LinkedList;

/**
 *简单实现队列
 * 队列是一种特殊的线性表，特殊之处在于它只允许在表的前端进行删除操作，而在表的后端进行插入操作，
 * 和栈一样，队列是一种操作受限制的线性表。进行插入操作的端成为队尾，进行删除操作的端成为队头。
 * @param <E>
 */
public class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    // 入队
    public void enqueue(E e) {
        list.addLast(e);
    }

    // 出队
    public E dequeue() {
        return list.removeFirst();
    }
}
