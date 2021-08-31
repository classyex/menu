# 推荐菜单
根据用户的性别、年龄、身高、体重、饮食偏好（增重、减重、均衡）推荐每日菜单。  
- [x] 录入食物
- [x] 录入会员信息
- [x] 推荐每日饮食
- [ ] 记录每日饮食
- [ ] 查看每日饮食历史记录


## 依赖
1. 本项目测试环境依赖docker，要运行测试代码，需要先安装docker。  
参考：
    - [window安装docker](https://docs.docker.com/desktop/windows/install/)  
    - [Linux安装docker](https://docs.docker.com/engine/install/)
2. 本项目使用idea开发

## 运行测试
本项目使用cucumber做集成测试，使用参考 [10分钟入门cucumber](https://cucumber.io/docs/guides/10-minute-tutorial/) 。  
运行项目：
```shell
git clone https://github.com/classyex/menu.git
cd menu
启动docker服务
mvn test
```
或者将本项目导入idea，启动docker服务， 
   -  第一个测试入口为 src/test/resources/e2e/dummy.feature，右键运行即可  
   -  运行全部测试，在项目根目录运行 `mvn test` 或者右键运行src/test/java/cn/classyex/menu/RunCucumberTest.java类

查看jacoco测试覆盖报告  
menu\build-tools\target\site\jacoco-aggregate\index.html   
> 要求测试覆盖率到达100%

查看编码风格检查报告  
menu\target\site\checkstyle-aggregate.html
> 根据谷歌代码规范调整：  
> 4个空格  
> 去除文档格式要求  
> 行最大字数120  
> 运行*导入  
> 排除DO，VO，DTO，DAO连续大写校验  

  

