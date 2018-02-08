public class StrategyDesignMode {
    public static void main(String[] args) {
        //策略模式
        Context context = new Context(new ConcreteStrategyA());
        context.ContextInterface();
        Context context1 = new Context(new ConcreteStrategyB());
        context1.ContextInterface();
        Context context2 = new Context(new ConcreteStrategyC());
        context2.ContextInterface();
        System.out.println("-------------------------------------------");
        //策略模式和简单工厂模式的结合
        ImproveContext a = new ImproveContext("A");
        a.getAlgorith();
        ImproveContext b = new ImproveContext("B");
        b.getAlgorith();
    }
}

/**
 * 一、策略模式（Strategy）:它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化不会影响到使用算法的客户。
 * 1、第一步先定义一个算法抽象类
 * 2、第二步创建三个实现类
 * 3、创建一个上下文对象，传入具体的实现类
 * 感觉整个过程很像工厂设计模式,那么两者之间的区别是什么呢？
 * 简单工厂模式：客户端传一个条件给工厂类，工厂类根据条件创建相应的产品类对象，并return给客户端，供客户端
 * 使用。即客户端使用的是工厂类生产的产品对象。
 *
 * 策略模式：客户端创建一个Context类对象a（可以看做工厂模式中的工厂类）,创建一个策略对象c传给对象a，然后客户端使用a的某些方法
 * 使用前面传参进来的策略c,即客户端是通过a对象使用策略的。
 *
 */
//抽象算法类
abstract class Strategy {
    //算法方法
    public abstract void AlgorithmInterface();
}

class ConcreteStrategyA extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("ConcreteStrategyA");
    }
}

class ConcreteStrategyB extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("ConcreteStrategyB");
    }
}

class ConcreteStrategyC extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("ConcreteStrategyC");
    }
}

class Context {
    Strategy strategy;

    /**
     * 初始化的时候传入具体的策略
     *
     * @param strategy
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    //上下文接口

    /**
     * 根据具体的策略对象，调用其算法的方法
     */
    public void ContextInterface() {
        strategy.AlgorithmInterface();
    }
}

/**
 * 二、策略模式和简单工厂模式的结合
 * 策略模式是一种定义一系列算法的方法，从概念上来看就是所有的这些算法完成的都是相同的工资，只是实现不同而已。它可以通过相同的方式调用所有的算法，
 * 减少了了各种算法类之间的耦合
 * 比如一个银行收款列表，我们就可以通过传入活动的String名，然后调里面的
 */
//改造后的Context
class ImproveContext {
    Strategy strategy = null;
    public ImproveContext(String type) {
        switch (type) {
            case "A":
                strategy = new ConcreteStrategyA();
                break;
            case "B":
                strategy = new ConcreteStrategyB();
                break;
            case "C":
                strategy = new ConcreteStrategyC();
                break;
        }
    }
    public void getAlgorith() {
        strategy.AlgorithmInterface();
    }
}