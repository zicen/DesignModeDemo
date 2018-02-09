public class DecoratorDesignMode {
    public static void main(String[] args) {
        Person person = new Person("小明");
        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        Shoe shoe = new Shoe();
        tShirts.decorate(person);
        bigTrouser.decorate(tShirts);
        shoe.decorate(bigTrouser);
        person.show();
    }
}
/**
 * 装饰模式：动态的给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活
 * 装饰模式是为已有功能动态的添加更多功能的一种方式，比如我的person类需要一个穿不同的衣服的功能，而
 * 此时如果把各种衣服的类都写到主类person中，那就增加了主类的复杂度，而穿不同衣服的功能仅仅是为了瞒住一些只在
 * 特定情况下才会执行的特殊行为的需求，此时就可以使用装饰模式。
 *
 * 在Android中比如我们想给TextView做一个装饰器，那么这个装饰器其实感觉就是一个工具类而已，我们用public static void decode(TextView textview){ textview.setxxx...}
 *
 */

class Person{
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("装扮的"+this.getName());
    }

}

/**
 * 服装类
 */
class Finery extends Person{
    protected Person component;

    public void decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}

/**
 * 具体服装类
 */
class TShirts extends Finery {
    @Override
    public void show() {
        System.out.println("大T桖");
        super.show();
    }
}
class BigTrouser extends Finery {
    @Override
    public void show() {
        System.out.println("裤子");
        super.show();
    }
}
class Shoe extends Finery {
    @Override
    public void show() {
        System.out.println("鞋子");
        super.show();
    }
}
