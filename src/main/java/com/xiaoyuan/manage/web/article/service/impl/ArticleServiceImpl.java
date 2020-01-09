package com.xiaoyuan.manage.web.article.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoyuan.manage.content.Status;
import com.xiaoyuan.manage.util.Help;
import com.xiaoyuan.manage.util.Paginator;
import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.article.dto.ArticleListDto;
import com.xiaoyuan.manage.web.article.model.ArticleListModel;
import com.xiaoyuan.manage.web.article.service.ArticleService;
import com.xiaoyuan.manage.web.dao.ArticleMapper;
import com.xiaoyuan.manage.web.dao.UserMapper;
import com.xiaoyuan.manage.web.entity.Article;
import com.xiaoyuan.manage.web.entity.User;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private static final Logger log= LoggerFactory.getLogger(ArticleServiceImpl.class);
	  @Autowired
	  private ArticleMapper articleMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	@Override
	public Result articleList(ArticleListModel articleListModel) {

		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(articleListModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Integer page = articleListModel.getPage();
		Integer pageSize = articleListModel.getPageSize();
		Integer articleType = articleListModel.getArticleType();
		String beginDate = articleListModel.getBeginDate();
		String endDate = articleListModel.getEndDate();
		String keyword = articleListModel.getKeyword();
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("articleType", articleType);
		param.put("beginDate", beginDate);
		param.put("endDate", endDate);
		param.put("keywords", keyword);
		
		int count =articleMapper.countArticleList(param);
		
		
		int pageCount=1;
		if(Help.isNotNull(page)&&Help.isNotNull(pageSize)){
		/**** 分页判断begin *****/
		Paginator paginator = new Paginator(0, pageSize);
		paginator.gotoPage(page);
		pageCount = paginator.calcPageCount(count); // 总页数
		
		/**** 分页判断end *****/
		param.put("startRow", paginator.getStartRow());
		param.put("pageSize", paginator.getPageSize());
		}
		List<Article> findArticleList = articleMapper.findArticleList(param);
		
		List<ArticleListDto> ArticleListDtos=new ArrayList<ArticleListDto>();
		if(Help.isNotNull(findArticleList)){
			for(Article article:findArticleList){
				ArticleListDto articleListDto = new ArticleListDto();
				articleListDto.setArticleId(article.getnArticleId());
				articleListDto.setArticleTitle(article.getcArticleTitle());
				articleListDto.setArticleType(article.getnArticleType());
				
				Long getnCreateId = article.getnCreateId();
				User selectByPrimaryKey = userMapper.selectByPrimaryKey(getnCreateId);
				if(Help.isNotNull(selectByPrimaryKey)){
					articleListDto.setCreateName(selectByPrimaryKey.getcUserRealname());
				}
				
				articleListDto.setCreateTime(article.gettCreateTime());
				
				articleListDto.setArticleStatus(article.getnSubmitStatus());
				
				ArticleListDtos.add(articleListDto);
			}
		}
		log.debug("查询文章列表成功==");
		log.debug("组装接口所需数据完成==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("pageSize", pageSize);
		data.put("pageCount", pageCount);
		data.put("dataList", ArticleListDtos);
		data.put("total", count);
		result.setData(data);
		return result;

	}

	@Override
	public Result articleVerify(Long articleId, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

}
