package org.tvos.controller.Login;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tvos.constant.ConstantHolder;
import org.tvos.service.PhotoService;
import org.tvos.util.ThumbnailGenerator;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * TODO 用户上传高校图片
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    PhotoService photoService;

    /**
     * 用户景点上传景点图片
     * TODO 确定图片的url地址
     *
     * @param file
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadPhoto/spots/{provinceName}/{cityName}", method = RequestMethod.POST)
    public ResponseEntity<?> spotPhotoUpload(@RequestParam CommonsMultipartFile file,
                                             @PathVariable("provinceName") String provinceName,
                                             @PathVariable("cityName") String cityName,
                                             HttpServletRequest request) throws Exception {
        String userName = getCurrentUserName();

        //post请求中拿到参数
        String albumName = request.getParameter("albumName");
        String photoName = request.getParameter("photoName");
        String photoDesc = request.getParameter("photoDesc");

        File dir = new File(ConstantHolder.originSpotsImagePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        //图片文件名
        String photoFileName = photoName + "--" + System.currentTimeMillis();
        //图片的服务器保存路径+文件名
        String path = dir.getPath() + File.separatorChar + photoFileName;
        //图片的url
        String url = "/upload/" + provinceName + "/" + cityName + "/" + userName + "/" + photoFileName;
        //创建图片文件
        File uploadFile = new File(path);
        System.out.println(photoName);
        file.transferTo(uploadFile);
        //转换成缩略图
        ThumbnailGenerator.generate(path, path, 3);
        //得到当前登录的用户名
        userName = getCurrentUserName();
        photoService.addPhotoFromSpots(
                userName,
                albumName,
                photoFileName,
                photoDesc,
                provinceName,
                cityName,
                url);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/uploadPhoto/college/{provinceName}", method = RequestMethod.POST)
    public ResponseEntity<?> collegePhotoUpload(@RequestParam CommonsMultipartFile file,
                                                @PathVariable("provinceName") String provinceName,
                                                HttpServletRequest request) throws Exception {
        String userName = getCurrentUserName();

        //post请求中拿到参数
        String albumName = request.getParameter("albumName");
        String photoName = request.getParameter("photoName");
        String photoDesc = request.getParameter("photoDesc");

        File dir = new File(ConstantHolder.originCollegeImagePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        //图片文件名
        String photoFileName = photoName + "--" + System.currentTimeMillis();
        //图片的服务器保存路径+文件名
        String path = dir.getPath() + File.separatorChar + photoFileName;
        //图片的url
        String url = "/upload/" + provinceName + "/" + userName + "/" + photoFileName;
        //创建图片文件
        File uploadFile = new File(path);
        System.out.println(photoName);
        file.transferTo(uploadFile);
        //生成缩略图，缩小一半
        ThumbnailGenerator.generate(path, path, 3);
        //得到当前登录的用户名
        userName = getCurrentUserName();

        photoService.addPhotoFromCollege(
                userName,
                albumName,
                photoFileName,
                photoDesc,
                provinceName,
                url);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/{provinceName}/{cityName}/{username}/{photoName}", method = RequestMethod.GET)
    public ResponseEntity<?> spotsFileDownload(@PathVariable(value = "photoName") String photoName,
                                               @PathVariable(value = "provinceName") String provinceName,
                                               @PathVariable(value = "cityName") String cityName,
                                               @PathVariable(value = "username") String username) throws IOException {
        File dir = new File("C:\\upload\\spotsPhoto\\" + photoName);
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.MULTIPART_FORM_DATA);
        //h.setContentDispositionFormData("attachment",dir.getCanonicalPath());
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(dir), h, HttpStatus.OK);
    }

    @RequestMapping(value = "/{provinceName}/{username}/{photoName}", method = RequestMethod.GET)
    public ResponseEntity<?> collegeFileDownload(@PathVariable(value = "photoName") String photoName,
                                                 @PathVariable(value = "provinceName") String provinceName,
                                                 @PathVariable(value = "username") String username) throws IOException {
        File dir = new File("C:\\upload\\collegePhoto\\" + photoName);
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.MULTIPART_FORM_DATA);
        //h.setContentDispositionFormData("attachment",dir.getCanonicalPath());
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(dir), h, HttpStatus.OK);
    }

    /**
     * 获取用户名
     *
     * @return
     */
    private String getCurrentUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            return null;
        } else {
            return ((UserDetails) auth.getPrincipal()).getUsername();
        }
    }


}
