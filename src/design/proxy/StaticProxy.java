package design.proxy;

/**
 * 静态代理
 * 代理(Proxy)是一种设计模式,提供了对目标对象另外的访问方式;即通过代理对象访问目标对象.这样做的好处是:
 * 可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.
 *
 * 这里使用到编程中的一个思想:不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法（那这个思想就能让我们做很多事情了）
 * ——代理模式是面向对象编程中比较常见的设计模式。
 */
public class StaticProxy {
    interface IGoods{
        void delete();
    }

    static class GoodsImpl implements IGoods {
        @Override
        public void delete() {
            System.out.println("请求后台删除操作");
        }
    }

     static   class GoodsProxy implements IGoods{
        private IGoods iGoods;
        public GoodsProxy(IGoods iGoods) {
            this.iGoods = iGoods;
        }

        @Override
        public void delete() {
            System.out.println("在这里做删除前的一些操作...");
            iGoods.delete();
            System.out.println("在这里做删除后的一些操作...");
        }
    }

    public static void main(String args[]){
        GoodsProxy goodsProxy = new GoodsProxy(new GoodsImpl());
        goodsProxy.delete();
    }

}
