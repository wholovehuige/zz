package com.nplat.convert.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.oss.model.UploadUdfImageRequest;
import com.nplat.convert.utils.MultiClientsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by roy on 2019/6/20.
 */
@Service
public class OSSOptionService {
    @Value("${ali-oos.endpoint}")
    private String endpoint;
    @Value("${ali-oos.accessKeyId}")
    private String accessKeyId;
    @Value("${ali-oos.accessKeySecret}")
    private String accessKeySecret;
    @Value("${ali-oos.bucket_1}")
    private String BucketName_wxUploadFile;
    @Value("${ali-oos.enterpriseFolder}")
    private String enterpriseFolder;

    public String setFileToOss(MultipartFile imageFile) {
        try {
            //以输入流的形式上传文件
            InputStream is = imageFile.getInputStream();
            //文件名
            String fileName = imageFile.getOriginalFilename();
            //文件大小
            Long fileSize = imageFile.getSize();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(is.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            OSSClient ossClient = MultiClientsUtils.getOSSClient(endpoint, accessKeyId, accessKeySecret);
            // 列举存储空间。
            List<Bucket> buckets = ossClient.listBuckets();
            for (Bucket bucket : buckets) {
                System.out.println(" - " + bucket.getName());
            }
            ossClient.putObject(BucketName_wxUploadFile, enterpriseFolder + "/" + fileName, is, metadata);
            URL url = ossClient.generatePresignedUrl(BucketName_wxUploadFile, enterpriseFolder + "/" + fileName, expiration);
            System.out.println(url);
            return url.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return  "";
        }
    }


    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }

}
