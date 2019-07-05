package design.adapter;

public class AdapterDesignMode {
    /**
     *
     * 用电源接口做例子，笔记本电脑的电源一般都是接受5V的电压，但是我们生活中的电线电压一般都是220V的输出。
     * 这个时候就出现了不匹配的状况，在软件开发中我们称之为接口不兼容，此时就需要适配器来进行一个接口转换。
     * 在软件开发中有一句话正好体现了这点：任何问题都可以加一个中间层来解决。
     * 这个层我们可以理解为这里的Adapter层，通过这层来进行一个接口转换就达到了兼容的目的。
     *
     * 适配器模式也分两种，即类适配器模式、对象适配器模式，
     *
     * 目标(Target)角色：这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
     * 源(Adapee)角色：现在需要适配的接口。
     * 适配器(Adaper)角色：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
     *
     * 在上述电源接口这个示例中，5V电压就是Target接口，220v电压就是Adaptee类，而将电压从220V转换到5V就是Adapter。
     */


    public static void main(String[] args) {
        //类适配器模式  耦合度比较高
        ClassAdapter adapter = new ClassAdapter();
        System.out.println("输出电压 : " + adapter.getVolt5());
        //对象适配器模式 耦合度低，推荐 ListView.setAdapter 就是这种模式
        Volt220 volt220 = new Volt220();
        ObjectAdapter objectAdapter = new ObjectAdapter(volt220);
        System.out.println("输出电压 : " +  objectAdapter.getVolt5());
    }

}

/**
 * Target角色
 */
 interface FiveVolt {
    public int getVolt5();
}

/**
 * Adaptee角色,需要被转换的对象
 */
 class Volt220 {
    public int getVolt220() {
        return 220;
    }
}

/**
 *  adapter角色
 *  类适配器模式
 */
class ClassAdapter extends Volt220 implements FiveVolt {

    @Override
    public int getVolt5() {
        return 5;
    }
}

/**
 *  adapter角色
 *  对象适配器模式
 */

class ObjectAdapter implements FiveVolt {

    Volt220 mVolt220;

    public ObjectAdapter(Volt220 adaptee) {
        mVolt220 = adaptee;
    }

    public int getVolt220() {
        return mVolt220.getVolt220();
    }

    @Override
    public int getVolt5() {
        return 5;
    }

}



