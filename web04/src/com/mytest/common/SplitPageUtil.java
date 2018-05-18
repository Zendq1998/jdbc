package com.mytest.common;

import java.util.List;

public class SplitPageUtil {
	private int pageNum = 0; // 每页记录数
	private int page = 1; // 当前页码
	private int count = 0; // 数据总条数
	private int offset = 0; // 初始位置
	private int totalpage = 0; //总页数
	private int prePage = 1; //上一页
	private int nextPage = 1; //下一页
	private int lastPage = 1; //最后一页
	private int firstPage = 1; //首页
	private List arrayPage = null;
	public SplitPageUtil(int num, int pageNum, int page) {
		this.count = num; //数据总条数
		this.pageNum = pageNum; // 每页记录数
		this.page = page; // 当前页码
		this.offset = (page - 1) * pageNum; // 初始位置
		this.totalpage = (num % pageNum == 0)?(num / pageNum):(num / pageNum + 1); //总页数
		this.lastPage = this.totalpage; // 最后一页
		this.prePage = (page > this.firstPage)?(page - 1):(page); // 上一页
		this.nextPage = (page < this.lastPage)?(page + 1):(page); // 下一页
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public List getArrayPage() {
		return arrayPage;
	}
	public void setArrayPage(List arrayPage) {
		this.arrayPage = arrayPage;
	}

	public void getShowPage() {
		// TODO Auto-generated method stub
		
	}
	
	
}
