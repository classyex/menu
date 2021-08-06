Feature: 食品管理
  作为管理员，我需要添加食品到食品库，这样推荐饮食的时候就能有食品可以选择；
  我需要编辑已存在的食品；我还能下架不需要的食品。
  我还能查看全部的食品

  Scenario: 添加食品
    When 保存食品
    """
    {
      "category": 1,
      "name": "牛瘦肉",
      "unit": "份",
      "quantity": 1,
      "weight": 100,
      "calorie": 106,
      "carbohydrate": 1.2,
      "protein": 20.2,
      "axunge": 2.3,
      "gi": 1,
      "foodImage": "https://no-image.png",
      "isBreakfast": true,
      "isLunch": true,
      "isDinner": true
    }
    """

    Then 有填写的食品
      | 分类 | 名称 | 单位 | 数量 | 重量 | 热量 | 碳水化合物 | 蛋白质 | 脂肪 | GI值 | 参考图片 | 早餐 | 午餐 | 晚餐 | 来源 | 状态 | 删除 | 编号 |
      | 1 | 牛瘦肉 | 份 | 1.0 | 100 | 106 | 1.2 | 20.2 | 2.3 | 1 | https://no-image.png | true | true | true | system | 1 | false | 123 |