package com.cecdat.convert.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.cecdat.convert.entity.QuestionRequest;
import com.cecdat.convert.utils.FileOperationUtil;
import com.cecdat.convert.utils.MultiClientsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;

@Controller
public class FileRestApi {

    @Value("${ali-oos.endpoint}")
    private String endpoint;
    @Value("${ali-oos.accessKeyId}")
    private String accessKeyId;
    @Value("${ali-oos.accessKeySecret}")
    private String accessKeySecret;
    @Value("${ali-oos.bucket_1}")
    private String BucketName_wxUploadFile;

    @GetMapping(path = "/file_upload")
    @ResponseBody
    public String question() {
        try {

            System.out.println(endpoint);
            System.out.println(accessKeyId);
            System.out.println(accessKeySecret);
            OSSClient ossClient = MultiClientsUtils.getOSSClient(endpoint, accessKeyId, accessKeySecret);
            // 列举存储空间。
            List<Bucket> buckets = ossClient.listBuckets();
            for (Bucket bucket : buckets) {
                System.out.println(" - " + bucket.getName());
            }
            InputStream inputStream = FileOperationUtil.getFileBytes("C:\\Users\\admin\\Pictures\\day01\\03.jpg");

            PutObjectResult request = ossClient.putObject(BucketName_wxUploadFile, "type_up", inputStream);
            System.out.println("=="+request.getETag());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }


}
