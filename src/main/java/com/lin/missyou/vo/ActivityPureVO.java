/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-03 20:06
 */
package com.lin.missyou.vo;

import com.lin.missyou.model.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ActivityPureVO {
    private Long id;
    private String title;
    private String entranceImg;
    private Boolean online;
    private String remark;
    private String startTime;
    private String endTime;

    public ActivityPureVO(Activity activity) {
        BeanUtils.copyProperties(activity,this);
    }

    public ActivityPureVO(Object object){
        BeanUtils.copyProperties(object, this);
    }

}
