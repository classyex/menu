Feature: 查看一天的推荐饮食
  作为用户，我想查看系统给我推荐今天的饮食，这样就能知道今天吃什么

  Scenario: 推荐一天的饮食
    Given 食品库如下：
      | id  | category | name | unit | quantity | weight | calorie | carbohydrate | protein | axunge | gi | foodImage | isBreakfast | isLunch | isDinner |
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

    When 我每天消耗热量为 2000 千卡，查看系统给我推荐一天的饮食

    Then 我看到
    """
{
    "currentCalorie": 1583,
    "dietGoal": 1,
    "suggestCalorie": 1832,
    "suggestCalorieRange": {
        "ceiling": 3297,
        "maxSuggest": 1832,
        "minSuggest": 1465,
        "floor": 0
    },
    "carbohydrate": {
        "maxSuggest": 213.73334,
        "minSuggest": 0,
        "value": 214.30002
    },
    "dietMeal": {
        "lunch": [
            {
                "gi": 1,
                "quantity": 3,
                "weight": 300,
                "foodImage": "https://no-image.png",
                "carbohydrate": 76.8,
                "unit": "碗",
                "protein": 7.5,
                "name": "米饭",
                "calorie": 342,
                "axunge": 0.6,
                "id": 1,
                "category": 0
            },
            {
                "gi": 1,
                "quantity": 3,
                "weight": 180,
                "foodImage": "https://no-image.png",
                "carbohydrate": 11.700001,
                "unit": "份",
                "protein": 54.600002,
                "name": "基围虾",
                "calorie": 303,
                "axunge": 4.2,
                "id": 3,
                "category": 1
            },
            {
                "gi": 1,
                "quantity": 2,
                "weight": 188,
                "foodImage": "https://no-image.png",
                "carbohydrate": 2.6,
                "unit": "份",
                "protein": 2.6,
                "name": "生菜",
                "calorie": 26,
                "axunge": 0.6,
                "id": 7,
                "category": 2
            }
        ],
        "dinner": [
            {
                "gi": 1,
                "quantity": 2,
                "weight": 200,
                "foodImage": "https://no-image.png",
                "carbohydrate": 51.2,
                "unit": "碗",
                "protein": 5,
                "name": "米饭",
                "calorie": 228,
                "axunge": 0.4,
                "id": 1,
                "category": 0
            },
            {
                "gi": 1,
                "quantity": 2,
                "weight": 120,
                "foodImage": "https://no-image.png",
                "carbohydrate": 7.8,
                "unit": "份",
                "protein": 36.4,
                "name": "基围虾",
                "calorie": 202,
                "axunge": 2.8,
                "id": 3,
                "category": 1
            },
            {
                "gi": 1,
                "quantity": 2,
                "weight": 188,
                "foodImage": "https://no-image.png",
                "carbohydrate": 2.6,
                "unit": "份",
                "protein": 2.6,
                "name": "生菜",
                "calorie": 26,
                "axunge": 0.6,
                "id": 7,
                "category": 2
            }
        ],
        "breakfast": [
            {
                "gi": 1,
                "quantity": 2,
                "weight": 200,
                "foodImage": "https://no-image.png",
                "carbohydrate": 51.2,
                "unit": "碗",
                "protein": 5,
                "name": "米饭",
                "calorie": 228,
                "axunge": 0.4,
                "id": 1,
                "category": 0
            },
            {
                "gi": 1,
                "quantity": 2,
                "weight": 120,
                "foodImage": "https://no-image.png",
                "carbohydrate": 7.8,
                "unit": "份",
                "protein": 36.4,
                "name": "基围虾",
                "calorie": 202,
                "axunge": 2.8,
                "id": 3,
                "category": 1
            },
            {
                "gi": 1,
                "quantity": 2,
                "weight": 188,
                "foodImage": "https://no-image.png",
                "carbohydrate": 2.6,
                "unit": "份",
                "protein": 2.6,
                "name": "生菜",
                "calorie": 26,
                "axunge": 0.6,
                "id": 7,
                "category": 2
            }
        ]
    },
    "protein": {
        "maxSuggest": 183.2,
        "minSuggest": 0,
        "value": 152.70001
    },
    "axunge": {
        "maxSuggest": 27.140741,
        "minSuggest": 0,
        "value": 13
    }
}
    """