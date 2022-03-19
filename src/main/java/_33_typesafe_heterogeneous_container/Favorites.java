package _33_typesafe_heterogeneous_container;

import java.util.HashMap;

// 前面泛型是为了保证一个容器中只有一种类型，但是如果我们要一个容器中
// 包含多种类型而又不出错该怎么办呢？类型安全的异构容器
//
public class Favorites {
    private HashMap map = new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        map.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return (T) map.get(type);
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "123");
        favorites.putFavorite(Integer.class, 456);

        System.out.println(favorites.getFavorite(String.class));
        System.out.println(favorites.getFavorite(Integer.class));
    }
}
