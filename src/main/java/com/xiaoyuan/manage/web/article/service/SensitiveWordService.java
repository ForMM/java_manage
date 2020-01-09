package com.xiaoyuan.manage.web.article.service;

import com.xiaoyuan.manage.util.Result;

public interface SensitiveWordService {
	public Result insertSenWord(String wordStr)throws Exception;
	public Result senWordList(String keyword, Integer pageSize,Integer page);
	public Result deleteSenWord(Long wordId)throws Exception;
	
}
