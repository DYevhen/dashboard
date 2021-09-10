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

Object _global_manualcard = null;
Object _dynamic_par = bindings.get("par");
_global_manualcard = renderContext.call("use", com.exadel.core.models.ManualCard.class.getName(), obj());
out.write("<div></div>\n<!DOCTYPE html>\n<html>\n<style>\n.wrapper {\n  display: grid;\n  grid-template-columns: repeat(3, 2fr);\n  grid-column-gap: 10px;\n  grid-row-gap: 1em;\n}\n</style>\n<body>\n<div class=\"wrapper\">\n    ");
{
    Object var_resourcecontent1 = renderContext.call("includeResource", null, obj().with("path", _dynamic_par).with("resourceType", "wcm/foundation/components/parsys"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent1));
}
out.write("\n</div>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

