/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-17 04:52
 */
package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SaleExplain extends BaseEntity {
    @Id
    private Long id;
    private Boolean fixed;
    private String text;
    private Long spuId;
    private Long index;
    private Long replaceId;
}
