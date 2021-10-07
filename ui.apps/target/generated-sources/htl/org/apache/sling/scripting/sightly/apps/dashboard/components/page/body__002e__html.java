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
package org.apache.sling.scripting.sightly.apps.dashboard.components.page;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class body__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_templatedcontainer = null;
Collection var_collectionvar0_list_coerced$ = null;
out.write("<div class=\"topnav\">\n  <a class=\"active\">NEWS</a>\n  <a> </a>\n  <form method=\"get\">\n    <div class=\"search\">\n      <input name=\"searchText\" id=\"searchText\" type=\"text\" placeholder=\"text...\"/>\n      <label for=\"sortBy\">sort by:</label>\n      <select name=\"sortBy\" id=\"sortBy\" class=\"custom-select\">\n        <option value=\"byDate\">date</option>\n        <option value=\"byTitle\">title</option>\n      </select>\n    </div>\n  </form>\n</div>\n  ");
_global_templatedcontainer = renderContext.call("use", com.day.cq.wcm.foundation.TemplatedContainer.class.getName(), obj());
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_templatedcontainer, "structureResources");
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
                            if (var_collectionvar0_list_coerced$ == null) {
                                var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                            }
                            long var_index7 = 0;
                            for (Object child : var_collectionvar0_list_coerced$) {
                                {
                                    boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                    if (var_traversal9) {
                                        {
                                            Object var_resourcecontent10 = renderContext.call("includeResource", renderContext.getObjectModel().resolveProperty(child, "path"), obj().with("decorationTagName", "div").with("resourceType", renderContext.getObjectModel().resolveProperty(child, "resourceType")));
                                            out.write(renderContext.getObjectModel().toString(var_resourcecontent10));
                                        }
                                    }
                                }
                                var_index7++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar0_list_coerced$ = null;
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

