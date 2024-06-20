package com.gunni.gunnihaeba.domain.exception.issue;

import com.gunni.gunnihaeba.domain.exception.issue.error.IssueErrorProperty;
import com.gunni.gunnihaeba.global.exception.BusinessException;

public class IssueNotFoundException extends BusinessException {
    public static final IssueNotFoundException EXCEPTION = new IssueNotFoundException();

    private IssueNotFoundException(){
        super(IssueErrorProperty.ISSUE_NOT_FOUND);
    }
}
