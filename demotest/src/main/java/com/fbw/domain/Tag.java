package com.fbw.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 标签表
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "oId", type = IdType.AUTO)
    private Integer oId;

    /**
     * 标签关联的已发布文章计数
     */
    @TableField(value = "publishedRefCount")
    private Integer publishedRefCount;

    /**
     * 标签关联的文章计数
     */
    @TableField(value = "referenceCount")
    private Integer referenceCount;

    /**
     * 标签标题
     */
    @TableField(value = "title")
    private String title;


}
