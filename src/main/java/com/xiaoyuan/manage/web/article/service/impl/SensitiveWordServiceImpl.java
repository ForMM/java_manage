package com.xiaoyuan.manage.web.article.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoyuan.manage.content.FinVal;
import com.xiaoyuan.manage.content.Status;
import com.xiaoyuan.manage.util.Help;
import com.xiaoyuan.manage.util.Paginator;
import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.article.dto.SensitiveWordDto;
import com.xiaoyuan.manage.web.article.service.SensitiveWordService;
import com.xiaoyuan.manage.web.dao.OwlSensitiveWordMapper;
import com.xiaoyuan.manage.web.entity.OwlSensitiveWord;
import com.xiaoyuan.manage.web.user.service.UserService;

@Service
@Transactional
public class SensitiveWordServiceImpl implements SensitiveWordService {
	private static final Logger log= LoggerFactory.getLogger(SensitiveWordServiceImpl.class);
	@Autowired
	private OwlSensitiveWordMapper owlSensitiveWordMapper;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public Result insertSenWord(String wordStr) throws Exception {
		// TODO Auto-generated method stub
		log.debug("开始插入敏感词==");
		Result result = new Result();
		String[] wordArr =  wordStr.split(",");
		for(int i=0;Help.isNotNull(wordArr)&& i<wordArr.length;i++){
			String wordTemp = wordArr[i];
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("word", wordTemp);
			List<OwlSensitiveWord> findByParam = owlSensitiveWordMapper.findByParam(param);
			if(Help.isNull(findByParam)){
				OwlSensitiveWord  owlSensitiveWord =  new OwlSensitiveWord();
				owlSensitiveWord.setcWord(wordTemp);
				owlSensitiveWord.settCreateTime(new Date());
				owlSensitiveWord.setnStatus(FinVal.DEFAULT_TRUE);
			
				owlSensitiveWordMapper.insert(owlSensitiveWord);
			}
		}
		log.debug("插入敏感词结束==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result senWordList(String keyword, Integer pageSize, Integer page) {
		
		// TODO Auto-generated method stub
		log.debug("开始查询敏感词列表");
		Result result = new Result();
	
		if(Help.isNull(pageSize))pageSize=FinVal.DEFAULT_PAGESIZE;
		if(Help.isNull(page))page=FinVal.DEFAULT_PAGE;		
		
		Integer pageCount=1;
		
		Map<String,Object> param = new HashMap<String,Object>();				
		param.put("searchword", keyword);	
	
		int count =owlSensitiveWordMapper.countByParam(param);
	
		/**** 分页判断begin *****/
		Paginator paginator = new Paginator(0, pageSize);
		paginator.gotoPage(page);
		pageCount = paginator.calcPageCount(count); // 总页数
		int startRow = paginator.getStartRow();		
		param.put("startRow", startRow);
		param.put("pageSize", pageSize);
		param.put("orderBy", "ORDER BY t_create_time desc");
		
		List<OwlSensitiveWord> owlSensitiveWords =	owlSensitiveWordMapper.findByParam(param);
		List<SensitiveWordDto> sensitiveWordDtos = new  ArrayList<SensitiveWordDto>();
		
		for(int i=0;owlSensitiveWords!=null&&i<owlSensitiveWords.size();i++){
			SensitiveWordDto sensitiveWordDto = new SensitiveWordDto();
			OwlSensitiveWord owlSensitiveWord = owlSensitiveWords.get(i);
			sensitiveWordDto.setWordId(owlSensitiveWord.getnSensitiveId());
			sensitiveWordDto.setCreateTime(owlSensitiveWord.gettCreateTime());
			sensitiveWordDto.setWord(owlSensitiveWord.getcWord());
			sensitiveWordDtos.add(sensitiveWordDto);
		}
		 
		 log.debug("组装敏感词列表接口所需数据完成==");
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("page", page);
			data.put("pageSize", pageSize);
			data.put("pageCount", pageCount);
			data.put("dataList", sensitiveWordDtos);
			data.put("total", count);		
			result.setData(data);
			return result;
	}

	@Override
	public Result deleteSenWord(Long wordId) throws Exception {
		// TODO Auto-generated method stub
		log.debug("删除敏感词开始==");
		Result result = new Result();
		OwlSensitiveWord  owlSensitiveWord =  new OwlSensitiveWord();
		owlSensitiveWord.setnSensitiveId(wordId);
		owlSensitiveWord.setnStatus(FinVal.DEFAULT_FALSE);
		owlSensitiveWordMapper.updateByPrimaryKeySelective(owlSensitiveWord);
		log.debug("删除敏感词结束==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}
    
}
