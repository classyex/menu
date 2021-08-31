# 推荐菜单

## 依赖
1. 本项目测试环境依赖docker，要运行测试代码，需要先安装docker。  
参考：
    - [window安装docker](https://docs.docker.com/desktop/windows/install/)  
    - [Linux安装docker](https://docs.docker.com/engine/install/)
2. 本项目使用idea开发


## 运行测试
本项目使用cucumber做集成测试，使用参考 [10分钟入门cucumber](https://cucumber.io/docs/guides/10-minute-tutorial/) 。  
   -  第一个测试入口为 src/test/resources/e2e/dummy.feature，右键运行即可  
   -  运行全部测试，在项目根目录运行 `mvn test` 或者右键运行src/test/java/cn/classyex/menu/RunCucumberTest.java类




查看jacoco测试覆盖报告  
menu\build-tools\target\site\jacoco-aggregate\index.html 

查看编码风格检查报告  
menu\target\site\checkstyle-aggregate.html 

  

