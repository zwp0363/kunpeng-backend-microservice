package com.zwp.kunpengbackendjudgeservice.judge.codesandbox;

import com.zwp.kunpengbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zwp.kunpengbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
