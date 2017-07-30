package org.tvos.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.tvos.dto.*;
import org.tvos.service.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

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
    public List<AlbumDto> albumList(@PathVariable("provinceName") String provinceName,
                                          @PathVariable("cityName") String cityName) {
        //TODO 需要对相册分页
        // businessDto.getPage().setPageNumber(businessSearchNumber);
        return albumService.getAlbumsFromSpots(provinceName,cityName);
    }

    /**
     * 浏览图片
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}", method = RequestMethod.GET)
    public PhotoDto photoView(@PathVariable("provinceName") String provinceName,
                           @PathVariable("cityName") String cityName,
                           @PathVariable("albumId") Long albumId,
                           @PathVariable("photoId") Long photoId) {

        return photoService.getPhotoFromSpots(provinceName,cityName,albumId,photoId);
    }

    /**
     * 获取评论
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}/comment", method = RequestMethod.GET)
    public CommentListDto detail(@PathVariable("provinceName") String provinceName,
                             @PathVariable("cityName") String cityName,
                             @PathVariable("albumId") Long albumId,
                             @PathVariable("photoId") Long photoId) {
        return commentService.getCommentListDto(provinceName,cityName,albumId,photoId);
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
    public List<AlbumDto> orderlist(@PathVariable("provinceName") String provinceName) {
        return albumService.getAlbumsFromCollege(provinceName);
    }

    /**
     * 浏览高校图片
     * TODO 分页功能
     */
    @RequestMapping(value = "/provinces/college/{provinceName}/{albumId}/{photoId}", method = RequestMethod.GET)
    public PhotoDto submitComment(@PathVariable("provinceName") String provinceName,
                                  @PathVariable("albumId") Long albumId,
                                  @PathVariable("photoId") Long photoId) {

        return photoService.getPhotoFromCollege(provinceName,albumId,photoId);
    }

    /**
     * 最新推荐
     */
    @RequestMapping(value = "/lastest", method = RequestMethod.GET)
    public List<AlbumDto> Recommend() {
        return albumService.getAlbumsFromRecommend();
    }

    /**
     * 登录状态判断，返回UserDto对象，其中status属性为登陆状态
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDto login(@CookieValue ("JSESSIONID") String cookieId) {

        return userService.getUserDto(cookieId);
    }

    /**
     * 我的作品
     * TODO 分页功能
     */
    @RequestMapping(value = "/user/works/{userName}", method = RequestMethod.GET)
    public List<PhotoDto> order(@CookieValue ("JSESSIONID") String cookieId,@PathVariable("userName") String userName) {

        return photoService.getPhotoFromUserWork(cookieId,userName);
    }

    /**
     * 我的收藏
     * TODO 分页功能
     */
    @RequestMapping(value = "/user/favorite/{userName}", method = RequestMethod.GET)
    public List<PhotoDto> like(@CookieValue ("JSESSIONID") String cookieId,@PathVariable("userName") String userName) {
        UserInfoDto myFavorite = new UserInfoDto();
        return photoService.getPhotoFromUserFavorite(cookieId,userName);
    }
}
