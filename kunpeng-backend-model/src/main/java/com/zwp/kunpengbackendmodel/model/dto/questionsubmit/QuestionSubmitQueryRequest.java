package com.zwp.kunpengbackendmodel.model.dto.questionsubmit;

import com.zwp.kunpengbackendcommon.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 题目提交查询请求
 *
 * @author <a href="https://github.com/zwp0363">zwp</a>
 * @from <a href="https://www.yuque.com/geqian-gtmrp/kskx4b">zwp知识库</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
// 注解让 QuestionSubmitQueryRequest 类在比较相等性和计算哈希值时，正确地包含了父类 PageRequest 的属性，确保了继承关系下的对象比较和哈希运算的正确性
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}