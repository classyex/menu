Feature: 初始测试

  Scenario: 访问根路径得到hello
    When Get访问路径 "/" 得到结果是
        """
        hello
        """
