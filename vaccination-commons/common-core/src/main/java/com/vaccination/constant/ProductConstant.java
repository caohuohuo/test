package com.vaccination.constant;


import com.vaccination.enums.ProductEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.core.constant
 * @Description:
 * @date 2021/5/11 15:33
 */
public class ProductConstant {
    public static Map<Integer,Integer> mapPlatform = new HashMap<>();
    static {
        mapPlatform.put(ProductEnum.ProductStatus.YES.getValue(), ProductEnum.PlatformStatus.EFFECT.getValue());
        mapPlatform.put(ProductEnum.ProductStatus.NO.getValue(), ProductEnum.PlatformStatus.WAIT_EFFECT.getValue());
    }
}
