package queue;


public interface ITask extends Comparable<ITask>{
    void run();

    void setPriority(Priority priortty);

    Priority getPriority();

    void setSequence(int sequence);

    int getSequence();
}
