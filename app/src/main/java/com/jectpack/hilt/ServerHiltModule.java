package com.jectpack.hilt;

import com.jectpack.hilt.annotation.LocalServer;
import com.jectpack.hilt.annotation.RemoteServer;
import com.jectpack.iinterface.AbstractRepositoryServer;
import com.jectpack.iinterface.IRepositoryServer;
import com.jectpack.impl.LocalIRepositoryServer;
import com.jectpack.impl.RemoteRepositoryServer;
import com.jectpack.impl.RemoteRepositoryServerImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public abstract class ServerHiltModule {



    @ActivityScoped
    @LocalServer
    @Binds
    public abstract IRepositoryServer bindLocalIRepositoryServer(LocalIRepositoryServer server);

    @ActivityScoped
    @RemoteServer
    @Binds
    public abstract IRepositoryServer bindRemoteRepositoryServer(RemoteRepositoryServer server);

    @ActivityScoped
    @Binds
    public abstract AbstractRepositoryServer bindAbstractRepositoryServer(RemoteRepositoryServerImpl server);

}
