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
import javax.swing.JLabel;

/**
 * ������ ������ ���������� ����������
 * @author Sergei Lyashko
 */
public class ResultMarker extends JLabel {
    
    public ResultMarker(){
        super.setLocation(190, 105);
        super.setVisible(true);
        super.setText("0.0");
        super.setHorizontalAlignment(RIGHT);
        super.setSize(125, 25);
    }
    
    /**
     * ��������� �������� � ������ ����������
     * @param result
     */
    public void setResult(String result){
        if(result.equals("error")){
            super.setForeground(Color.red);
            super.setText(result);
        }else{
            String str = new StringBuilder().append(result).append(" ").append("��").toString();
            super.setText(str);
        }
    }
    
    /**
     * ����� ����������
     */
    public void reset(){        
        super.setText("0.0");
    }
}
