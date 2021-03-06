# EyesWorld-be

## Backend of the EyesWorld app( Runs on TVOS)

[![Travis](https://img.shields.io/travis/rust-lang/rust.svg?style=plastic)](https://github.com/lianghao208/EyesWorld-be)
[![](https://img.shields.io/badge/JDK-1.8.025-red.svg)](https://github.com/lianghao208/EyesWorld-be)
[![](https://img.shields.io/badge/maven--central-v3.0.5-blue.svg)](https://maven.apache.org)

* Framework: Spring + SpringMVC + MyBatis + Redis( Coming soon)

Frontend Repository
--------------
[check the frontend repository](https://github.com/eyes-world/eyes-world-fe) 

API and Summary
--------------
* The development process: [check the whole process](https://github.com/lianghao208/eyes-world-server/blob/master/README.md) 
* The development API(TV): [check the TV (PC) API document](https://github.com/lianghao208/eyes-world-api/blob/master/api.md) 
* The development API(Mobile): [check the Mobile API document](https://github.com/lianghao208/eyes-world-api/blob/master/api-web.md) 

To Do List
----------

- Update Mybatis Pager
- Combine the function with frontend pages
- Reconstruct the database construction
- Test with Jmeter

Update
-----------------
```
./org/tvos/listener    # upgrade listener
./org/tvos/filter      # add CORS request support
./org/tvos/util        # add thumbnail image support
./org/tvos/dao/cache   # update redis cache support
```
- Convert the database timestamp to POJO type timestamp


Architecture
------------
#### user, host, servers
![]()

#### deployment flow
![]()

Screenshots
-----------

#### project config
![]()

#### web - login page
![](https://github.com/lianghao208/EyesWorld-be/blob/master/src/main/webapp/screenshot/loginPage.png)

#### web - menu page
![](https://github.com/lianghao208/EyesWorld-be/blob/master/src/main/webapp/screenshot/menu2.png)

#### web - view photo page
![](https://github.com/lianghao208/EyesWorld-be/blob/master/src/main/webapp/screenshot/viewPhoto.png)

#### web - personal information page
![](https://github.com/lianghao208/EyesWorld-be/blob/master/src/main/webapp/screenshot/personalInfo.png)

## CHANGELOG
[CHANGELOG](https://github.com/lianghao208/EyesWorld-be/blob/master/changeLog.md)
