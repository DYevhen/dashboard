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
package org.apache.sling.scripting.sightly.apps.dashboard.components.content.gridcomponent;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class gridcomponent__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_landing = null;
Collection var_collectionvar0_list_coerced$ = null;
_global_landing = renderContext.call("use", com.exadel.core.models.Landing.class.getName(), obj());
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_landing, "getCards");
    {
        long var_size1 = ((var_collectionvar0_list_coerced$ == null ? (var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0)) : var_collectionvar0_list_coerced$).size());
        {
            boolean var_notempty2 = (var_size1 > 0);
            if (var_notempty2) {
                {
                    long var_end5 = var_size1;
                    {
                        boolean var_validstartstepend6 = (((0 < var_size1) && true) && (var_end5 > 0));
                        if (var_validstartstepend6) {
                            out.write("<div class=\"wrapper\">");
                            if (var_collectionvar0_list_coerced$ == null) {
                                var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                            }
                            long var_index7 = 0;
                            for (Object card : var_collectionvar0_list_coerced$) {
                                {
                                    boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                    if (var_traversal9) {
                                        out.write("\n    <div>\n        <b>");
                                        {
                                            Object var_10 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(card, "topic"), "html");
                                            out.write(renderContext.getObjectModel().toString(var_10));
                                        }
                                        out.write("</b>\n        <p><img");
                                        {
                                            Object var_attrvalue11 = renderContext.getObjectModel().resolveProperty(card, "image");
                                            {
                                                Object var_attrcontent12 = renderContext.call("xss", var_attrvalue11, "uri");
                                                {
                                                    boolean var_shoulddisplayattr14 = (((null != var_attrcontent12) && (!"".equals(var_attrcontent12))) && ((!"".equals(var_attrvalue11)) && (!((Object)false).equals(var_attrvalue11))));
                                                    if (var_shoulddisplayattr14) {
                                                        out.write(" src");
                                                        {
                                                            boolean var_istrueattr13 = (var_attrvalue11.equals(true));
                                                            if (!var_istrueattr13) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent12));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write(" width=\"350\" height=\"300\"/></p>\n        <i>");
                                        {
                                            Object var_15 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(card, "article"), "html");
                                            out.write(renderContext.getObjectModel().toString(var_15));
                                        }
                                        out.write("</i>\n        <br/>\n        <a");
                                        {
                                            Object var_attrvalue16 = renderContext.getObjectModel().resolveProperty(card, "link");
                                            {
                                                Object var_attrcontent17 = renderContext.call("xss", var_attrvalue16, "uri");
                                                {
                                                    boolean var_shoulddisplayattr19 = (((null != var_attrcontent17) && (!"".equals(var_attrcontent17))) && ((!"".equals(var_attrvalue16)) && (!((Object)false).equals(var_attrvalue16))));
                                                    if (var_shoulddisplayattr19) {
                                                        out.write(" href");
                                                        {
                                                            boolean var_istrueattr18 = (var_attrvalue16.equals(true));
                                                            if (!var_istrueattr18) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent17));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write(" class=\"button\">Read</a>\n    </div>\n");
                                    }
                                }
                                var_index7++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar0_list_coerced$ = null;
}
out.write("\n<div id=\"add_here\"></div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

