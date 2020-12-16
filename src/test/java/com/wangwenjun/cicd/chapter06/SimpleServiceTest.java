package com.wangwenjun.cicd.chapter06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SimpleService.class)
public class SimpleServiceTest
{
    private SimpleService simpleService = new SimpleService();

    @Test
    public void testCount() throws Exception
    {
        SimpleDao simpleDao = mock(SimpleDao.class);
        whenNew(SimpleDao.class).withAnyArguments()
                .thenReturn(simpleDao);
        when(simpleDao.getCount()).thenReturn(10);

        assertThat(simpleService.count(), equalTo(10));
    }
}