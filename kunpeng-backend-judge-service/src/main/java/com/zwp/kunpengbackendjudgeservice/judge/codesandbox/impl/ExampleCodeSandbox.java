package com.zwp.kunpengbackendjudgeservice.judge.codesandbox.impl;


import com.zwp.kunpengbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.zwp.kunpengbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zwp.kunpengbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.zwp.kunpengbackendmodel.model.codesandbox.JudgeInfo;
import com.zwp.kunpengbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.zwp.kunpengbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
