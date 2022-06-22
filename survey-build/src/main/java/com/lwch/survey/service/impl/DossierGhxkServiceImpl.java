package com.lwch.survey.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.dao.mapper.IDossierGhxkDao;
import com.lwch.survey.dao.mapper.JsgcghxkDossierApplyMapper;
import com.lwch.survey.dao.mapper.JsgcghxkDossierExamineMapper;
import com.lwch.survey.model.JsgcghxkDossierApply;
import com.lwch.survey.model.JsgcghxkDossierApplyExample;
import com.lwch.survey.model.JsgcghxkDossierExamine;
import com.lwch.survey.model.JsgcghxkDossierExamineExample;
import com.lwch.survey.model.JsgcghxkDossierExamineExample.Criteria;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.JsgcghxkDossier;
import com.lwch.survey.pojo.JsgcghxkParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.DossierGhxkService;
import com.lwch.survey.utils.ServiceUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DossierGhxkServiceImpl implements DossierGhxkService {
	
	/** 存在 */
	static final Integer JSGCGHXK_ISEXIT_YES = 0;
	/** 不存在 */
	static final Integer JSGCGHXK_ISEXIT_NO = 1;
	/** 申请 */
	static final Integer JSGCGHXK_STATE_APPLY = 0;
	/**  申请成功状态 */
	static final int APPLY_STATE_SUCCESS = 3;
	/** 申请失败状态 */
	static final int APPLY_STATE_FAIL = 2;
	/** 申请中 状态 */
	static final int APPLY_STATE_ING = 1;

	@Autowired
	private IDossierGhxkDao dossierGhxkDao;
	
	@Autowired
	private JsgcghxkDossierExamineMapper jsgcghxkDossierExamineMapper;
	
	@Autowired
	private JsgcghxkDossierApplyMapper jsgcghxkDossierApplyMapper;
	
	@Override
	public ResponseObject query(DossierParam dossierParam) {
		ResponseObject obj = new ResponseObject();
		
		try {
			obj.setCount(dossierGhxkDao.queryCount(dossierParam));
			
			Integer startPage = null == dossierParam.getPageNum()?1:dossierParam.getPageNum();
			Integer pageNum = null == dossierParam.getPageSize()?10:dossierParam.getPageSize();
			PageParm pageParm = new PageParm(startPage,pageNum," create_time desc");
			
			ServiceUtils.startPage(pageParm);
			obj.setData(conventQueryData(dossierGhxkDao.query(dossierParam)));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return obj;
	}
	private List<JsgcghxkDossier> conventQueryData(List<JsgcghxkDossier> list) {
		for(JsgcghxkDossier member: list) {
			JsgcghxkDossierExamineExample example = new JsgcghxkDossierExamineExample();
			Criteria criteria = example.createCriteria();
			criteria.andApplyUsernameEqualTo(Utils.getCurrentUsername());
			criteria.andJdIdEqualTo(member.getId());
			criteria.andStateEqualTo(1);
			member.setView(jsgcghxkDossierExamineMapper.countByExample(example)>0);
		}
		return list;
	}

	@Override
	public JsgcghxkDossier getOne(Integer id) {
		return dossierGhxkDao.queryOne(id);
	}

	@Override
	public long saveDossier(JsgcghxkDossier jsgcghxkDossier) {
		jsgcghxkDossier.setUseName(Utils.getCurrentUsername());
		jsgcghxkDossier.setCreateTime(new Date());
		return dossierGhxkDao.saveDossier(jsgcghxkDossier);
	}

	@Override
	public long updateDossier(JsgcghxkDossier jsgcghxkDossier) {
		return dossierGhxkDao.updateDossier(jsgcghxkDossier);
	}

	@Override
	public long removeDossierById(Integer id) {
		return dossierGhxkDao.removeDossierById(id);
	}

	@Override
	public ResponseObject queryExamine(JsgcghxkParam jsgcghxkParam) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		
		if(null == jsgcghxkParam) {
			return obj;
		}
		
		try {
			int pageNum = jsgcghxkParam.getPageNum()==null?0:jsgcghxkParam.getPageNum();
			int pageSize = jsgcghxkParam.getPageSize()==null?10:jsgcghxkParam.getPageSize();
			
			JsgcghxkDossierExamineExample example = new JsgcghxkDossierExamineExample();
			Criteria criteria = example.createCriteria().andIsExistEqualTo(jsgcghxkParam.getIsExist());
			if(!StringUtils.isBlank(jsgcghxkParam.getApplyUsername())) {
				criteria.andApplyUsernameLike("%" + jsgcghxkParam.getApplyUsername() + "%");
			}
			
			if(!StringUtils.isBlank(jsgcghxkParam.getJsgcghxkzNo())) {
				criteria.andJsgcghxkzNoLike("%" + jsgcghxkParam.getJsgcghxkzNo() + "%");
			}
			
			obj.setTotal(jsgcghxkDossierExamineMapper.countByExample(example));
			
			ServiceUtils.startPage(new PageParm(pageNum, pageSize, "create_time desc"));
			
			List<JsgcghxkDossierExamine> list = jsgcghxkDossierExamineMapper.selectByExample(example);
			if(list.isEmpty()) {
				obj.setData(Collections.emptyList());
			}else {
				list.forEach(x -> {
					JsgcghxkDossierApply b = jsgcghxkDossierApplyMapper.selectByPrimaryKey(x.getJdId());
					String fileId = "";
					if(null != b) {
						fileId = null == b.getFileId()?"":b.getFileId();
					}
					x.setFileId(fileId);
				});
				obj.setData(list);
			}
			obj.setHttp(HttpStatus.OK.value());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public ResponseObject applyDowning(Integer id) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.msg(StringUtils.EMPTY).build();
		
		try {
			JsgcghxkDossierApply jsgcghxkDossier = jsgcghxkDossierApplyMapper.selectByPrimaryKey(id);
			if(null == jsgcghxkDossier) {
				obj.setMsg("id不正确!");
				return obj;
			}
			jsgcghxkDossier.setDossier(dossierGhxkDao.queryOne(jsgcghxkDossier.getJdid()));
			
			JsgcghxkDossierExamineExample example = new JsgcghxkDossierExamineExample();
			example.createCriteria()
				.andApplyUsernameEqualTo(jsgcghxkDossier.getUsrName())
				.andJdIdEqualTo(id)
				.andIsExistEqualTo(JSGCGHXK_ISEXIT_YES);
			
			if(jsgcghxkDossierExamineMapper.countByExample(example) < 1) {
				jsgcghxkDossierExamineMapper.insertSelective(JsgcghxkDossierExamine.builder()
						.applyUsername(Utils.getCurrentUsername())
						.jdId(id)
						.state(JSGCGHXK_STATE_APPLY)
						.createTime(new Date())
						.jsgcghxkzNo(jsgcghxkDossier.getDossier().getJsgcghxkzNo())
						.build());
				jsgcghxkDossierApplyMapper.updateByPrimaryKeySelective(JsgcghxkDossierApply.builder()
						.id(id)
						.state(APPLY_STATE_ING)
						.build());
			}
			
			obj.setHttp(HttpStatus.OK.value());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
		return obj;
	}

	@Override
	public ResponseObject applyCehuiDowning(Integer id) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.msg(StringUtils.EMPTY).build();
		
		try {
			JsgcghxkDossierApplyExample example = new JsgcghxkDossierApplyExample();
			example.createCriteria().andJdidEqualTo(id)
				.andUsrNameEqualTo(Utils.getCurrentUsername());
			
			if(jsgcghxkDossierApplyMapper.countByExample(example)< 1) {
				jsgcghxkDossierApplyMapper.insertSelective(JsgcghxkDossierApply.builder()
						.jdid(id).usrName(Utils.getCurrentUsername())
						.state(JSGCGHXK_STATE_APPLY).createTime(new Date())
						.build());
				obj.setHttp(HttpStatus.OK.value());
			}else {
				obj.setMsg("该用户已经申请!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public ResponseObject applyCehuiQuery(JsgcghxkParam jsgcghxkParam) {
		ResponseObject obj = ResponseObject.builder().http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		
		try {
			int pageNum = jsgcghxkParam.getPageNum()==null?0:jsgcghxkParam.getPageNum();
			int pageSize = jsgcghxkParam.getPageSize()==null?10:jsgcghxkParam.getPageSize();
			
			JsgcghxkDossierApplyExample example = new JsgcghxkDossierApplyExample();
			com.lwch.survey.model.JsgcghxkDossierApplyExample.Criteria criteria 
				= example.createCriteria();
			
			if(!"admin".equals(Utils.getCurrentUsername())) {
				criteria.andUsrNameEqualTo(Utils.getCurrentUsername());
			}
			if(!getCehuiParmer(jsgcghxkParam).isEmpty()) {
				criteria.andJdidIn(getCehuiParmer(jsgcghxkParam));
			}
			
			obj.setTotal(jsgcghxkDossierApplyMapper.countByExample(example));
			
			ServiceUtils.startPage(new PageParm(pageNum, pageSize, ""));
			List<JsgcghxkDossierApply> list = jsgcghxkDossierApplyMapper.selectByExample(example);
			list.forEach(x ->{
				x.setDossier(dossierGhxkDao.queryOne(x.getJdid()));
			});
			
			obj.setData(list);
			obj.setHttp(HttpStatus.OK.value());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return obj;
	}
	
	private List<Integer> getCehuiParmer(JsgcghxkParam jsgcghxkParam){
		List<JsgcghxkDossier> list = dossierGhxkDao.query(DossierParam.builder()
									.jsgcghxkzNo(jsgcghxkParam.getJsgcghxkzNo())
									.jsdwmc(jsgcghxkParam.getJsdwmc())
									.proName(jsgcghxkParam.getProName())
									.lpzh(jsgcghxkParam.getLpzh())
									.build());
		if(list.isEmpty()) {
			return Collections.emptyList();
		}
		return list.stream().map(JsgcghxkDossier::getId).collect(Collectors.toList());
	}
	
	@Override
	public JsgcghxkDossier getCehuiOne(Integer id) {
		JsgcghxkDossierApply apply = jsgcghxkDossierApplyMapper.selectByPrimaryKey(id);
		if(null == apply) {
			throw new RuntimeException("id错误");
		}
		return dossierGhxkDao.queryOne(apply.getJdid());
	}
	
	@Override
	public long updateCehui(JsgcghxkDossierApply jsgcghxkDossierApply) {
		if(null == jsgcghxkDossierApply) {
			return 0;
		}
		return jsgcghxkDossierApplyMapper.updateByPrimaryKeySelective(jsgcghxkDossierApply);
	}
	
	@Override
	@Transactional
	public ResponseObject operationExamine(JsgcghxkParam jsgcghxkParam) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		try {
			if(null == jsgcghxkParam.getExamineId() || null == jsgcghxkParam.getState()) {
				return obj;
			}
			jsgcghxkDossierExamineMapper.updateByPrimaryKeySelective(
					JsgcghxkDossierExamine.builder()
					.id(jsgcghxkParam.getExamineId())
					.isExist(JSGCGHXK_ISEXIT_NO)
					.state(jsgcghxkParam.getState())
					.build()
			);
			
			jsgcghxkDossierApplyMapper.updateByPrimaryKeySelective(JsgcghxkDossierApply.builder()
					.id(jsgcghxkDossierExamineMapper.selectByPrimaryKey(jsgcghxkParam.getExamineId()).getJdId())
					.state(jsgcghxkParam.getState() == 1?APPLY_STATE_SUCCESS:APPLY_STATE_FAIL)
					.build());
			obj.setHttp(HttpStatus.OK.value());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	@Override
	public ResponseObject applyCehuiNewQuery(DossierParam dossierParam) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.msg("数据错误").build();
		
		try {
			obj.setCount(dossierGhxkDao.queryNewListCount(dossierParam));
			obj.setTotal(dossierGhxkDao.queryNewListCount(dossierParam));
			
			Integer startPage = null == dossierParam.getPageNum()?1:dossierParam.getPageNum();
			Integer pageNum = null == dossierParam.getPageSize()?10:dossierParam.getPageSize();
			PageParm pageParm = new PageParm(startPage,pageNum," applyTime desc");
			
			ServiceUtils.startPage(pageParm);
			obj.setData(conventQueryData(dossierGhxkDao.queryNewList(dossierParam)));
			obj.setHttp(HttpStatus.OK.value());
			obj.setMsg("成功");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return obj;
	}
	
	@Override
	public long saveNewCehui(JsgcghxkDossierApply jsgcghxkDossierApply) {
		
		if(null != jsgcghxkDossierApply 
				&& null != jsgcghxkDossierApply.getId()
				&& null!=jsgcghxkDossierApplyMapper.selectByPrimaryKey(jsgcghxkDossierApply.getId())) {
			return jsgcghxkDossierApplyMapper.updateByPrimaryKeySelective(jsgcghxkDossierApply);
		}
		
		JsgcghxkDossierApplyExample example = new JsgcghxkDossierApplyExample();
		example.createCriteria().andJdidEqualTo(jsgcghxkDossierApply.getJdid())
			.andUsrNameEqualTo(Utils.getCurrentUsername());
		
		if(jsgcghxkDossierApplyMapper.countByExample(example)< 1) {
			return jsgcghxkDossierApplyMapper.insertSelective(JsgcghxkDossierApply.builder()
					.jdid(jsgcghxkDossierApply.getJdid()).usrName(Utils.getCurrentUsername())
					.state(JSGCGHXK_STATE_APPLY).createTime(new Date())
					.fileId(jsgcghxkDossierApply.getFileId())
					.build());
		}else {
			return -1;
		}
	}

	
}
