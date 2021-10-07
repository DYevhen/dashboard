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
package org.apache.sling.scripting.sightly.apps.dashboard.components.granite__002d__page;

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

out.write("<!DOCTYPE html>\n<html>\n<head>\n  <style type=\"text/css\">\n  .button {\n  background-color: #4CAF50; /* Green */\n  border: none;\n  color: white;\n  padding: 16px 32px;\n  text-align: center;\n  text-decoration: none;\n  display: inline-block;\n  font-size: 46px;\n  margin: 400px 500px;\n  transition-duration: 0.4s;\n  cursor: pointer;\n  width: 40%;\n}\n.button2 {\n  background-color: white;\n  color: black;\n  border: 2px solid #008CBA;\n}\n\n.button2:hover {\n  background-color: #008CBA;\n  color: white;\n}\n  </style>\n  <meta charset=\"utf-8\"/>\n  <title></title>\n</head>\n<body>\n<form method=\"get\" action=\"/content/dashboard/granite-page/start.html\">\n  <input onclick=\"showAlert()\" type=\"submit\" class=\"button button2\" value=\"IMPORT NEWS\"/>\n</form>\n</body>\n<script>\n   async function showAlert() {\n    var response = await fetch(\"/content/dashboard/granite-page.html\");\n    console.log(response);\n    if (response.ok) {\n    let div = document.createElement('div');\n    div.className = \"alert\";\n    div.innerHTML = \"<strong>Success</strong>\";\n    document.body.append(div);\n    setTimeout(() => div.remove(), 1000);\n    } else {\n    alert(\"Error HTTP: \" + response.status);\n    }\n   }\n</script>\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

