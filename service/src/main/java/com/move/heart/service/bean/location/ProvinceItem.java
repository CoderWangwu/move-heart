package com.move.heart.service.bean.location;

import lombok.Data;

import java.util.List;

/**
 * @Author: wg
 * @Date: 2020/6/7 10:23 下午
 * 省/直辖市/特别行政区
 */
@Data
public class ProvinceItem {
    private String name;
    private String code;

    private List<CityItem> cityItems;
}
