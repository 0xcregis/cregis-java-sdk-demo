1）安装

```xml
 <dependency>
    <groupId>com.cregis</groupId>
    <artifactId>cregis-sdk-spring-boot-starter</artifactId>
    <version>${latest.version}</version>
</dependency>
```

2）配置（以yml格式为例）

配置参数对应项目`API`中的三个参数。

```yaml
cregis:
  sdk:
    url: http://xxx.com
    apiKey: f502a9ac9ca54327986f29c03b271491
    pid: 1382528827416576
```

3）使用

在`Bean`中注入`CregisClient`,就可直接使用其中的方法

```java
@Autowired
CregisClient cregisClient;

/**
 * 检测地址合法性
 */
@ApiOperation("检测地址合法性")
@GetMapping("/address-legal")
public Result<?> isLegalAddress(String mainCoinType, String address) {
    return cregisClient.addressLegal(mainCoinType, address);
}
```