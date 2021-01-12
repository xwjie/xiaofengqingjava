package cn.xiaowenjie.spider;

import cn.xiaowenjie.spider.annotations.CssSelctor;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/1/12 0012
 * @Author 晓风轻 https://github.com/xwjie
 */
public class Spider {
    public static <T> T get(String url, Class<T> tClass) throws IOException {
        Document document = JsoupUtil.get(url);
        return createInstance(document, tClass);
    }

    @SneakyThrows
    private static <T> T createInstance(Document doc, Class<T> tClass) {
        T instance = tClass.newInstance();

        List<Field> fields = getAllFields(tClass);

        for (Field field : fields) {
            field.setAccessible(true);

            CssSelctor cssSelctor = field.getAnnotation(CssSelctor.class);
            if (cssSelctor == null) {
                continue;
            }

            Object value = getCssSelectorValue(doc, cssSelctor);
            field.set(instance, value);
        }

        return instance;
    }

    private static Object getCssSelectorValue(Document doc, CssSelctor cssSelctor) {
        Elements select = doc.select(cssSelctor.value());

        int size = select.size();

        System.out.println("size:" + size);

        if (size == 1) {
            return cssSelctor.html() ? select.html() : select.text();
        } else if (size > 1) {
            List<String> values = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                values.add(cssSelctor.html() ? select.get(i).html() : select.get(i).text());
            }

            return values;
        } else {
            throw new IllegalArgumentException("找不到数据");
        }


    }

    @SneakyThrows
    private static List<Field> getAllFields(Class<?> tClass) {
        List<Field> fields = new ArrayList<>();

        while (!tClass.equals(Object.class)) {
            fields.addAll(Arrays.asList(tClass.getDeclaredFields()));
            tClass = tClass.getSuperclass();
        }

        return fields;
    }
}
