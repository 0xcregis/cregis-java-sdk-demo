package com.cregis.sdk.demo.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cregis.core.model.AddressDepositCallback;
import com.cregis.core.model.PayoutCallback;
import com.cregis.core.util.SignUtil;
import com.cregis.spring.starter.config.CregisProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miller
 * @since 2023/9/25
 * @version 1.0.0
 */
@RestController
@Slf4j
public class CregisCallbackController {
    @Autowired
    CregisProps cregisProps;

    /**
     * 地址充值回调
     * @param addressDepositCallback 回调对象
     * @return 结果
     */
    @PostMapping("/address/deposit/callback")
    public String callback2(@RequestBody AddressDepositCallback addressDepositCallback) {
        log.info("地址充值回调:{}", addressDepositCallback);
        if (SignUtil.verifySign(BeanUtil.beanToMap(addressDepositCallback), cregisProps.getApiKey(), addressDepositCallback.getSign())) {
            log.info("验签成功");
        }
        return "success";
    }

    /**
     * 提币回调
     * @param payoutCallback 回调对象
     * @return 结果
     */
    @PostMapping("/withdraw/callback")
    public String callback3(@RequestBody PayoutCallback payoutCallback) {
        log.info("提币回调:{}", payoutCallback);
        if (SignUtil.verifySign(BeanUtil.beanToMap(payoutCallback), cregisProps.getApiKey(), payoutCallback.getSign())) {
            log.info("验签成功");
        }
        return "success";
    }
}
