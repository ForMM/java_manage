package com.xiaoyuan.manage.web.course.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
import com.xiaoyuan.manage.web.course.dto.CourseDto;
import com.xiaoyuan.manage.web.course.dto.CourseTypeDto;
import com.xiaoyuan.manage.web.course.dto.UserCourseListDto;
import com.xiaoyuan.manage.web.course.model.AuthUserModel;
import com.xiaoyuan.manage.web.course.model.CourseModel;
import com.xiaoyuan.manage.web.course.model.CourseTypeModel;
import com.xiaoyuan.manage.web.course.service.CourseService;
import com.xiaoyuan.manage.web.dao.CourseMapper;
import com.xiaoyuan.manage.web.dao.CourseTypeMapper;
import com.xiaoyuan.manage.web.dao.OrgUserMapper;
import com.xiaoyuan.manage.web.dao.SchoolMapper;
import com.xiaoyuan.manage.web.dao.UserMapper;
import com.xiaoyuan.manage.web.entity.Course;
import com.xiaoyuan.manage.web.entity.CourseType;
import com.xiaoyuan.manage.web.entity.OrgUser;
import com.xiaoyuan.manage.web.entity.School;
import com.xiaoyuan.manage.web.entity.Tag;
import com.xiaoyuan.manage.web.entity.User;
import com.xiaoyuan.manage.web.user.dto.UserListDto;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	private static final Logger log= LoggerFactory.getLogger(CourseServiceImpl.class);
	  @Autowired
	  private CourseTypeMapper courseTypeTypeMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	  
	  @Autowired
	  private CourseMapper courseMapper;
	  
	  @Autowired
	  private SchoolMapper schoolMapper;
	  
	  
	  @Autowired
	  private OrgUserMapper orgUserMapper;
	  
	@Override
	public Result courseTypeList(CourseTypeModel courseTypeListModel) {

		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(courseTypeListModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Integer page = courseTypeListModel.getPage();
		Integer pageSize = courseTypeListModel.getPageSize();
		String keyword = courseTypeListModel.getKeyword();
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("keywords", keyword);
		
		int count =courseTypeTypeMapper.countCourseTypeList(param);
		
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
		List<CourseType> findCourseTypeList = courseTypeTypeMapper.findCourseTypeList(param);
		
		List<CourseTypeDto> CourseListDtos=new ArrayList<CourseTypeDto>();
		if(Help.isNotNull(findCourseTypeList)){
			for(CourseType courseTypeType:findCourseTypeList){
				CourseTypeDto courseTypeTypeDto = new CourseTypeDto();
				courseTypeTypeDto.setCourseTypeId(courseTypeType.getnCourseTypeId());
				courseTypeTypeDto.setCourseTypeName(courseTypeType.getcTypeName());
				
				CourseListDtos.add(courseTypeTypeDto);
			}
		}
		log.debug("查询课堂类别列表成功==");
		log.debug("组装接口所需数据完成==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("pageSize", pageSize);
		data.put("pageCount", pageCount);
		data.put("dataList", CourseListDtos);
		data.put("total", count);
		result.setData(data);
		return result;

	}

	@Override
	public Result addCourseType(String courseTypeName) {
		log.debug("开始添加课堂类别");
		Result result = new Result();
		
		int maxIndex = courseTypeTypeMapper.maxIndex()+1;
		
		CourseType courseType = new CourseType();
		courseType.setcTypeName(courseTypeName);
		courseType.setnIndex(maxIndex);
		
		courseTypeTypeMapper.insertSelective(courseType);
		log.debug("添加课堂类别结束");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result updateCourseType(Long courseTypeId, String courseTypeName) {
		log.debug("开始更新评论");
		Result result = new Result();
		CourseType courseType = new CourseType();
		courseType.setcTypeName(courseTypeName);
		courseType.setnCourseTypeId(courseTypeId);
		
		courseTypeTypeMapper.updateByPrimaryKey(courseType);
		log.debug("更新评论结束");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result deleteCourseType(Long courseTypeId) {
		Result result = new Result();
		courseTypeTypeMapper.deleteByPrimaryKey(courseTypeId);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result courseList(CourseModel courseModel) {

		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(courseModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Integer page = courseModel.getPage();
		Integer pageSize = courseModel.getPageSize();
		String keyword = courseModel.getKeyword();
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("keywords", keyword);
		
		int count =courseMapper.countByParam(param);
		
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
		List<Course> findByParam = courseMapper.findByParam(param);
		
		List<CourseDto> courseDtos=new ArrayList<CourseDto>();
		if(Help.isNotNull(findByParam)){
			for(Course course:findByParam){
				CourseDto courseDto = new CourseDto();
				courseDto.setCourseId(course.getnCourseId());
				courseDto.setCourseName(course.getcCourseName());
				courseDto.setCourseType(course.getcCourseType());
				courseDto.setBeginTime(course.gettBeginTime());
				courseDto.setCreateTime(course.gettCreateTime());
				courseDto.setEndTime(course.gettEndTime());
				courseDto.setCount(course.getnCountUser());
				
				User selectByPrimaryKey = userMapper.selectByPrimaryKey(course.getnTeacherId());
				if(Help.isNotNull(selectByPrimaryKey)){
					courseDto.setTeacherName(selectByPrimaryKey.getcUserRealname());
				}
				
				OrgUser selectByPrimaryKey2 = orgUserMapper.selectByPrimaryKey(course.getnOrgId());
				if(Help.isNotNull(selectByPrimaryKey2)){
					courseDto.setOrgName(selectByPrimaryKey.getcUserRealname());
				}
				
				School selectByPrimaryKey3 = schoolMapper.selectByPrimaryKey(course.getnSchoolId());
				if(Help.isNotNull(selectByPrimaryKey3)){
					courseDto.setSchoolName(selectByPrimaryKey3.getcSchoolName());
				}
				courseDto.setPptImgs(convertPPTImgs(course));
				courseDtos.add(courseDto);
				
			}
		}
		log.debug("查询课堂类别列表成功==");
		log.debug("组装接口所需数据完成==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("pageSize", pageSize);
		data.put("pageCount", pageCount);
		data.put("dataList", courseDtos);
		data.put("total", count);
		result.setData(data);
		return result;

	}
	
	private Map<String,Object> convertPPTImgs(Course course){
		String imgsJSON = course.getcPptImgs();
		Map<String, Object> pptImgs = new HashMap<String,Object>();
		if(Help.isNotNull(imgsJSON)){
			pptImgs.put("title", course.getcCourseName());
			pptImgs.put("id", course.getnCourseId());
			List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
			
			JSONArray jsonArr = JSONArray.fromObject(imgsJSON);
			for(int i = 0;i<jsonArr.size();i++){
				Map<String,Object> photo = new HashMap<String,Object>();
				JSONObject jsonObj = (JSONObject) jsonArr.get(i);
				String imgPath = (String) jsonObj.get("imgPath");
				photo.put("src", imgPath);
				data.add(photo);
			} 
			pptImgs.put("data", data );
			
		}
		return pptImgs;
	}

	@Override
	public Result authUserList(AuthUserModel authUserModel) {
		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(authUserModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Integer page = authUserModel.getPage();
		Integer pageSize = authUserModel.getPageSize();
		
		Integer authStatus = authUserModel.getAuthStatus();
		String beginDate = authUserModel.getBeginDate();
		String endDate = authUserModel.getEndDate();
		String keyword = authUserModel.getKeyword();
		Map<String, Object> param=new HashMap<String,Object>();
		param.put("authStatus", FinVal.AUTH_STATUS_SUBMIT);
		param.put("beginDate", beginDate);
		param.put("endDate", endDate);
		param.put("keywords", keyword);
		
		int count =userMapper.countUserList(param);
		
		
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
		List<User> userList = userMapper.findUserList(param);
		
		List<UserListDto> userListDtos=new ArrayList<UserListDto>();
		if(Help.isNotNull(userList)){
			for(User user:userList){
				UserListDto userListDto = new UserListDto();
				userListDto.setUserId(user.getnUserId());
				userListDto.setUserAccount(user.getcUserAccount());
				userListDto.setUserRealName(user.getcUserRealname());
				userListDto.setSchoolName(user.getcSchoolName());
				userListDto.setMajor(user.getcMajor());
				userListDto.setUserAuthStatus(user.getnAuthStatus());
				userListDto.setUserType(user.getnUserType());
				userListDto.setUserPortrait(user.getcUserPortrait());			
				userListDto.setUserMobilePhone(user.getcMobilePhone());
				userListDto.setCreateTime(user.gettCreateTime());
				userListDto.setUserCode(user.getcUserCode());
				userListDto.setGrade(user.getcGrade());
				userListDto.setUserAuthImg(user.getcAuthImgs());
				userListDtos.add(userListDto);
			}
		}
		log.debug("查询用户列表成功==");
		log.debug("组装接口所需数据完成==");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("pageSize", pageSize);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		data.put("pageCount", pageCount);
		data.put("dataList", userListDtos);
		data.put("total", count);
		result.setData(data);
		return result;
}


}
