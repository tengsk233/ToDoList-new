package com.example.todolist;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = HiltApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface HiltApp_GeneratedInjector {
  void injectHiltApp(HiltApp hiltApp);
}
