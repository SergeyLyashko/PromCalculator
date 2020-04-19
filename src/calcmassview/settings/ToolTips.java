/*
 * Copyright 2019 Sergei Lyashko. Contacts: <slyashko@mail.ru>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package calcmassview.settings;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.ToolTipManager;

/**
 * Всплывающие подсказки
 * @author Sergei Lyashko
 */
public class ToolTips extends JToolTip { 
    
    private static final ArrayList<JComponent> COMPONENT_LIST = new ArrayList<>();
    
    public static void addToolTips(JComponent component, String text){
        COMPONENT_LIST.add(component);
        component.setToolTipText(text);
    }
    
    public static void oFF(){
        ToolTipManager.sharedInstance().setEnabled(false);
    }
    
    public static void oN(){
        ToolTipManager.sharedInstance().setEnabled(true);
    }
}
