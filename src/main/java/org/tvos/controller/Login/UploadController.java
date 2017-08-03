package org.tvos.controller.Login;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tvos.service.PhotoService;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    PhotoService photoService;

    /**
     * 用户景点上传图片
     * TODO 确定图片的url地址
     *
     * @param file
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadPhoto/{provinceName}/{cityName}/{userName}", method = RequestMethod.POST)
    public ResponseEntity<?> spotPhotoUpload(@RequestParam CommonsMultipartFile file,
                                             @PathVariable("provinceName") String provinceName,
                                             @PathVariable("cityName") String cityName,
                                             @PathVariable("userName") String userName,
                                             HttpServletRequest request) throws Exception {

        //post请求中拿到参数
        String albumName = request.getParameter("albumName");
        String photoName = request.getParameter("photoName");
        String photoDesc = request.getParameter("photoDesc");

        File dir = new File("C:\\upload\\spotsPhoto");
        if (!dir.exists()) {
            dir.mkdir();
        }
        //图片文件名
        String photoFileName = photoName + "%%" + System.currentTimeMillis();
        //图片的服务器保存路径+文件名
        String path = dir.getPath() + File.separatorChar + photoFileName;
        //图片的url
        String url = "/upload/"+ provinceName + "/" + cityName + "/" + userName + "/" + photoFileName;
        //创建图片文件
        File uploadFile = new File(path);
        System.out.println(photoName);
        file.transferTo(uploadFile);

        photoService.addPhotoFromSpots(
                userName,
                albumName,
                photoName,
                photoDesc,
                provinceName,
                cityName,
                url);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/uploadPhoto/upload/{provinceName}/{userName}", method = RequestMethod.POST)
    public ResponseEntity<?> collegePhotoUpload(@RequestParam CommonsMultipartFile file,
                                                @PathVariable("provinceName") String provinceName,
                                                @PathVariable("userName") String userName,
                                                HttpServletRequest request) throws Exception {

        //post请求中拿到参数
        String albumName = request.getParameter("albumName");
        String photoName = request.getParameter("photoName");
        String photoDesc = request.getParameter("photoDesc");

        File dir = new File("C:\\upload\\collegePhoto");
        if (!dir.exists()) {
            dir.mkdir();
        }
        //图片文件名
        String photoFileName = photoName + "--" + System.currentTimeMillis();
        //图片的服务器保存路径+文件名
        String path = dir.getPath() + File.separatorChar + photoFileName;
        //图片的url
        String url = "/upload/"+ provinceName + userName + path;
        //创建图片文件
        File uploadFile = new File(path);
        System.out.println(photoName);
        file.transferTo(uploadFile);

        photoService.addPhotoFromCollege(
                userName,
                albumName,
                photoFileName,
                photoDesc,
                provinceName,
                url);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/{photoName}",method = RequestMethod.GET)
    public ResponseEntity<?> fileDownload(
            @PathVariable(value = "photoName") String photoName) throws IOException {
        File dir = new File("C:\\upload\\spotsPhoto\\"+photoName);
        HttpHeaders h=new HttpHeaders();
        h.setContentType(MediaType.MULTIPART_FORM_DATA);
        //h.setContentDispositionFormData("attachment",dir.getCanonicalPath());
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(dir),h,HttpStatus.OK);
    }

}
