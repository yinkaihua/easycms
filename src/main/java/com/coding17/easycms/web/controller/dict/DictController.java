package com.coding17.easycms.web.controller.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding17.easycms.api.container.DictContainer;
import com.coding17.easycms.soa.entity.dict.TDict;
import com.coding17.easycms.soa.service.dict.TDictService;
import com.coding17.easycms.web.base.BaseController;
import com.coding17.easycms.web.vo.dict.Dict;

 /**
 * 描述：</b><br>
 * @author：系统生成
 * @version:1.0
 */
@Scope(value="prototype")
@RequestMapping("/dict")
@Controller
public class DictController extends BaseController<Dict> {
	
	@Autowired
	private TDictService tDictService;
	
	@RequestMapping("/view.htm")
	public String view() {
		TDict para = new TDict();
		List<TDict> allDict = tDictService.selectListByCondition(para);
		List<Dict> dicts = new ArrayList<Dict>();
		for (TDict td : allDict) {
			Dict dict = new Dict();
			BeanUtils.copyProperties(td, dict);
			dicts.add(dict);
		}
		request.setAttribute("dicts", dicts);
		return "dict/dict_view";
	}
	
	@RequestMapping("/save.htm")
	public String save() {
		LOG.info("=====>保存字典条目，{}", p);
		TDict para = new TDict();
		BeanUtils.copyProperties(p, para);
		if (p.getId()==null) {
			try {
				tDictService.create(para);
			} catch (Exception ex) {
				LOG.error("=====>保存字典条目失败，{}", p, ex);
			}
		} else {
			try {
				tDictService.update(para);
			} catch (Exception ex) {
				LOG.error("=====>更新字典条目失败，{}", p, ex);
			}
		}
		return view();
	}
	
	@RequestMapping("/to_edit.htm")
	public String toEdit() {
		TDict para = new TDict();
		para.setId(p.getId());
		TDict site = tDictService.getByPriKey(para);
		Dict vo = new Dict();
		BeanUtils.copyProperties(site, vo);
		request.setAttribute("so", vo);
		request.setAttribute("isEdit", "yes");
		return "dict/dict_info";
	}
	
	@RequestMapping("/to_add.htm")
	public String toAdd() {
		return "dict/dict_info";
	}
	
	@RequestMapping("/remove.htm")
	public String remove() {
		LOG.info("=====>删除字典条目，{}", p);
		TDict para = new TDict();
		para.setId(p.getId());
		try {
			tDictService.deleteByPriKey(para);
		} catch (Exception ex) {
			LOG.error("=====>删除字典条目失败，{}", p, ex);
		}
		return view();
	}
	
	@ResponseBody
	@RequestMapping(value="/refresh.shtm")
	public Map<String, String> refresh() {
		Map<String, String> json = new HashMap<String, String>();
		DictContainer.refresh();
		json.put("success", "刷新成功");
		return json;
	}
	
}