package com.s4game.oa.manager.web;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.s4game.oa.common.entity.PlanMoneyOutYear;
import com.s4game.oa.common.mapper.PlanMoneyOutYearMapper;
import com.s4game.oa.common.response.Response;
import com.s4game.oa.common.service.PageService;
import com.s4game.oa.manager.utils.WebUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/plan/money/out/year")
@Api(value = "/plan/money/out/year", description = "年度资金支出计划")
public class PlanMoneyOutYearController {

	@Autowired
	private PlanMoneyOutYearMapper planMoneyOutYearMapper;

	@Autowired
	private PageService<PlanMoneyOutYear> pageService;
	
	@ApiOperation(value = "资金支出列表")
	@RequestMapping(value = "/list")
	public Response list(
			@ApiParam(value = "当前页数") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页数量") @RequestParam(value = "limit", required = false) Integer limit
			) {
		Response.Builder response = Response.newBuilder();

		PageInfo<PlanMoneyOutYear> pageInfo = pageService.selectPage(new PlanMoneyOutYear(), new Page<PlanMoneyOutYear>(page, limit));
		response.setData(pageInfo.getList());

		return response.build();
	}

	@ApiOperation(value = "更新资金支出")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response update(@ApiParam(value = "资金支出Id") @RequestParam(value = "id", required = true) Long id,
			@ApiParam(value = "年份") @RequestParam(value = "year", required = true) Integer year,
			@ApiParam(value = "所属公司") @RequestParam(value = "company", required = true) Integer company,
			@ApiParam(value = "部门") @RequestParam(value = "departmentId", required = true) Integer departmentId,
			@ApiParam(value = "合同名称") @RequestParam(value = "contractName", required = true) String contractName,
			@ApiParam(value = "合同金额") @RequestParam(value = "contractAmount", required = true) BigDecimal contractAmount,
			@ApiParam(value = "已支付金额") @RequestParam(value = "paidAmount", required = true) BigDecimal paidAmount,
			@ApiParam(value = "1月") @RequestParam(value = "month1", required = true) BigDecimal month1,
			@ApiParam(value = "2月") @RequestParam(value = "month2", required = true) BigDecimal month2,
			@ApiParam(value = "3月") @RequestParam(value = "month3", required = true) BigDecimal month3,
			@ApiParam(value = "4月") @RequestParam(value = "month4", required = true) BigDecimal month4,
			@ApiParam(value = "5月") @RequestParam(value = "month5", required = true) BigDecimal month5,
			@ApiParam(value = "6月") @RequestParam(value = "month6", required = true) BigDecimal month6,
			@ApiParam(value = "7月") @RequestParam(value = "month7", required = true) BigDecimal month7,
			@ApiParam(value = "8月") @RequestParam(value = "month8", required = true) BigDecimal month8,
			@ApiParam(value = "9月") @RequestParam(value = "month9", required = true) BigDecimal month9,
			@ApiParam(value = "10月") @RequestParam(value = "month10", required = true) BigDecimal month10,
			@ApiParam(value = "11月") @RequestParam(value = "month11", required = true) BigDecimal month11,
			@ApiParam(value = "12月") @RequestParam(value = "month12", required = true) BigDecimal month12) {
		Response.Builder response = Response.newBuilder();
		
		PlanMoneyOutYear yearInfo = null;
		if (WebUtils.isAdd(id)) {
			yearInfo = new PlanMoneyOutYear();
			yearInfo.setYear(year);
			yearInfo.setCompany(company);
			yearInfo.setDepartmentId(departmentId);
//			yearInfo.setProjectId(projectId);
//			yearInfo.setSubjectId(subjectId);
//			yearInfo.setReceiver(receiver);
			yearInfo.setContractName(contractName);
			yearInfo.setContractAmount(contractAmount);
			yearInfo.setPaidAmount(paidAmount);
			yearInfo.setMonth1(month1);
			yearInfo.setMonth2(month2);
			yearInfo.setMonth3(month3);
			yearInfo.setMonth4(month4);
			yearInfo.setMonth5(month5);
			yearInfo.setMonth6(month6);
			yearInfo.setMonth7(month7);
			yearInfo.setMonth8(month8);
			yearInfo.setMonth9(month9);
			yearInfo.setMonth10(month10);
			yearInfo.setMonth11(month11);
			yearInfo.setMonth12(month12);
			
			yearInfo.setCreateTime(new Date());

			planMoneyOutYearMapper.insert(yearInfo);
		} else {
			yearInfo = planMoneyOutYearMapper.selectByPrimaryKey(id);
			yearInfo.setYear(year);
			yearInfo.setCompany(company);
			yearInfo.setDepartmentId(departmentId);
//			yearInfo.setProjectId(projectId);
//			yearInfo.setSubjectId(subjectId);
//			yearInfo.setReceiver(receiver);
			yearInfo.setContractName(contractName);
			yearInfo.setContractAmount(contractAmount);
			yearInfo.setPaidAmount(paidAmount);
			yearInfo.setMonth1(month1);
			yearInfo.setMonth2(month2);
			yearInfo.setMonth3(month3);
			yearInfo.setMonth4(month4);
			yearInfo.setMonth5(month5);
			yearInfo.setMonth6(month6);
			yearInfo.setMonth7(month7);
			yearInfo.setMonth8(month8);
			yearInfo.setMonth9(month9);
			yearInfo.setMonth10(month10);
			yearInfo.setMonth11(month11);
			yearInfo.setMonth12(month12);
			
			planMoneyOutYearMapper.updateByPrimaryKey(yearInfo);
		}

		response.setData(yearInfo);
		return response.build();
	}

	@ApiOperation(value = "删除资金支出")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Response delete(@ApiParam(value = "资金支出Id") @RequestParam(value = "id", required = true) Long id) {
		Response.Builder response = Response.newBuilder();

		int result = planMoneyOutYearMapper.deleteByPrimaryKey(id);

		response.setData(result);
		return response.build();
	}
}
