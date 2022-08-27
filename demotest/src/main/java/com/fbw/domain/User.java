package com.fbw.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "oId", type = IdType.AUTO)
    private Integer oId;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 用户名
     */
    @TableField(value = "userName")
    private String userName;

    /**
     * 用户链接地址
     */
    @TableField(value = "URL")
    private String URL;

    /**
     * 用户密码，MD5
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户角色，管理员：adminRole，普通用户：defaultRole
     */
    @TableField(value = "role")
    private String role;

    /**
     * 用户文章计数
     */
    @TableField(value = "articleCount")
    private Integer articleCount;

    /**
     * 用户已发布文章计数
     */
    @TableField(value = "publishedArticleCount")
    private Integer publishedArticleCount;

    /**
     * 用户头像图片链接地址
     */
    @TableField(value = "avatar")
    private String avatar;


}
