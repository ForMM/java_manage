package com.xiaoyuan.manage.web.comment.service.impl;

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
import com.xiaoyuan.manage.web.comment.Model.CommentListModel;
import com.xiaoyuan.manage.web.comment.dto.CommentListDto;
import com.xiaoyuan.manage.web.comment.service.CommentService;
import com.xiaoyuan.manage.web.dao.CommentMapper;
import com.xiaoyuan.manage.web.dao.UserMapper;
import com.xiaoyuan.manage.web.entity.Comment;
import com.xiaoyuan.manage.web.entity.User;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	private static final Logger log= LoggerFactory.getLogger(CommentServiceImpl.class);
	  @Autowired
	  private CommentMapper commentMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	@Override
	public Result commentList(CommentListModel commentListModel) {
		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(commentListModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Integer page = commentListModel.getPage();
		Integer pageSize = commentListModel.getPageSize();
		String beginDate = commentListModel.getBeginDate();
		String endDate = commentListModel.getEndDate();
		String keyword = commentListModel.getKeyword();
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("beginDate", beginDate);
		param.put("endDate", endDate);
		param.put("keywords", keyword);
		
		int count =commentMapper.countCommentList(param);
		
		
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
		List<Comment> findCommentList = commentMapper.findCommentList(param);
		
		List<CommentListDto> commentListDtos=new ArrayList<CommentListDto>();
		if(Help.isNotNull(findCommentList)){
			for(Comment comment:findCommentList){
				CommentListDto commentListDto = new CommentListDto();
				commentListDto.setId(comment.getnCommentId());
				commentListDto.setContent(comment.getcCommentContent());
				
				User selectByPrimaryKey = userMapper.selectByPrimaryKey(comment.getnUserId());
				if(Help.isNotNull(selectByPrimaryKey)){
					commentListDto.setCreateName(selectByPrimaryKey.getcUserRealname());
				}
				commentListDto.setCreateTime(comment.gettCreateTime());
				
				commentListDtos.add(commentListDto);
				
			}
		}
		log.debug("查询评论列表成功==");
		log.debug("组装接口所需数据完成==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("pageSize", pageSize);
		data.put("pageCount", pageCount);
		data.put("dataList", commentListDtos);
		data.put("total", count);
		result.setData(data);
		return result;
}

	@Override
	public Result commentVerify(Long commentId, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

}
