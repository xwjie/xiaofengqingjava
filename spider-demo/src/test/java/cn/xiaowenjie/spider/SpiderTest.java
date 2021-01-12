package cn.xiaowenjie.spider;

import cn.xiaowenjie.spider.beans.GithubPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2021/1/12 0012
 * @Author 晓风轻 https://github.com/xwjie
 */

public class SpiderTest {

    @Test
    public void test() throws IOException {
        String url = "https://github.com/xwjie";
        GithubPage page = Spider.get(url, GithubPage.class);

        System.out.println(page);

        Assertions.assertEquals(page.getFullname(), "晓风轻");
        Assertions.assertEquals(page.getName(), "xwjie");
    }
}
