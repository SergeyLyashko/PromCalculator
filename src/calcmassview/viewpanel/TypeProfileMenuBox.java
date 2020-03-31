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

import calcmassview.BasePanel;
import java.awt.event.ActionEvent;

/**
 * ������ ���� ����� ��������
 * @author Sergei Lyashko
 */
public class TypeProfileMenuBox extends AbstractMenuBox {   
    
    private String selectMenu;
    
    // ����������� �������� ���������� ������
    private static final TypeProfileMenuBox INSTANCE = new TypeProfileMenuBox();
    
    /**
     * ��������-����� �������� ������ ����������� ����
     * @return ������ "���� ���� ��������"
     */
    public static final TypeProfileMenuBox getInstance(){
        return INSTANCE;
    }    
    
    // �����������
    private TypeProfileMenuBox() {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractMenuBox cb = (AbstractMenuBox)e.getSource();
        String currentMenu = (String)cb.getSelectedItem();
        // ����� ��������
        BasePanel.getInstance().reset();
        // ���������� ���� ������� ��������
        BasePanel.getInstance().updateView(currentMenu, this);
        this.selectMenu = currentMenu;
    }
    
    @Override
    public String getStringValue() {
        return selectMenu;
    }
}