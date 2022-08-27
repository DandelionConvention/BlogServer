package com.fbw.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "oId", type = IdType.AUTO)
    private Integer oId;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 评论时间戳
     */
    @TableField(value = "created")
    private Long created;

    /**
     * 评论人名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 评论的文章/页面的 id
     */
    @TableField(value = "onId")
    private Integer onId;

    /**
     * 评论人id
     */
    @TableField(value = "userId")
    private Integer userId;

    /**
     * 评论人头像图片链接地址
     */
    @TableField(value = "thumbnailURL")
    private String thumbnailURL;

    /**
     * 评论回复时原始的评论 id，即父评论 id
     */
    @TableField(value = "originalCommentId")
    private Integer originalCommentId;

    /**
     * 评论回复时原始的评论人名称，即父评论人名称
     */
    @TableField(value = "originalCommentName")
    private String originalCommentName;


}
