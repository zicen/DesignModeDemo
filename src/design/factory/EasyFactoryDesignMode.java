package design.factory;

public class EasyFactoryDesignMode {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation("+");
        System.out.println("result:"+operation.getResult(1, 2));
    }
}

/**
 * 简单工厂设计模式的应用场景：
 * 比如说我在做Android底部选择的四个Fragment类就可以通过继承一个BaseFragment然后根据传入的str返回对应的fragment类
 */


abstract class Operation{
    abstract double getResult(double numberA,double numberB);
}
class OperationAdd extends Operation{

    @Override
    double getResult(double numberA,double numberB) {
        return numberA + numberB;
    }
}
class OperationSub extends Operation{

    @Override
    double getResult(double numberA,double numberB) {
        return numberA - numberB;
    }
}
class OperationMul extends Operation{

    @Override
    double getResult(double numberA,double numberB) {
        return numberA * numberB;
    }
}

class OperationDiv extends Operation{

    @Override
    double getResult(double numberA,double numberB) {
        if (numberB == 0) {
            return 0;
        }
        return numberA / numberB;
    }
}

/**
 * 一个计算器的简单工厂模式
 */
class OperationFactory{
    public static Operation createOperation(String oper){
        Operation operation = null;
        switch (oper) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}

