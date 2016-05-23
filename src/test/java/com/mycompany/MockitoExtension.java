/*
 * original source : https://github.com/junit-team/junit5-samples
 * 
 */
/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.mycompany;

import static org.mockito.Mockito.mock;

import java.lang.reflect.Parameter;

import org.junit.gen5.api.extension.ExtensionContext;
import org.junit.gen5.api.extension.ExtensionContext.Namespace;
import org.junit.gen5.api.extension.ExtensionContext.Store;
import org.junit.gen5.api.extension.InstancePostProcessor;
import org.junit.gen5.api.extension.MethodInvocationContext;
import org.junit.gen5.api.extension.MethodParameterResolver;
import org.junit.gen5.api.extension.ParameterResolutionException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * {@code MockitoExtension} showcases the {@link InstancePostProcessor}
 * and {@link MethodParameterResolver} extension points of JUnit 5 by
 * providing dependency injection support at the field level via Mockito's
 * {@link Mock @Mock} annotation and at the method level via our demo
 * {@link InjectMock @InjectMock} annotation.
 *
 * @since 5.0
 */
public class MockitoExtension implements InstancePostProcessor, MethodParameterResolver {

	private static final Namespace namespace = Namespace.of(MockitoExtension.class);
@Override
    public void postProcessTestInstance(Object o, ExtensionContext ec)  {
    MockitoAnnotations.initMocks(ec.getClass());      
    
    }

	@Override
	public boolean supports(Parameter parameter, MethodInvocationContext methodInvocationContext,
			ExtensionContext extensionContext) {

		return parameter.isAnnotationPresent(InjectMock.class);
	}

	@Override
	public Object resolve(Parameter parameter, MethodInvocationContext methodInvocationContext,
			ExtensionContext extensionContext) throws ParameterResolutionException {
		Store mocks = extensionContext.getStore(namespace);
		return getMock(parameter.getType(), mocks);
	}

	private Object getMock(Class<?> mockType, Store mocks) {
		return mocks.getOrComputeIfAbsent(mockType, type -> mock(mockType));
	}

    

  

}