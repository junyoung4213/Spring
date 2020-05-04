package com.springstudy.view.controller;

// 담당 컨트롤러 객체가 리턴한 정보에 
// 경로나 확장자 같은 부가정보를 추가하는 역할
// 서버내에서는 자유롭게 파일을 접근하되
// 외부 브라우저에서는 접근하지 못하게 할 때 사용하는 클래스
public class ViewResolver {
	public String prefix;	// 접두사
	public String suffix;	// 접미사
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}











