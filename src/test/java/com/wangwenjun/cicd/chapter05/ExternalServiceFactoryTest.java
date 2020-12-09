package com.wangwenjun.cicd.chapter05;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ExternalServiceFactoryTest
{
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private ExternalServiceFactory factory;

    @Test
    public void testDefaultMock()
    {
        factory.createExternalService().getValue();
    }
    @After
    public void tearDown()
    {
        reset(factory);
    }
}