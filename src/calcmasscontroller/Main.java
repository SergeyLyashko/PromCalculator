/*
 * Copyright 2019 Sergei Lyashko. Contacts: <9lLLLepuLLa@gmail.com>.
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
package calcmasscontroller;

import calcdatabase.DataBaseDispatcher;
import calcmassview.ViewServiceDispatcher;
import javax.swing.SwingUtilities;
import calcmassview.info.Info;
import calcmassmodel.ModelServiceDispatcher;
import details.MassCalculatorFactory;
import calcmassmodel.ModelService;
import calcmassview.ViewService;

/**
 * ��������� ������������
 * @author Sergei Lyashko
 */
public class Main { 
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            ModelService model = new ModelServiceDispatcher();
                        
            ControllerService controller = new CalculatorControllerImpl(model);
            
            Info info = new InfoImpl();
            ViewService view = new ViewServiceDispatcher(info, controller);
            
            new DataBaseDispatcher(model, view);
            MassCalculatorFactory massFactory = new MassCalculatorFactory();
            model.acceptRealization(massFactory);
                });
    }
}
