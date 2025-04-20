package com.zwp.kunpengbackendquestionservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwp.kunpengbackendmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zwp.kunpengbackendmodel.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zwp.kunpengbackendmodel.model.entity.QuestionSubmit;
import com.zwp.kunpengbackendmodel.model.entity.User;
import com.zwp.kunpengbackendmodel.model.vo.QuestionSubmitVO;

/**
* @author zwp
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-04-03 21:55:19
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
