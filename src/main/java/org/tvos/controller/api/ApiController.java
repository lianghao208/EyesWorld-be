package org.tvos.controller.api;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.tvos.dto.*;
import org.tvos.service.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Api接口Controller，处理页面请求，返回Json数据
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private ProvinceService provinceService;

    @Resource
    private CityService cityService;

    @Resource
    private AlbumService albumService;

    @Resource
    private PhotoService photoService;

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    @Autowired
    private LikeService likeService;

    /**
     * 省份信息-风景
     */
    @RequestMapping(value = "/provinces/cities", method = RequestMethod.GET)
    public List<ProvinceDto> privinceListForSpots() {
        return provinceService.getProvincesForSpots();
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String test() {
        return "ok";
    }

    /**
     * 城市信息
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}", method = RequestMethod.GET)
    public List<CityDto> cityList(@PathVariable("provinceName") String provinceName) {
        return cityService.getCities(provinceName);
    }

    /**
     * 浏览相册
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}/{cityName}/spots", method = RequestMethod.GET)
    public List<AlbumDto> albumFromSpotsList(@PathVariable("provinceName") String provinceName,
                                    @PathVariable("cityName") String cityName) {
        //TODO 需要对相册分页
        // businessDto.getPage().setPageNumber(businessSearchNumber);
        return albumService.getAlbumsFromSpots(provinceName, cityName);
    }

    /**
     * 浏览景点图片
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}", method = RequestMethod.GET)
    public PhotoDto photoView(@PathVariable("provinceName") String provinceName,
                              @PathVariable("cityName") String cityName,
                              @PathVariable("albumId") Long albumId,
                              @PathVariable("photoId") Long photoId) {
        return photoService.getPhotoFromSpots(provinceName, cityName, albumId, photoId);
    }


    /**
     * 省份信息-高校
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/college", method = RequestMethod.GET)
    public List<ProvinceDto> ProvinceListForCollege() {
        return provinceService.getProvincesForCollege();
    }

    /**
     * 浏览高校相册
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/college/{provinceName}", method = RequestMethod.GET)
    public List<AlbumDto> albumFromCollegeList(@PathVariable("provinceName") String provinceName) {
        return albumService.getAlbumsFromCollege(provinceName);
    }

    /**
     * 浏览高校图片
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/college/{provinceName}/{albumId}/{photoId}", method = RequestMethod.GET)
    public PhotoDto photoFromCollegeList(@PathVariable("provinceName") String provinceName,
                                  @PathVariable("albumId") Long albumId,
                                  @PathVariable("photoId") Long photoId) {

        return photoService.getPhotoFromCollege(provinceName, albumId, photoId);
    }

    /**
     * 最新推荐
     */
    @RequestMapping(value = "/lastest", method = RequestMethod.GET)
    public List<PhotoDto> Recommend() {
        return photoService.getPhotosFromRecommend();
    }

    /**
     * 登录状态判断，返回UserDto对象，其中status属性为登陆状态
     */
/*    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDto login(@CookieValue("JSESSIONID") String cookieId) {

        return userService.getUserDto(cookieId);
    }*/

    /**
     * 我的作品
     * TODO 分页功能
     */
    @RequestMapping(value = "/user/works", method = RequestMethod.GET)
    public List<PhotoDto> photoFromUserWork() {
        String username = getCurrentUserName();
        return photoService.getPhotoFromUserWork("", username);
    }

    /**
     * 删除用户图片
     * @param photoName
     * @return
     */
    @RequestMapping(value = "/user/works/{photoName}/delete",method = RequestMethod.GET)
    public Map<String,Boolean> deleteUserPhoto(@PathVariable("photoName") String photoName){
        String username = getCurrentUserName();
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        resultMap.put("delete",photoService.deletePhoto(photoName,username));
        return resultMap;
    }

    /**
     * 我的收藏
     * TODO 分页功能
     */
    @RequestMapping(value = "/user/favorite", method = RequestMethod.GET)
    public List<PhotoDto> userLike() {
        //UserInfoDto myFavorite = new UserInfoDto();
        String userName = getCurrentUserName();
        return photoService.getPhotoFromUserFavorite("", userName);
    }

    /**
     * 用户景点图片点赞
     *
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return false--取消赞 true--点赞
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}/like", method = RequestMethod.GET)
    public Map<String, Boolean> spotsLike(@PathVariable(value = "provinceName") String provinceName,
                                     @PathVariable(value = "cityName") String cityName,
                                     @PathVariable(value = "albumId") Long albumId,
                                     @PathVariable(value = "photoId") Long photoId
    ) {
        String username = getCurrentUserName();
        Map<String, Boolean> likedMap = new HashMap<String, Boolean>();
        //用户点赞
        Boolean liked = likeService.spotsLikeClick(provinceName, cityName, albumId, photoId, username);
        likedMap.put("state", liked);
        return likedMap;


    }

    @RequestMapping(value = "/provinces/college/{provinceName}/{albumId}/{photoId}/like", method = RequestMethod.GET)
    public Map<String, Boolean> collegeLike(@PathVariable(value = "provinceName") String provinceName,
                                          @PathVariable(value = "albumId") Long albumId,
                                          @PathVariable(value = "photoId") Long photoId
    ) {
        String username = getCurrentUserName();
        Map<String, Boolean> likedMap = new HashMap<String, Boolean>();
        //用户点赞
        Boolean liked = likeService.collegeLikeClick(provinceName, albumId, photoId, username);
        likedMap.put("state", liked);
        return likedMap;


    }

    /**
     * 读取景点用户评论
     *
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @return
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}/comment", method = RequestMethod.GET)
    public List<CommentListDto> commentListFromSpots(@PathVariable(value = "provinceName") String provinceName,
                                  @PathVariable(value = "cityName") String cityName,
                                  @PathVariable(value = "albumId") Long albumId,
                                  @PathVariable(value = "photoId") Long photoId) {
        //TODO 读取用户评论
        List<CommentListDto> commentListDtoList = commentService.getCommentListFromSpots(provinceName,cityName,albumId,photoId);

        return commentListDtoList;

    }


    /**
     * 读取大学用户评论
     *
     * @param provinceName
     * @param albumId
     * @param photoId
     * @return
     */
    @RequestMapping(value = "/provinces/college/{provinceName}/{albumId}/{photoId}/comment", method = RequestMethod.GET)
    public List<CommentListDto> commentListFromCollege(@PathVariable(value = "provinceName") String provinceName,
                                                     @PathVariable(value = "albumId") Long albumId,
                                                     @PathVariable(value = "photoId") Long photoId) {
        //TODO 读取用户评论
        List<CommentListDto> commentListDtoList = commentService.getCommentListFromCollege(provinceName,albumId,photoId);

        return commentListDtoList;

    }


    /**
     * 添加景点图片评论
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param request
     * @return
     */
    @RequestMapping(value = "/spotsComment/{provinceName}/{cityName}/{albumId}/{photoId} ", method = RequestMethod.POST)
    public Map<String,Boolean> addCommentForSpots(@PathVariable(value = "provinceName") String provinceName,
                                               @PathVariable(value = "cityName") String cityName,
                                               @PathVariable(value = "albumId") Long albumId,
                                               @PathVariable(value = "photoId") Long photoId,
                                               HttpServletRequest request) {
        String username = getCurrentUserName();
        String content = request.getParameter("photoComment");
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        System.out.println(photoId);
        System.out.println(provinceName);
        System.out.println(cityName);
        System.out.println(username);
        System.out.println(content);
        System.out.println(albumId);
        resultMap.put("respond",
                commentService.addCommentForSpots(provinceName,cityName,username,content,albumId,photoId));
        return resultMap;

    }

    /**
     * 添加高校图片评论
     * @param provinceName
     * @param albumId
     * @param photoId
     * @param request
     * @return
     */
    @RequestMapping(value = "/collegeComment/{provinceName}/{albumId}/{photoId}  ", method = RequestMethod.POST)
    public Map<String,Boolean> addCommentForCollege(@PathVariable(value = "provinceName") String provinceName,
                                                  @PathVariable(value = "albumId") Long albumId,
                                                  @PathVariable(value = "photoId") Long photoId,
                                                  HttpServletRequest request) {
        String username = getCurrentUserName();
        String content = request.getParameter("photoComment");
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        resultMap.put("respond",
                commentService.addCommentForCollege(provinceName,username,content,albumId,photoId));
        return resultMap;

    }

    /**
     * 判断景点图片评论是否可以删除
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/spotsComment/{provinceName}/{cityName}/{albumId}/{photoId}/{commentId}/deletable", method = RequestMethod.GET)
    public Map<String,Boolean> spotsDeletable(@PathVariable(value = "provinceName") String provinceName,
                                                  @PathVariable(value = "cityName") String cityName,
                                                  @PathVariable(value = "albumId") Long albumId,
                                                  @PathVariable(value = "photoId") Long photoId,
                                                  @PathVariable(value = "commentId") Long commentId) {
        String username = getCurrentUserName();
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        resultMap.put("respond",
                commentService.spotsCommentDeletable(provinceName,cityName,username,albumId,photoId,commentId));
        return resultMap;

    }

    /**
     * 判断高校评论是否可以删除
     * @param provinceName
     * @param albumId
     * @param photoId
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/collegeComment/{provinceName}/{albumId}/{photoId}/{commentId}/deletable", method = RequestMethod.GET)
    public Map<String,Boolean> collegeDeletable(@PathVariable(value = "provinceName") String provinceName,
                                              @PathVariable(value = "albumId") Long albumId,
                                              @PathVariable(value = "photoId") Long photoId,
                                              @PathVariable(value = "commentId") Long commentId) {
        String username = getCurrentUserName();
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        resultMap.put("respond",
                commentService.collegeCommentDeletable(provinceName,username,albumId,photoId,commentId));
        return resultMap;

    }

    /**
     * 删除景点图片评论
     * @param provinceName
     * @param cityName
     * @param albumId
     * @param photoId
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/spotsComment/{provinceName}/{cityName}/{albumId}/{photoId}/{commentId}/delete", method = RequestMethod.GET)
    public Map<String,Boolean> deleteCommentForSpots(@PathVariable(value = "provinceName") String provinceName,
                                              @PathVariable(value = "cityName") String cityName,
                                              @PathVariable(value = "albumId") Long albumId,
                                              @PathVariable(value = "photoId") Long photoId,
                                              @PathVariable(value = "commentId") Long commentId) {
        String username = getCurrentUserName();
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        resultMap.put("respond",
                commentService.deleteCommentForSpots(provinceName,cityName,username,albumId,photoId,commentId));
        return resultMap;

    }

    /**
     * 删除高校图片评论
     * @param provinceName
     * @param albumId
     * @param photoId
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/collegeComment/{provinceName}/{albumId}/{photoId}/{commentId}/delete", method = RequestMethod.GET)
    public Map<String,Boolean> deleteCommentForCollege(@PathVariable(value = "provinceName") String provinceName,
                                                @PathVariable(value = "albumId") Long albumId,
                                                @PathVariable(value = "photoId") Long photoId,
                                                @PathVariable(value = "commentId") Long commentId) {
        String username = getCurrentUserName();
        Map<String,Boolean> resultMap = new HashMap<String, Boolean>();
        resultMap.put("respond",
                commentService.deleteCommentForCollege(provinceName,username,albumId,photoId,commentId));
        return resultMap;

    }


    /**
     * 获取用户名
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
