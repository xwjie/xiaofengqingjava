package cn.xiaowenjie.spider.beans;

import cn.xiaowenjie.spider.annotations.CssSelctor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;

/**
 * @Description TODO
 * @Date 2021/1/12 0012
 * @Author 晓风轻 https://github.com/xwjie
 */
@Data
public class GithubPage {
    @CssSelctor("#js-pjax-container > div.container-xl.px-3.px-md-4.px-lg-5 > div > div.flex-shrink-0.col-12.col-md-3.mb-4.mb-md-0 > div > div.clearfix.d-flex.d-md-block.flex-items-center.mb-4.mb-md-0 > div.vcard-names-container.float-left.col-10.col-md-12.pt-1.pt-md-3.pb-1.pb-md-3.js-sticky.js-user-profile-sticky-fields > h1 > span.p-name.vcard-fullname.d-block.overflow-hidden")
    private String fullname;

    @CssSelctor("#js-pjax-container > div.container-xl.px-3.px-md-4.px-lg-5 > div > div.flex-shrink-0.col-12.col-md-3.mb-4.mb-md-0 > div > div.clearfix.d-flex.d-md-block.flex-items-center.mb-4.mb-md-0 > div.vcard-names-container.float-left.col-10.col-md-12.pt-1.pt-md-3.pb-1.pb-md-3.js-sticky.js-user-profile-sticky-fields > h1 > span.p-nickname.vcard-username.d-block")
    private String name;

    @CssSelctor("#js-pjax-container > div.container-xl.px-3.px-md-4.px-lg-5 > div > div.flex-shrink-0.col-12.col-md-9.mb-4.mb-md-0 > div:nth-child(2) > div > div:nth-child(1) > div > ol > li > div > div > div > a > span")
    private Collection<String> versions;
}
