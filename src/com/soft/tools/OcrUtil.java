package com.soft.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.stereotype.Component;

import com.qcloud.image.ImageClient;
import com.qcloud.image.request.OcrPlateRequest;

@Component
public class OcrUtil {
	private String appId = "1257381093";
	private String secretId = "AKIDkQvdFgGyvmU0LUuP5avskQuJ6llbn4jF";
	private  String secretKey = "TlvKhEbIuPrAHCvSAmt36ye9SbYpGZko";
	private String bucketName = "park";
    ImageClient imageClient = new ImageClient(appId, secretId, secretKey, ImageClient.NEW_DOMAIN_recognition_image_myqcloud_com/*根据文档说明选择域名*/);
    
    public String getCarNum(String src,String fileName){
    	 return ocrPlate(imageClient, bucketName,src,fileName);
    }
    private static String ocrPlate(ImageClient imageClient, String bucketName,String src,String fileName) {
        String ret;
        // 1. url方式
        OcrPlateRequest request = new OcrPlateRequest(bucketName, "http://youtu.qq.com/app/img/experience/char_general/icon_ocr_license_3.jpg");
//        ret = imageClient.ocrPlate(request);
//        System.out.println("ocrPlate车牌号:" + ret);

        //2. 图片内容方式
        request = new OcrPlateRequest(bucketName, new File(src, fileName));
        ret = imageClient.ocrPlate(request);
        System.out.println(ret);
        return ret;
    }
    
    private static byte[] getFileBytes(File file) {
        byte[] imgBytes = null;
        try {
            RandomAccessFile f = new RandomAccessFile(file, "r");
            imgBytes = new byte[(int) f.length()];
            f.readFully(imgBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return imgBytes;
    }
}
