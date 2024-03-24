/*
 * Copyright 2013 the original author or authors.
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

package org.gradle.ide.visualstudio.internal
import org.gradle.language.base.internal.AbstractBuildableModelElement
import org.gradle.nativebinaries.internal.NativeBinaryInternal

class VisualStudioSolution extends AbstractBuildableModelElement {
    private final NativeBinaryInternal rootBinary
    List<VisualStudioProjectConfiguration> projectConfigurations = []
    String name

    VisualStudioSolution(String name, NativeBinaryInternal rootBinary) {
        this.name = name
        this.rootBinary = rootBinary
    }

    void addProjectConfiguration(VisualStudioProjectConfiguration projectConfiguration) {
        this.projectConfigurations << projectConfiguration
        builtBy projectConfiguration.project
    }

    String getSolutionFile() {
        return "${name}.sln"
    }
}
