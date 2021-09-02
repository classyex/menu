Feature: 饮食记录
  作为普通用户，我想保存平台给我推荐的饮食记录，这样就能查看我的饮食记录

  Scenario: 保存饮食记录
    Given 我的饮食记录如下:
    """
{
    "memberId": 1,
    "currentCalorie": 1583,
    "dietGoal": 1,
    "suggestCalorie": 1832,
    "carbohydrate": 214.30002,
    "protein": 152.70001,
    "axunge": 13,
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
    }
}
    """

    When 保存为 "2021-08-31" 日的饮食记录

    Then 有饮食记录：
      | 会员id | 饮食日期 | 饮食月份 | 推荐摄入热量 | 当前卡路里 | 饮食目标 | 已选碳水化合物 | 已选蛋白质 | 已选脂肪 | 饮食详情 | 是否最佳 |
      | 1 | 2021-08-31 | 2021-08 | 1832 | 1583 | 1 | 214.3 | 152.7 | 13.0 | {"lunch":[{"gi":1,"quantity":3,"weight":300,"foodImage":"https://no-image.png","carbohydrate":76.8,"unit":"碗","protein":7.5,"name":"米饭","calorie":342,"axunge":0.6,"id":1,"category":0},{"gi":1,"quantity":3,"weight":180,"foodImage":"https://no-image.png","carbohydrate":11.700001,"unit":"份","protein":54.600002,"name":"基围虾","calorie":303,"axunge":4.2,"id":3,"category":1},{"gi":1,"quantity":2,"weight":188,"foodImage":"https://no-image.png","carbohydrate":2.6,"unit":"份","protein":2.6,"name":"生菜","calorie":26,"axunge":0.6,"id":7,"category":2}],"dinner":[{"gi":1,"quantity":2,"weight":200,"foodImage":"https://no-image.png","carbohydrate":51.2,"unit":"碗","protein":5,"name":"米饭","calorie":228,"axunge":0.4,"id":1,"category":0},{"gi":1,"quantity":2,"weight":120,"foodImage":"https://no-image.png","carbohydrate":7.8,"unit":"份","protein":36.4,"name":"基围虾","calorie":202,"axunge":2.8,"id":3,"category":1},{"gi":1,"quantity":2,"weight":188,"foodImage":"https://no-image.png","carbohydrate":2.6,"unit":"份","protein":2.6,"name":"生菜","calorie":26,"axunge":0.6,"id":7,"category":2}],"breakfast":[{"gi":1,"quantity":2,"weight":200,"foodImage":"https://no-image.png","carbohydrate":51.2,"unit":"碗","protein":5,"name":"米饭","calorie":228,"axunge":0.4,"id":1,"category":0},{"gi":1,"quantity":2,"weight":120,"foodImage":"https://no-image.png","carbohydrate":7.8,"unit":"份","protein":36.4,"name":"基围虾","calorie":202,"axunge":2.8,"id":3,"category":1},{"gi":1,"quantity":2,"weight":188,"foodImage":"https://no-image.png","carbohydrate":2.6,"unit":"份","protein":2.6,"name":"生菜","calorie":26,"axunge":0.6,"id":7,"category":2}]} | true |

