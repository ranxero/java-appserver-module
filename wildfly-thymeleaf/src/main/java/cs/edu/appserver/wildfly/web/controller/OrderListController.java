/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package cs.edu.appserver.wildfly.web.controller;

import java.io.Writer;
import java.util.List;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;

import cs.edu.appserver.wildfly.business.entities.Order;
import cs.edu.appserver.wildfly.business.services.OrderService;

public class OrderListController implements IGTVGController {

    
    public OrderListController() {
        super();
    }
    
    
    public void process(final IWebExchange webExchange, final ITemplateEngine templateEngine, final Writer writer)
            throws Exception {
        
        final OrderService orderService = new OrderService();
        final List<Order> allOrders = orderService.findAll(); 
        
        final WebContext ctx = new WebContext(webExchange, webExchange.getLocale());
        ctx.setVariable("orders", allOrders);
        
        templateEngine.process("order/list", ctx, writer);
        
    }

}
