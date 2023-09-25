package com.cregis.sdk.demo.controller;

import com.cregis.core.client.CregisClient;
import com.cregis.core.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miller
 * @since 2023/9/25
 * @version 1.0.0
 */
@RestController
public class CregisSdkController {
    @Autowired
    CregisClient cregisClient;

    /**
     * 生成充值地址
     */
    @GetMapping("/address-create")
    public Result<?> addressCreate(String chainId, String callbackUrl, String alias) {
        return cregisClient.addressCreate(chainId, callbackUrl, alias);
    }
    /**
     * 检测地址合法性
     */
    @GetMapping("/address-legal")
    public Result<?> isLegalAddress(String chainId, String address) {
        return cregisClient.addressLegal(chainId, address);
    }

    /**
     * 检测地址在项目中是否存在
     */
    @GetMapping("/address-inner")
    public Result<?> addressInner(String chainId, String address) {
        return cregisClient.addressInner(chainId, address);
    }

    /**
     * 生成提币订单
     */
    @GetMapping("/payout")
    public Result<?> payout(String address, String amount, String thirdPartyId, String callbackUrl, String currency, String remark) {
        return cregisClient.payout(address, currency, amount, thirdPartyId, callbackUrl, remark);
    }

    /**
     * 查询提币信息
     */
    @GetMapping("/payoutQuery")
    public Result<?> payoutQuery(Long cid) {
        return cregisClient.payoutQuery(cid);
    }
}
