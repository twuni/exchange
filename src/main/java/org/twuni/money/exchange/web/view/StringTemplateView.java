package org.twuni.money.exchange.web.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.InternalResourceView;

public class StringTemplateView extends InternalResourceView {

	@Override
	protected void renderMergedOutputModel( Map<String, Object> model, HttpServletRequest request, HttpServletResponse response ) throws Exception {

		PrintWriter writer = response.getWriter();
		StringTemplate template = getTemplate( model );

		writer.print( template );
		writer.flush();
		writer.close();

	}

	private StringTemplate getTemplate( Map<String, Object> model ) throws IOException {

		Resource resource = getApplicationContext().getResource( getUrl() );
		StringTemplateGroup group = new StringTemplateGroup( "default", resource.getFile().getParent() );
		StringTemplate template = group.getInstanceOf( getBeanName().replaceAll( "\\.", "/" ) );

		template.setAttributes( model );

		return template;

	}

}
