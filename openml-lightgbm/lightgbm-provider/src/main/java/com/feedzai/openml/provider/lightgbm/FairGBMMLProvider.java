/*
 * Copyright 2020 Feedzai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.feedzai.openml.provider.lightgbm;

import com.google.auto.service.AutoService;
import java.util.Optional;
import java.util.Set;

import com.feedzai.openml.provider.MachineLearningProvider;
import com.feedzai.openml.provider.TrainingMachineLearningProvider;
import com.feedzai.openml.provider.descriptor.MLAlgorithmDescriptor;
import com.feedzai.openml.util.algorithm.MLAlgorithmEnum;

/**
 * This class implements Feedzai's OpenML MachineLearningProvider interface for FairGBM (constrained LightGBM).
 *
 * @author Andre Cruz (andre.cruz@feedzai.com)
 * @since 1.4.0
 */
@AutoService(MachineLearningProvider.class)
public class FairGBMMLProvider implements TrainingMachineLearningProvider<LightGBMModelCreator> {

    /**
     * The reported name of this provider.
     */
    private static final String PROVIDER_NAME = "Feedzai GBM";

    @Override
    public String getName() {
        return PROVIDER_NAME;
    }

    @Override
    public Set<MLAlgorithmDescriptor> getAlgorithms() {
        return MLAlgorithmEnum.getDescriptors(new MLAlgorithmEnum[]{LightGBMAlgorithms.FAIRGBM_BINARY_CLASSIFIER});
    }

    @Override
    public Optional<LightGBMModelCreator> getModelCreator(final String algorithmName) {
        return MLAlgorithmEnum.getByName(new MLAlgorithmEnum[]{LightGBMAlgorithms.FAIRGBM_BINARY_CLASSIFIER}, algorithmName)
                .map(algorithm -> new LightGBMModelCreator());
    }
}
