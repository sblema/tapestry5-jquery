//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
package org.got5.tapestry5.jquery.components;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * @since 2.1.1
 *
 * @tapestrydoc
 */
@SupportsInformalParameters
public class CarouselItem implements ClientElement {

    @Property
    @Parameter(value = "75", defaultPrefix = BindingConstants.LITERAL)
    private int width;

    @Property
    @Parameter(value = "75", defaultPrefix = BindingConstants.LITERAL)
    private int height;

    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.PROP)
    private String imageSource;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String page;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String event;

    @Property
    @Parameter(allowNull = true, defaultPrefix = BindingConstants.PROP)
    private Object context;

	@Property
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String zone;

	@Inject
	private ComponentResources componentResources;

	@Inject
	private JavaScriptSupport javaScriptSupport;

	@Inject
	private PageRenderLinkSource pageRenderLink;

    private String clientId;

	private boolean isPageLink;

	private boolean isEventLink;

	public boolean isPagelink(){
		return StringUtils.isNotEmpty(page);
	}

	public boolean isEventlink(){
		return StringUtils.isNotEmpty(event);
	}

	
	@SetupRender
	public boolean init(MarkupWriter w){
		w.element("li");
		Link url = null;
		if(isPagelink()){
			
			if(context!=null){
				url=pageRenderLink.createPageRenderLinkWithContext(page, context);
			}else{
				url=pageRenderLink.createPageRenderLinkWithContext(page);
			}
			w.element("a","href",url.toURI());
		}else if(isEventlink()){
			String linkId = javaScriptSupport.allocateClientId(componentResources);
			
			if(context!=null){
				url=componentResources.createEventLink(event, context);
			}else{
				url=componentResources.createEventLink(event);
			}
			
			if(zone==null) w.element("a","href",url.toURI(),"id",linkId);
			
		}
		
		w.element("img","src",imageSource,"height",height+"px","width",width+"px");
		
		if(isEventlink() && zone!=null){
			//clientSupport.linkZone(linkId, zone, url);
			w.attributes("data-update-zone", zone);
			w.attributes("data-update-zone-url", url);
		}
		
		componentResources.renderInformalParameters(w);
		w.end();
		
		if(isPagelink() || (isEventlink() && zone == null)){
			w.end();
		}
		
		w.end();
		return false;
		

	}

	void afterRender(MarkupWriter writer) {

        if (isPageLink || isEventLink) {
            writer.end();
        }

	    writer.end();
    }

    public String getClientId() {

        return this.clientId;
    }

}
