package com.annotationValid.validator;

import com.annotationValid.validator.valid.AddGroups;
import com.annotationValid.validator.valid.UpdateGroups;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ValidVO {
    private String id;

    @Length(min = 6,max = 12,message = "appId长度必须位于6到12之间")
    private String appId;

    @NotBlank(message = "名字为必填项",groups = {UpdateGroups.class})
    private String name;

    @Email(message = "请填写正确的邮箱地址")
    @NotBlank(message = "邮箱为必填项",groups = {AddGroups.class})
    private String email;

    private String sex;

    @NotEmpty(message = "级别不能为空",groups = {AddGroups.class, UpdateGroups.class})
    private String level;
}

