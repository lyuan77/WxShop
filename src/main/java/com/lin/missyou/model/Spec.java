/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-02 04:14
 */
package com.lin.missyou.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Spec implements Serializable {

    @JsonProperty("key_id")
    private Long keyId;
    private String key;
    @JsonProperty("value_id")
    private Long valueId;
    private String value;
}


