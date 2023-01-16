package com.ysb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitConversion {

    /**
     * 四舍五入
     *
     * @param value    - 原始数值
     * @param original - 原始单位
     * @param need     - 转换的单位
     * @return BigDecimal - 转换后的值
     */
    public static BigDecimal conversion(BigDecimal value, String original, String need) {
        return conversion(value, getUnitEnum(original), getUnitEnum(need));
    }

    /**
     * 指定小数点位数，四舍五入
     *
     * @param value    - 原始数值
     * @param original - 原始单位
     * @param need     - 转换的单位
     * @param scale    - 小数点位数
     * @return BigDecimal - 转换后的值
     */
    public static BigDecimal conversion(BigDecimal value, String original, String need, final Integer scale) {
        return conversion(value, getUnitEnum(original), getUnitEnum(need), scale);
    }

    /**
     * 使用默认位数（2 或 need 的小数点位数）四舍五入
     *
     * @param value    - 原始数值
     * @param original - 原始单位
     * @param need     - 转换的单位
     * @return BigDecimal - 转换后的值
     */
    public static BigDecimal conversion(final BigDecimal value, final UnitEnum original, final UnitEnum need) {
        String needString = need.rate.toString();
        int scale = 2;
        if (needString.indexOf('.') > 0) {
            scale = needString.substring(needString.indexOf('.')).length() - 1;
        }
        return conversion(value, original, need, scale);
    }

    /**
     * 转换主方法，指定小数点位数，四舍五入
     *
     * @param value    - 原始数值
     * @param original - 原始单位
     * @param need     - 转换的单位
     * @param scale    - 小数点位数
     * @return BigDecimal - 数值
     */
    public static BigDecimal conversion(final BigDecimal value, final UnitEnum original, final UnitEnum need, final Integer scale) {
        if (original == UnitEnum.UN_KNOWN || need == UnitEnum.UN_KNOWN) {
            throw new IllegalArgumentException("存在不支持的计量单位参数");
        }
        if (original.category != need.category) {
            throw new IllegalArgumentException(String.format("转换计量单位不统一 %s 不能转换为 %s ", original.category.name, need.category.name));
        }
        return value == null ? BigDecimal.ZERO : value.multiply(need.rate).divide(original.rate, scale, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        System.out.println(conversion(new BigDecimal("2"), "kg", "mg"));
    }

    /**
     * 获取计量单位枚举
     *
     * @param unit - 计量单位名称
     * @return UnitsEnum - 计量单位
     */
    public static UnitEnum getUnitEnum(String unit) {
        if (StringUtils.isNotEmpty(unit)) {
            for (UnitEnum unitEnum : UnitEnum.values()) {
                for (String possibleName : unitEnum.possibleNames) {
                    if (possibleName.equals(unit.toLowerCase())) {
                        return unitEnum;
                    }
                }
            }
        }
        return UnitEnum.UN_KNOWN;
    }

    /**
     * 获取计量单位集合
     *
     * @return Map<String, List < Map < String, String>>> - 计量单位集合
     */
    public static Map<String, List<Map<String, String>>> getUnitListMap() {
        Map<String, List<Map<String, String>>> listMap = new HashMap<>(UnitEnum.CategoryEnum.values().length);
        for (UnitEnum unit : UnitEnum.values()) {
            if (unit.category != null) {
                String categoryName = unit.category.name;
                Map<String, String> lengthMap = new HashMap<>(2);
                lengthMap.put("code", unit.getUnit());
                lengthMap.put("name", unit.getDescription());
                List<Map<String, String>> list = listMap.get(categoryName);
                if (list == null || list.isEmpty()) {
                    list = new ArrayList<>();
                }
                list.add(lengthMap);
                listMap.put(categoryName, list);
            }
        }
        return listMap;
    }

    /**
     * 获取计量单位类型
     *
     * @return List<Map < String, String>> - 计量单位类型
     */
    public static List<Map<String, String>> getCategoryList() {
        List<Map<String, String>> categoryList = new ArrayList<>();
        for (UnitEnum.CategoryEnum category : UnitEnum.CategoryEnum.values()) {
            Map<String, String> lengthMap = new HashMap<>(2);
            lengthMap.put("code", category.getName());
            lengthMap.put("name", category.getDescription());
            categoryList.add(lengthMap);
        }
        return categoryList;
    }

    /**
     * 计量单位枚举
     */
    @Getter
    @AllArgsConstructor
    public enum UnitEnum {


        /**
         * 质量计量单位
         */
        M_KG(CategoryEnum.MASS, "kg", new String[]{"kg", "千克"}, new BigDecimal("0.001"), "千克"),
        M_G(CategoryEnum.MASS, "g", new String[]{"g", "克"}, new BigDecimal("1"), "克"),
        M_MG(CategoryEnum.MASS, "mg", new String[]{"mg", "毫克"}, new BigDecimal("1000"), "毫克"),
        M_UG(CategoryEnum.MASS, "μg", new String[]{"μg", "ug", "微克"}, new BigDecimal("1000000"), "微克"),


        /**
         * 温度计量单位
         */
        T_DEGREE_CELSIUS(CategoryEnum.TEMPERATURE, "°C", new String[]{"°C", "degreecelsius", "摄氏度"}, new BigDecimal("1"), "摄氏度"),
        T_FAHRENHEIT_SCALE(CategoryEnum.TEMPERATURE, "°F", new String[]{"°F", "fahrenheitscale", "华氏度"}, new BigDecimal("33.8"), "华氏度"),



        /**
         * 未知
         */
        UN_KNOWN(null, "未知", null, new BigDecimal("0"), "未知");

        /**
         * 计量类别
         */
        private final CategoryEnum category;
        /**
         * 计量单位
         */
        private final String unit;
        /**
         * 可能的名称
         */
        private final String[] possibleNames;
        /**
         * 换算率
         */
        private final BigDecimal rate;
        /**
         * 描述
         */
        private final String description;

        /**
         * 计量类别
         */
        @Getter
        @AllArgsConstructor
        private enum CategoryEnum {

            /**
             * 质量
             */
            MASS("Mass", UnitEnum.M_G, "质量"),
            /**
             * 温度
             */
            TEMPERATURE("Temperature", UnitEnum.T_DEGREE_CELSIUS, "温度"),


            ;
            /**
             * 类别名称
             */
            private final String name;
            /**
             * 类别基准
             */
            private final UnitEnum base;
            /**
             * 描述
             */
            private final String description;
        }

    }

}