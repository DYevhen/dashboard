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

public final class body__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"utf-8\"/>\n    <title>Article</title>\n    <style type=\"text/css\">\n.column {\n  float: left;\n  width: 50%;\n  padding-left: 2;\n}\n\n/* Clear floats after the columns */\n.row:after {\n  content: \"\";\n  display: table;\n  clear: both;\n}\n\t</style>\n</head>\n<body>\n<div class=\"row\">\n    <div class=\"column\">");
{
    Object var_resourcecontent0 = renderContext.call("includeResource", "child", obj().with("resourceType", "dashboard/components/content/image"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent0));
}
out.write("</div>\n    <div class=\"column\">");
{
    Object var_resourcecontent1 = renderContext.call("includeResource", "child_2", obj().with("resourceType", "dashboard/components/content/text"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent1));
}
out.write("</div>\n</div>\n<div>");
{
    Object var_resourcecontent2 = renderContext.call("includeResource", "child_3", obj().with("resourceType", "dashboard/components/content/button"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent2));
}
out.write("</div>\n</body>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

