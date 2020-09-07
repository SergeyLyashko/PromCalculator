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
package calcmassview.base;

import java.awt.Color;
import java.lang.annotation.Annotation;
import javax.swing.JLabel;

/**
 * ������������� ������ ����� ��������� ����
 * @author Sergei Lyashko
 */
@CalculatorPanel()
@Reset(reset = true)
public class MessageServiceInscription extends JLabel implements CalculatorPanel, Reset {
   
    public MessageServiceInscription(){
        super.setLocation(20, 140);
        super.setVisible(true);
        super.setHorizontalAlignment(CENTER);
        super.setSize(315, 15);
    }
    
    @Override
    public boolean reset(){
        super.setText(null);
        //System.out.println("service info reset");// TEST
        return true;
    }
    
    /**
     * ����� ��������� ������ �� ������
     * @param message
     */
    public void show(String message){
        super.setText(message);
    }
    
    /**
     * ����� ��������� �� ������ �� ������ View
     * @param error
     */
    public void showError(String error){
        super.setForeground(Color.RED);        
        super.setText(error);
    }       

    @Override
    public Class<? extends Annotation> annotationType() {
        return getClass();
    }
}