/*
 * Copyright (C) 2013-2014 小绿鸭 <gengqb0129@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package thread.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存级别数据共享工具，<br/>
 * 注意：设置数据和获取数据必须在同一个线程中使用
 * Created by miracle on 2017/8/19.
 */
public class ShareDataManager {

    private static final ThreadLocal<ShareDataManager> sThreadLocal = new ThreadLocal();
    private final Map<Class, Object> map;

    private static void prepare() {
        sThreadLocal.set(new ShareDataManager());
    }

    private ShareDataManager() {
        map = new HashMap<>();
    }

    /**
     * 保存数据
     *
     * @param data 需要存储到内存的数据
     */
    public static <T> void set(T data) {
        if (sThreadLocal.get() == null) {
            prepare();
        }
        ShareDataManager shareDataManager = sThreadLocal.get();
        if (shareDataManager.map.get(data.getClass()) != null) {
            throw new RuntimeException("ShareDataManager已经存在该类型的数据，不可重复设置");
        }
        shareDataManager.map.put(data.getClass(), data);
    }

    /**
     * 获取数据仓库中的数据
     *
     * @param clazz 数据的存储类型
     * @return 根据类型获取数据，数据不存在时返回null
     */
    public static <T> T get(Class clazz) {
        if (sThreadLocal.get() == null) {
            return null;
        }
        return (T) sThreadLocal.get().map.get(clazz);
    }

    /**
     * 清空数据
     */
    public static void clear() {
        if (sThreadLocal.get() == null) {
            return;
        }
        sThreadLocal.get().map.clear();
        sThreadLocal.remove();
    }

    /**
     * 移除投个类型的数据
     *
     * @param clazz 数据的类型
     */
    public static <T> void remove(Class clazz) {
        if (sThreadLocal.get() == null) {
            return;
        }
        sThreadLocal.get().map.remove(clazz);
    }
}