/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-03 19:21
 */
package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Where(clause = "delete_time is null and online = 1")
public class Activity extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String name;
    private String description;
//    private Long activityCoverId;
    private Date startTime;
    private Date endTime;
    private Boolean online;
    private String entranceImg;
    private String internalTopImg;
    private String remark;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "activity_category",
//            joinColumns = @JoinColumn(name = "activity_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<Category> categoryList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="activityId")
    private List<Coupon> couponList;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "activity_coupon",
//            joinColumns = @JoinColumn(name = "activity_id"),
//            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
//    private List<Coupon> couponList;
}
