package cn.xiaowenjie.feigndemo.controllers;

import cn.xiaowenjie.feigndemo.beans.ResultBean;
import cn.xiaowenjie.feigndemo.services.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

/**
 * 上传文件
 *
 * @author 晓风轻
 */
@RestController
@RequestMapping("/feigndemo")
@Slf4j
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    public ResultBean<Boolean> upload(MultipartFile file) {
        log.info("upload file:" + file);
        uploadService.upload(file);
        return new ResultBean<>(true);
    }

    @GetMapping("/test")
    public ResultBean<String> test() {
        log.info("springboot controller test");
        return new ResultBean<>("ok");
    }
}
