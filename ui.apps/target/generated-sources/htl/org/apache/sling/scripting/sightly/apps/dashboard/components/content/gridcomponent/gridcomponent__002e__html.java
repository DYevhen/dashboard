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
Object _global_manualcard = null;
Collection var_collectionvar0_list_coerced$ = null;
Object _dynamic_par = bindings.get("par");
out.write("<!DOCTYPE html>\n<html>\n<style>\n.wrapper {\n  display: grid;\n  grid-template-columns: repeat(3, 2fr);\n  grid-column-gap: 10px;\n  grid-row-gap: 1em;\n}\n    a.button {\n  background-color: #04AA6D;\n  border: none;\n  color: black;\n  font-weight: 600;\n  padding: 15px 32px;\n  text-align: center;\n  text-decoration: none;\n  display: inline-block;\n  font-size: 16px;\n}\n\n</style>\n<body>\n");
_global_landing = renderContext.call("use", com.exadel.core.models.Landing.class.getName(), obj());
_global_manualcard = renderContext.call("use", com.exadel.core.models.ManualCard.class.getName(), obj());
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
                                        out.write("</b>\n        <i>");
                                        {
                                            Object var_11 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(card, "article"), "html");
                                            out.write(renderContext.getObjectModel().toString(var_11));
                                        }
                                        out.write("</i>\n        <br/>\n        <a");
                                        {
                                            Object var_attrvalue12 = renderContext.getObjectModel().resolveProperty(card, "link");
                                            {
                                                Object var_attrcontent13 = renderContext.call("xss", var_attrvalue12, "uri");
                                                {
                                                    boolean var_shoulddisplayattr15 = (((null != var_attrcontent13) && (!"".equals(var_attrcontent13))) && ((!"".equals(var_attrvalue12)) && (!((Object)false).equals(var_attrvalue12))));
                                                    if (var_shoulddisplayattr15) {
                                                        out.write(" href");
                                                        {
                                                            boolean var_istrueattr14 = (var_attrvalue12.equals(true));
                                                            if (!var_istrueattr14) {
                                                                out.write("=\"");
                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent13));
                                                                out.write("\"");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        out.write(" class=\"button\">Read</a>\n    </div>\n");
                                        {
                                            String var_16 = (("<!--    <div data-sly-resource=\"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.call("uriManipulation", null, obj().with("path", _dynamic_par)), "comment"))) + "\" data-sly-unwrap></div>-->");
                                            out.write(renderContext.getObjectModel().toString(var_16));
                                        }
                                        out.write("\n");
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
out.write("\n<form action=\"landing.html?pageNum=1\" method=\"GET\"><button>pageNum</button> </form>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

