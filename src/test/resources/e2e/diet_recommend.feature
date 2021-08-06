Feature: 查看一天的推荐饮食
  作为用户，我想查看系统给我推荐今天的饮食，这样就能知道今天吃什么

  Scenario: 推荐一天的饮食
    Given 食品库如下：
      | 食物id  | 分类 | 名称 | 单位 | 数量 | 重量(g) | 热量(kcal) | 碳水化合物(g) | 蛋白质(g) | 脂肪(g) | GI值 | 参考图片 | 早餐 | 午餐 | 晚餐 |
      | 1  | 0 | 米饭 | 碗 | 1 | 100 | 114 | 25.6 | 2.5 | 0.2 | 1 | https://no-image.png | true | true | true |
      | 2  | 0 | 玉米 | 根 | 0.5 | 46 | 106 | 19.9 | 4 | 1.2 | 1 | https://no-image.png | true | true | true |
      | 3  | 1 | 基围虾 | 份 | 1 | 60 | 101 | 3.9 | 18.2 | 1.4 | 1 | https://no-image.png | true | true | true |
      | 4  | 1 | 猪瘦肉 | 份 | 1 | 100 | 143 | 1.5 | 20.3 | 6.2 | 1 | https://no-image.png | true | true | true |
      | 5  | 1 | 牛瘦肉 | 份 | 1 | 100 | 106 | 1.2 | 20.2 | 2.3 | 1 | https://no-image.png | true | true | true |
      | 6  | 1 | 鸡蛋 | 个 | 1 | 88 | 156 | 1.3 | 12.8 | 11.1 | 1 | https://no-image.png | true | true | true |
      | 7  | 2 | 生菜 | 份 | 1 | 94 | 13 | 1.3 | 1.3 | 0.3 | 1 | https://no-image.png | true | true | true |
      | 8  | 2 | 韭菜 | 份 | 1 | 90 | 26 | 3.2 | 2.4 | 0.4 | 1 | https://no-image.png | true | true | true |
    And 我的个人信息如下：
    """
    {
      "userId": "1",
      "gender": "Male",
      "height": 170,
      "weight": 60,
      "birthday": "1990-01-01",
      "dietGoal": 1
    }
    """

    When 我每天消耗热量为 2000 千卡，查看系统给我推荐一天的饮食

    Then 我看到
    """
    {
    "code": 2000,
    "message": "操作成功！",
    "obj": {
        "id": null,
        "userId": "1",
        "dietDate": null,
        "suggestCalorie": 2061,
        "suggestCalorieRange": {
            "floor": 0,
            "minSuggest": 1648,
            "maxSuggest": 2061,
            "ceiling": 3709
        },
        "currentCalorie": 1961,
        "dietGoal": 1,
        "carbohydrate": {
            "value": 218.0,
            "minSuggest": 0.0,
            "maxSuggest": 240.45
        },
        "protein": {
            "value": 159.59999,
            "minSuggest": 0.0,
            "maxSuggest": 206.1
        },
        "axunge": {
            "value": 50.399998,
            "minSuggest": 0.0,
            "maxSuggest": 30.533335
        },
        "dietDetails": {
            "breakfast": [
                {
                    "id": "1",
                    "category": 0,
                    "name": "米饭",
                    "unit": "碗",
                    "quantity": 2.0,
                    "weight": 200,
                    "calorie": 228,
                    "carbohydrate": 51.2,
                    "protein": 5.0,
                    "axunge": 0.4,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                },
                {
                    "id": "6",
                    "category": 1,
                    "name": "鸡蛋",
                    "unit": "个",
                    "quantity": 2.0,
                    "weight": 176,
                    "calorie": 312,
                    "carbohydrate": 2.6,
                    "protein": 25.6,
                    "axunge": 22.2,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                },
                {
                    "id": "1420565339513868290",
                    "category": 2,
                    "name": "生菜",
                    "unit": "份",
                    "quantity": 2.0,
                    "weight": 188,
                    "calorie": 26,
                    "carbohydrate": 2.6,
                    "protein": 2.6,
                    "axunge": 0.6,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                }
            ],
            "lunch": [
                {
                    "id": "1419942899393765378",
                    "category": 0,
                    "name": "玉米",
                    "unit": "根",
                    "quantity": 3.0,
                    "weight": 138,
                    "calorie": 318,
                    "carbohydrate": 59.699997,
                    "protein": 12.0,
                    "axunge": 3.6000001,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                },
                {
                    "id": "1420564570064605186",
                    "category": 1,
                    "name": "猪瘦肉",
                    "unit": "份",
                    "quantity": 3.0,
                    "weight": 300,
                    "calorie": 429,
                    "carbohydrate": 4.5,
                    "protein": 60.899998,
                    "axunge": 18.599998,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                },
                {
                    "id": "1420565799192809473",
                    "category": 2,
                    "name": "韭菜",
                    "unit": "份",
                    "quantity": 2.0,
                    "weight": 180,
                    "calorie": 52,
                    "carbohydrate": 6.4,
                    "protein": 4.8,
                    "axunge": 0.8,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                }
            ],
            "dinner": [
                {
                    "id": "1",
                    "category": 0,
                    "name": "米饭",
                    "unit": "碗",
                    "quantity": 3.0,
                    "weight": 300,
                    "calorie": 342,
                    "carbohydrate": 76.8,
                    "protein": 7.5,
                    "axunge": 0.6,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                },
                {
                    "id": "1420566516875972610",
                    "category": 1,
                    "name": "基围虾",
                    "unit": "份",
                    "quantity": 2.0,
                    "weight": 120,
                    "calorie": 202,
                    "carbohydrate": 7.8,
                    "protein": 36.4,
                    "axunge": 2.8,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                },
                {
                    "id": "1420565799192809473",
                    "category": 2,
                    "name": "韭菜",
                    "unit": "份",
                    "quantity": 2.0,
                    "weight": 180,
                    "calorie": 52,
                    "carbohydrate": 6.4,
                    "protein": 4.8,
                    "axunge": 0.8,
                    "gi": 1,
                    "foodImage": "https://no-image.png"
                }
            ]
        }
    }
}
    """