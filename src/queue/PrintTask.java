package queue;

public class PrintTask extends BasicTask {
    private int id;

    public PrintTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {

        }

        // sendDanmu
        System.out.println("我的 id 是：" + id);
    }
}
