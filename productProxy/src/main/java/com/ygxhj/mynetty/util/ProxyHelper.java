package com.ygxhj.mynetty.util;

import java.io.IOException;
import java.util.ArrayList;

import com.ygxhj.mynetty.message.CommandResult;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateHashModel;

public class ProxyHelper {

	public static String REGEX_FILE="";
	public static String TEMPLATE_DIR="";
	
	private static String TEMPLATE_DOAMAIN = "TemplateFile";
	private static RegexMatch.MatchDomain TEMPLATE_CONF;
	private static Configuration FREEMARKER_CONF;
	public static String MSG_CHARSET;
	
	/**
	 * 初始化freemark
	 * */
	public static void initFreeMarker(Object servletContext, String regexFile) {
		RegexMatch reg = new RegexMatch();
		try {
			reg.loadFromFile(regexFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TEMPLATE_CONF = reg.getDomain(TEMPLATE_DOAMAIN);
		FREEMARKER_CONF = new Configuration();
		FREEMARKER_CONF.setDefaultEncoding(MSG_CHARSET);
		FREEMARKER_CONF.setServletContextForTemplateLoading(servletContext, "WEB-INF/" + TEMPLATE_DIR);

		BeansWrapper wrapper = (BeansWrapper) BeansWrapper.BEANS_WRAPPER;
		wrapper.setExposureLevel(BeansWrapper.EXPOSE_ALL);
		try {
			TemplateHashModel staticModels = wrapper.getStaticModels();
			// 设置页面上需要静态访问的类
			TemplateHashModel tempStatics = (TemplateHashModel) staticModels.get(MD5.class.getName());
			FREEMARKER_CONF.setSharedVariable("MD5", tempStatics);
			FREEMARKER_CONF.setSharedVariable("SnsAppFace", tempStatics);
			FREEMARKER_CONF.setSharedVariable("statics", BeansWrapper.getDefaultInstance().getStaticModels());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}

	}
	
	
	/**
	 * 获取模板文件
	 * 
	 * @throws IOException
	 * */
	public static Template getTemplate(CommandResult result) throws IOException {
		ArrayList<String> option = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		option.add(result.getCmd());
		option.add(result.getStatus());
		if (TEMPLATE_CONF.match(option, values)) {
			return FREEMARKER_CONF.getTemplate(values.get(0));
		}
		return null;
	}
}
