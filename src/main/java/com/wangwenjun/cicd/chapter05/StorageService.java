package com.wangwenjun.cicd.chapter05;

import java.io.IOException;

public class StorageService
{
    private GoogleCloudStorage googleCloudStorage;

    public StorageService(GoogleCloudStorage googleCloudStorage)
    {
        this.googleCloudStorage = googleCloudStorage;
    }

    public boolean uploadToCloud(byte[] data)
    {
        try
        {
            if (data != null)
                this.googleCloudStorage.store(data);
            else
                return false;
        } catch (IOException e)
        {
            return false;
        }

        return true;
    }
}
