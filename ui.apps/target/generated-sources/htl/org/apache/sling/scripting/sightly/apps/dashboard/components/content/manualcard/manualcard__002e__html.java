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
package org.apache.sling.scripting.sightly.apps.dashboard.components.content.manualcard;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class manualcard__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_manualcard = null;
out.write("<!DOCTYPE html>\n<html>\n<style>\n    a.button {\n  background-color: #04AA6D;\n  border: none;\n  color: black;\n  font-weight: 600;\n  padding: 15px 32px;\n  text-align: center;\n  text-decoration: none;\n  display: inline-block;\n  font-size: 16px;\n}\n</style>\n");
_global_manualcard = renderContext.call("use", com.exadel.core.models.ManualCard.class.getName(), obj());
out.write("<div></div>\n<div>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_manualcard, "topic"), "html");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\n<div>");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_manualcard, "article"), "html");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</div>\n<div><a");
{
    Object var_attrvalue2 = renderContext.getObjectModel().resolveProperty(_global_manualcard, "link");
    {
        Object var_attrcontent3 = renderContext.call("xss", var_attrvalue2, "uri");
        {
            boolean var_shoulddisplayattr5 = (((null != var_attrcontent3) && (!"".equals(var_attrcontent3))) && ((!"".equals(var_attrvalue2)) && (!((Object)false).equals(var_attrvalue2))));
            if (var_shoulddisplayattr5) {
                out.write(" href");
                {
                    boolean var_istrueattr4 = (var_attrvalue2.equals(true));
                    if (!var_istrueattr4) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent3));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" class=\"button\">Read</a>???</div>\n</html>\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

