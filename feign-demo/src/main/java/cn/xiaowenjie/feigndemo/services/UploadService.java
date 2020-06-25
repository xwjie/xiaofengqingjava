package cn.xiaowenjie.feigndemo.services;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 处理上传文件
 *
 * @author 晓风轻
 */
@Service
@Slf4j
public class UploadService {

    @SneakyThrows
    public void upload( MultipartFile file) {
        // 使用原来的文件名
        // 实际项目中不能这样做
        File targetFile = new File("d:\\" + file.getOriginalFilename());

        try(InputStream inputStream = file.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile))   {
            byte[] bytes = new byte[1024*1024];
            int readLength = -1;
            while ((readLength = inputStream.read(bytes)) > 0){
                fileOutputStream.write(bytes,0,readLength);
            }
        }

        log.info("upload success, save to:" + targetFile.getCanonicalPath());
    }
}
