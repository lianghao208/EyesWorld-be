视界TV端_接口文档
==========================

## 旅游景区

### 1.1 省份、城市选择

#### 省份信息

* router
  * /provinces/cities

* request
```
```

* response
```js
[{
    "provinceName": String,
    "spotNum": Number,
	"collegeNum": Number
},
...]
```
#### 城市信息
* router
  * /provinces/cities/{provinceName}

* request
  *

* response
```js
[{
    "city": String,
    "albumNum": Number,
},
...]
```


### 1.2 浏览相册

* router
  * /provinces/cities/{provinceName}/{cityName}/spots

* request
```
```

* response
```js
[{
    "albumId": Number,
    "albumName": String,
    "visitAmount": Number,
    "likeAmount": Number,
    "url": String
}, ...]
```

### 1.3 浏览图片

* router
  * /provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}

* request
```
```

* response
```js
{
    "photoId":Number,
    "username":String,
    "photoName":String,
    "photoDescription":String,
    "url":String,
    "like":Boolean,
    "likeAmount":Number,
    "createTime":Number
    "last": Boolean
}
```
* 作用\
获取一album里所有照片的id按顺序形成数组

### 1.4 上一张，下一张

* router
  * /provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}

* request
```
```

* response
  * 同 1.3-response

* 上一张下一张通过photoId加一减一实现

### 1.5 点赞

* router
  * /provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}

* request
method: GET
```js
{
	"like": Boolean
}
```

* response
```
{
    "isSuccessful":Boolean
}
```

### 1.6 获取评论

* router
  * /provinces/cities/{provinceName}/{cityName}/spots/{albumId}/{photoId}/comment

* request

* response
```js
[{
    "userName": String,
    "comment": String,
    "date": UNIX
}, ...]
```

## 高校景观

### 2.1 省份选择
#### 省份选择
* router
  * /provinces/collage

* request

* response
```js
[{
	"provinceName": String,
    "spotNum": Number,
	"collegeNum": Number
},
...]
```

#### 高校选择

* router
  * /provinces/college/{provinceName}

* request
  *

* response
```js
[{
    "college": String,
    "albumId": Number,
    "name": String,
    "visited": Number,
    "likeNum": Number,
    "url": String
},
...]
```


### 2.2 浏览图片

* router
  * /provinces/college/{provinceName}/{albumId}/{photoId}
  * 这里photoId默认值为1
  * 前端自己判断是否能点击上一张下一张

* request
```
```

* response
  * 同 1.3-response


## 最新推荐

### 3.1 轮播图

* router
  * /lastest

* response
  * 同 1.2-response

### 3.2 推荐相册

* router
  * /lastest

* response
  * 同 1.3-response

## 用户管理

### 4.1 登录状态判断

* router
  * /user

* request
  * cookie：
  
* response
```js
{
    "state":Boolean,
    "username": String //state = 1 时才返回
}
```

### 4.2 未登录，请扫玛登录
???
* response
```js
{
    "QRUrl": String
}
```

* 要有过期时间

### 4.3 已经登录

* 跳到 4.1 重新验证

### 4.4 退出

* router
  * /logout

### 4.5 我的作品

* router
  * /user/works/{userName}

* response
```js
[{
    "date": UNIX,
    "url": String,
    "photoId": Number,
    "photoName":String,
    "albumId": Number,
    "albumName":String
}, ...]
```

### 4.5 我的作品-删除

  * /user/works/{userName}/delete/{albumId}/{photoName}

### 4.6 我的作品-上传

* response
  * 返回二维码，及token、链接

### 4.7 我的收藏

* router
  * /user/favorite/{userId}

* response
```js
[{
    "date": UNIX,
    "url": String,
    "photoId": Number,
    "photoName":String,
    "albumId": Number,
    "albumName":String
}, ...]
```
