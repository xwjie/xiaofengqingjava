package cn.xiaowenjie.feigndemo.controllers;

import cn.xiaowenjie.feigndemo.beans.ResultBean;
import cn.xiaowenjie.feigndemo.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件
 *
 * @author 晓风轻
 */
@RestController
@RequestMapping("/feigndemo")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    public ResultBean<Boolean> upload(MultipartFile file){
        uploadService.upload(file);
        return new ResultBean<>(true);
    }

    @GetMapping("/test")
    public ResultBean<String> test(){
        return new ResultBean<>("ok");
    }
}
