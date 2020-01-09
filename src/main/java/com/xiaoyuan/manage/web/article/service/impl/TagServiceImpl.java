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

import com.xiaoyuan.manage.content.FinVal;
import com.xiaoyuan.manage.content.Status;
import com.xiaoyuan.manage.util.Help;
import com.xiaoyuan.manage.util.Paginator;
import com.xiaoyuan.manage.util.Result;
import com.xiaoyuan.manage.web.article.service.TagService;
import com.xiaoyuan.manage.web.comment.Model.TagListModel;
import com.xiaoyuan.manage.web.comment.dto.TagListDto;
import com.xiaoyuan.manage.web.dao.TagMapper;
import com.xiaoyuan.manage.web.dao.UserMapper;
import com.xiaoyuan.manage.web.entity.Tag;
import com.xiaoyuan.manage.web.entity.User;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	private static final Logger log= LoggerFactory.getLogger(TagServiceImpl.class);
	  @Autowired
	  private TagMapper tagMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	@Override
	public Result tagList(TagListModel tagListModel) {

		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(tagListModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Integer page = tagListModel.getPage();
		Integer pageSize = tagListModel.getPageSize();
		String keyword = tagListModel.getKeyword();
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("keywords", keyword);
		
		int count =tagMapper.countTagList(param);
		
		
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
		List<Tag> findTagList = tagMapper.findTagList(param);
		
		List<TagListDto> TagListDtos=new ArrayList<TagListDto>();
		if(Help.isNotNull(findTagList)){
			for(Tag tag:findTagList){
				TagListDto tagListDto = new TagListDto();
				tagListDto.setTagId(tag.getnTagId());
				tagListDto.setTagName(tag.getcTagName());
				
				Long getnCreateId = tag.getnCreateId();
				User selectByPrimaryKey = userMapper.selectByPrimaryKey(getnCreateId);
				if(Help.isNotNull(selectByPrimaryKey)){
					tagListDto.setCreateName(selectByPrimaryKey.getcUserRealname());
				}
				
				tagListDto.setCreateTime(tag.gettCreateTime());
				TagListDtos.add(tagListDto);
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
		data.put("dataList", TagListDtos);
		data.put("total", count);
		result.setData(data);
		return result;

	}

	@Override
	public Result tagVerify(Long tagId, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addTag(String tagName) {
		log.debug("开始添加评论");
		Result result = new Result();
		Tag tag = new Tag();
		tag.setcTagName(tagName);
		tag.setnTagType(FinVal.TAG_TYPE_SYSTEM);
		
		tagMapper.insertSelective(tag);
		log.debug("添加评论结束");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result updateTag(Long tagId,String tagName) {
		log.debug("开始更新评论");
		Result result = new Result();
		Tag tag = new Tag();
		tag.setnTagId(tagId);
		tag.setcTagName(tagName);
		
		tagMapper.updateByPrimaryKey(tag);
		log.debug("更新评论结束");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result deleteTag(Long tagId) {
		Result result = new Result();
		tagMapper.deleteByPrimaryKey(tagId);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

}
