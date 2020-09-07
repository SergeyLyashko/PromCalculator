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
package calcmassmodel;


/**
 * 
 * @author Sergei Lyashko
 */
public class ModelDispatcherImpl implements ModelDispatcher {
    
    private InputService inputDataService;
    private OutputService outputDataService;
    private DetailAreaReceiver areaReceiver;
    private MassableDetail detail;

    public ModelDispatcherImpl() {
        
    }

    @Override
    public void setInputData(InputService inputDataService) {
        this.inputDataService = inputDataService;
    }

    @Override
    public void setOutputData(OutputService outputDataService) {
        this.outputDataService = outputDataService;
    }

    @Override
    public void setDetailAreaReceiver(DetailAreaReceiver areaReceiver) {
        this.areaReceiver = areaReceiver;
    }

    @Override
    public void setMassableDetail(MassableDetail detail) {
        this.detail = detail;
    }
    
    
    
}