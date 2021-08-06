Feature: APP用户管理
  作为小程序用户，我授权登录之后，填写个人信息，这样系统就能给我推荐合适的饮食
  我可以修改我的个人信息
  我还能查看我的个人信息

  Scenario: 用户更新个人信息
    When 提交个人信息
    """
    {
      "openId": "123",
      "nickname": "张三",
      "avatar": "https://no-image.png",
      "gender": 1,
      "height": 170.0,
      "weight": 60.0,
      "birthday": "1990-01-01",
      "dietGoal": 1
    }
    """

    Then 有用户提交的个人信息
      | openId | 昵称 | 头像 | 性别 | 身高 | 体重 | 生日 | 饮食目标 |
      | 123 | 张三 | https://no-image.png | 1 | 170.0 | 60.0 | 1990-01-01 | 1 |
