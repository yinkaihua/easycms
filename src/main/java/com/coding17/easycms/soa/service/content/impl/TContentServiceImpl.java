package com.coding17.easycms.soa.service.content.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding17.easycms.soa.base.dao.ISuperDAO;
import com.coding17.easycms.soa.base.pager.Pagination;
import com.coding17.easycms.soa.base.service.impl.BaseServiceImpl;
import com.coding17.easycms.soa.dao.channelcontent.TChannelContentDAO;
import com.coding17.easycms.soa.dao.content.TContentDAO;
import com.coding17.easycms.soa.dao.contentext.TContentExtDAO;
import com.coding17.easycms.soa.service.content.TContentService;
import com.coding17.easycms.soa.entity.channelcontent.TChannelContent;
import com.coding17.easycms.soa.entity.content.TContent;
import com.coding17.easycms.soa.entity.contentext.TContentExt;
import com.coding17.easycms.soa.exception.CmsSoaExcpetion;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Repository("tContentService")
public class TContentServiceImpl extends BaseServiceImpl<TContent> implements TContentService {
	
	@Autowired
	public TContentDAO tContentDao;
	
	@Autowired
	public TContentExtDAO tContentExtDao;
	
	@Autowired
	public TChannelContentDAO tChannelContentDao;

	@SuppressWarnings("unused")
	private final static Logger log= LoggerFactory.getLogger(TContentServiceImpl.class);
	
	@Override
	protected ISuperDAO<TContent> getDao() {
		return tContentDao;
	}

	@Override
	public Pagination<TContent> selectListInfoByPagination(TContent tContent) {
		//数据校验
		if (tContent.getPageNum()==null || tContent.getPageNum()<=0) {
			tContent.setPageNum(Pagination.DEFAULT_PAGENUM);
		}
		if (tContent.getPageSize()==null || tContent.getPageSize()<=0 || tContent.getPageSize()>Pagination.MAX_PAGESIZE) {
			tContent.setPageSize(Pagination.DEFAULT_PAGESIZE);
		}
		List<TContent> datas = tContentDao.selectListInfoByPagination(tContent);
		Integer totalCount = tContentDao.selectListInfoCountByCondition(tContent);
		Integer totalPage = (totalCount-1)/tContent.getPageSize()+1;
		return new Pagination<>(tContent.getPageNum(), tContent.getPageSize(), totalCount, totalPage, datas);
	}

	@Override
	public TContent createContent(TContent content) {
		int r = 0;
		//保存文章基本信息
		r = tContentDao.insert(content);
		if (r == 0) {
			throw new CmsSoaExcpetion("保存文章信息失败");
		}
		//保存文章内容
		TContentExt ext = new TContentExt();
		ext.setContentId(content.getId());
		ext.setTxt(content.getContentExt().getTxt());
		r = tContentExtDao.insert(ext);
		if (r == 0) {
			throw new CmsSoaExcpetion("保存文章内容失败");
		}
		//保存文章栏目关系
		TChannelContent t = new TChannelContent();
		t.setContentId(content.getId());
		t.setChannelId(content.getChannel().getId());
		r = tChannelContentDao.insert(t);
		if (r == 0) {
			throw new CmsSoaExcpetion("保存文章栏目关系失败");
		}
		return content;
	}

	@Override
	public TContent deleteContent(TContent content) {
		int r = 0;
		//删除文章
		TContent para = new TContent();
		para.setId(content.getId());
		r = tContentDao.deleteByPrimaryKey(para);
		if (r == 0) {
			throw new CmsSoaExcpetion("删除文章信息失败");
		}
		//删除文章内容
		TContentExt ext = new TContentExt();
		ext.setContentId(content.getId());
		r = tContentExtDao.deleteByPrimaryKey(ext);
		if (r == 0) {
			throw new CmsSoaExcpetion("删除文章内容失败");
		}
		//删除文章栏目关系
		TChannelContent cc = new TChannelContent();
		cc.setContentId(content.getId());
		r = tChannelContentDao.deleteByContentId(cc);
		if (r == 0) {
			throw new CmsSoaExcpetion("删除文章栏目关系失败");
		}
		return content;
	}

	@Override
	public TContent findInfoByPriKey(TContent content) {
		return tContentDao.findInfoByPriKey(content);
	}

}
