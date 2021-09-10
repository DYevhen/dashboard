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
package org.apache.sling.scripting.sightly.apps.dashboard.components.content.article;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class article__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_page = null;
Object _global_head = null;
Object _global_footer = null;
Object _global_redirect = null;
Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _global_isredirectpage = null;
out.write("<!DOCETYPE HTML>\n");
_global_page = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Page.class.getName(), obj());
_global_head = renderContext.call("use", "head.html", obj());
_global_footer = renderContext.call("use", "footer.html", obj());
_global_redirect = renderContext.call("use", "redirect.html", obj());
out.write("<html");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_page, "language");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
            if (var_shoulddisplayattr3) {
                out.write(" lang");
                {
                    boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                    if (!var_istrueattr2) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\n<head>");
{
    Object var_templatevar4 = renderContext.getObjectModel().resolveProperty(_global_head, "head");
    {
        Object var_templateoptions5_field$_page = _global_page;
        {
            java.util.Map var_templateoptions5 = obj().with("page", var_templateoptions5_field$_page);
            callUnit(out, renderContext, var_templatevar4, var_templateoptions5);
        }
    }
}
out.write("</head>\n<body");
{
    Object var_attrvalue6 = renderContext.getObjectModel().resolveProperty(_global_page, "cssClassNames");
    {
        Object var_attrcontent7 = renderContext.call("xss", var_attrvalue6, "attribute");
        {
            boolean var_shoulddisplayattr9 = (((null != var_attrcontent7) && (!"".equals(var_attrcontent7))) && ((!"".equals(var_attrvalue6)) && (!((Object)false).equals(var_attrvalue6))));
            if (var_shoulddisplayattr9) {
                out.write(" class");
                {
                    boolean var_istrueattr8 = (var_attrvalue6.equals(true));
                    if (!var_istrueattr8) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent7));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" id=\"page-top\">\n");
_global_isredirectpage = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_page, "redirectTarget")) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit")) ? renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit") : renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "preview"))) : renderContext.getObjectModel().resolveProperty(_global_page, "redirectTarget")));
if (renderContext.getObjectModel().toBoolean(_global_isredirectpage)) {
    {
        Object var_templatevar10 = renderContext.getObjectModel().resolveProperty(_global_redirect, "redirect");
        {
            Object var_templateoptions11_field$_redirecttarget = renderContext.getObjectModel().resolveProperty(_global_page, "redirectTarget");
            {
                java.util.Map var_templateoptions11 = obj().with("redirectTarget", var_templateoptions11_field$_redirecttarget);
                callUnit(out, renderContext, var_templatevar10, var_templateoptions11);
            }
        }
    }
}
out.write("\n");
{
    boolean var_testvariable12 = (!renderContext.getObjectModel().toBoolean(_global_isredirectpage));
    if (var_testvariable12) {
        out.write("\n    ");
        {
            Object var_includedresult13 = renderContext.call("include", "body.html", obj());
            out.write(renderContext.getObjectModel().toString(var_includedresult13));
        }
        out.write("\n    ");
        {
            Object var_templatevar15 = renderContext.getObjectModel().resolveProperty(_global_footer, "footer");
            {
                Object var_templateoptions16_field$_page = _global_page;
                {
                    java.util.Map var_templateoptions16 = obj().with("page", var_templateoptions16_field$_page);
                    callUnit(out, renderContext, var_templatevar15, var_templateoptions16);
                }
            }
        }
        out.write("\n");
    }
}
out.write("\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

