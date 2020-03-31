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

package calcmassview.viewpanel;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 * ����������� ����� ��� �����-������ ���������� ����
 * @author Sergei Lyashko
 */
public abstract class AbstractMenuBox extends JComboBox<String> implements ActionListener {
    
    public AbstractMenuBox(){
        super.setSize(155, 25);
        super.setSelectedIndex(-1);
        super.addActionListener(this);
    }

    public abstract String getStringValue();
}