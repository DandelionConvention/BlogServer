package com.fbw.service.impl;

import com.fbw.domain.Comment;
import com.fbw.dao.CommentDao;
import com.fbw.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-07-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements ICommentService {

}
