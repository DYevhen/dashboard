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
package org.apache.sling.scripting.sightly.apps.dashboard.components.content.dynamiccard;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class dinamiccard__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_manualcard = null;
_global_manualcard = renderContext.call("use", com.exadel.core.models.ManualCard.class.getName(), obj());
out.write("<div></div>\n<div class=\"carousel\">\n    <div id=\"carousel-c813aecaf1\" class=\"cmp-carousel\" role=\"group\" aria-live=\"polite\" aria-roledescription=\"carousel\" data-cmp-delay=\"5000\" data-placeholder-text=\"false\">\n        <div class=\"cmp-carousel__content\" aria-atomic=\"false\" aria-live=\"polite\">\n            <div> </div>\n            <div class=\"cmp-carousel__actions\">\n                <button class=\"cmp-carousel__action cmp-carousel__action--previous\" type=\"button\" aria-label=\"Previous\" data-cmp-hook-carousel=\"previous\">\n                    <span class=\"cmp-carousel__action-icon\"></span>\n                    <span class=\"cmp-carousel__action-text\">Previous</span>\n                </button>\n                <button class=\"cmp-carousel__action cmp-carousel__action--next\" type=\"button\" aria-label=\"Next\" data-cmp-hook-carousel=\"next\">\n                    <span class=\"cmp-carousel__action-icon\"></span>\n                    <span class=\"cmp-carousel__action-text\">Next</span>\n                </button>\n            </div>\n            <ol class=\"cmp-carousel__indicators\" role=\"tablist\" aria-label=\"Choose a slide to display\" data-cmp-hook-carousel=\"indicators\">\n            </ol>\n        </div>\n    </div>\n</div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

