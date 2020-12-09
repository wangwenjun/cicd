package com.wangwenjun.cicd.chapter05;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class StorageServiceTest
{
    @Mock
    private GoogleCloudStorage googleCloudStorage;
    private StorageService storageService;

    @Before
    public void setUp() throws IOException
    {
        this.storageService = new StorageService(googleCloudStorage);
        //doNothing().when(googleCloudStorage).store(any(byte[].class));
    }

    @Test
    public void testUploadToCloudSuccess() throws IOException
    {
        boolean result = this.storageService.uploadToCloud(new byte[]{0x1, 0x2});
        assertThat(result, is(equalTo(true)));
        verify(googleCloudStorage).store(any(byte[].class));
    }

    @Test
    public void testUploadToCloudFailed() throws IOException
    {
        boolean result = this.storageService.uploadToCloud(null);
        assertThat(result, is(equalTo(false)));
        verify(googleCloudStorage, times(0)).store(any(byte[].class));
    }

    @Test
    public void testDoThrowWhenForVoidMethod() throws IOException
    {
        doThrow(IOException.class).when(googleCloudStorage).store(any(byte[].class));
        boolean result = this.storageService.uploadToCloud(new byte[]{0x1, 0x2});
        assertThat(result, is(equalTo(false)));
    }

}