package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 有点复杂可以参考 https://www.jianshu.com/p/f82a03ec5110
 */
public class DynamicProxy {
    interface Restaurant {
        void eatFan();

        void dink();
    }

    static class WoJiaSuancaiYu implements Restaurant {
        @Override
        public void eatFan() {
            System.out.println("来我家吃酸菜鱼啦");
        }

        @Override
        public void dink() {
            System.out.println("喝果汁");
        }
    }

    static class PlaceForSell implements InvocationHandler {
        private Object target;

        public PlaceForSell(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("dink")) {
                System.out.println("欢迎光临");
                method.invoke(target, args);
                System.out.println("谢谢惠顾");
            } else {
                method.invoke(target, args);
            }

            return null;
        }
    }

    public static void main(String args[]) {
        WoJiaSuancaiYu woJiaSuancaiYu = new WoJiaSuancaiYu();
        PlaceForSell placeForSell = new PlaceForSell(woJiaSuancaiYu);
        Restaurant restaurant = (Restaurant) Proxy.newProxyInstance(WoJiaSuancaiYu.class.getClassLoader(), WoJiaSuancaiYu.class.getInterfaces(), placeForSell);
        restaurant.eatFan();
        restaurant.dink();
    }
}
