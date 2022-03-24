package com.example.bootsplit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lintianxing
 * @since 2022-03-15
 */
@TableName("t_user")@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@ApiModel(value = "User对象", description = "")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    private String role;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", userName=" + userName +
            ", password=" + password +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
