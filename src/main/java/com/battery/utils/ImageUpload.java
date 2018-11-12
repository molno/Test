package com.battery.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUpload {
    public static String uploadImage(MultipartFile image, String baseUrl) throws IOException {
        String OriginalVideoName = image.getOriginalFilename();
        //后缀
        String imagePrefix = OriginalVideoName.substring(OriginalVideoName.lastIndexOf(".") + 1);
        if(!(imagePrefix.equalsIgnoreCase("jpg") || imagePrefix.equalsIgnoreCase("png") || imagePrefix.equalsIgnoreCase("jpeg"))){
            return null;
        }

        String fileName = Generator.generateUniqueName() + "." + imagePrefix;
        File dir = new File(baseUrl,fileName);
//         if(!dir.isDirectory()){
//                 dir.mkdir();
//         }
        image.transferTo(dir);
        return baseUrl + File.separator + fileName;
    }

    public static List<String> uploadImageBatch(MultipartFile[] image, String baseUrl) throws IOException {
        List<String> pathList = new ArrayList<String>();
        for(MultipartFile file : image) {
            String fileName = Generator.generateUniqueName() + file.getOriginalFilename();
            file.transferTo(new File(baseUrl, fileName));
            pathList.add(baseUrl + fileName);
        }
        return pathList;
    }

    public static String updateImage(MultipartFile image, String baseUrl, String sourceUrl) throws IOException {
        String OriginalVideoName = image.getOriginalFilename();
        //后缀
        String imagePrefix = OriginalVideoName.substring(OriginalVideoName.lastIndexOf(".") + 1);
        if(!(imagePrefix.equalsIgnoreCase("jpg") || imagePrefix.equalsIgnoreCase("png") || imagePrefix.equalsIgnoreCase("jpeg"))){
            return null;
        }

        String fileName = Generator.generateUniqueName() + "." + imagePrefix;
        if (sourceUrl != null) {
            String realName = sourceUrl.substring(sourceUrl.lastIndexOf(File.separator) + 1);

            //删除图片
            File targetFile = new File(baseUrl, realName);
            if (targetFile.exists()) {
                //删除
                targetFile.delete();
            }
        }
        //传输新图片
        File dir = new File(baseUrl,fileName);

        image.transferTo(dir);
        return baseUrl + File.separator+fileName;
    }

    public static boolean deleteImage(String baseUrl, String sourceUrl){
        String imageName = sourceUrl.substring(sourceUrl.lastIndexOf("/") + 1);
        File file = new File(baseUrl, imageName);
        if(file.exists()){
            file.delete();
        }
        return true;
    }


//    public static void main(String args[]){
//       deleteImage(Const.PRODUCT_IMAGE_PIC, "/usr/local/image/product/\20180719204419156228");
//
//    }
}
