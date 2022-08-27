package com.fbw.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "oId", type = IdType.AUTO)
    private Integer oId;

    /**
     * 文章标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 文章摘要
     */
    @TableField(value = "abstract")
    private String abstractContext;

    /**
     * 文章作者 id
     */
    @TableField(value = "authorId")
    private Integer authorId;

    /**
     * 文章评论计数
     */
    @TableField(value = "commentCount")
    private Integer commentCount;

    /**
     * 文章浏览计数
     */
    @TableField(value = "viewCount")
    private Integer viewCount;

    /**
     * 文章正文内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 文章是否已经发布过
     */
    @TableField(value = "hadPublished")
    private String hadPublished;

    /**
     * 文章是否处于已发布状态
     */
    @TableField(value = "isPublished")
    private String isPublished;

    /**
     * 文章是否置顶
     */
    @TableField(value = "putTop")
    private String putTop;

    /**
     * 文章创建时间戳
     */
    @TableField(value = "created")
    private Long created;

    /**
     * 文章更新时间戳
     */
    @TableField(value = "updated")
    private Long updated;

    /**
     * 文章随机数，用于快速查询随机文章列表
     */
    @TableField(value = "randomDouble")
    private Double randomDouble;

    /**
     * 文章是否可以评论
     */
    @TableField(value = "commentable")
    private String commentable;

    /**
     * 文章对应的图片
     */
    @TableField(value = "imgName")
    private String imgName;


}
