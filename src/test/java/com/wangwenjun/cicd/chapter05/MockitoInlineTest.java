package com.wangwenjun.cicd.chapter05;

import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MockitoInlineTest
{
    @Test
    public void testMockStaticMethod()
    {
        try (MockedStatic<StaticExternalResource> theMock = Mockito.mockStatic(StaticExternalResource.class))
        {
            theMock.when(StaticExternalResource::foo).thenReturn("Mockito");
            assertThat(StaticExternalResource.foo(), equalTo("Mockito"));
        }
    }
}
