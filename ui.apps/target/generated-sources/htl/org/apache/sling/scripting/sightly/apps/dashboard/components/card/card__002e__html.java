/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.dashboard.components.card;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class card__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_card = null;
out.write("<style>\n.card {\n  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);\n  transition: 0.3s;\n  width: 50%;\n}\n\n.card:hover {\n  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);\n}\n\n.container {\n  padding: 2px 16px;\n}\n</style>\n<div class=\"card\">\n<img src=\"https://i.postimg.cc/HkQXgMdX/news.jpg\" alt=\"Avatar\" style=\"width:100%\"/>\n\t<div class=\"container\">\n\t\t");
_global_card = renderContext.call("use", com.exadel.core.models.Card.class.getName(), obj());
out.write("<div></div>\n\t\t<div>");
{
    String var_0 = ("Title : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_card, "title"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n\t\t<div>");
{
    String var_1 = ("Text : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_card, "mainText"), "text")));
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</div>\n\t</div>\n</div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

