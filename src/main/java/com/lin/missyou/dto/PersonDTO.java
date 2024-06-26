/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-01-18 17:07
 */
package com.lin.missyou.dto;

import com.lin.missyou.dto.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Builder
@Getter
@PasswordEqual(message = "两次密码不相同")
public class PersonDTO {
    @Length(min=2, max=10, message = "xxxxx")
    private String name;
    private Integer age;

//@PasswordEqual

    private String password1;
    private String password2;
}



