/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.android.build.gradle.model

import com.android.annotations.Nullable
import com.android.build.gradle.internal.TaskFactory
import org.gradle.api.Action
import org.gradle.api.Task
import org.gradle.model.collection.CollectionBuilder

/**
 * Adaptor to transform CollectionBuilder<Task> into TaskFactory.
 */
class TaskCollectionBuilderAdaptor implements TaskFactory {

    private final CollectionBuilder<Task> tasks

    TaskCollectionBuilderAdaptor(CollectionBuilder<Task> tasks) {
        this.tasks = tasks
    }

    @Override
    boolean containsKey(String name) {
        return tasks.containsKey(name)
    }

    @Override
    void create(String name) {
        tasks.create(name)
    }

    @Override
    void create(String name, Action<? super Task> configAction) {
        tasks.create(name, configAction)
    }

    @Override
    def <S extends Task> void create(String name, Class<S> type) {
        tasks.create(name, type)
    }

    @Override
    def <S extends Task> void create(String name, Class<S> type, Action<? super S> configAction) {
        tasks.create(name, type, configAction)
    }

    @Override
    void named(String name, Action<? super Task> configAction) {
        tasks.named(name, configAction)
    }

    @Nullable
    @Override
    Task named(String name) {
        return tasks.get(name);
    }
}
