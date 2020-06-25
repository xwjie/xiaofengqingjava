package cn.xiaowenjie.feigndemo.clients;

import cn.xiaowenjie.feigndemo.beans.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 晓风轻
 */
@FeignClient(name = "testClient",url = "${test.host}")
public interface TestClient {

    @PostMapping("/upload")
    ResultBean<Boolean> upload(@RequestParam(value="file") MultipartFile file);

    @GetMapping("/test")
    ResultBean<String> test();
}